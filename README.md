# Testing Guidlines for ToDoList_Test

Framework Used : selenium-cucumber : Automation Testing Using Java 

selenium-cucumber is a behavior driven development (BDD) approach to write automation test script to test Web. It enables you to write and execute automated acceptance/unit tests.

Framework Architecture
--------------
    Project-Name
            |
            |_src/main/java
            |_src/main/resources
            |	|_toDoList.feature
            |	|...
            |_src/test/java
            |	|_testRunners
            |	|	|_runner.java
            |	|	|...
            |	|_stepDefinitions
            |	|	|_toDOListSteps.java
            |	|	|...
            |_drivers
            |	|_chromedriver

Please find below the Folder Structure maintained :

src/test/resources/features - all the cucumber features files (files .feature ext) goes here.
src/test/java/StepDefinition - you can define step defintion under this package for your feature steps.
src/test/java/env - this package contains cucumber runner (RunCukeTest.java) where you can configure your glue code location (step defintions), define test result output format.(html, json, xml). Hooks where you can configure all before and after test settings Hooks.java, DriverUtil.java contains code for intializing driver instances for respective driver.


Writing a test
--------------

The cucumber features goes in the `features` library and should have the ".feature" extension.

Running test
--------------

Go to your project directory from terminal and hit following commands
* `mvn test (defualt will run on local firefox browser)`
* `mvn test "-Dbrowser=chrome" (to use any other browser)`
* `mvn test "-Dcloud_config=saucelab_windows_chrome52" (to run test on cloud test platforms)`


# Testing URL : 
      https://todomvc.com/examples/vue/
      
      
