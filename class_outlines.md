# Tuesday, September 5th: Course Introduction
* This course is 5 years in the making, since 2011
* I can't think of anything that we will not want to discuss in this course
* Why (finally) disuss about mobile in a CS curriculum?  Mobile Development sounds very vocational:
	- Mobile is not going away: even in third-world countries, almost everyone has a mobile device
	- Mobile is very different environment than traditional PC
	- Writing software is very different than what you have been accustomed to
	- "Always on"
	- Constraints galore: battery and power, screen size, user interaction paradigm, memory, disk space, networking => you cannot take many elements for granted
	- Distribution model is very different that say deploying a website
	- New features to take advantage of including GPS, accelerometer, SMS, compass, NFC, camera
	- Networking: can you depend on it? Think 2G.
	- New security model and privacy issues
	- Mobile is not going away despite it is much harder to make money on a mobile platform now
	- Testing gets interesting especially with physical devices and fragmentation in Android (including carrier issues)
	- Policy issues in the news
	- Topics in Programming Languages, Operating Systems, Security and Privacy, Algorithms, Web, and Data Structures will constantly come up
	- Students have little exposure to the full-stack
	- If you do not understand mobile development, it will be very hard to understand issues such as mobile malware, forensics, privacy (or lack thereof) in mobile
	- To go through pain.  You are now at the mercy of corporations and things will change all the time.  There will be things you will do not understand and you have little control.
* What we will be using in this course: Android.  Baseline target of devices: Android 6.0 (Marshmellow).
* Why not iOS for this course?
* Assessment and the Semester Project:
	- Engineering notebook
* What you will need for the course:
	- Java
	- Android Studio
	- Node.js
* Q: Do we need an Android device for this course? A: No
* Let's start a simple app in Android Studio and pinpoint the big ideas and topics......
	- The reason why we are doing this: we have moved away from looking "under the hood."  So much is now abstracted in a CS curriculum.

# Thursday, September 7th: The Basics
* Last class: structure of an Android app
* The Android architecture: https://developer.android.com/guide/platform/index.html
* Android Runtime: Dalvik VM: https://source.android.com/devices/tech/dalvik/
* Components of an Android app:
	- Activity: a single screen, the user interface. While you can have multiple activities in an app, they are independent of each other!  This is what we are focusing on today
		- View: refers to the rectangular portion of screen; "container"
		- Best practice: one activity per screen
	- Service
	- Receiver
	- Intent
	- Content provider
* Activity lifecycle:
	- ![Diagram](activity_lifecycle.png "Diagram")
	- Documentation: https://developer.android.com/reference/android/app/Activity.html#ActivityLifecycle
* Going back to our starter Android app
* `AndroidManifest.xml` - Information about the app including components of the application, permissions, linked libraries, and minimum version of Android OS and API the app requires
* Android and Java documentation
* Basic Java review
* Designing a view and widgets
* Linking a view into an activity
* The Android `R` class: dynamically generated class, created during build process to dynamically identify all assets (from strings to android widgets to layouts), for usage in java classes in Android app.  More: http://stackoverflow.com/questions/6804053/understand-the-r-class-in-android.  DO NOT MANUALLY MODIFY THIS CLASS!
* Interaction

# Tuesday, September 12th: The Toolchain
* Leg 1 due this week.  What you need to do: email me link to your team's engineering notebook
* Last class: a simple app with an activity, a view, and widgets
* Today: more basics, the tools
* `.apk` - the binary of the app.  Automatically generated for each app.  Believe it or not, it is just a ZIP file! http://stackoverflow.com/questions/3599210/view-content-of-apk-file.  Later in this course, we will discuss about reverse engineering an app
	- Flappy Bird
* Enabling "Developer Options" on an Android device => click on "Build Number" of your system 7 times.
* `adb`- Android Debug Bridge
	- `adb devices`
	- `adb install ...`
	- `adb push...` => upload a file from machine to device
	- `adb pull... => download a file from device to machine
	- `adb reboot`
	- `adb shell`
	- `adb logcat`
* `android` - Android SDK manager
* Managing Android simulators (`avd`)
	- `emulator`
	- How the Android simulator really works: virtual machine via `qemu`
* `ddms` - Dalvik Debug Monitor Server. https://developer.android.com/studio/profile/ddms.html
* `lint` - Lint tool for Android apps.  IMPORTANT for this class. https://developer.android.com/studio/write/lint.html
* `fastboot` -  Used to manipulate the flash partitions of the Android developer phone.  Used to install custom Android ROM (e.g., for rooting)
* `monkeyrunner` - https://developer.android.com/studio/test/monkeyrunner/index.html