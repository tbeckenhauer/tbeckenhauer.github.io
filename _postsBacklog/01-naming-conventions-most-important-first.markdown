---
layout: post
title:  "Naming Convetions"
date:   2021-03-16 00:00:00
categories: Programing, CodingStyle, NamingConventions
---

They say there are two hard problems in computer science: Caching, Naming things, and off by one errors.

No? Ok.

Let's talk about naming things. I don't think it has to be that hard.  I have a few guidelines to keep in mind.

First of all, pretend your speaking spanish. In spanish

Most important word first.

Consider how things might get sorted in a file explorer.

All of these are basically the same idea.

Choose the most imporant words first, and what you would like to be ordered together first.
Use spanish as a guide nounAdjative rather than adjativeNoun

                | Wide Scope | Narrow Scope
Function | Short Name | Long Name
Variable  | Long Name | Short Name

I can't quite explain why this works, but I have two things to back up my claim. First, an appeal to an authority.  This is a recommendation from Uncle Bob.  You'll have to watch his videos to see it though a quick search doesn't turn anything up.  Second, a few examples.

- Function - Wide scope: Meaning how widely used is it? Consider Lodash and jQuery or maybe some other constructors.
    - _.map()
    - $("#appContainer")
    - new Vue()
    - Something that is pushing the limit of "short"
        - ReactDOM.render(/**/)
    - How come the jQuery constructor feels much more natural than
        - document.querySelectorAll("#appContainer")
- Function - Narrow scope: functions that have a super specific purpose should speak for themselves.
    - cudaGetTextureAlignmentOffset
        - I bet you have a decent idea what this function is for.  Now it's especially good for this example here because it mentions the library name, but that may not be best in practice.  I don't want cuda eating up 4 characters everytime I call it.  I know we are using cuda! Stop with the branding Nvidia!
        - Keep in mind this isn't the most narrow scoped function possible, just one of the more narrow ones that can be readily shared.
- Variable - Narrow scope: Let's not be tempted to stick with the previous example.  The problem is that function has a wide audience and so do the variables. So shortening them is probably not a good idea.  Let's make something up.  Let's convert drivers licenses into applications.
    - const applications = driversLicenses.map((dL, i, arr) => { id: i, userName: dL.name, phone:dL.phoneNumber });
    - I bet you didn't need me to explain dL stood for Drivers License. It might have even annoyed you if I had spelled it out.  The further away some data gets from it origin the more it will need to be explained. But with one or two lines, one or two characters is probably just fine.
- Variable - Wide scope: Think public database, or maybe color names.
    - Css Color Names is tricky because there are good and bad strategies for managing your applications colors.  But if you are trying to create names for all 16 million colors your going to need some long names.  Good luck keeping all of them meaningful.
    - Public Databases: I can say it is 72°F but that doesn't mean much unless I also specify where and when. Which could be considered part of the name.  I know I am streching this here but we haven't gone too far yet.  If you wanted to make a public database of temperatures your api might be
    - tempsDB.atLocation(48.85827172505176, 2.294531782785587).atTime(946645199)
    - tempsDB.atLocation("Eiffel tower").atTime("Midnight")
    - We are definitely stretching the definition of name to encompass that. But I don't think it's a stretch to say that we required a very long identifier to specify a piece of data we were looking for that had a wide scope.
    - it's also easy to imagine I config file that would be consumed by an application that would require long names to specify different pieces of data the application would consume.
