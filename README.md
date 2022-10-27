# SpamSchutz

[![Github Action master branch status](https://github.com/ottlinger/spamschutz/actions/workflows/maven.yml/badge.svg?branch=master)](https://github.com/ottlinger/spamschutz/actions)

[![codecov.io](http://codecov.io/github/ottlinger/spamschutz/coverage.svg?branch=master)](http://codecov.io/github/ottlinger/spamschutz?branch=master)

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/93ad105bf87d4261a5fca994c4d56af3)](https://www.codacy.com/gh/ottlinger/spamschutz/dashboard)
https://github.com/users/ottlinger/projects/2

# Purpose of this programm

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
  * Get your Maven up'n'running
  * Download the sources of spamschutz
  * run ```mvn clean install -Plive-demo``` to launch the application

A different possibility is to launch the combined uberJAR:

  * ```mvn clean install```
  * ```java -jar target/spamschutz-1.0.6-SNAPSHOT-executable.jar``` - please adapt the version number

### Localization

Relates to [issue #22](../../issues/22)

  As of now the application can be localized (at the moment only German and English is supported). Use the following parameters to explicitly set language and country or trust your system defaults:
```
mvn -Plive-demo -Duser.language=en -Duser.country=US
```

## Reports

A current snapshot's maven [site reports](https://ottlinger.github.io/spamschutz/) is a good place to start to understand the application without trying it.
