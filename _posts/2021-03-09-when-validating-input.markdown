---
layout: post
title:  "Validating Inputs"
date:   2021-03-09 00:00:00
categories: Programing
---

Note: Another good and related topic that I won't cover in depth here/yet. Is how when building a codebase/system. You should be validating your input's at the boundary of the system. Don't litter every function you write with check's that variables are of a certain type.  If you want that you need to consider TypeScript or any other typed language. On the backend if you are fetching data from other systems you don't own, you need to be rigerously validating it, On the frontend rigerously validating user input. Everything else inbetween needs to be rigerously checked via unit testing.

A common issue I see when reviewing code is developers using negative test cases when validating inputs

When validating input, use positive testcases, meaning test that the input/variable is the format you want rather than what you don't want.  Consider which is more effective.

{% highlight javascript %}

function comsumeUserInputGood(fieldOne, fieldTwo) {
    if(_.isNumber(fieldOne) && _.isNumber(fieldTwo)) {
        //exceute behavior you want.
        return fieldOne + fieldTwo;
    } else {
        //execute exceptional case.
    }
}

function comsumeUserInputBad(fieldOne, fieldTwo) {
    if(_.isNull(fieldOne) || _.isNull(fieldTwo)) {
        //Handle the null case. Maybe there is something special you can do here.
    }
    if(_.isUndefined(fieldOne) || _.isUndefined(fieldTwo)) {
        //Handle the undefined case. Maybe there is something special you can do here.
    } 
    //exceute behavior you want.
    return fieldOne + fieldTwo;
}

{% endhighlight %}

I think the differences here are obvious 
- In the "bad" case it's more likely to break. Maybe it wont. Maybe your input field has type=number. Ok, that's fine. The point is if you are going to be validating your input, then use positive cases.

But there is another interesting side effect that should be discussed
- in the "good" case we are propogating the most interesting code to the top of the function.  It's what you probably need to be reading. It get's straight to the point with out beating around the bush. We need a number 

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
