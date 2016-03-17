vk-android-sdk
==========

Library for working with VK API, authorization through VK app, using VK functions. Minimal version of Android is 2.3

Prepare for Using VK SDK
----------
To use VK SDK primarily you need to create a new VK application  **[here](https://vk.com/editapp?act=create)** by choosing the Standalone application type. Choose a title and confirm the action via SMS and you will be redirected to the application settings page.
You will require your Application ID (referenced as API_ID in the documentation). Fill in the "Batch name for Android", "Main Activity for Android" and "Certificate fingerprint for Android". 

Certificate Fingerprint Receiving
==========
To receive your certificate's fingerprint you can use one of the following methods.

Fingerprint Receiving via Keytool
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

Fingerprint Receiveing via SDK
----------
If you've already added SDK to your project, you can use the following function in each Activity of your app.

```
String[] fingerprints = VKUtil.getCertificateFingerprint(this, this.getPackageName());
```

As a rule, fingerprints contains a single line. It's a fingerprint of your certificate (depends on the certificate used for your app's signing)

<blockquote>You can add more than one fingerprint in your app settings, e.g., debug and release fingerprints.</blockquote>

Connecting VK SDK to Your Android Application
==========

Connecting With Maven
----------
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.vk/androidsdk/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.vk/androidsdk)

You can add next maven dependency in your project:

`com.vk:androidsdk:[MAVEN_CENTRAL_VERSION]`

For example, your gradle script will contains such dependencies: 
```
dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    compile 'com.android.support:appcompat-v7:20.0.0'
    compile 'com.vk:androidsdk:1.6.5'
}
```

Connecting in Android Studio
----------

We give preference to Android Studio and our platform is targeted firstly to this enviroment.

Connecting Using Gradle
----------
You can add the library to your project using Gradle.

1) Copy the **vksdk_library** directory to your project's directory.

2) Find the **settings.gradle** file.

![settings.gradle](https://pp.vk.me/c412727/v412727232/8e2a/bHFxzm-XzgU.jpg "settings.gradle")

Most likely, it contains something like that:
```
include ':app'
```
Edit the line this way:
```
include ':vksdk_library',':app'
```

3) Now your project includes **vksdk_library module**. You need to add it like a dependency to your app. Find the build.gradle file in the subdirectory of your app's module (e.g., YOUR_PROJECT/app/build.gradle).

![build.gradle](https://pp.vk.me/c412727/v412727232/8e31/h_ysvAFuh-Y.jpg "build.gradle")

Add this line to the **dependencies**.
<blockquote>compile project(':vksdk_library')</blockquote>
Your file can be like that:

![build.gradle](https://pp.vk.me/c412727/v412727232/8e23/kZ600DN9jMc.jpg "build.gradle")


Connecting Without Gradle
----------
If your project doesn't support Gradle, you can add SDK by the following way:

1) Open **Project Settings** and select **Modules**.

2) Click the **Add** (+) button and select **Import module**

3) Find the directory with VK SDK and select **vksdk_library**, click **Add**.

4) Select **Create module from existing sources**, then click **Next** two times. Rename the module from "main" to "vksdk", then click **Next**.

5) Add the new **vksdk** module as a dependency to your app's module.


Connecting Using Eclipse
----------
1) In **Package explorer** click right mouse button, then click **Import**.

2) Select **Android/Existing android code into workspace**.

3) Find a folder with SDK, select **vksdk_library**.

4) Open Properties of vksdk_library, then Java build path, then Add folder and pick "java" folder

5) In **Properties** of your app go to **Android**, add **vksdk_library** in the **library** section.


Editing AndroidManifest.xml
----------
Your need to add to your manifest the following elements:

1) in the root of <manifest> you need to add permission <uses-permission android:name="android.permission.INTERNET" />

2) in the <application> element shoud be added

```
<activity android:name="com.vk.sdk.VKServiceActivity" android:label="ServiceActivity" android:theme="@style/VK.Transparent" />
```

to avoid possible problems with running authorizing activity.


Using SDK
==========

SDK Initialization
----------

1) Add this to the resource file (example strings.xml):

```
<integer name="com_vk_sdk_AppId">your_app_id</integer>
```

2) Initialize the SDK on startup using the following method. The best way is to call it in the app's onCreate method.
`VKSdk.initialize(Context applicationContext);`

User Authorization
----------
There are several authorization methods:

```
VKSdk.login(Activity runningActivity, String... scope);
VkSdk.login(Fragment runningFragment, String... scope);
```

When succeeded call the onActivityResultMethod:

```
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
        @Override
        public void onResult(VKAccessToken res) {
            startTestActivity();
            // User passed Authorization
        }
        @Override
        public void onError(VKError error) {
            // User didn't pass Authorization
        }
    })) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
```

Handling "AccessToken invalid"
----------

Use AccessTokenTracker the following way:


