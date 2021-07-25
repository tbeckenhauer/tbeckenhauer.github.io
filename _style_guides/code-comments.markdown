---
layout: post
title:  "Code Comments:"
tags: [Programing, CodingStyle, Comments, ItDepends]
permalink: /Comments/
---

If you are my future manager, then yes, I comment my code.

## Summary
Many may find this heretical.  Comments are a code smell.  That doesn't necessarily mean they are bad in and of them self, just that things probably are not optimal.

*Comments should be reserved for things you can't do better with better tools. - me*

## My Thoughts
What tools might those be?
1. Deleting code / Version Control
2. Having time to write good code.
3. Having good programmers that can write good code, and understand good code.
4. Explaining bugs with unit tests.
5. Communicating to your Audience

Should you have version control, write good code, work with good programmers, and write unit tests?  Yes, but frequently reality falls short of what you should do, and you have to manage. 

1. Version Control
 - Sometime I am hacking up a quick little script, not a whole project and as I am iterating on it, I keep my versions in comments. If it becomes something I'll add in version control.

2. Having time to write good code.
 - I think too much work and not enough programmers is your managers problem. If you don't like the ratio, maybe you should find a better team.  Just be upfront about the problem if you think it's getting out of hand.  What you can do is focus on learning how to be a better programmer that can write good code faster.

3. Having good programmers that can write good code, and understand good code.
 - See point 2 above, similar but different. But it does raise another point below. See point 5.

4. Explaining bugs with unit tests.
 - I think this is a pretty good one.  I will take a unit test checking for the bug over a comment explaining it any day.  And this is the whole problem with comments, they aren't checked.  See the comments from Peter Vogel below.

5. Who is your Audience?
 - Well your audience are your customers, compiler, and co-workers. Let's focus on that co-workers one.  Sometimes I have been on teams, writing code, code I thought was good, but maybe a little abstract.  The problem called for it though, well what about the juniors on the team.  I didn't think they would be able to follow it. What about an intern? Or a new programmer, in general.  Do I need to leave a link explaining how html works so new programmers can read my code? Obviously we are getting in to absurd territory here. But somewhere between new programmer, and junior programmer people should be able to read and follow your code, and this is just something you and your team will need to work out. At this point let's refer back to point 3. Assuming your company is on a good trajectory, and is going to be hiring more and better programmers, let's assume this situation is getting better and not worse.  Hopefully your current co-workers situation is only getting better from here. ;)

## Peter's Thoughts
Per the article below Peter Vogel has written
 1. Writing and then maintaining comments is an expense.
 2. Your compiler doesn’t check your comments so there is no way to determine that comments are correct.
 3. You are, on the other hand, guaranteed that the computer is doing exactly what your code is telling it to.

So yes, I am firmly in Peter Vogels camp.

## Stackoverflow's Thoughts
Let's take a look at a recent Stackoverflow.Blog post on [Code Comments](https://stackoverflow.blog/2021/07/05/best-practices-for-writing-code-comments/) and I'll respond to each point.

1.  Comments should not duplicate the code.
 - Ok, yes. Per the article they are dispelling myths from freshman year, so OK. 

2. Good comments do not excuse unclear code.
 - Also, yes.  They go straight to [better naming](/naming-conventions/), and yes that will eliminate the need for many comments.  But there are many other things that can help eliminate the need for comments such as breaking large functions and classes up and [better ordering](/ordering-the-functions-in-your-class/).

3. If you can't write a clear comment, there may be a problem with the code.
 - Yes, kind of. I would say wanting to write a comment is an indicator of unclear code. But if you can't write a clear comment, you may not know what's going on.  A pretty crazy example.

4. Comments should dispel confusion, not cause it.
 - If you read their example, the advice should be don't put random stuff in the code. ISE 20. I didn't know it needed to be said, but ok. Another insane example.

5. Explain unidiomatic code in comments.
 - In their example they cover someone removing what may look like an unnecessary null check.  I would rather see a unit test present that scenario.

6. Provide links to the original source of copied code.
 - I don't know of a technical tool that can do this.  Code comments might be your only solution. So, yes.

7. Include links to external references where they will be most helpful. 
 - See point 6.

8. Add comments when fixing bugs.
 - Uh, no. Add unit tests when fixing bugs.

9. Use comments to mark incomplete implementations.
 - I don't like it, but if you are going to leave the implementation incomplete, then yes leave a comment.
 - Also, We are now at the point of accepting the tech debt.  This is a topic for another article.  But in a nutshell, techdebt can be acceptable, if taken seriously.  I think it should be viewed similar to regular debt that may be incurred for a startup, but as the business becomes profitable and mature, debt is reduced to "zero".
