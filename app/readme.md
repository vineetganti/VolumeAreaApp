# 🧮 VolumeAreaApp — Android Beginner Learning Journal

> **How to use this README:** The purpose of publishing this project, although a beginner one is to create a documented learning journey for myself and fellow Android developers who are in similar learning phase.
> Treat this is more as a personal write-and-learn document — there might be some details which might seem obvious to others but that is just how am writing this down for my own learning.

---

## 📖 Project Overview

**What does this app do?**

The purpose of this app is to calculate volume of various geometric shapes, specifically sphere, cube, cylinder and Prism.
This is primarily a two layout android application that helps us understand the concepts of GridView layouts, Model classes, GridView adapters and layout inflaters.
As you walk through this document, you might find something new to stumble upon and learn about the basics.

**Why did I build this?**

On a broader perspective, I want to build an end to end functional chat app tweaking in features which are not in current market chat apps.
Hence, the attempt to eventually get there by building smaller apps in Java and Kotlin.

**Current status:**

- [ ] Planning
- [ ] In progress
- [✅] Completed

---

## 🛠️ Tech Stack & Tools

| Tool / Technology | Version | Why I used it                                                                                                                                                                                                                                                                                                      |
|---|---|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Language | Java | Although Kotlin is the preferred choice for building Android apps because of it's readability, Null safety features by preventing common runtime crashes by catching null pointer exceptions at complile time, extension functions, lambda expressions and coroutines, I opted Java purely for the learning curve. |
| IDE | Android Studio | [ Which version? Any setup gotchas? ]                                                                                                                                                                                                                                                                              |
| Build System | Gradle (Kotlin DSL) | [ What is Gradle? What does build.gradle.kts do? ]                                                                                                                                                                                                                                                                 |
| Min SDK | [ e.g. API 24 ] | [ What does Min SDK mean? Which Android versions does this cover? ]                                                                                                                                                                                                                                                |
| Target SDK | [ e.g. API 34 ] | [ Why does Target SDK matter? ]                                                                                                                                                                                                                                                                                    |

#### Note on coroutines in Kotlin: Coroutines provide a more straight forward way to write a synchronous,non-blocking code, making it easier to handle tasks like network requests and concurrent operations.
#### It also avoids the need for writing boilerplate code especially for tasks like variable declaration, getters, setters and anonymous classes. Wait why am i using Java again?
---

## 📁 Project Structure

```
VolumeAreaApp/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/          ← Where I wrote my code
│   │   │   ├── res/           ← Where I wrote my XML layouts
│   │   │   └── AndroidManifest.xml  ← Where I registered my activities
│   │   └── test/              ← Unit tests that run on JVM.
├── build.gradle.kts            ← Applies config to all modules/ subprojects at root level.
├── settings.gradle.kts         ← Defines project structure, which modules to fetch plugins/ dependencies from.
└── gradle.properties           ← Key-Value config file for tuning gradle's behavior and passing flags to the build.
```

**My own explanation of the folder structure: (but actually prompted from claude)**

app/ - The main application module. Large projects can have multiple modules; app is the 
primary one that produces the final APK.

src/ - Contains all source code and resources, split into source sets:
main/ - production code,
test/ - unit tests,
androidTest/ - UI tests

main/ - The core of the app. Everything here goes to the final build.

java/ - All Kotlin/ Java source files, organized by package (e.g. com.example.app). Contains activities, 
ViewModels, Repositories, etc. despite being called "java", Kotlin files go here too.

res/ - All non-code resources: layout/ - XML UI layouts, drawable/ - images and icons, 
values/ - strings, colors, dimensions, themes, mipmap - app launcher icons

AndroidManifest.xml - App's configuration file. Declares components (Activities, Services, Receivers),
permissions (camera, internet), the app entry point, and metadata. Android reads this to understand
how the app is structured.

test/ - Local JVM unit tests. Fast, no device needed. Tests pure logic like ViewModels 
and utility functions

build.gradle.kts - Build config written in Kotlin DSL. Exists at two levels:
project level - global config, plugin versions, App level - dependencies, SDK versions(minSDK, targetSDK),
appID, build types (debug/ release)

settings.gradle.kts - Defines which modules are included in the project. Also configures repository
sources like Google and Maven Central. The entry point Gradle reads first.

gradle.properties - Key-Value config for the Gradle build system itself. Common settings include JVM
heap size, enabling AndroidX, and turning on Kotlin/ Android-specific flags like android.useAndroidX=true


---

## 🧠 Core Android Concepts I Learned

> This is the heart of the learning journal

### Activities

**What is an Activity?**

An Activity is like one screen of the app. It has a lifecycle — it can be created, paused,
stopped, or destroyed...

Unlike other programming languages, which are launched with main method, the Android system initiates code
in an activity instance by invoking specific callback methods that correspond to specific stages of it's lifecycle

In the mobile-app experience, the user journey often begins non-deterministically and the Activity class is designed to
facilitate this paradigm. When one app invokes another, the calling app invokes an activity in the other app,
rather than the app as an atomic whole. The activity serves as the entry point for an app's interaction with the user.


**Activities in this project:**

| Activity Name | What it does |
|---|---|
| `MainActivity.java` | [ Describe what this screen shows/does ] |

**What I found confusing about Activities:**

[ Be honest — what tripped you up? Did the back stack confuse you? The lifecycle? ]

---

### The Activity Lifecycle

An activity lifecycle is essential for transitioning between states. We use a series of callbacks to handle
transitions between states. 

onCreate - When the system creates the activity to create views and bind data to lists.

