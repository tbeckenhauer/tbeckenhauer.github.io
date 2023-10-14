Creating a Maven package from a directory of Java, CSS, HTML, and JavaScript files involves structuring the files according to Maven's standard directory layout, generating a `pom.xml` file, and executing Maven commands to build the package. This script assumes that your files are not already in a Maven structure, and it will attempt to create a simple Maven webapp structure, move files into the appropriate directories, and build the project.

```zsh
#!/bin/zsh

# Function to create a Maven project structure and move files
package_as_maven() {
    # Prompt for project parameters
    read "groupId?Enter Group ID (com.example): "
    read "artifactId?Enter Artifact ID (demo): "
    read "version?Enter Project Version (1.0-SNAPSHOT): "

    # Set default values if input is empty
    groupId=${groupId:-com.example}
    artifactId=${artifactId:-demo}
    version=${version:-1.0-SNAPSHOT}

    # Create the Maven directory structure
    mkdir -p src/main/java
    mkdir -p src/main/resources
    mkdir -p src/main/webapp

    # Move the user's files into the Maven structure
    # This is a simplistic approach and may need to be adjusted based on the actual directory structure and file types
    mv *.java src/main/java/
    mv *.css src/main/webapp/
    mv *.html src/main/webapp/
    mv *.js src/main/webapp/

    # Generate a basic pom.xml file
    cat > pom.xml <<EOL
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>$groupId</groupId>
  <artifactId>$artifactId</artifactId>
  <version>$version</version>
  <packaging>war</packaging>
  <dependencies>
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>3.1.0</version>
      <scope>provided</scope>
    </dependency>
    <!-- Add other dependencies here -->
  </dependencies>

  <build>
    <finalName>${artifactId}</finalName>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.8.1</version>
        <configuration>
          <source>1.8</source>
          <target>1.8</target>
        </configuration>
      </plugin>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-war-plugin</artifactId>
        <version>3.3.1</version>
        <configuration>
          <warSourceDirectory>src/main/webapp</warSourceDirectory>
          <failOnMissingWebXml>false</failOnMissingWebXml>
        </configuration>
      </plugin>
    </plugins>
  </build>
</project>
EOL

    # Build the project with Maven
    mvn clean package
}

# Check if Maven is installed
if ! type mvn > /dev/null 2>&1; then
    echo "Error: Maven is not installed."
    exit 1
fi

# Execute the function
package_as_maven
```

This script creates a basic Maven webapp project structure, generates a `pom.xml` with minimal configuration, moves your Java, CSS, HTML, and JavaScript files into the appropriate locations, and attempts to build a WAR file with Maven.

Please ensure that you adapt the file-moving commands based on your specific directory structure and needs. This script makes some assumptions about your project that might not apply. You might need to adjust paths, Maven coordinates, and configurations to suit your project's requirements. Also, make sure Maven is installed on your system and available in your PATH. 

After creating the script, don't forget to make it executable using `chmod +x script_name.zsh` and you can run it with `./script_name.zsh` within the directory containing your files.