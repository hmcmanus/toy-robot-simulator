toy-robot-simulator
===================

Building the code
-----------------

The code is built with maven as a build tool. You can download it from [here](http://maven.apache.org/download.cgi)

When downloaded you can then build, test and run the code with the following:

`
mvn clean package exec:java
`

This will produce a command prompt into which you can enter the commands as defined in the specification.

Test Data
---------

As required in the specification the test data is to be provided to exercise the application. In this case the data
is provided in the form of cucumber feature files. It will exercise the application in test lifecycle phase of the
build and is by consequence ran every time the build is complete.