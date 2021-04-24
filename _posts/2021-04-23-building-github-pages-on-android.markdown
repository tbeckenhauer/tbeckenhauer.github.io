---
layout: post
title:  "Building GitHub Pages on Android"
date:   2021-04-23 00:00:00
categories: Programing, Project, Android, GithubPages
---

1. Install Termux
2. Install Andronix
3. Install Ubuntu
4. Start Ubuntu

sudo isn't necessary

5. apt update
6. apt upgrade
7. apt-get install git ruby-dev
8. git clone https://github.com/tbeckenhauer/tbeckenhauer.github.io.git
9. apt install make gcc gpp build-essential zlib1g zlib1g-dev
10. cd tbeckenhauer.github.io
11. gem install bundler
12. bundler install
13. bundle exec jekyll serve
