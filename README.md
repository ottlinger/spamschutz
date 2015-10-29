# SpamSchutz

[![Build Status](https://travis-ci.org/ottlinger/spamschutz.svg?branch=master)](https://travis-ci.org/ottlinger/spamschutz)

# Purpose of this programm #

This application let's you easily change mail addresses into ASCII-encoded values. Therefore your webpages remain human-readable and spiders won't detect your mail addresses and use them for unwanted purposes.
This app can be launched as an applet or as a standalone version.

:smile:

# Developer information #

This project uses mvn to generate its artefacts.

![https://raw.githubusercontent.com/ottlinger/spamschutz/master/webpage/media/gplv3-88x31.png](https://raw.githubusercontent.com/ottlinger/spamschutz/master/webpage/media/gplv3-88x31.png)

## Applet ##
To run this class as an applet you need run
  * _mvn clean install_
  * Launch _./target/classes/applet.html_ for an example HTML integration
  * Launch _./target/classes/appletxhtml.html_ for an example XHTML integration

## Application ##
If you want to run this programme as a standalone application, perform the following:
  * Get your Maven up'n'running
  * Download the sources of spamschutz
  * run _mvn clean install -Plive-demo_ to launch the application

## Reports ##

A current snapshot's maven [site reports](https://github.com/ottlinger/spamschutz/blob/master/webpage/site/index.html) is a good place to start to understand the application without trying it.
