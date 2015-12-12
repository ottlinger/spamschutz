# SpamSchutz

[![Build Status](https://travis-ci.org/ottlinger/spamschutz.svg?branch=master)](https://travis-ci.org/ottlinger/spamschutz)

[![codecov.io](http://codecov.io/github/ottlinger/spamschutz/coverage.svg?bran
ch=master)](http://codecov.io/github/ottlinger/spamschutz?branch=master)

[![Stories in 
Ready](https://badge.waffle.io/ottlinger/spamschutz.svg?label=ready&title=Read
y)](http://waffle.io/ottlinger/spamschutz)

[![Codacy Badge](https://api.codacy.com/project/badge/grade/ab19f8aeeb264e0bbad1740e07a765aa)](https://www.codacy.com/app/github_25/spamschutz)

# Purpose of this programm #

This application let's you easily change mail addresses into ASCII-encoded values. Therefore your webpages remain human-readable and spiders are unable to n't detect your mail addresses and use them for unwanted purposes.
This app can be launched as an applet or as a standalone version.

:smile:

# Developer information #

This project uses [Maven](https://maven.apache.org "Official Maven website") to generate its artefacts.

![https://raw.githubusercontent.com/ottlinger/spamschutz/master/webpage/media/gplv3-88x31.png](https://raw.githubusercontent.com/ottlinger/spamschutz/master/webpage/media/gplv3-88x31.png)

## Application ##
If you want to run this programme as a standalone application, perform the following:
  * Get your Maven up'n'running
  * Download the sources of spamschutz
  * run ```mvn clean install -Plive-demo``` to launch the application

A different possibility is to launch the combined uberJAR:

  * ```mvn clean install```
  * ```java -jar target/spamschutz-1.0.4-SNAPSHOT-executable.jar``` - please adapt the version number

## Reports ##

A current snapshot's maven [site reports](https://ottlinger.github.io/spamschutz/) is a good place to start to understand the application without trying it.

## DEPRECATED: Applet ##
To run this class as an applet you need to run
  * ```mvn clean install```
  * Launch ```./target/classes/applet.html``` for an example HTML integration
  * Launch ```./target/classes/appletxhtml.html``` for an example XHTML integration

Due to the current security issues with Java Applet this way is not recommeneded and is addressed in issue #20.
