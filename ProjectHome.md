# Purpose of this programm #

This application let's you easily change mail addresses into ASCII-encoded values. Therefore your webpages remain human-readable and spiders won't detect your mail addresses and use them for unwanted purposes.
This app can be launched as an applet or as a standalone version.

# Developer information #

This project uses mvn to generate its artefacts.

![http://spamschutz.googlecode.com/hg/webpage/media/gplv3-88x31.png](http://spamschutz.googlecode.com/hg/webpage/media/gplv3-88x31.png)

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

A current snapshot's maven [site reports](http://spamschutz.googlecode.com/hg/webpage/site/index.html) is a good place to start to understand the application without trying it.