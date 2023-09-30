---
layout: post
title:  "Read The Error Message"
tags: [Programing, GeneralAdvice, Always]
permalink: /read-the-error-message/
---
 
See: [Learn to Read the Source, Luke](https://blog.codinghorror.com/learn-to-read-the-source-luke/)
 
I just want to throw this out there because it tripped me up recently. So, maybe if I write a blog post, I won't do it again.
 
Right now I am in between teams, about to leave one, and getting on-boarded with a new one; my time is somewhat crunched.  There is an important issue I need to resolve, in order to leave my soon-to-be former-team in a good state. The problem must be fixed while I still have the time.
 
The command that was failing was `yarn install`, on the build server.  It was complaining `there seems to be a problem with your internet connection`. Well, our internal network/VPN has always been finicky about the domains it will and won't connect to, this is nothing new.  I don't like it, but I guess the best pragmatic solution will be to cache the `node_modules` in the repo.  So, I started hacking up a quick node.js script to remove `node_modules` from the `.gitignore`, update the `node_modules` and restore the `.gitignore`. That didn't work, so I moved on to another solution, that then didn't work, and so on.
 
Fast Forward to me reading through the build log for what felt like the 20th time, then I see it. An error message complaining: 'blahblahblah I can't `yarn install` package from `repo.internaldomain.com/artifactory`'. I had forgotten we were never able to get to that server from our side of the network, and I could have read that error message at the beginning, if I wasn't in such a hurry and quick to jump to conclusions.
 
So, I think the moral of the story here is: `measure twice, cut once`.
 
One more note.  If you made it this far, you might have questions about shortcuts - that's fine. The project I was leaving was being shut down, while the project I was going to was being spun up, naturally.  This `yarn install` package that was being added to the build server was actually the source code/dependencies from the new project.  That's kinda why I was getting pulled onto the new project. Even though our old project was being shut down, what I did to gain experience - for me and my team - was bring the new project to us, so we could contribute to it sooner rather than later. Unfortunately, just as we were hitting our stride (deleting the old source code and importing the new source code), I got pulled off the project. However, to leave the former team in a good state, one of the last things I made sure of was the build server was working. So, yes, there were shortcuts we weren't proud of, but that's the wrong thing to focus on. The awesome part was, even though we got stuck maintaining some old/clunky software, we brought the new stuff to us, learned it ourselves, and started contributing to it; before they could even shut down the old project! [This whole story is worth it's own blog post](/rocking-the-boat/), because it provides some good lessons on how to rock the boat. For now, I am going to take this pragmatic shortcut, and knock this blog post out in one hour.
