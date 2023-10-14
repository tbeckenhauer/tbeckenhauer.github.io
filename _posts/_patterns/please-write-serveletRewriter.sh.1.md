Creating a Bash function to handle the input paths of an AEM Servlet and an empty Spring Boot application, and then scan for an "import network of packages," requires a fair amount of string manipulation and file operations. Below is a simplified example of how you might start this. This script assumes that your project files are Java files and that you're operating in a Unix-like environment.

Please note, this script does not handle the complexity of parsing Java files fully (like handling multiline comments, strings, etc.), but it should serve as a starting point. A more robust solution might involve a dedicated parser or a more sophisticated program written in a language that can handle file parsing more gracefully than Bash.

Here's how you might write the function:

```bash
#!/bin/bash

scan_imports() {
  # Paths to the source directories
  aem_servlet_path="$1"
  springboot_app_path="$2"

  # Check if paths are not empty
  if [[ -z "$aem_servlet_path" || -z "$springboot_app_path" ]]; then
    echo "Error: Paths to AEM Servlet and Spring Boot app are required."
    return 1
  fi

  # Check if paths are valid
  if [[ ! -d "$aem_servlet_path" || ! -d "$springboot_app_path" ]]; then
    echo "Error: Both paths must be directories."
    return 1
  fi

  # Find all Java files and scan for import statements
  echo "Scanning for import statements in AEM Servlet..."
  find "$aem_servlet_path" -name "*.java" -print0 | while IFS= read -r -d '' file; do
    echo "File: $file"
    grep -E '^import ' "$file" | cut -d ' ' -f2 | sed 's/;$//'  # Extracting import statements
  done

  # Optionally repeat the process for the Spring Boot application path
}

# Usage:
# scan_imports "/path/to/aem/servlet" "/path/to/springboot/app"
```

This script does the following:
1. Verifies that both paths are provided and that they point to valid directories.
2. Uses `find` to locate all `.java` files in the specified AEM servlet path.
3. Uses `grep` to find lines that start with `import`, indicating an import statement in Java.
4. Cuts out the actual package path from the import statement and removes the ending semicolon using `sed`.

Remember, Bash is not the ideal tool for parsing complex file structures or programming language syntaxes, but this script should give you a basic idea of how to start the process. For a more comprehensive solution, consider using a scripting language like Python, or a Java-based parser, which can understand the Java language constructs natively.