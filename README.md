VK SDK for Android
==========

[![Maven Central](https://img.shields.io/maven-central/v/com.vk/android-sdk-core.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.vk%22%20AND%20a:%22android-sdk-core%22)

Library for working with VK API, authorization through VK app, using VK functions. Minimal version of Android is 5.0

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

2) After the keystore's location has been found, use keytool utility (it is supplied with the Java SDK). You can get keys list with the following command:
<blockquote>keytool -exportcert -alias androiddebugkey -keystore path-to-debug-or-production-keystore -list -v</blockquote>
You will observe a similar result:
<blockquote>Certificate fingerprint: SHA1: DA:39:A3:EE:5E:6B:4B:0D:32:55:BF:EF:95:60:18:90:AF:D8:07:09</blockquote>
By deleting all the colons you'll get your key's fingerprint.

Fingerprint Receiving via SDK
----------
If you've already added SDK to your project, you can use the following function in each Activity of your app.

```
String[] fingerprints = VKUtils.getCertificateFingerprint(this, this.getPackageName());
```

As a rule, fingerprints contains a single line. It's a fingerprint of your certificate (depends on the certificate used for your app's signing)

Fingerprint Receiving via Android Studio
----------
Click in right menu on **Gradle** tab (or double shift and type **Gradle**). Open your project **root** folder, then open **Tasks** and after **android**.
Run **signingReport** task.
Find your **SHA1** fingerprint in **Run** tab output.

<blockquote>You can add more than one fingerprint in your app settings, e.g., debug and release fingerprints.</blockquote>

Connecting VK SDK to Your Android Application
==========

Connecting With Maven
----------
[![Core Release](https://img.shields.io/maven-central/v/com.vk/android-sdk-core.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.vk%22%20AND%20a:%22android-sdk-core%22)


You can add next maven dependency in your project:

The available library modules are listed below.

* `android-sdk-core`: Core functionality (required).
* `android-sdk-api` : Api generated models and methods.

* `androidsdk`: deprecated copy version of the android-sdk-core(will be removed in future releases since 01.09.2021).
* `androidsdkapi` : deprecated copy version of the android-sdk-api(will be removed in future releases since 01.09.2021).

For example, your `app/build.gradle` script will contains such dependencies:
```
dependencies {
    implementation 'com.vk:android-sdk-core:3.x.x'
    implementation 'com.vk:android-sdk-api:3.x.x' // generated models and api methods
}
```

Using SDK
==========

SDK Initialization
----------

1) Add permission to AndroidManifest.xml:

```
<uses-permission android:name="android.permission.INTERNET"/>
```

2) Add this to the resource file (example strings.xml):

```
<integer name="com_vk_sdk_AppId">your_app_id</integer>
```

User Authorization
----------
Create authorization launcher:

```kotlin
val authLauncher = VK.login(activity) { result : VKAuthenticationResult ->
    when (result) {
        is VKAuthenticationResult.Success -> {
            // User passed authorization
        }
        is VKAuthenticationResult.Failed -> {
            // User didn't pass authorization
        }
    }
}
```
In appropriate place call a created launcher:

```kotlin
authLauncher.launch(arrayListOf(VKScope.WALL, VKScope.PHOTOS))
```

Handling token authorization
----------
Create instance of VKTokenExpiredHandler:

```kotlin
class SampleApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        VK.addTokenExpiredHandler(tokenTracker)
    }

    private val tokenTracker = object: VKTokenExpiredHandler {
        override fun onTokenExpired() {
            // token expired
        }
    }
}
```


API Requests
==========

Run request with VK.execute and auto generated methods(android-sdk-api dependency is required):

```kotlin
VK.execute(FriendsService().friendsGet(fields = fields), object: VKApiCallback<FriendsGetFieldsResponse> {
            override fun success(result: FriendsGetFieldsResponse) {
                // you stuff is here
            }
            override fun fail(error: Exception) {
                Log.e(TAG, error.toString())
            }
        })
```


If you are using RxJava in your project, you can do something like this:

```kotlin
Observable.fromCallable {
    VK.executeSync(VKUsersRequest())
}
    .subscribeOn(Schedulers.single())
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe({
        // response here
    }, {
        // throwable here
    })
```

If you need more complex request, you should override ApiCommand. 
This approach allows you to make multiple requests at once
For example: [VKUsersRequest](samples/app/src/main/java/com/vk/sdk/sample/requests/VKUsersRequest.kt)

```kotlin
class VKUsersCommand(private val uids: IntArray = intArrayOf()): ApiCommand<List<VKUser>>() {
    override fun onExecute(manager: VKApiManager): List<VKUser> {

        if (uids.isEmpty()) {
            // if no uids, send user's data
            val call = VKMethodCall.Builder()
                    .method("users.get")
                    .args("fields", "photo_200")
                    .version(manager.config.version)
                    .build()
            return manager.execute(call, ResponseApiParser())
        } else {
            val result = ArrayList<VKUser>()
            val chunks = uids.toList().chunked(CHUNK_LIMIT)
            for (chunk in chunks) {
                val call = VKMethodCall.Builder()
                        .method("users.get")
                        .args("user_ids", chunk.joinToString(","))
                        .args("fields", "photo_200")
                        .version(manager.config.version)
                        .build()
                result.addAll(manager.execute(call, ResponseApiParser()))
            }
            return result
        }
    }

    companion object {
        const val CHUNK_LIMIT = 900
    }

    private class ResponseApiParser : VKApiResponseParser<List<VKUser>> {
        override fun parse(response: String): List<VKUser> {
            try {
                val ja = JSONObject(response).getJSONArray("response")
                val r = ArrayList<VKUser>(ja.length())
                for (i in 0 until ja.length()) {
                    val user = VKUser.parse(ja.getJSONObject(i))
                    r.add(user)
                }
                return r
            } catch (ex: JSONException) {
                throw VKApiIllegalResponseException(ex)
            }
        }
    }
}
```

VKUsersCommand supports dividing by chunks for working with api limits. This is main difference between VKUsersRequest and VKUsersCommand

Also you can check up [VKWallPostCommand](samples/app/src/main/java/com/vk/sdk/sample/requests/VKWallPostCommand.kt). 
This an example of complex api request with file uploading
