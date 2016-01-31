## JAXB - Jacobono XJC Gradle Plugin Example ##
This project accompanies my blog post at `https://javaunittesting.wordpress.com/` which talks about how to use Gradle and the Jacobono JAXB XJC plugin to generate JAXB java classes from a schema file and JAR them for distribution and use in other projects.

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
- The gradle task `xjc` parses the schema (.xsd) file and generates JAXB java sourcce code and then compiles it.
- The gradle task `jar` will create the JAR containing compiled classes for distribution.
- The gradle task `srcjar` will create the companion source JAR.
- The custom task `buildall` runs all four of the above tasks in the appropriate order.