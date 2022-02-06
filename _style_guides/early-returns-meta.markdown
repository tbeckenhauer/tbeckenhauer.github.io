---
layout: post
title:  "Structuring: Early Returns(Meta)"
tags: [Programing, CodingStyle, ItDepends]
permalink: /early-returns-meta/
blogcast: true
---

Note: This is post is part of a series with [Early Returns(For)](/early-returns-for/), and [When Validating Inputs](/when-validating-inputs/)

In a nutshell, I think this whole disagreement is a distraction.  Generally when I see this debate come up it is in the context of some functions that are trying to do too much. Chances are I would ask for that function to be broken down into smaller functions and given more meaningful names.  Then by the time we get to that point it will be more obvious if an if/elseIf/else block is better or if early returns are better.  Let's look at an abstract view of this, assuming the function has already been distilled into smaller functions.

{% highlight javascript %}
function ifElseClauseExample() {
  if (positiveTestCase()) {
      executeHappyPath();
  } else if (negativeTestCase()) {
      executeSadPath();
  } else {
      console.log("This should never happen, but could...");
  }
}
function earlyReturnExample() {
    if (negativeTestCase()) {
        executeSadPath();
    }

    executeHappyPath();
}
{% endhighlight %}

What I want to demonstrate here is: IF you need your "Happy Path" protected by a "Positive Test" AND you are interested in logging "Unknown Unhappy Paths" then you should use if/else clauses, otherwise you might be better off with a simple early return.  
