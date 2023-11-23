#!/bin/bash

# Your original Bitbucket repository URL
OLD_REPO_URL=""git@github.com:tbeckenhauer/tbeckenhauer.github.io.git

# Your new GitHub repository URL
NEW_REPO_URL="git@github.com:tbeckenhauer/test1.git"

# Check if the old remote exists and replace it with the new one
if git remote get-url origin | grep -q "$OLD_REPO_URL"; then
    git remote rename origin oldBitbucket
    git remote add origin "$NEW_REPO_URL"
    git fetch --all
else
    echo "Old remote URL does not match or does not exist."
    echo "Please check the OLD_REPO_URL value and try again."
fi