```
public class Application extends android.app.Application {
    VKAccessTokenTracker vkAccessTokenTracker = new VKAccessTokenTracker() {
        @Override
        public void onVKAccessTokenChanged(VKAccessToken oldToken, VKAccessToken newToken) {
            if (newToken == null) {
                // VKAccessToken is invalid
            }
        }
    };
    @Override
    public void onCreate() {
        super.onCreate();
        vkAccessTokenTracker.startTracking();
        VKSdk.initialize(this);
    }
}
```

API Requests
==========

Requests Syntax
----------
1) Plain request.
`VKRequest request = VKApi.users().get();`

2) Request with parameters.
`VKRequest request = VKApi.users().get(VKParameters.from(VKApiConst.USER_IDS, "1,2"));`

3) Http (not https) request (only if scope VK_PER_NOHTTPS has been passed).
```
VKRequest request = VKApi.users().get(VKParameters.from(VKApiConst.USER_IDS, "1,2"));
request.secure = NO;
```

4) Request with predetermined maximum number of attempts.
```
VKRequest request = VKApi.wall().post(VKParameters.from(VKApiConst.OWNER_ID, "-60479154", VKApiConst.MESSAGE, "Hello, world!"));
request.attempts = 10;
//or infinite
//postReq.attempts = 0;
```
It will take 10 attempts until succeeds or an API error occurs. 

5) Request that calls a method of VK API.
`VKRequest request = new VKRequest("friends.get", VKParameters.from(VKApiConst.FIELDS, "sex,bdate,city"));`

6) Request for uploading photos on user wall.
```
final Bitmap photo = getPhoto();
VKRequest request = VKApi.uploadWallPhotoRequest(new VKUploadImage(photo, VKImageParameters.jpgImage(0.9f)), 0, 60479154);
```

Requests Sending
----------
```
request.executeWithListener(new VKRequestListener() {
    @Override
    public void onComplete(VKResponse response) {
        //Do complete stuff
    }
    @Override
    public void onError(VKError error) {
        //Do error stuff
    }
    @Override
    public void onProgress(VKRequest.VKProgressType progressType,
                                     long bytesLoaded,
                                     long bytesTotal)
    {
        //I don't really believe in progress
    }
    @Override
    public void attemptFailed(VKRequest request, int attemptNumber, int totalAttempts) {
        //More luck next time
    }
});
```

Batch Processing Requests
----------
SDK gives a feature to execute several unrelated requests at the one call. 
1) Prepare requests.
                    
```
VKRequest request1 = VKApi.uploadWallPhotoRequest(new VKUploadImage(photo1, VKImageParameters.jpgImage(0.9f)), 0, 60479154);
VKRequest request2 = VKApi.uploadWallPhotoRequest(new VKUploadImage(photo2, VKImageParameters.jpgImage(0.5f)), 0, 60479154);
VKRequest request3 = VKApi.uploadWallPhotoRequest(new VKUploadImage(photo3, VKImageParameters.jpgImage(0.1f)), 0, 60479154);
VKRequest request4 = VKApi.uploadWallPhotoRequest(new VKUploadImage(photo4, VKImageParameters.pngImage()), 0, 60479154);
```

2)  Combine created requests into one. 
`VKBatchRequest batch = new VKBatchRequest(request1, request2, request3, request4);`

3) Load the obtained request.

```
batch.executeWithListener(new VKBatchRequestListener() {
    @Override
    public void onComplete(VKResponse[] responses) {
        super.onComplete(responses);
        String[] photos = new String[responses.length];
        for (int i = 0; i < responses.length; i++) {
            VKPhoto photoModel = ((VKPhotoArray) responses[i].parsedModel).get(0);
            photos[i] = String.format("photo%s_%s", photoModel.owner_id, photoModel.id);
        }
        makePost(VKStringJoiner.join(photos, ","));
    }
    @Override
    public void onError(VKError error) {
        showError(error);
    }
});
```

4) The result of each method returns to a corresponding requestListener. The **batch** VKResponse for each request in order they have been passed.

Use sdk purchases
=========
* For use sdk purchases you must use com.vk.sdk.payments.VKIInAppBillingService instead com.android.vending.billing.IInAppBillingService like this
mService = new VKIInAppBillingService(IInAppBillingService.Stub.asInterface(service));

* when initialize app use VKSdk.initialize(this).withPayments();

* add below code for your manifest


```
<receiver
            android:name="com.vk.sdk.payments.VKPaymentsReceiver"
            android:exported="true">
            <intent-filter>
                <action android:name="android.net.conn.CONNECTIVITY_CHANGE"/>
            </intent-filter>
            <intent-filter>
                <action android:name="com.android.vending.INSTALL_REFERRER"/>
            </intent-filter>
        </receiver>```

Class Reference
=========
[See the full classes reference at GitHub pages](http://vkcom.github.io/vk-android-sdk/)
