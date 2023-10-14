Creating a Spring Boot project involves a few steps and usually relies on a build tool like Maven or Gradle. While you can manually create the files and directory structure, it's common practice to use Spring Initializr, which generates a template project for you. However, Spring Initializr can be used via curl from the command line, so we can still achieve this with a bash script.

Here's how you might write a bash script to generate a basic Spring Boot project with Maven:

```bash
#!/bin/bash

# Function to generate a Spring Boot project using Spring Initializr
create_spring_boot_project() {
    # Prompt for project parameters
    read -p "Enter Group ID (com.example): " groupId
    read -p "Enter Artifact ID (demo): " artifactId
    read -p "Enter Description (Demo project for Spring Boot): " description
    read -p "Enter Package Name (com.example.demo): " packageName
    read -p "Enter Project Name (demo): " projectName
    read -p "Enter Project Version (0.0.1-SNAPSHOT): " version

    # Set default values if input is empty
    groupId=${groupId:-com.example}
    artifactId=${artifactId:-demo}
    description=${description:-"Demo project for Spring Boot"}
    packageName=${packageName:-com.example.demo}
    projectName=${projectName:-demo}
    version=${version:-0.0.1-SNAPSHOT}

    # Create a temporary directory for the zip file
    tmpDir=$(mktemp -d -t ci-XXXXXXXXXX)
    
    echo "Creating Spring Boot project..."
    # Generate the project using Spring Initializr and save the zip file
    curl https://start.spring.io/starter.zip \
        -d type=maven-project \
        -d language=java \
        -d bootVersion=2.5.4 \
        -d baseDir="$projectName" \
        -d groupId="$groupId" \
        -d artifactId="$artifactId" \
        -d name="$projectName" \
        -d description="$description" \
        -d packageName="$packageName" \
        -d javaVersion=11 \
        -d dependencies=web \
        -o "$tmpDir/$projectName.zip"
    
    # Unzip the project and move it to the current directory
    unzip "$tmpDir/$projectName.zip" -d "$tmpDir"
    mv "$tmpDir/$projectName" .

    # Clean up the temporary directory
    rm -rf "$tmpDir"

    echo "Spring Boot project created successfully."
}

# Execute the function
create_spring_boot_project
```

This script uses `curl` to download a zip file from Spring Initializr with the specified parameters. It creates a temporary directory to hold the zip file, unzips the file, and moves the project directory to your current location. 

Please make sure you have `curl` and `unzip` installed on your system for this script to work. Also, this script assumes you're using Maven and Java 11, but you can modify the parameters as needed for your specific use case.

Remember to make the script executable with `chmod +x script_name.sh` and then you can run it with `./script_name.sh`.