---
layout: post
title: "Git: Migrating a Team and Their Codebase from Bitbucket to GitHub"
date: 2023-11-02
categories: guide
---

Migrating your team and codebase from Bitbucket to GitHub can be a daunting task, especially if you want to preserve all branches and maintain the development history intact. In this post, we’ll go through the process step-by-step and provide you with scripts to make this transition as smooth as possible.

### Prerequisites

- A Bitbucket repository (`origin`) with branches that you want to migrate.
- A new GitHub repository (`originGithub`) where you want to migrate your codebase.

### Step 1: Clone the Bitbucket Repository

Firstly, ensure you have a local clone of the Bitbucket repository with all the branches that you need.

```bash
git clone --mirror [bitbucket_repo_url] local-repo
cd local-repo
```

Replace `[bitbucket_repo_url]` with the URL of your Bitbucket repository.

### Step 2: Push All Branches to the New GitHub Repository

The following script will push all branches from your local clone to the new GitHub repository:

```bash
#!/bin/bash

GITHUB_REPO_URL="https://github.com/yourusername/yournewrepo.git"

# Check if the GitHub repo URL has been provided
if [ -z "$GITHUB_REPO_URL" ]; then
    echo "GitHub repository URL is not set. Please modify the script with your new repository URL."
    exit 1
fi

# Pushing all branches to the new GitHub repository
git push --all "$GITHUB_REPO_URL"

# Pushing all tags to the new GitHub repository
git push --tags "$GITHUB_REPO_URL"
```

Make sure to replace `https://github.com/yourusername/yournewrepo.git` with the URL of your new GitHub repository.

Save this script as `migrate_to_github.sh` and execute it to migrate all branches and tags:

```bash
chmod +x migrate_to_github.sh
./migrate_to_github.sh
```

### Step 3: Update the Remotes on Developer Machines

To avoid having everyone re-clone the repository, you can use this script to update the remote URLs on developer machines:

```bash
#!/bin/bash

# Your original Bitbucket repository URL
OLD_REPO_URL="https://bitbucket.org/yourusername/oldrepo.git"

# Your new GitHub repository URL
NEW_REPO_URL="https://github.com/yourusername/yournewrepo.git"

# Check if the old remote exists and replace it with the new one
if git remote -v | grep -q "$OLD_REPO_URL"; then
    git remote rename origin old-origin
    git remote add origin "$NEW_REPO_URL"
    git remote remove old-origin
else
    echo "Old remote URL does not match or does not exist."
    echo "Please check the OLD_REPO_URL value and try again."
fi
```

Make sure to replace the URLs with the actual Bitbucket and GitHub repository URLs. Save this script as `update_remotes.sh` and distribute it to your team members. They can run it in their local repository directories:

```bash
chmod +x update_remotes.sh
./update_remotes.sh
```

### Conclusion

After following these steps, your team's new GitHub repository will contain all the branches and tags from the Bitbucket repository. Developer machines will have their remotes updated without the need to re-clone. The scripts provided should streamline the migration process, making the move to GitHub a hassle-free experience.

Remember to verify the integrity and functionality of your new GitHub repository after the migration. Check the branches, pull requests, and ensure the latest code is up and running.

Happy coding in your new home on GitHub!