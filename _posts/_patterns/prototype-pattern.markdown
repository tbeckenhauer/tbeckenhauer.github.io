---
layout: post
title:  "Prototypes & Components for Mocks/Fixtures"
date:   2016-05-16 00:00:00
categories: Programing, CodingStyle
---
I want to talk about how you can simplify the problem of building out mocks for your application.  I am not sure if this is obvious, but I would like to share this.

Frequently when you are developing an application you need a way to mock out fake information, for various tasks.  Unit Testing, and Demos(with contrived scenarios) come to mind.  This is especially useful if your application isn't as straight forward as the one I am suggesting here.

We are using two patterns here the component pattern to build up our mocks, and the prototype pattern to make several of them.

Building a new employee.
{% highlight javascript %}
var employees = {
  tom: {
    id: 40,
    name: {
      first: 'Thomas',
      last: 'Beckenhauer'
    },
    locationPath: 'downtownBuilding.awesomeProductTeamFloor.windowSeat',
    position: positions.developer.superStar,
    editor: editors.vim,
  }
}

var editors = {
  vim: {
  },
  emacs: {
  }
}

var positions = {
  developer: {
    superStar: {
      makeMistakes: true,
      learnFromMistakes: true
    }
  }
};

var locations = {
  downtownBuilding: {
      awesomeProductTeamFloor: {
        windowSeat: {
          isNoisy: false,
          isChairNice: true,
        }
    }
  }
};

{% endhighlight %}

First lets look at the component pattern, we are going to use this to build up one of our employees.  What makes this the component pattern, is that we have removed (almost)all of our logic/data out of the definition of 'tom', and put it into a domain specific place.


Basing a new employee off of an existing employee is relatively easy.  Here I am using lodash to make the new object.
{% highlight javascript %}
var _ = require('lodash');

employees.jane = _.merge({}, employees.tom, {
  id: 41,
  name: {
    first: 'Jane',
    last: 'Doe'
  },
  editor: editors.emacs
});
{% endhighlight %}

As you can see building the second mock was significantly easier.  For the most part we wanted to keep everything the same except the id, name, and editor.

I would also like to add, hardcoding the id, isn't a great idea, and is out of scope for this blog post. You might want to use either a UUID generator, or a singleton couting up. Unless your id's are meaningfull. In which case you would find yourself back at something like domain specific enums or components.
