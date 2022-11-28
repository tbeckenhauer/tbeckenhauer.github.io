---
layout: post
title:  "Feature Branches and Environment Branches"
date:   2022-11-28 17:28:00
categories: Programing, CodingStyle
---

This question came up at work recently, so I wanted to document a solution for others.

The problem was we had two teams, with two long-running feature branches, both of which needed to use the same environment. In a nutshell the solution was to merge the two feature branches into a new environment branch.  Don't merge that new environment branch. You can keep it separate. I'll elaborate.

Let's say you have two long-running feature branches `feature-make-new-foo-bar`, and `feature-build-a-hurr-durr`. Branch off of either one and make a `env-public-staging`, so that it's known that branch is specifically for that environment, and push merge commits to it pulling in the latest from the feature branches.  This keep the feature work separate and lets the environment get the latest. 

I ran these commands on [git-school](https://git-school.github.io/visualizing-git/#free).

```bash
git checkout -b develop
git branch -d master
git checkout -b feature-make-new-foo-bar develop
git commit -m message
git commit -m message
git commit -m message
git checkout -b feature-build-a-hurr-dur develop
git commit -m message
git commit -m message
git commit -m message
git checkout -b env-public-staging
git merge feature-make-new-foo-bar
```

![useful image]({{ site.url }}/_tutorials/feature-branches-and-environment-branches.1.markdown)

At this point we have the first go round of having both feature branches merged to the environment, but lets say we need more, no problem.

```bash
git checkout feature-make-new-foo-bar
git commit -m message
git commit -m message
git commit -m message
```
Get some updates to feature-make-new-foo-bar, then use a merge commit to get them in env-public-staging
```bash
git checkout env-public-staging
git merge feature-make-new-foo-bar
```
We can also go the other way.
![useful image]({{ site.url }}/_tutorials/feature-branches-and-environment-branches.2.markdown)
```bash
git checkout feature-build-a-hurr-dur
git commit -m message
git commit -m message
git commit -m message
```
Now merge into the env branch
```bash
git checkout env-public-staging
git merge feature-build-a-hurr-dur
```

If you follow the history closely the feature branches don't know anything about each other, but the environment can still pull in both feature branches just fine.

![useful image]({{ site.url }}/_tutorials/feature-branches-and-environment-branches.3.markdown)