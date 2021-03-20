---
layout: post
title:  "Returning Early"
date:   2021-03-17 00:00:00
categories: Programing, CodingStyle, ItDepends
---

Note: This is post is part of a pair with [When Validating Input](/programing,/codingstyle/2021/03/08/when-validating-input.html)

In this post we are going to argue for 'guard clauses' and 'returning early'.  Let's look at some of the common arguments for this.

## [Replace Nested Conditionals with Guard Clauses](https://refactoring.com/catalog/replaceNestedConditionalWithGuardClauses.html)

I think the benefits here are quite obvious. Let's take a look at some nested conditionals.

{% highlight javascript %}
function getPayAmount() {
  let result;
  if (isDead)
    result = deadAmount();
  else {
    if (isSeparated)
      result = separatedAmount();
    else {
      if (isRetired)
        result = retiredAmount();
      else
        result = normalPayAmount();
    }
  }
  return result;
}
{% endhighlight %}

Compared with:

{% highlight javascript %}
function getPayAmount() {
  if (isDead) return deadAmount();
  if (isSeparated) return separatedAmount();
  if (isRetired) return retiredAmount();
  return normalPayAmount();
}
{% endhighlight %}

The latter is obviously much cleaner.  Returning early can be used to prevent excess nesting of code blocks.



I think the differences here are obvious
- In the "bad" case it's more likely to break. Maybe it wont. Maybe your input field has type=number. So in practice you are dealing with null and numbers. Ok, that's fine. The point is if you are going to be validating your input, positive test cases won't let anything slip through the cracks.

But there is another interesting side effect that should be discussed
- In the "good" case we are propagating the most interesting code to the top of the function.  It's what you probably need to be reading. It gets straight to the point. We need a number, then get on with what you're going to do with it. Littering the top of the function with negative checks is everything I am not interested in.

Another scenario that mixes the above but the point remains would be

{% highlight javascript %}

function comsumeUserInputGood(fieldOne, fieldTwo) {
  fieldOne = _.isNumber(fieldOne) ? fieldOne : 0;
  fieldTwo = _.isNumber(fieldTwo) ? fieldTwo : 0;

  return fieldOne + fieldTwo;
}

function comsumeUserInputBad(fieldOne, fieldTwo) {
  fieldOne = fieldOne || 0;
  fieldTwo = fieldTwo || 0;

  return fieldOne + fieldTwo;
}

{% endhighlight %}

I don't have to tell you an empty array or empty object would slip through the checks in the second function. [Which could lead to some fun math.](https://github.com/denysdovhan/wtfjs#funny-math)

{% highlight javascript %}
> {} + []
> 0
{% endhighlight %}

I hope I have sufficiently proved in most cases if you need to validate some input there is a good chance you should be using positive test cases.  If you have any exceptions that prove the rule, I would be interested to see them.

