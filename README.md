# Gradle for Android and Java Final Project
In this project, you will create an app with multiple flavors that uses
multiple libraries and Google Could Endpoints. The finished app will consist
of four modules. A Java library that provides jokes, a Google Could Endpoints
(GCE) project that serves those jokes, an Android Library containing an
activity for displaying jokes, and an Android app that fetches jokes from the
GCE module and passes them to the Android Library for display.

## Why this Project
As Android projects grow in complexity, it becomes necessary to customize the
behavior of the Gradle build tool, allowing automation of repetitive tasks.
Particularly, factoring functionality into libraries and creating product
flavors allow for much bigger projects with minimal added complexity.

##What Will I Learn?
You will learn the role of Gradle in building Android Apps and how to use Gradle to manage apps of increasing complexity. You'll learn to:
* Add free and paid flavors to an app, and set up your build to share code between them
* Factor reusable functionality into a Java library
* Factor reusable Android functionality into an Android library
* Configure a multi project build to compile your libraries and app
* Use the Gradle App Engine plugin to deploy a backend
* Configure an integration test suite that runs against the local App Engine development server

##How Do I Complete this Project?
### Step 0: Starting Point
This is the starting point for the final project, which is provided to you in the [course repository](https://github.com/udacity/ud867/tree/master/FinalProject).
It contains an activity with a banner ad and a button that purports to tell a
joke, but actually just complains. The banner ad was set up following the
instructions here:
https://developers.google.com/mobile-ads-sdk/docs/admob/android/quick-start
You may need to download the Google Repository from the Extras section of the
Android SDK Manager.

When you can build an deploy this starter code to an emulator, you're ready to
move on.
### Step 1: Create a Java library
Your first task is to create a Java library that provides jokes. Create a new
Gradle Java project either using the Android Studio wizard, or by hand. Then
introduce a project dependency between your app and the new Java Library. If
you need review, check out demo 4.01 from the course code.
Make the button display a toast showing a joke retrieved from your Java joke
telling library.
### Step 2: Create an Android Library
Create an Android Library containing an Activity that will display a joke
passed to it as an intent extra. Wire up project dependencies so that the
button can now pass the joke from the Java Library to the Android Library.
For review on how to create an Android library, check out demo 4.03. For a
refresher on intent extras, check out;
http://developer.android.com/guide/components/intents-filters.html
### Step 3: Create GCE Module
This next task will be pretty tricky. Instead of pulling jokes directly from
our Java library, we'll set up a Google Cloud Endpoints development server,
and pull our jokes from there. Follow the instructions in the following
tutorial to add a Google Could Endpoints module to your project:
https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
Introduce a project dependency between your Java library and your GCE module,
and modify the GCE starter code to pull jokes from your Java library. Create
an Async task to retrieve jokes. Make the button kick off a task to retrieve a
joke, then launch the activity from your Android Library to display it.
### Step 4: Add Functional Tests
Add code to test that your Async task successfully retrieves a non-empty
string. For a refresher on setting up Android tests, check out demo 4.09.
### Step 5: Add a Paid Flavor
Add free and paid product flavors to your app. Remove the ad (and any
dependencies you can) from the paid flavor.
## Optional Tasks
To exceed expectations, do the following:
### Add Interstitial Ad
Follow these instructions to add an interstitial ad to the free version.
Display the add after the user hits the button, but before the joke is shown.
https://developers.google.com/mobile-ads-sdk/docs/admob/android/interstitial
### Add Loading Indicator
Add a loading indicator that is shown while the joke is being retrieved and
disappears when the joke is ready. The following tutorial is a good place to
start:
http://www.tutorialspoint.com/android/android_loading_spinner.htm
### Configure Test Task
To tie it all together, create a Gradle task that:
1. Launches the GCE local development server
2. Runs all tests
3. Shuts the server down again
# Rubric
### Required Components
* Project contains a Java library for supplying jokes
* Project contains an Android library with an activity that displays jokes passed to it as intent extras.
* Project contains a Google Cloud Endpoints module that supplies jokes from the Java library. Project loads jokes from GCE module via an async task.
* Project contains connected tests to verify that the async task is indeed loading jokes.
* Project contains paid/free flavors. The paid flavor has no ads, and no unnecessary dependencies.
### Required Behavior
* App retrieves jokes from Google Cloud Endpoints module and displays them via an Activity from the Android Library.
### Optional Components
To receive "exceeds specifications", your app must fully implement all of the following items.
* The free app variant displays interstitial ads between the main activity and the joke-displaying activity.
* The app displays a loading indicator while the joke is being fetched from the server.
* The root build.gradle file contains a task that will start up the GCE development server, run all Android tests, then shutdown the development server.

#Execution Instructions
Requires: Android Studio v1.5.0+

Dependencies:
-------------
Min SDK Version: 10 (Gingerbread 2.3.3)
Target SDK Version: 22 (Android lollipop)
Android Support Library v7 revision 22.1.1

Building/Running the app:
-------------------------

#### Setting up the Java Environment
Install the [Java SDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html) on your system.

#### Set up Git Repository
*  Install git.  For Windows users, you may wish to do so by installing [GitHub for Windows](https://windows.github.com/).  For Mac users, there is [GitHub for Mac](https://mac.github.com/).
*  Clone the project repository.  To do so with the GitHub application, click the plus sign in the upper left, and select to clone a repository.
    -  The project repository URL to clone with public access is:
    [https://github.com/nshukla75/builditbigger.git](https://github.com/nshukla75/builditbigger.git)

#### Installing Android SDK Dependencies
*  Install [Android Studio](https://developer.android.com/sdk/installing/studio.html).
*  Launch Android Studio and select to 'Import Project' from the project directory cloned to above.
*  Then, in Android Studio, go to Tools->Android->SDK Manager and
install the following:
  -  Tools -> Android SDK Build-tools 22.1
  -  Android 5.1.1K (API V22) -> SDK Platform and Google APIs
       - For running in an emulator, install one or both system images.  The Intel x86 system image will run much faster than ARM, especially if hardware acceleration is enabled.
  -  Extras -> Android Support Library
  -  Extras -> Android Support Repository
  -  Extras -> Google Play Services (v.19)
  -  Extras -> Google Repository
  -  For a faster emulator on Windows, Extras -> Intel x86 Emulator Accelerator
  
#### Install device drivers and enable debug mode on device
*  Windows users will need to install the appropriate USB driver for their device in order to run the app on a device.  Please see the [list of available USB drivers](http://developer.android.com/tools/extras/oem-usb.html) and installation instructions.
* You can [enable debug mode on your device](http://developer.android.com/tools/device.html) to allow debugging over USB.

#### Running in an emulator
The app will run on an Android emulator.  
The emulator will run much faster with hardware acceleration enabled.  Please see the [directions on using the Android emulator and enabling hardware acceleration](http://developer.android.com/tools/devices/emulator.html).  For Windows, this uses the HAXM emulator accelerator package available under 'Extras' in the SDK Manager.

#### Running the app
Sync your gradle build file if your IDE asks you to, and then run the app via Run -> Run.

Troubleshooting Steps
---------------------

If the project won't build, here are a few steps to try:

1.  Shelve any changes:  VCS -> Shelve Changes
2.  Sync the gradle files:  Tools -> Android -> Sync Project with Gradle Files
3.  Clean the project build:  Build -> Clean project