onStart - Activity becomes visible to the user. Final preparations for coming to the foreground and becoming 
interactive

onResume - Invokes this callback just before the activity starts interacting with the user. Activity is at the 
top of the activity stack, and captures all user input. Most of an app's core functionality is implemented in the
onResume method. 

onPause - Activity loses focus and enters a paused state. Occurs when user taps the back or recents button. 
Still partially visible, but most often is an indication that the user is leaving the activity and will soon 
enter Stopped or Resumed state. 

onStop - Activity is no longer visible to the user. Activity either destroyed, new activity starting up,
or returning to resumed state and covering the stopped activity. Either onRestart or onDestroy.

onRestart - Activity is being restarted. Restores the state of the activity from the time it was stopped and always
followed by onStart.

onDestroy - Activity is being destroyed. Implemented to ensure that all resources are released and avoid leaks.

```
onCreate() → onStart() → onResume() → [App Running]
                                            ↓
                                       onPause() → onStop() → onDestroy()
```

**When do I use each callback?**

- `onCreate()`: Used this callback in MainActivity.java 

---

### XML Layouts

**What is an XML layout file?**

[ Explain in your own words how XML describes the UI. ]

**Layout types I used:**

| Layout | When I used it | Why I chose it |
|---|---|---|
| `LinearLayout` | [ ... ] | [ ... ] |
| `ConstraintLayout` | [ ... ] | [ ... ] |
| [ others ] | [ ... ] | [ ... ] |

**A layout snippet I'm proud of (paste it here):**

```xml
<!-- Paste a layout snippet and explain what each attribute does -->
```

---

### Views & View Binding

**Common Views I used:**

| View | What it does | Example in my app |
|---|---|---|
| `TextView` | Displays text | [ ... ] |
| `ImageView` | Displays images | [ ... ] |
| `RecyclerView` | Scrollable list | [ ... ] |
| `Button` | Tappable button | [ ... ] |

**How I connected XML to Java (findViewById or ViewBinding):**

[ Explain the difference between `findViewById` and View Binding. Which did you use and why? ]

---

### Intents

**What is an Intent?**

[ Explain what an Intent is. How did you use it to navigate between screens? ]

**Explicit vs Implicit Intents:**

[ Describe the difference in your own words with an example from your app. ]

**Code I wrote:**

```java
// Paste an example of how you launched a new Activity
```

---

### RecyclerView & Adapters

**Why can't I just use a ListView?**

[ What did you learn about the difference? ]

**How RecyclerView works (in my own words):**

[ Explain ViewHolder pattern, the Adapter, and how they connect. This is a key concept! ]

**My Adapter class:**

```java
// Paste a snippet of your Adapter or describe how you wrote it
```

---

### AndroidManifest.xml

**What is the Manifest?**

[ Explain what this file registers and declares. ]

**Things I declared in my Manifest:**

- [ e.g., Activities I registered ]
- [ e.g., Permissions I requested — why? ]
- [ e.g., The launcher Activity ]

---

## 🌐 Networking (if applicable)

**Did the app fetch data from the internet?**

[ Yes / No — if yes, describe what API or data source you used. ]

**Library used:**

[ e.g., Retrofit, Volley, OkHttp — what is it and how does it work? ]

**How I handled JSON parsing:**

[ Did you use Gson? JSONObject? Explain. ]

**A thing that confused me about networking:**

[ Threads? Callbacks? The main thread rule? Write it here. ]

---

## 🧱 Build System — Gradle

**What is Gradle?**

[ In plain English, what does Gradle do? ]

**build.gradle.kts (app level) — what I added:**

```kotlin
// Paste key dependencies you added and explain what they do
dependencies {
    // e.g., implementation("...") ← what does this library add?
}
```

**The difference between project-level and app-level Gradle:**

[ Explain what each file controls. ]

---

## 🐛 Bugs I Hit & How I Fixed Them

> This is one of the most valuable sections. Document your debugging process.

| Bug | What caused it | How I fixed it |
|---|---|---|
| [ e.g., App crashed on launch ] | [ NullPointerException in onCreate ] | [ Forgot to call setContentView() ] |
| [ ... ] | [ ... ] | [ ... ] |

**Most confusing error message I faced:**

[ Paste the error and explain what it actually meant once you figured it out. ]

---

## 💡 Key Takeaways & "Aha!" Moments

[ This is your reflection section. Write down the moments where things clicked. ]

1. [ e.g., "I finally understood that the UI thread is special — you can't do network calls on it." ]
2. [ ... ]
3. [ ... ]

---

## 🔮 What I Want to Build Next

[ What features do you want to add? What new concepts do you want to learn next? ]

- [ e.g., Add a search feature ]
- [ e.g., Learn about Room database ]
- [ e.g., Add dark mode ]

---

## 📚 Resources That Helped Me

| Resource | Link | What I learned from it |
|---|---|---|
| Android Docs | https://developer.android.com | [ ... ] |
| [ Tutorial / Video ] | [ URL ] | [ ... ] |
| [ StackOverflow post ] | [ URL ] | [ ... ] |

---

## 🚀 How to Run This Project

1. Clone the repo: `git clone https://github.com/vineetganti/VolumeAreaApp.git`
2. Open in Android Studio
3. Let Gradle sync finish
4. [ Any other steps — API keys, emulator setup, etc. ]
5. Hit ▶ Run

**Min Android version required:** [ e.g., Android 7.0 (API 24) ]

---

*Last updated: [ date ] · Written by Vineet Ganti*