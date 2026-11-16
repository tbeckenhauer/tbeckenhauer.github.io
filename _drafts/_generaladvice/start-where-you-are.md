---
layout: post
title: "Start Where You Are"
tags: [Programming, GeneralAdvice, ItDepends]
permalink: /start-where-you-are/
---

Frequently, the best place to start is where you're at. Accept where you are. What's the true next step?

That sounds obvious. Of course you have to start where you are. But I think a lot of our plans quietly assume we're somewhere else. We plan around the skills we *should* have by now, or the time we wish we had, and then wonder why we can't follow through.

Say you want to contribute to an unfamiliar codebase. You know the language, but you don't know how the application fits together. You could sign up for a beginner's programming course, even though you already know much of what it covers. You could also volunteer for a large change and hope to figure the system out along the way. Both plans skip over the same thing: you need to learn this particular application.

So I'd take one small behavior and trace it through the code. Where does the request come in? What happens to the data? Where does the response come from? If I get lost, I can ask someone to walk through that part with me. Once I can explain the path back to them, I have a better idea of what I understand and what I need to learn next.

That is what I mean by accepting where you are. It takes an honest look at your current abilities and circumstances. It also takes an honest look at what you *do* know. In this example, knowing the language is useful; so is knowing the product or the people who use it. There's no reason to start over because one part of the work is unfamiliar.

Admitting that you don't understand something can still be uncomfortable, especially when you think you ought to know it already. But that discomfort can make the gap seem bigger than it is. "I can't follow this request past the controller" gives you something to investigate. "I'm behind" doesn't tell you much.

There is some evidence that acknowledging a shortcoming needn't take away your motivation to improve. In one of [Juliana Breines and Serena Chen's experiments on self-compassion](https://self-compassion.org/wp-content/uploads/publications/selfimp.motivation.pdf), students encouraged to be less harsh with themselves after a difficult test spent more time studying for another test than students given no such encouragement. Their scores did not show a clear direct improvement. I take a modest lesson from that: you can be candid about where you are and still put in the work to change it.

Now for the other half of the advice: what's the *true* next step? In the codebase example, tracing a request helps because it moves you toward understanding the system. Fixing an easy typo might get a change merged, but it may tell you very little about the application. A step can be small and still need to point in the right direction.

It also needs to tell you something. If you can't run the application, that's your next obstacle. If you can run it but can't follow the request, now you know where to ask for help. If you can follow it but can't change it safely, you might work on the tests. You don't have to know the whole route in advance, but each step should help you choose the one after it.

This is close to what [Edwin Locke and Gary Latham found in their review of goal-setting research](https://static1.squarespace.com/static/57309137ab48de6f423b3eec/t/588a1bcd3e00bed8dee037e1/1485446094138/Locke%26Latham2002.pdf): specific, challenging goals tend to work better than vague ones when people have the ability, commitment, and feedback they need. For unfamiliar and complex work, they also discuss goals aimed at learning how to do the task. "Trace one request and explain it" is the kind of learning goal I'd use here. The research supports making the step concrete and checking what you learn; it doesn't say the step has to be easy.

This advice is useful when the goal feels so far away that all you can see is a list of things you don't know. It helps turn that list into something you can actually investigate. It is less useful if you keep choosing tasks you can already do comfortably. If you trace requests for weeks but never try changing one, the next step has probably changed and you haven't noticed.

Some work also needs a view of the whole path before you begin. If you're planning a large migration, dependencies and timing may determine which part to tackle first. Spending time understanding those constraints *is* a next step. Picking the nearest available task could send you in the wrong direction.

And sometimes the obstacle isn't a skill. You may lack access to the system, time to learn it, or a chance to take on the work you're aiming for. Accepting where you are includes noticing those limits. Maybe the next step is to ask for access, change your priorities, or find a project where you can practice. If your current work cannot take you where you want to go, doing more of it won't solve that problem.

So I would ask: what am I trying to be able to do, what can I do today, and what action would teach me something useful about the gap between them? Then I'd try that action and ask the questions again. Where you're at will have changed.
