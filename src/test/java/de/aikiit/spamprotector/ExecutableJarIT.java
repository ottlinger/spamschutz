/**
 * SpamSchutz - simple way to protect your mail addresses from naïve spammers
 * Copyright (C) 2011, Aiki IT
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.aikiit.spamprotector;

import de.aikiit.spamprotector.converter.SpamProtector;
import de.aikiit.spamprotector.util.LocalizationHelper;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;
import java.util.jar.JarFile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Regression coverage for the executable JAR used by Java and jBang (#94).
 */
public class ExecutableJarIT {

    @Test
    public void packagedApplicationIncludesServicesAndResources() throws Exception {
        Path jar = Path.of(System.getProperty("executableJar")).toAbsolutePath();
        try (JarFile archive = new JarFile(jar.toFile())) {
            assertEquals(AntiSpamApplication.class.getName(),
                    archive.getManifest().getMainAttributes().getValue("Main-Class"));
        }

        String java = Path.of(System.getProperty("java.home"), "bin",
                System.getProperty("os.name").startsWith("Windows") ? "java.exe" : "java").toString();
        String classpath = jar + File.pathSeparator + System.getProperty("testClasses");
        Path log = Files.createTempFile("spamschutz-executable-", ".log");
        Process process = null;
        try {
            // Deliberately exclude Maven's dependency classpath: everything must come from the JAR.
            process = new ProcessBuilder(java, "-Djava.awt.headless=true", "-cp", classpath,
                    Probe.class.getName()).redirectErrorStream(true).redirectOutput(log.toFile()).start();
            assertTrue("Executable JAR smoke test timed out", process.waitFor(30, TimeUnit.SECONDS));
            String output = Files.readString(log);
            assertEquals(output, 0, process.exitValue());
            assertTrue(output, output.contains("Executable JAR smoke test passed"));
        } finally {
            if (process != null && process.isAlive()) {
                process.destroyForcibly().waitFor();
            }
            Files.deleteIfExists(log);
        }
    }

    /**
     * Standalone probe, also runnable through the jBang catalog without opening a GUI.
     * Does not use JUnit, which is intentionally absent from the child JVM's classpath.
     */
    public static final class Probe {

        public static void main(String[] args) throws Exception {
            // Reflection avoids inlining the generated constant and verifies the class is packaged.
            String version = (String) Class.forName("de.aikiit.spamprotector.util.Version")
                    .getField("VERSION").get(null);
            if (version.isEmpty() || version.contains("${")) {
                throw new IllegalStateException("Missing Maven-filtered version: " + version);
            }
            for (String language : new String[]{"de", "en"}) {
                System.setProperty("user.language", language);
                System.setProperty("user.country", "de".equals(language) ? "DE" : "US");
                // Initializes Log4j as well as the packaged localization resources.
                LocalizationHelper.setLocale();
                String title = LocalizationHelper.getBundleString("spamschutz.main.title");
                String expected = "de".equals(language) ? "SpamSchutz" : "SpamProtector";
                if (!title.startsWith(expected)) {
                    throw new IllegalStateException("Missing localization for " + language + ": " + title);
                }
            }
            String input = "hello@example.org";
            if (!input.equals(SpamProtector.toPlain(SpamProtector.toEncoded(input)))) {
                throw new IllegalStateException("Conversion roundtrip failed");
            }
            System.out.println("Executable JAR smoke test passed: " + version);
        }
    }
}
