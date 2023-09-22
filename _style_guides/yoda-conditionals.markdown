---
layout: post
title:  "Yoda Conditionals: Why you should use them."
tags: [Programing, CodingStyle, ItDepends]
---

Before diving into this, I acknowledge that the Yoda style may seem foreign to you and your team. It might not resonate with you at first glance. However, I believe it is objectively superior and can enhance code readability once your team grows accustomed to it. Nevertheless, adopting such a style should be a collective team decision to avoid potential chaos.

### Summary

Here's a traditional conditional:
```javascript
var exitCode = performBatchFunction();
if (exitCode == 'success') {
    doSuccessAction();
} else if (exitCode == 'warning') {
    logWarnings();
    doSuccessAction();
} else if (exitCode == 'failure') {
    logErrors();
} else {
    logErrors();
}
performCleanup();
```

And here's a Yoda conditional:
```javascript
var exitCode = performBatchFunction();
if ('success' == exitCode) {
    doSuccessAction();
} else if ('warning' == exitCode) {
    logWarnings();
    doSuccessAction();
} else if ('failure' == exitCode) {
    logErrors();
} else {
    logErrors();
}
performCleanup();
```

### Pros and Cons

While I firmly believe in the superiority of Yoda conditionals, it's worth noting that their effectiveness is conditional.

**Yoda Pro: Prioritizing the Important**
Eye-tracking studies on resumes have shown that English readers predominantly read from left to right. Consequently, whenever you bury the lead—either vertically or horizontally—you make your content more challenging to decipher. Consider this heatmap from a resume eye-tracking study that corroborates this reading pattern.

![Resume Eye Tracking study showing English readers default to reading left to right]({{ site.url }}/style_guides/yoda-conditionals.1.jpeg)

**Yoda Con: It's Unconventional**
If Yoda conditionals were the norm, this blog post would be redundant. The downside to their increased readability is that the majority of code you'll encounter won't employ this style. If more than 70% of the conditionals in your team's code are non-Yoda, it might be best to stick with that for consistency. Before transitioning, ensure your team is convinced of the enhanced readability Yoda conditionals can offer.

**Yoda Pro: Typos Are More Detectable**
Yoda conditionals are more fail-safe. If an equality operator is mistyped, some compilers will detect the error, although this varies by language. While I believe testing should identify these issues, adopting team-wide conventions like Yoda conditionals can preemptively eliminate certain errors, benefiting the entire team.

Here, we can see two problems in a problematic language. Both are silent failures: a typoed equality operator results in the conditional running the wrong branch.

![]({{ site.url }}/style_guides/yoda-conditionals.2.png)

Contrastingly, a typo in a Yoda conditional leads to a loud failure. The compiler, recognizing the illogical assignment to a string literal, throws errors. Consequently, the function doesn't execute due to a missing definition.

![]({{ site.url }}/style_guides/yoda-conditionals.3.png)

While it might seem improbable to make such a typo, I've personally spent hours with fellow engineers trying to spot a single character error. Though this might be a weaker argument for Yoda conditionals, I still believe it holds weight.

### Conclusion

Yoda conditionals might seem unconventional initially, but they offer enhanced safety and, with familiarity, improved readability.
