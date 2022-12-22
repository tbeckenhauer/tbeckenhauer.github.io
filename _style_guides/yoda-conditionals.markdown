---
layout: post
title:  "Yoda Conditionals: Why you should use them."
tags: [Programing, CodingStyle, ItDepends]
permalink: /YodaConditionals/
---

So before we get started here, I want to say first this will probably be a foreign style to you and your team. For that reason, you probably won't like it at first look.  But I maintain it is objectively better, and can lend itself to "higher readability" once you and your team get used to it.  That being said. This should probably be a team decision because [we don't want chaos](http://thecodelesscode.com/case/123).

## Summary
Here is a normal conditional.
```javascript
var exitCode = performBatchFunction()
if (exitCode == 'success') {
    doSuccessAction()
} else if (exitCode == 'warning') {
    logWarnings()
    doSuccessAction()
} else if (exitCode == 'failure') {
    logErrors()
} else {
    logErrors()
}
performCleanup()
```
Here is a yoda conditional
```javascript
var exitCode = performBatchFunction()
if ('success' == exitCode) {
    doSuccessAction()
} else if ('warning' == exitCode) {
    logWarnings()
    doSuccessAction()
} else if ('failure' = exitCode) {
    logErrors()
} else {
    logErrors()
}
performCleanup()
```

## Pros and Cons
While I do think yoda conditionals are objectively better, that is conditional. 

### Yoda Pro: Most Important Things First
[Most Important Things First](https://soft-wa.re/most-important-things-first/).  Let's take a look at some eye tracking studies of resumes. We aren't going to go too deep here.  Here are [some](https://www.nngroup.com/articles/f-shaped-pattern-reading-web-content/) [links](https://www.workitdaily.com/resumes-eye-tracking-secrets) if you want to go down that rabbit hole.  Suffice it to say, English readers default to reading left to right. So any time you "bury the lead", up or down, or left to right, you are making your work harder to read.  Take a look at this heatmap here. 

![Resume Eye Tracking study showing English readers default to reading left to right]({{ site.url }}/style_guides/yoda-conditionals.1.jpeg)

### Yoda Con: This is not expected.
If this were expected, I wouldn't be writing a blog post about this. The natural Con to the previous Pro is that most code you read will not be written in this way. So if you are on a team, and more than say 70% of the conditionals are written non-yoda, then you should probably continue with that. You don't want to be the one introducing inconsistencies.  So I would get buy-in first that yoda-conditionals lead themselves to a "higher top speed readability", then move forward with them.

### Yoda Pro: Some typos are easier to catch.
Yoda conditionals are more robust.  If someone accidentally typos the equality operator the compiler may catch it for you.  I suppose it depends on the language.  To me this is a less strong argument.  I think testing should catch this type of issue.  But I think having team wide-conventions like this can eliminate a whole class of errors, which is of course good for the team.  Let's test out one of the more problematic languages.

Here we have two issues, both are silently failing.  Someone typoed the equality operator, then instead of the conditional, running the "negative" branch, it re-assigns the variable with the "positive" state, and runs the positive branch. *This may be hard to catch in testing, because the code and the UI ultimately end up in a reasonable state.*

![]({{ site.url }}/style_guides/yoda-conditionals.2.png)

Here we have one issue, that fails loudly. Someone typoed the equality operator. Then the compiler knew that assignment to a string literal made no sense, and threw errors on declaration.  Later when we tried to call the function, it wouldn't run because it wasn't even defined.

![]({{ site.url }}/style_guides/yoda-conditionals.3.png)

You may think it's unlikely to typo an equality operator like this, but just yesterday, 4 other engineers and myself had to work together to find a single character bug. So while I think this is the weaker argument, I still think it's sufficient. 

## Conclusion

I am sorry if yoda conditionals look a little weird, but I think they are far safer, and when you get used to them, I think they have a higher readability. 