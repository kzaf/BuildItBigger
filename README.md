# Gradle for Android and Java Final Project

In this project, I have created an app with multiple flavors that uses
multiple libraries and Google Cloud Endpoints. 

The finished app will consist of four modules. 
* A Java library that provides jokes, 
* A Google Cloud Endpoints (GCE) project that serves those jokes, 
* An Android Library containing an activity for displaying jokes,
* An Android app that fetches jokes from the GCE module and passes them to the Android Library for display.

## Why this Project

As Android projects grow in complexity, it becomes necessary to customize the
behavior of the Gradle build tool, allowing automation of repetitive tasks.
Particularly, factoring functionality into libraries and creating product
flavors allow for much bigger projects with minimal added complexity.

## What I Learned?

I learned the role of Gradle in building Android Apps and how to use Gradle to manage apps of increasing complexity:
* Add free and paid flavors to an app, and set up your build to share code between them
* Factor reusable functionality into a Java library
* Factor reusable Android functionality into an Android library
* Configure a multi project build to compile your libraries and app
* Use the Gradle App Engine plugin to deploy a backend
* Configure an integration test suite that runs against the local App Engine development server

### Step 0: Starting Point

This is the starting point for the final project, which is provided in
the [course repository](https://github.com/udacity/ud867/tree/master/FinalProject).
It ontains an activity with a banner ad and a button that purports to tell a
joke, but actually just complains. The banner ad was set up following the
instructions here:

https://developers.google.com/mobile-ads-sdk/docs/admob/android/quick-start


### Step 1: Create a Java library

Created a new Gradle Java project. Then introduced a project dependency between your app and the new Java Library.

### Step 2: Create an Android Library

Wired up project dependencies so that the button can now pass the joke from the Java Library to the Android Library.

### Step 3: Setup GCE

Before going ahead a local instance of the GCE is needed to run the server. 
In order to do that the Cloud SDK has to be installed:
https://cloud.google.com/sdk/docs/

The local server can be started or stoped by using the gradle tasks as shown in the following screenshot:

<img src="/FinalProject/GCE-server-gradle-tasks.png" height="500">

Once the local GCE server is started the following can be seen at [localhost:8080](http://localhost:8080)

<img src="https://raw.githubusercontent.com/GoogleCloudPlatform/gradle-appengine-templates/77e9910911d5412e5efede5fa681ec105a0f02ad/doc/img/devappserver-endpoints.png">

Introduced a project dependency between Java library 
and GCE module, and modified the GCE starter code to pull jokes from the Java library. 

An AsyncTask has been created to retrieve jokes using the template included in these [instructions](https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/77e9910911d5412e5efede5fa681ec105a0f02ad/HelloEndpoints#2-connecting-your-android-app-to-the-backend). 

The button kicks off a task to retrieve a joke, then the activity is launched from the Android Library to display it.

### Step 4: Add Functional Tests

Added code to test that the Async task successfully retrieves a non-empty string.

### Step 5: Add a Paid Flavor

Added free and paid product flavors to the app.

# Rubric

### Components

* Project contains a Java library for supplying jokes
* Project contains an Android library with an activity that displays jokes passed to it as intent extras.
* Project contains a Google Cloud Endpoints module that supplies jokes from the Java library. Project loads jokes from GCE module via an async task.
* Project contains connected tests to verify that the async task is indeed loading jokes.
* Project contains paid/free flavors. The paid flavor has no ads, and no unnecessary dependencies.

### Behavior

* App retrieves jokes from Google Cloud Endpoints module and displays them via an Activity from the Android Library.
