---
layout: post
title:  "Javascript: includes(...) vs indexOf(...)"
tags: [Programing, GeneralAdvice, Javascript, Always]
date:   2021-07-22 00:00:00
permalink: /includes-vs-indexof/
---
 
## Summary
If you are using `Array.prototype.indexOf(...) >= 0` or `String.prototype.indexOf(...) >= 0` you might want to use `Array.prototype.includes(...) >= 0` or `String.prototype.includes(...)` instead.

## Details
[`.includes(...)` became available with ES 2016](https://en.wikipedia.org/wiki/ECMAScript#7th_Edition_%E2%80%93_ECMAScript_2016), before then all we had was `.indexOf(...) >= 0`, and that's how you would check if an object exists in array-like structures.

IE doesn't have support for `.includes(...)` so you would have to use [a polyfill](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/includes#polyfill) or `.indexOf(...)`.

```javascript
const nums = [1, 2, 3];
console.log(nums.indexOf("a") >= 0); //false
console.log(nums.includes("a"));     //false

console.log(nums.indexOf(2) >= 0);   //true
console.log(nums.includes(2));       //true

const str = "A E I O U a e i o u";
console.log(str.indexOf(1) >= 0);    //false
console.log(str.includes(1));        //false

console.log(str.indexOf("a") >= 0);  //true
console.log(str.includes("a"));      //true
```
