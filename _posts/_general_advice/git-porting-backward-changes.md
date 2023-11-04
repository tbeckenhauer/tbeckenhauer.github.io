---
layout: post
title:  "Backporting Changes in Git"
date:   2023-11-02 00:00:00
tags: [Git, VersionControl, Collaboration, BestPractices, PullRequests, CodeMerge, Teamwork, DeveloperTools, SoftwareDevelopment, CodingGuidelines]
---

## Why you would want to?

You have changes that have been sent to develop, that you also want to go to production, right now, in a hotfix, or an offcycle or what have you.

## Instructions on how to Cherrypick changes from Develop branch

The first thing you need to do is check out the branch you want to commit your changes you. For example Let's say you want to commit your changes to release/3.14.0. So run 

`git switch release/3.14.0`

This is the branch you want your fix to be in.  But you have your work idealy in 2 places

1. All of your original commits, scratch work and all in the feature branch, these are commits D1, and D2.
2. Your final answer squashed down in the `develop` branch, this is commit D

Run `git log --all --decorate --oneline --graph`

I remember that by All Dogs...

You'll see a graph that looks like this. Imagine you are looking for Commit D.
```
         +-D1-D2 (feature branch) 
        / 
A---B---C---D---E (develop branch) 
\ 
 +--F--G (release/3.14.0-branch)
```

run `git cherry-pick D`, but you will need the first 5-7 characters of the git sha.

Apply your commit message.
Push up to `release/3.14.1`

And that should be that for preping your release branch, but you have one more step.

## Divergant Branches and Merging Forward

Your release branches should now look like this.
```
         +-D1-D2 (feature branch) 
        / 
A---B---C---D---E (develop branch) 
\ 
 +--F--G (release/3.14.0-branch)
        \ 
          +--D* (release/3.14.1-branch)
```

Note that D* is not the same as D. The diff may well be identical, but what makes up a commit are a few things. 
1. The changes.
2. The message.
3. The ancesstor commits. 

When you cherry pick the commit it makes it an inherritly different commit.  If you are following a git-flow model, you will want to merge your release branch back to your develop branch and your main branch.  See the original git-flow diagram below.

<img src="https://soft-wa.re/general_advice/git-model.png" width="75%">
