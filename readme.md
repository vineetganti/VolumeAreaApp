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

`onCreate()`: Used this callback in MainActivity.java to initialize the activity. 

Once the MainActivity class is loaded by the system and memory is allocated, the `onCreate()(Bundle savedInstanceState)` 
callback is invoked. The system passes any previously saved state (e.g., after a rotation) inside the `Bundle`.
In this simple app, no state is saved, so `savedInstanceState` is null.

`super.onCreate(savedInstanceState)` - ensures the parent class (`AppCompactActivity`) performs initial setup,
susch as creating the internal decor view, initializing the theme, and restoring any framework-managed state.

`setContentView(R.layout.activity_main)` - The layout file `activity_main.xml` is parsed (XML is inflated to 
actual view objects) and becomes the visible content of the activity. 

`findViewById(R.id.gridView)` - The inflated `GridView` is located and stored in the `gridView` variable.

Create the data source - An `ArrayList<Shape>` is created and populated with four shapes, each containing 
an image resource and a label.

Create and set the adapter - Custom adapter is instantiated with the shape list and the application context.
Adapter's job is to convert each `Shape` object into a `View` (typically an `ImageView` + `TextView` inside a grid cell).
Tells the GridView to ask the adapter for the number of items and for each item's view.

`gridView.setNumColumns(2)` - forces the grid to show two columns regardless of screen width.

---

### XML Layouts

**What is an XML layout file?**

Defines structure for User Interface and are built using a hierarchy of View and ViewGroup objects. 

View usually draws something the user can see and interact with. 

ViewGroup is an invisible container that defines the layout structure for View and other ViewGroup objects.

View objects are often called widgets and can be one of many subclasses, such as Button or TextView.

ViewGroup objects are called layouts and can be LinearLayout or ConstraintLayout

**Layout types I used:**

| Layout | When I used it                                     | Why I chose it                                                                           |
|---|----------------------------------------------------|------------------------------------------------------------------------------------------|
| `ConstraintLayout` | To create a grid view of various shapes in the app | Helps create large, complex layouts with a <br/> flat hierarchy - no nested view groups. |

**A layout snippet I'm proud of (ConstraintLayout for the grid):**

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content">

    <ImageView
        android:id="@+id/imageView"
        android:layout_width="120dp"
        android:layout_height="120dp"
        android:layout_marginStart="16dp"
        android:layout_marginTop="16dp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginEnd="16dp"
        android:text="text1"
        android:textColor="@color/black"
        android:textSize="24sp"
        app:layout_constraintStart_toStartOf="@+id/imageView"
        app:layout_constraintEnd_toEndOf="@+id/imageView"
        app:layout_constraintTop_toBottomOf="@+id/imageView"/>

