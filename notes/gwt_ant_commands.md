# Create a New GWT Project:
- webAppCreator -out MyGwtProject com.example.MyGwtModule

Description: Generates a new GWT project named MyGwtProject with an initial module named com.example.MyGwtModule.

# Create a New GWT Module:
$ cd MyGwtProject
$ bin/create-module.sh com.example.NewModule

* Description: Adds a new GWT module named com.example.NewModule to the existing project.

* These commands assume that the necessary GWT tools are in your system's PATH. Adjust the paths and module names as needed for your specific project structure.

# GWT Ant Commands

Google Web Toolkit (GWT) provides Ant tasks to assist in the build process. Here are some common GWT Ant commands along with descriptions:

## 1. **Compile GWT Module:**

```xml
<target name="gwtc" description="Compile GWT module">
    <java failonerror="true" fork="true" classname="com.google.gwt.dev.Compiler">
        <classpath>
            <pathelement location="src"/>
            <pathelement location="war/WEB-INF/classes"/>
            <!-- Add other dependencies as needed -->
        </classpath>
        <arg value="com.example.MyGwtModule"/>
    </java>
</target>
```
--------------------------------------------------------
```xml
<project name="YourGWTProject" default="build" basedir=".">

    <!-- Set properties -->
    <property name="src.dir" value="src"/>
    <property name="war.dir" value="war"/>
    <property name="gwt.module" value="com.example.YourGwtModule"/>
    <property name="markdown.file" value="path/to/your/markdownfile.md"/>

    <!-- Initialize the project -->
    <target name="init">
        <mkdir dir="${war.dir}"/>
    </target>

    <!-- Compile GWT module -->
    <target name="gwtc" depends="init">
        <java failonerror="true" fork="true" classname="com.google.gwt.dev.Compiler">
            <classpath>
                <pathelement location="${src.dir}"/>
                <pathelement location="${war.dir}/WEB-INF/classes"/>
                <!-- Add any other dependencies needed for GWT compilation -->
            </classpath>
            <arg line="-war ${war.dir}"/>
            <arg line="${gwt.module}"/>
        </java>
    </target>

    <!-- Copy Markdown file -->
    <target name="copyMarkdown" depends="init">
        <copy file="${markdown.file}" todir="${war.dir}"/>
    </target>

    <!-- Build (Compile GWT module and copy Markdown file) -->
    <target name="build" depends="gwtc, copyMarkdown">
        <!-- Add any other tasks needed after GWT compilation and Markdown file copying -->
    </target>

    <!-- Clean -->
    <target name="clean">
        <delete dir="${war.dir}"/>
        <!-- Add any other cleaning tasks as needed -->
    </target>

</project>
```
----------------------------------

## In this example:

- The init target creates the necessary directories.
- The gwtc target compiles the GWT module.
- The copyMarkdown target copies the Markdown file to the output directory.
- The build target depends on both gwtc and copyMarkdown.
- The clean target deletes the output directory.
