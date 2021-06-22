---
layout: post
title:  "Rocking the Boat"
date:   2021-06-21 00:00:00
categories: Programing, SoftSkills
permalink: /rocking-the-boat/ 
---

Here be Dragons!

This is a strategy I have used in the past to great effect(even if I wasn't fully aware of what I was doing) that can bring you some attention.  The general strategy is to take what ever software you and your company are working on and replace some module in it with some open source compatible license module.

Pretend your software looks like this.
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
Ok, and pretend your friend works on DB layer there. Well, go replace the DB layer with some open source alternative, and do it publicly.  You don't necessarily have to have it merged, just the act of putting together a proof of concept will be enough to stir the pot.  Your friend probably won't be your friend anymore, unless they are actually really cool.  Obviously, try to be tactful, to increase your odds of a productive response.

But your higher ups might think to themselves that you might be a bit of trouble maker, and that's fine in small doses.  The squeaky wheel gets the grease, but if it's too squeaky it gets replaced.  So you might get some things you've been asking for when they see you stir the pot a little bit. Sometimes this has worked well for me.

A good example:  I was working in a company that had been merged with several other large companies.  Through the merger I was unlucky enough to end up on one of the 4 of the 5 teams without the least amount of tech debt, consequently our software was not chosen to be what the future modern codebase would be based on.  We also needed to stay on the legacy codebase delivering new features for customers.  Also because our software was the most feature rich it was going to take the most amount of work to catch up to, so we were told we were going to be last to join the modern team.  So sometimes you just gotta play the hand you are dealt.  Our one break was that the new features that were being asked to deliver were aligned with new features that were being delivered to modern codebase that was getting its technical debt payed down.

I knew what I wanted to do, I wanted to start pulling in the modern components, and merge them with our legacy system, a real Frankenstein it was sounding like.  How did it play out?
- First: I got access to the modern system. I had to ask around. I asked my boss, my bosse's boss, their peers.
	1. I told them we would at a minimum learn the modern code base (even if we were never successful in back porting those components, we would learn the modern codebase, and modern technologies)
	2. Many people were skeptical that this would work.  I don't blame them, I was skeptical that I would have enough time to get it done.
- Second: I researched options.  I developed a few proof of concepts of how it would work.  I demoed it to my juniors, and peers, looking for feedback.
	1. I told them, we would save time, this is kinda true. See below for details.
- Third: When the opportunity presented itself to take it to production, we were ready, and then it went off without a hich. This opened up several avenues for my team to stay relevant.
	1. There was a lot of learning at the beginning, but once we hit our stride, back porting the first component went smoothly and my team was ready literally months before the modern-backend team was ready.
	2. When we got requests for features that were not on par with the modern system, because we had already sorted out the build system, and how to back port the modules, we wrote the new features for the legacy system as modern components.
	3. Add on to this finding and fixing bugs in the modern system.

In the company wide weekly 'standup' I made sure to keep all the developers updated with our teams status of pulling in their code, running their build process and profiting off their work. Developers love it when you use their work.

About 12 months after starting this, and 6 months after the first release of my hybrid frankenstine I got asked to move over to the modern team.

Looking back, If I were to stay at the company of course I would have to learn the modern system, and if I were to leave the company knowing that modern stuff is something I would like to put on my resume.  So in all cases front loading the learning of the modern work was worth it, and that was most the work.  So I don't see any downsides here in the investment.

I think everyone won here.
