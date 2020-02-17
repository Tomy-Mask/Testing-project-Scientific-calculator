# Testing-project-Scientific-calculator

 
## Windows testing project for testing testcases on scientific calculator application for Android devices using TestNG framework.

Testcases are:
  Addition.java, 
  Subtraction.java,
  Multiplication.java, 
  Division.java, 
  ValueOfPi.java

Addition: simple addition test using scientific calculator app. Test adds two 1-digit numbers and shows a result of operation and closes the application.

Subtraction: simple subtraction test using scientific calculator app. Test subtracts a 1-digit number from a 2-digit number and shows a result of operation and closes the application.

Multiplication: simple multiplication test using scientific calculator app. Test multiplies two 1-digit numbers and shows a result of operation and closes the application.

Division: simple division test using scientific calculator app. Test divides a 1-digit number from a 3-digit number and shows a result of operation and closes the application.

ValueOfPi: simple test using scientific calculator app which shows a value of π(pi).

Steps are described in : android-scientific_calc-testng-test. It can be downloaded and easily modified. All steps are explained.
Example of this fully functional project:  android-scientific_calc-testng-example


This project is written in Java and made in IntelliJ IDEA environment, driven by Maven tool with Appium and TestNG dependencies.

As a server and for searching elements of application is used Appium Desktop.


For regularly performance a couple of settings must be setted.

_______________________________________________________

1: Download and install Android Studio

	Download Android Studio from:
 	https://developer.android.com/studio

In Control Panel change an environment variables:

Control Panel > Sytem and Security > System > Advanced system settings > Environment Variables

User variables(example): 
ANDROID_HOME = C:\Users\User\AppData\Local\Android\Sdk

System variables-PATH(examples):
	C:\Users\User\AppData\Local\Android\Sdk\tools
	C:\Users\User\AppData\Local\Android\Sdk\emulator

2. Command Prompt - run daemon service

In Windows open Command Prompt and type:
	cd C:\Users\User\AppData\Local\Android\Sdk\platform-tools    
	-->adb devices

		Should be written : 
			List of devices attached
			*daemon not running; starting now at tcp:5037
			*daemon started succesfully
			


3. Run Android emulator from Android Studio
	Tools(Configure) > AVD Manager > Run   (I installed Pixel 3-API 28)
	(for first installation run Create Virtual Device and choose a device)

	or you can run emulator from Command Prompt:

	cd C:\Users\User\AppData\Local\Android\Sdk\emulator
	--->emulator -avd -list-avds


	cd C:\Users\User\AppData\Local\Android\Sdk\emulator
	--->emulator -avd Pixel_3_Api_28


4. Install Scientific Calculator application

	Download the app with .apk extension from:
	https://apkpure.com/scientific-calculator-free/com.scientificCalculator
	

5. Control Panel - show devices
	
Open another Command Prompt and write:
	cd C:\Users\User\AppData\Local\Android\Sdk\platform-tools
	-->adb devices

		Should be written : 
		List of devices attached
		emulator-5554 device



6. Install app on emulator from Command Prompt

	cd C:\Users\User\AppData\Local\Android\Sdk\platform-tools
	-->adb -s emulator-5554 install D:\PATH_TO_APP\App_name.apk
	

7. Start server from Command Prompt

	cd C:\Users\User\AppData\Local\Android\Sdk\platform-tools
	--->adb start server


8. Download and install JDK(Java Development Kit)
	
	Download and install Java JDK(version 8 or newer) in Windows:
	https://www.guru99.com/install-java.html


9. Download and install Node.js

	Download Node.js from: 
	https://nodejs.org/en/download/
	

10. Download and install Appium Desktop
	
	Download Appium Desktop from:
	http://appium.io/

	or

	https://github.com/appium/appium-desktop


11. Run Appium Desktop and configure ANDROID_HOME and JAVA_HOME
	
	ANDROID_HOME(example):  C:\Users\User\AppData\Local\Android\Sdk

	JAVA_HOME(example):
	C:\Program Files\Java\jdk-13.0.2\bin


12. Start server in Appium Desktop
	
	Open Appium Desktop and start server with default options:
		Host: 0.0.0.0         Port: 4723
		

13. Start new session in Appium Desktop

	While the server is running open:
	File > New Session Window

	In textfield JSON Represantation write desired capabilities

	e.g.
		{
			"app":"E:\Calculator\Scientific_Calculator.apk",
			"VERSION":"9,0",
			"deviceName": "emulator",
			"platformName": "Android"
		}

	Click a save sign in the right corner of the textfield and start a session.



14. Download and install IntelliJ IDEA

 	Download IntelliJ IDEA from:
 	https://www.jetbrains.com/idea/download/#section=windows


15. (additional)Add dependencies

 	For creating a new project it's needed to be a Maven project with an Appium and TestNG depencencies.
 	In pom.xml file copy a code for dependency from:
	
 		Appium dependency:
 		https://mvnrepository.com/artifact/io.appium/java-client/7.3.0

 		TestNG dependency:
 		https://mvnrepository.com/artifact/org.testng/testng

 	In IntelliJ IDEA take Enable Auto-Import for Maven projects to be imported.








