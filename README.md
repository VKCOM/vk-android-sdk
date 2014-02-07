VK SDK 2.0
==========

Enhanced library for working with VK API, Minimal version of Android is 2.2

Overview of features:

* Authorization via OAuth and official application
* Async requests processing, enhanced callback
* Errors auto handling: captcha, token expiration, validation procedure, https_only error.
* Sync requests processing
* Set of models, tools and classes for easy writing your own queries and parsing server response, including parsing based on reflection.
* Adaptive issuing photos for photo_sizes
* Requests cancelation API
* GZIP compression and fast HTTP implementation
* Optimized multithreading for better performance
* HTTP mode support
* Universal set of models allows you to store a data cache
* File uploading to VK servers with upload listeners
* Supports sequential request execution(RequestBatch)
* Support for parallel request execution (automatic bonding to execute)
* Support for delayed or periodic requests
* Support Activity recreation when configuration is changed
* Support for Codeblock, Execute and StoredFuctions.

Documentation and samples
==========
Project's ''doc'' folder contains class reference in ''JavaDoc'' format. You can find sources of sample app in project's  ''Sample'' folder. Also available is a [detailed overview](http://vk.com/page-54475169_46888763) of the SDK(only russian language).


Installation
==========

To use VK SDK primarily you need to create a new VK application  <b>[here](https://vk.com/editapp?act=create)</b> by choosing the Standalone application type. Choose a title and confirm the action via SMS and you will be redirected to the application settings page. 
You will require your Application ID (referenced as API_ID in the documentation). Fill in the "Batch name for Android", "Main Activity for Android" and "Certificate fingerprint for Android". 

Certificate Fingerprint Receiving
----------

1) You need to find the keystore location for your app. The ''debug'' store is usually located in these directories:
* ~/.android/ for OS X and Linux, 
* C:\Documents and Settings\<user>\.android\ for Windows XP, 
* C:\Users\<user>\.android\ for Windows Vista, Windows 7 and Windows 8.

The keystore for the release version is usually created by a programmer, so you should create it or recall its location. 
2) After the keystore's location has been found, use keytool utilite (it is supplied with the Java SDK). You can get keys list with the following command:
<blockquote>keytool -exportcert -alias androiddebugkey -keystore path-to-debug-or-production-keystore -list -v</blockquote>
You will observe a similar result:
 <blockquote>Certificate fingerprint: SHA1: DA:39:A3:EE:5E:6B:4B:0D:32:55:BF:EF:95:60:18:90:AF:D8:07:09</blockquote>
By deleting all the colons you'll get your key's fingerprint.

<blockquote>You can add more than one fingerprint in your app settings, e.g., debug and release fingerprints.</blockquote>

Connecting Using Gradle
----------
You can add the library to your project using Gradle.

Copy the <b>vk-android-sdk</b> directory to your project's directory.

Adding a new module to your settings.gradle (replace the app on the name of your main project):

```
include ':vk-android-sdk', ':app' 
```
Then add a dependency on the project by adding the following line to the <b>dependencies</b> of your <b>app/build.gradle<b>: 
```
compile project(":vk-android-sdk") 
```

You will also need the following permissions in <b>AndroidManifest.xml</b>:

```
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" /> 
<uses-permission android:name="android.permission.INTERNET" /> 
```

Connecting Without Gradle
----------

Open <b>Project Settings</b> and select <b>Modules</b>.

Click the <b>Add</b> (+) button and select <b>Import module</b>

Find the directory with VK SDK and select <b>vk-android-sdk</b>, click <b>Add</b>.

Select <b>Create module from existing sources</b>, then click <b>Next</b> two times. Rename the module from "main" to "vk-android-sdk", then click <b>Next</b>.

Add the new <b>vk-android-sdk</b> module as a dependency to your app's module.

Connecting Using Eclipse
----------

In <b>Package explorer</b> click right mouse button, then click <b>Import</b>.

Select <b>Android/Existing android code into workspace</b>.

Find a folder with SDK, select <b>vk-android-sdk</b>.

Open Properties of vk-android-sdk, then Java build path, then Add folder and pick "java" folder

In <b>Properties</b> of your app go to <b>Android</b>, add <b>vk-android-sdk</b> in the <b>library</b> section.
