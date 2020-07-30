# CLI_Weather_Forecaster
Simple command line interface weather forecasting utility.

How to run the project: 
- the project should ideally be run using IntelliJ IDEA (this is the simplest way to run it)
- the project requires Java 11 (JDK 11) to be installed
- import the project into IntelliJ IDEA
- import the jar dependencies: File -> Project Structure -> Project Settings -> Libraries -> + -> Java -> Select the jar files from the jarDependencies folder -> Apply -> OK 
- ensure Java 11 is used for the project: File -> Project Structure -> Project Settings -> Platform Settings -> SDKs -> Select JDK 11 using JDK Home Path
- go to src/main/Main.java and run the application (Shift + F10).

List of issues with current code: 
- some of the inputs have to be provided in a very precise manner; for example "London  " is not a valid city name
- some inputs are not properly sanitised; for example the latitude and longitude are not checked against predefined bounds
- when multiple cities have the same name, the one that occurs first is the one that will be used; this is not the best way to approach this issue
- as a result of the point above, some cities are impossible to access through their name 
- city name look up is linear and slow (a trie could have been used) 
- not all classes have tests
- class names can be improved; 3 Forecast classes can lead to confusion
- class hierarchy could be improved; classes that are used just for JSON parsing should be grouped somehow
- not all input equivalence classes are tested 
- when compared to implementations that would be possible in other programming languages, the current one can be a bit verbose; for example lots of classes were declared just to parse JSON strings. 