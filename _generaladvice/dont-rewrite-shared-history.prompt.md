Please write a github pages markdown blogpost about "don't rewrite shared history" 

Let's enumerate a few common scenarios as well. 
Let's keep this in the context of merging 'pull-requests'
Let's assume, and state we are assuming the team is using git-flow.

Acceptable Scenarios for Squashing:
1. feature -> develop, For regular feature work when you delete the feature branch immediately after merging it.
2. feature -> release/*, For Scope creep, and bug fixes into a release branch. Also, here we will delete the feature branch immediately after merging it.
3. feature -> main, For hotfixes into the main branch. Also, here we will delete the feature branch immediately after merging it. 

Unacceptable Scenarios for Squashing, and MergeCommits should be used:
1. main -> release/*
2. release/* -> main
3. main -> develop
