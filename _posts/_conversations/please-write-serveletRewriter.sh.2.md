To recursively copy the Java files from the AEM Servlet directory to the Spring Boot application directory and scan for import statements, we can modify the script as follows. This script now includes functionality to copy files from the source directory to the destination, maintaining the directory structure. Please ensure you have the necessary permissions to read and write to these directories.

```bash
#!/bin/bash

scan_and_copy_imports() {
  # Paths to the source and destination directories
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

  # Create a subdirectory to copy the files
  mkdir -p "${springboot_app_path}/migrated_sources"

  # Find all Java files, scan for import statements, and copy them
  echo "Scanning for import statements in AEM Servlet and copying files..."
  find "$aem_servlet_path" -name "*.java" -print0 | while IFS= read -r -d '' file; do
    echo "File: $file"
    grep -E '^import ' "$file" | cut -d ' ' -f2 | sed 's/;$//'  # Extracting import statements
    
    # Construct the target file path
    relative_path="${file#${aem_servlet_path}/}"
    target_path="${springboot_app_path}/migrated_sources/${relative_path}"

    # Create the directory path in the target
    mkdir -p "$(dirname "$target_path")"

    # Copy the file
    cp "$file" "$target_path"
  done
}

# Usage:
# scan_and_copy_imports "/path/to/aem/servlet" "/path/to/springboot/app"
```

This script does the following:

1. Validates that both paths are provided and that they point to directories.
2. Creates a `migrated_sources` subdirectory in the Spring Boot application directory for the copied files.
3. Uses `find` to locate all `.java` files in the AEM servlet path.
4. Scans for lines that start with `import`, indicating an import statement in Java, and extracts the actual package path.
5. Constructs a relative file path to preserve the directory structure during the copy.
6. Copies each Java file from the AEM servlet to the corresponding location in the Spring Boot application’s `migrated_sources` directory.

**Note**: This script doesn't handle file conflicts or provide advanced logging. If a file with the same name exists in the destination path, it will be overwritten. Be sure to back up your files or check for conflicts before running this script in a production environment. Also, it's recommended to handle errors that might occur during file copy operations for a robust script.