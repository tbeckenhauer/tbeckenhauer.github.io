---
layout: post
title:  "Naming: Casing Conventions"
tags: [Programing, CodingStyle, NamingConventions, ItDepends]
permalink: /Casing-conventions/
---

### Things to consider
#### Alignment between the casing conventions in the module
My rule of thumb is: Align you casing with the rest of the named variables/functions in the module.

Let's say you have some module that is processing user input.  Your module will receive possibly anything and it's should be attempting to get a date.
```javascript
function getUserinputAsDate (userinputString) { /**/ }
```
See: [Naming: Naming Conventions](/naming-conventions) for info about why userinput needs to come first. 
Now suppose 
- for some good reason we aren't giving the user a good ui for entering dates.
- your function can handle a few different date inputs and will normalize them, and finally return them in an object format.
- normalize can accept mm/dd/yy, mm/dd/yyyy, and yyyy/mm/dd and format as YYYY-MM-DDTHH:MM:SS.sssZ
```javascript
function getUserinputAsDate (userinputString) {
	userinputString = userinputString || "1970/01/01";
	userinputDateString = normalize(userinputString);
	userinputDateObject = convertToObject(userinputDateString);
}
```

Ok this is a bit of a contrived example, but I do frequently come across functions that have this setup.  The consistent casing on all the variables starting with userinput makes it 
- easier to scan. 
- easier to understand.
- easier to write regex for.

#### Compound and Prefixed words should be considered one word (strong probability)
- I would rather see StylePreprocessor than StylePreProcessor.
- I would rather see ConfigFilename than ConfigFileName.

- My rule of thumb here is: if I could ever want to programmatically split the letters into words, then I should consider capitalizing the letter. 

In the case of ConfigFilename: I think the chances of me wanting to have a script iterate over a list of words blindly splitting on capital letters, or any of the below casing conventions I am going to be annoyed if I see words like Pre & Processor or File & Name.

#### Mixing casing conventions could have value.
I once told a co-worker this to much of their scorn, but look how well [BEM](http://getbem.com/naming/) took off.  It will always be a hack though.  Generally I find if I want to mix casing conventions, it's because I am fitting multiple types or sources of data into just one field.  Here is an example.

Let's say I am writing a blog post on github, and it requires me to prefix the blog post markdown filename with the date I am writing the blog post. So `YYYY-MM-DD`.  Most developers might do `YYYY-MM-DD-my-first-blog-post`.  Wouldn't it be better if I used `YYYY-MM-DD_my-first-blog-post` or `YYYY-MM-DD--my-first-blog-post`.  I like the underscore best because if I ever need to regex the date from the title, I am ready to go.  With the double dash, I am sure I could make it work, but with a single dash, I am going to have to have regex available because I need the pattern matching to drop or get the date. But a simple find and replace utility isn't going to cut it since that can distinguish between the dashes in the date, name, or between the date and name.  

Like I said, this will always be a hack, but that's better than no solution.

#### Reflection
It seems to me, the question is if you ever want to mechanically separate the words, then you might need to consider your casing conventions.  Let's also remember the source of casing conventions, a hack to improve the readability of code with limited systems.

#### Notes

##### Is your system case insensitive?
  - Is your file system case insensitive like the MacOs file system generally is?
    - [Case-insensitive](https://en.wikipedia.org/wiki/Case_preservation)
      - Case-preserving 
        - VFAT, FAT32 which is basically always used with long filename support, NTFS, HFS Plus, APFS 
      - Non-case-preserving 
        - FAT12, FAT16 only when without long filename support. 
  - Is your programming language case insensitive?
    - ABAP
    - Ada
    - BASIC (most of them)
    - Fortran
    - SQL
    - Pascal


##### Quick Examples
- Camel case
  - myVariable
- Snake case
  - my_variable
- Kebab case
  - my-variable
- Pascal case
  - MyVariable
- Upper case (with snake case)
  - MY_VARIABLE

##### Sources
 - [Chaseadams.io: Most Common Programming Case Types](https://chaseadams.io/posts/most-common-programming-case-types/)
 - [Study.com: Case Insensitive Programming Languages](https://study.com/academy/lesson/case-insensitive-programming-languages.html)
 - [Wikipedia: Case Sensitivity: In programming languages](https://en.wikipedia.org/wiki/Case_sensitivity#In_programming_languages)
 - [Wikipedia: Case preservation](https://en.wikipedia.org/wiki/Case_preservation)
