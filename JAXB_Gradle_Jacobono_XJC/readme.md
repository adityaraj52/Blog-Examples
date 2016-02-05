
# JAXB - Jacobono XJC Gradle Plugin Example #

![alt text](http://www.gravatar.com/avatar/f09ffc9167484288f3f77fecc61ce824.jpg "Warren Smith")

**Author:** Warren Smith

**File Created:** 1/31/2016 2:30:00 PM 

**File Updated:** 2/4/2016 10:17:00 PM 

### Purpose ###
This project accompanies my blog post at [https://javaunittesting.wordpress.com](https://javaunittesting.wordpress.com/2016/02/01/jaxb-jacobono-xjc-gradle-plugin-example/ "https://javaunittesting.wordpress.com") which talks about how to use Gradle and the Jacobono JAXB XJC plugin to generate JAXB java classes from a schema file and JAR them for distribution and use in other projects.

### Building the Project ###
The project is built using a Gradle build script.  Follow these instructions:

1. Check out the project from Github
2. Open a command window
3. Navigate to the root location of the folder containing the project.
4. Run the following command `gradlew buildall`

**Note:**
- You may notice that there are build problems noted by your IDE (if you are using one). Specifically in my Eclipse IDE, the class `Date` in the `build.gradle` file cannot be resolved initially.  This is because the Eclipse specific files like `.project`, `.classpath` and files in folder `.settings` are not checked into the Github repository (not everybody is using Eclipse). This is easily fixed by executing the command `gradle cleanEclipse eclipse` (which will clean any existing Eclipse project files and create new ones for you).
- You don't need to have gradle installed on your machine (you are executing a gradle wrapper command and it will download the version of gradle required for the build automatically).
- The gradle task `clean` sets up the environment by deleting any transient folders (from prior builds).
- The gradle task `xjc` parses the schema (.xsd) file and generates JAXB java source code and then compiles it.
- The gradle task `jar` will create the JAR containing compiled classes for distribution.
- The gradle task `srcjar` will create the companion source JAR.
- The custom task `buildall` runs all four of the above tasks in the appropriate order.

### The Manifest ###
The manifest of the JARs is particularly useful because it tells you everything you need to know about how the JAR was created such as the release version number, Java compiler version, Gradle version, JAXB version, source and target compatibility and exact date and time of the build.  I will be creating another blog post showing how to include other useful information such as Jenkins build number and even a GIT commit in the manifest.  Here's an example:

```
Manifest-Version: 1.0
Specification-Title: Generated JAXB_Gradle_Jacobono_XJC JAR
Specification-Vendor: Jalamor Software
Implementation-Title: JAXB_Gradle_Jacobono_XJC
Implementation-Version: v1.0
Created-By: 1.8.0_45 (Oracle Corporation 25.45-b02)
Built-With: Gradle 2.10
JAXB-Version: 2.2.10
Source-Compatibility: 1.8
Target-Compatibility: 1.8
Build-Time-ISO-8601: 2016-02-02T00:08:11-0500
```

### Changing the Version Number for the JAR ###
Changing the release version number is also a simple as edit in `gradle.properties`. Change the `jarImplVersion` property to what you need. Obviously I chose version `1.0` for the initial release.  Any future modifications to the JAR (when the schema changes), should have appropriate point or full number increments to reflect changes.

### Changing the Generated Source Package ###
The Jacobono plugin will instruct XJC to use whatever package name you supply when it generates the Java source code.  This can be done by modifying the `jaxbPackageName` property in `gradle.properties`

### Changing the Gradle Version ###
At time of writing, the latest version of Gradle was 2.10.  The Gradle script in this project should work with any version newer than 2.1.  Simply edit the `gradle.properties` file and changing the `gradleVersion` property to what you want.

### Changing the JAXB Version ###
Changing the version of JAXB is as simple as editing the `gradle.properties` file and changing the `jaxbVersion` property to what you want. I chose version `2.2.10` for this example because it was the latest version, but generally I try to make the JAXB version line up with the version that shipped with the Java version I am using for compilation (e.g. if using Java compiler 1.7.0_051, I might consider JAXB version 2.2.4). Note that depending on the version, you need to change your dependencies in the gradle build (2.2.10 and 2.2.11 has a different groupID, at least at the time of writing).

There are a lot of versions of JAXB-XJC.  You can find the ones I use listed at [Maven Central](http://search.maven.org/#search|ga|1|%28g%3A%22com.sun.xml.bind%22%20OR%20g%3A%22org.glassfish.jaxb%22%29%20AND%20a%3A%22jaxb-xjc%22 "Maven Central")
