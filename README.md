![https://raw.githubusercontent.com/ottlinger/spamschutz/master/webpage/logo/postal-horn.png](https://raw.githubusercontent.com/ottlinger/spamschutz/master/webpage/logo/postal-horn.png)
# SpamSchutz

[![Github Action master branch status](https://github.com/ottlinger/spamschutz/actions/workflows/maven.yml/badge.svg?branch=master)](https://github.com/ottlinger/spamschutz/actions)

[![codecov.io](https://codecov.io/github/ottlinger/spamschutz/coverage.svg?branch=master)](https://codecov.io/github/ottlinger/spamschutz?branch=master)

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/93ad105bf87d4261a5fca994c4d56af3)](https://app.codacy.com/gh/ottlinger/spamschutz/dashboard)

# Purpose of this program

This application lets you easily change mail addresses or other HTML contents into ASCII-encoded values. Therefore your webpages remain human-readable and spiders are unable to detect your mail addresses and use them for unwanted purposes, when relying on regular expressions for data extraction.

This app can be launched as a standalone version.

:smile:

# Version history

Details about the current versions can be found in the [changelog](CHANGES.md)

# Developer information

This project uses [Maven](https://maven.apache.org "Official Maven website") to generate its artefacts.

![https://raw.githubusercontent.com/ottlinger/spamschutz/master/webpage/media/gplv3-88x31.png](https://raw.githubusercontent.com/ottlinger/spamschutz/master/webpage/media/gplv3-88x31.png)

## Application
If you want to run this programme as a standalone application, perform the following:

  * Get your Maven up'n'running, JDK version >=11
  * Download the sources of spamschutz
  * run ```./mvnw clean install -Plive-demo``` to launch the application

A different possibility is to launch the combined uberJAR:

  * ```./mvnw clean install```
  * ```java -jar target/spamschutz-1.1.0-SNAPSHOT-executable.jar``` - please adapt the version number

### Launch with jBang

Related to [issue #94](https://github.com/ottlinger/spamschutz/issues/94).
Install [jBang](https://www.jbang.dev/download/) and run these commands from the repository root:

```bash
./mvnw clean verify
jbang run spamschutz
```

The local `jbang-catalog.json` resolves `spamschutz` to the Maven-built executable JAR.
You can also launch the JAR directly:

```bash
jbang run target/spamschutz-1.1.0-SNAPSHOT-executable.jar
```

Adapt the JAR version in the command and catalog when the project version changes.
Rebuild after changing the application; jBang launches the packaged JAR, not the Java sources.
The JAR includes all runtime dependencies, language resources, and the Maven-generated version class.
Its service-provider files are merged so Log4j can initialize correctly.
A graphical desktop is required to run the Swing application. This does not create a native
OS-specific installer (`jpackage` is a separate topic in issue #94).

`./mvnw verify` also runs a headless integration test against the packaged JAR in a separate JVM,
checking Log4j initialization, German and English resources, the generated version, and conversion.
CI additionally checks the jBang catalog using the same smoke-test probe.

### Localization

Relates to [issue #22](https://github.com/ottlinger/spamschutz/issues/22)

  As of now the application can be localized (at the moment only German and English are supported). Use the following parameters to explicitly set language and country or trust your system defaults:
```bash
./mvnw -Plive-demo -Duser.language=en -Duser.country=US
```

## Reports

A current snapshot's maven [site reports](https://ottlinger.github.io/spamschutz/) is a good place to start to understand the application without trying it.
