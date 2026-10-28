# History

## 1.1.0-SNAPSHOT - currently in development

* Add the `run.sh` convenience script to build and launch the application via Maven's `live-demo` profile as an alternative to jBang; document it on the site home page.
* Manage AssertJ with its BOM and migrate all unit, GUI, and integration test assertions to AssertJ, retaining JUnit as the test runner and the standalone FatJAR/jBang probe without test-library dependencies.
* Replace wildcard imports with explicit imports and share IntelliJ project code-style settings to prevent automatic wildcard imports for classes and static members.
* Fix Log4j initialization in the executable FatJAR by merging service-provider files ([#94](https://github.com/ottlinger/spamschutz/issues/94)).
* Add a local jBang catalog to launch the Maven-built executable JAR, replacing the experimental source-file directives; document usage and add packaged-JAR regression coverage independent of the host locale ([#94](https://github.com/ottlinger/spamschutz/issues/94)).
* Remove applet
* Use README.md as the Maven site home page and include CHANGES.md as the version history.

## 1.0.6 - 2023-08-13

* Dependency updates.
* Main features are:

  * Applet
  * Main application (FatJAR)