</androidx.constraintlayout.widget.ConstraintLayout>
```

The entire layout is wrapped in a `ConstraintLayout` , which positions child views using constraints (relationships
between views or the parent). It's set to `wrap_content` in both dimensions, meaning it shrinks to fit its children.

ImageView

A fixed 120x120dp image placeholder positioned at top-left corner of the layout and no `src` attribute is set here,
so the image would be assigned programmatically.

TextView

Displays the placeholder text 'text1', horizontally centered under the ImageView by constraining both it's start
and end to the ImageView's start and end. `constraintTop_toBottomOf` ensures text sits directly below the ImageView.

---

### Views & View Binding

**Common Views I used:**

| View        | What it does                                 | Example in my app                                                                                               |
|-------------|----------------------------------------------|-----------------------------------------------------------------------------------------------------------------|
| `TextView`  | Displays text                                | Pretty much anywhere i wanted to display text on the screen                                                     |
| `ImageView` | Displays images                              | Used to display images in the grid_item_layout.xml before replicating it in the activity_main.xml as a GridView |
| `GridView`  | Arranges ImageViews in specified grid format | Usage in the activity_main.xml where multiple images view are arranged in a grid strictly with 2 columns        |
| `Button`    | Tappable button                              | Used in individual xml files of respective shapes in order to calculate volume results                          |

**How I connected XML to Java (findViewById or ViewBinding):**


| Feature             | findViewById               | View Binding                                                        |
|---------------------|----------------------------|---------------------------------------------------------------------|
| Null Safety         | ❌ Can return null          | ✅ Always non-null           |
| Type Safety         | ❌ Manual casting            | ✅ Correct type auto-generated |
| Compile-time checks | ❌ Errors at runtime | ✅ Errors caught at compile time |
| Boilerplate         | ❌ One call per view           | ✅ One binding object |
| Setup required      | ✅ None                           | ⚠️ Must enable in build.gradle                                                                    |
| Performance         |  ⚠️ Slower (traverses view tree)   |  ✅ References generated at compile time                                                                   |



---

### Intents

**What is an Intent?**

A messaging object used to request an action from another component. Three main purposes are: Starting an activity,
(navigating between screens), Starting a service (background task), and Broadcasting an action (system-wide event).

**Explicit vs Implicit Intents:**

| Feature        | Explicit Intent                 | Implicit Intent                        |
|----------------|---------------------------------|----------------------------------------|
| Target         | Specific class named            | Action described                       |
| Usecase        | Within app                      | Across apps                            |
| Security       | More secure                     | Less controlled                        |
| Example        | Open ProfileActivity            | Open URL in a browser                  |

---

### RecyclerView & Adapters

**Difference between ListView and RecyclerView**

| Feature            | ListView                                               | RecyclerView                                                                                  |
|--------------------|--------------------------------------------------------|-----------------------------------------------------------------------------------------------|
| ViewHolder Pattern | Recommended but not enforced                           | Mandatory - improves performance by reducing `findViewById` calls                             |
| Layout Management  | Fixed vertical list only                               | Pluggable via `LayoutManager` - supports linear, grid, staggered grid, custom layouts         |
| Item Animations    | Not built-in - requires custom code                    | Built-in support via `ItemAnimator` (add/ remove/ move/ chnage animations)                    |
| Item Decoration    | Limited - can use dividers via XML `(android:divider)` | Dedicated `ItemDecoration` class for custom dividers, spacing, or overlays                    |
| Adapter            | Extend `BaseAdapter` (or `ArrayAdapter`)               | Extend `RecyclerView.Adapter` - Enforces `ViewHolder` creation and binding                    |
| Click Handling     | `onItemClickListener` provided                         | No default - must implement click listeners in the `ViewHolder` or via interface              |
| Performance        | Good for simple lists, but recreates views more often  | Highly optimized - reuses views more aggresively, smoother scrolling for complex/ large lists |
| Nested Scrolling   | Not officially supported (requires workarounds)        | Native support for nested scrolling (eg inside `NestedScrollView`)                            |
| API Level          | Since API level 1                                      | Added in API level 14 (Android 4.0) via support library, now in AndroidX                      |
| Flexibility        | Low - rigid list behavior                              | High - fully customizable via `LayoutManager`, `ItemAnimator`, `ItemDecoration`                |


**How RecyclerView works (in my own words):**

#### ViewHolder pattern, the Adapter, and how they connect. This is a key concept in RecyclerView.

##### ViewHolder
ViewHolder pattern is a performance optimization technique used in Android AdapterView to reduce the number of expensive
`findViewById()` calls while scrolling.

A simple static inner class that holds references to the child views inside a list item layout. Instead of calling 
`findViewById()` everytime, `getView()` (for `ListView`) or `onBindViewHolder()` (for `RecyclerView`) calls the ViewHolder.

Attached to the item view via `setTag()` (in `ListView`) or `bind()` (in `RecyclerView`).

##### Adapter
Adapter acts as a bridge between a data source (E.g. `ArrayList`) and an `AdapterView` (like `ListView` or `RecyclerView`).
It's responsible for creating, binding views to the data and managing the data set.

In `RecyclerView`, the adapter is abstract and must implement:
onCreateViewHolder() - Called when the RecyclerView needs a new ViewHolder of the given type to represent an item.

onBindViewHolder() - Called by the RecyclerView to display the data at the specified position.

getItemCount() - Returns the total number of items in the data set.

---

### AndroidManifest.xml

**What is the Manifest?**

The app's blueprint - tells the Android system everything it needs to know about the app before any code runs.

What it registers and declares:


| Category                   | What it declares/ registers                                                                                                                       | Example                                                                                                                                    |
|----------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------|
| App package & identity     | Package name, version code, version name                                                                                                          | `package="com.example.myapp"`                                                                                                              |
| App components (core building blocks) | Activities - UI screens, Services - background tasks, Broadcast receivers - respond to system events, Content Providers - share the data between apps | `<activity android:name=".MainActivity"/>`, `<service android:name=".MyService"/>`                                                         |
| Permissions                | Permissions the app requires (eg internet, camera, location)                                                                                      | `<uses-permission android:name="android.permission.INTERNET"/>`                                                                            |
| Hardware and Software features | Features the app needs (camera, bluetooth, touchscreen)                                                                                           | `<uses-feature android:name="android.hardware.camera"/>`                                                                                   |
| API level requirements     | Minimum SDK, target SDK version                                                                                                                   | `<uses-sdk android:minSdkVersion="21"/>`                                                                                                   |
| Launchable Entry Point     | Which activity opens first (with `<intent-filter>`)                                                                                               | `<intent-filter><action android:name="android.intent.action.MAIN"/><category android:name="android.intent.category.LAUNCHER"/></intent-filter>` |
| App metadata & configurations | Theme, icon, label (app name), hardware acceleration, screen orientation, etc.                                                                    | `android:icon="@mipmap/ic_launcher"`                                                                                                       |
| Device compatibility          | Declares whether the app supports large screens, tablets, etc.                                                                                    | `android:resizeableActivity="true"`                                                                        |
| App links & deep links        | URL associations for handling web links                                                                                                                                 | `<intent-filter> with VIEW action and data scheme`                                                                 |

---

## 🧱 Build System — Gradle

**What is Gradle?**

Gradle is a build automation tool. Takes raw ingredients - source code, images, libraries, and resources 
and turn them into a finished app (like an Android APK) or program. 

Handles:

- Compiling code
- Downloading and adding external libraries (dependencies)
- Running tests
- Packaging everything together
- Optimizing and signing the final file


**The difference between project-level and app-level Gradle:**


| File            | Location                                     | What it does                                                                      |
|-----------------|----------------------------------------------|-----------------------------------------------------------------------------------|
| `settings.gradle` (or `settings.gradle.kts`)| Project root                                 | Lists which modules (e.g., `:app`, `:library`) are included in the build. It defines the project’s structure.                                                    |
| Project‑level `build.gradle` | Project root                                 | Contains global configuration that applies to all modules. |
| App‑level build.gradle | Inside each module (e.g., `app/build.gradle`)  | Defines module‑specific settings.                   

---

## ⌨️ Line by line explanation of MainActivity.java & MyCustomAdapter.java

### MainActivity.java

```java
import android.content.Intent;
```
Imports the `Intent` class used to start new activities (screens) or pass data between components

```java
import android.os.Bundle;
```
A container for saving/ restoring activity state (e.g. screen rotation)

```java
import android.view.View;
```
Base class for all UI widgets (buttons, text views, etc). Used for the `onItemClick` parameter.

```java
import android.widget.AdapterView;
```
A view whose children are determined by an adapter (`GridView`, `ListView`)

```java
import android.widget.GridView;
```
A view that displays items in a two_dimensional scrollable grid.

```java
import androidx.activity.EdgeToEdge;
```
Helper to make the app draw edge-to-edge. No call in code.

```java
import androidx.appcompat.app.AppCompatActivity;
```
Base activity class that provides backward compatible features

```java
import java.util.ArrayList;
```
A resizeable array implementation used to store list of shapes.

```java
public class MainActivity extends AppCompactActivity {
```
Defines Main Activity class that inherits all the functionality of an android activity

```java
GridView gridView;
```
Hold reference to the grid view defined in the layout.

```java
ArrayList<Shape> shapeArrayList;
```
Store objects of a custom class `Shape`.

```java
MycustomAdapter adapter;
```
Extends `BaseAdapter` or `ArrayAdapter` that will bind the `shapeArrayList` to the `GridView`

```java
@Override
protected void onCreate(Bundle savedInstanceState) {
```
Overrides the `onCreate` method - entry point when the activity is created. `Bundle` contains previously saved
state if the activity is being restored.

```java
super.onCreate(savedInstanceState);
```
Calls the parent class's `onCreate` to perform the initial setup (creating decor view, saving instance state).

```java
setContentView(R.layout.activity_main);
```
Inflates the layout file `activity_main.xml` and becomes the visible content of the activity. All subsequent
`findViewById` calls look for views inside this layout.

```java
gridView = findViewById(R.id.gridView);
```
Finds the `GridView` in the layout and stores it in the `gridView` variable.

```java
shapeArrayList = new ArrayList<>();
```
Creates an `ArrayList` of `Shape` objects.

```java
Shape s1 = new Shape(R.drawable.sphere, "Sphere");
Shape s2 = new Shape(R.drawable.cylinder, "Cylinder");
Shape s3 = new Shape(R.drawable.cube, "Cube");
Shape s4 = new Shape(R.drawable.prism, "Prism");
```
Creates four Shape objects. The constructor likely takes an image resource ID 
(e.g., R.drawable.sphere) and a string label.

```java
shapeArrayList.add(s1);
shapeArrayList.add(s2);
shapeArrayList.add(s3);
shapeArrayList.add(s4);
```
Adds the four Shape objects to the `shapeArrayList`

```java
adapter = new MyCustomAdapter(shapeArrayList, getApplicationContext());
```

Instantiates the custom adapter, passing the list of shapes and the application context needed for 
inflating item layouts and accessing resources.

```java
gridView.setAdapter(adapter);
```
Attaches adapter to the GridView. Will display items as defined by `MyCustomAdapter`

```java
gridView.setNumColumns(2);
```
Forces the grid to show two columns regardless of screen width.

```java
gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
```
Registers a click listener for the grid items. When a shape is tapped, the `onItemClick` method is called.

```java
Intent i = new Intent(getApplicationContext(), Sphere.class);
startActivity(i);
Intent j = new Intent(getApplicationContext(), Cube.class);
startActivity(j);
Intent k = new Intent(getApplicationContext(), Cylinder.class);
startActivity(k);
Intent l = new Intent(getApplicationContext(), Prism.class);
startActivity(l);
```
Creates four different intents for each shape and starts all of them in sequence with `Sphere` activity,
then j with `Cube`, k with `Cylinder`, and l with `Prism`.

Every time the user taps any grid item, the app will try to open all four calculation screens one after another

---
## A word on what 'inflating' means

Inflating in Android means converting an XML layout file into actual Java/Kotlin view objects
that can be displayed on the screen.

When you write a layout file (e.g., activity_main.xml), it’s just a text file describing what buttons, text,
images, etc. you want, along with their sizes, positions, and attributes. But Android doesn’t understand XML
directly at runtime – it needs real, live View objects (like Button, TextView, GridView, etc.) to draw on the screen.

Inflation is the process where the Android system:

- Reads the XML file. 
- Parses every tag (like <Button>, <TextView>, <GridView>). 
- Creates a corresponding Java object for each tag (e.g., new Button(...), new GridView(...)). 
- Sets all the attributes you wrote (like android:text, android:layout_width) on those objects. 
- Builds the parent-child relationships (e.g., a LinearLayout containing a Button). 
- Returns the root View object (usually a ViewGroup like ConstraintLayout, LinearLayout, etc.).

---
## 📚 Resources That Helped Me

| Resource | Link | What I learned from it |
|---|---|---|
| Android Docs | https://developer.android.com | [ ... ] |
| [ Tutorial / Video ] | [ URL ] | [ ... ] |

---

## 🚀 How to Run This Project

1. Clone the repo: `git clone https://github.com/vineetganti/VolumeAreaApp.git`
2. Open in Android Studio
3. Let Gradle sync finish
4. [ Any other steps — API keys, emulator setup, etc. ]
5. Hit ▶ Run

**Min Android version required:** [ e.g., Android 7.0 (API 24) ]

---

*Last updated: May 15th 2026 · Written by Vineet Ganti*