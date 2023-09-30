---
layout: post
title:  "Rocking the Boat"
date:   2021-06-21 00:00:00
categories: Programing, SoftSkills
permalink: /rocking-the-boat/ 
---

## Causing Trouble
Here be Dragons!

This is a strategy I have used in the past, to great effect, (even if I wasn't fully aware of what I was doing) that can bring you some attention. The idea is to take whatever software you and your company are working on and replace a module therein with an open-source-compatible license module.

Pretend your software looks like this:
```asci
[UI Module 1] [UI module 2]
   |        \ /       |
   |         X        |
   |        / \       |
  [Module 3]   [Module 4]
   |        \ /       |
   |         X        |
   |        / \       |
[DB Module 5] [DB Module 6]
```
Now, imagine your friend works on DB layer there and you publicly replace it with an open source alternative. Whether it's actually merged may not matter, just putting together a proof-of-concept will probably be enough to stir the pot. You may lose a friend (unless they're cool) and your higher ups may see you as a bit of a trouble maker, but this has, nonetheless, worked to my great advantage. Obviously, tactfulness is important - do what you can to increase the odds of a productive response. The squeaky wheel gets the grease, but when continually so: it gets replaced. By stirring the pot a bit, you may find yourself receiving more of what you ask for.

## A Good Example
Here's a slightly different, yet relevant, example. I was working in a company that merged with several other large companies. Through the merger, I was unlucky enough to end up on one of the 4 of 5 teams without the least amount of tech debt; consequently our software wasn't chosen to be what the future modern codebase would be based on. We also needed to stay on the legacy codebase, delivering new features for customers.  Also, because our software was the most feature rich, it was going to take the most amount of work to catch up on. For these reasons, we would be the last to join the modern team. Sometimes you just gotta play the hand you're dealt. Our one break was that the new features that we were being asked to deliver were aligned with new features that were being delivered to the modern codebase that was getting its technical debt paid down.

I knew what I wanted to do. I wanted to start pulling in the modern components, and merge them with our legacy system; a real Frankenstein it was sounding like. How did it play out?
- First: I got access to the modern system. I had to ask around. I asked my boss, my boss' boss, their peers.
	1. I told them we would, minimally, learn the modern code base (even if we were never successful in back porting those components, we would learn the modern codebase, and modern technologies).
	2. Many people were skeptical that this would work. I don't blame them, I was skeptical that I would have enough time to get it done.
- Second: I researched options. I developed a few proof of concepts of how it would work. Looking for feedback, I demoed it to my juniors and peers.
	1. I told them we would save time, which was kinda true. See below for details.
- Third: When the opportunity presented itself to take it to production, we were ready and it went off without a hitch. This opened up several avenues for my team to stay relevant.
	1. There was a lot of learning at the beginning, but once we hit our stride, back porting the first component went smoothly and my team was, literally, ready months before the modern-backend-team was ready.
	2. When we got requests for features that were not on par with the modern system, because we had already sorted out the build system and how to back port the modules, we wrote the new features for the legacy system as modern components.
	3. Add on to this finding and fixing bugs in the modern system.

In the company-wide weekly 'standup', I made sure to keep all the developers updated with our team's status of pulling in their code, running their build process and profiting off their work. Developers love it when you use their work.

About 12 months after starting this, and 6 months after the first release of my hybrid-frankenstein, I was asked to move over to the modern team. I still work on legacy system, though. We have had zero regrets.

Looking back, If I were to stay at the company, of course I would have to learn the modern system. If I were to leave the company, knowing that modern stuff is something I would like to put on my resume. So, in all cases, front loading the learning of the modern work was worth it, and that was most the work. I don't see any downside in the investment. In my eyes, everyone won here!
