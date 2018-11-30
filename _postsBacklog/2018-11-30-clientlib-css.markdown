---
layout: post
title:  "AEM Clientlib Basics"
date:   2018-11-29 00:00:00
categories: frontendDevelopment contentManagementSystem adobeExperienceManager aem clientlibs
---
I am learning AEM, and I am new to the system.  I think this post will illustrate that, and possibly help other newbies.

When making an AEM component, if you want to create js or css files that go along with that component you will need to use the client lib system.  I am going to go over the steps to set this up and one of the gotchas that got me.

First let's make our clientlib directory.  
{% highlight bash %}
mkdir navigation/clientlibs
{% endhighlight %}

Ok, great.  Next we need to create the .content.xml.  This is a AEM/[JCR](https://en.wikipedia.org/wiki/Content_repository_API_for_Java) thing.  you will find your source code littered with these .content.xml files.  On one level they feel like a mess, because they are everywhere.  On another level, they feel like a simple way to annotate folders with information.  I would suggest getting used to reading them.  They are not too bad.

{% highlight bash %}
vim navigation/clientlibs/.content.xml
{% endhighlight %}

{% highlight xml %}
<?xml version="1.0" encoding="UTF-8"?>
<jcr:root xmlns:cq="http://www.day.com/jcr/cq/1.0"
          xmlns:jcr="http://www.jcp.org/jcr/1.0"
    jcr:primaryType="cq:ClientLibraryFolder"
    categories="[navigation]"/>
{% endhighlight %}

{% highlight bash %}
echo navigation/navigation.html
{% endhighlight %}

{% highlight html %}
<div data-sly-use.clientLib="${'/libs/granite/sightly/templates/clientlib.html'}"></div>
<output data-sly-call="${clientlib.css @ categories='navigation'}" data-sly-unwrap/>

<nav class="navigationBlock">
    <!--Navigation code goes here-->
</nav>

<output data-sly-call="${clientlib.js @ categories='navigation'}" data-sly-unwrap/>
{% endhighlight %}

{% highlight bash %}
echo navigation/clientlibs/navigation.css
{% endhighlight %}

{% highlight css %}
.navigationBlock {
    box-sizing: border-box;
    display: flex;
}

.navigationBlock .navigationElement {
    flex-grow: 1;
}
{% endhighlight %}
