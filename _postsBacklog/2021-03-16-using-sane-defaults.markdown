---
layout: post
title:  "Using Sane Defaults"
date:   2021-03-16 00:00:00
categories: Programing, CodingStyle
---

Here I would like to argue for a style of code I have come to like. There are a few phrases I associate with it.
1. Using sane defaults
2. Write your code so that it is always true.
3. Null object pattern.

A forth phrase that comes to mind, but I am only just thinking about it now would be "dynamic dispatch".

An recent issue that came up that puts this at the for front of my mind is an ask that involved updating a pie chart. Now this pie chart could have many states, but to basic ones, we will throw in a third for good measure.
1. Loading
2. Empty
3. Populated

Now during the pie chart initialization code, I saw something like

{% highlight javascript %}
const pieChartEmpty = {
    section1: 0,
    section2: 0,
    section3: 0,
    text: 'This pie chart is empty, something broke!'
}
const pieChartLoading = {
    text: 'Please wait while the data loads...'
};
const pieChart = {
};
{% endhighlight %}

Do you see where this is going? Let's attach that loading state.

{% highlight javascript %}
    attachPieChart(pieChartLoading)
{% endhighlight %}

Let's fetch some data. 

{% highlight javascript %}
fetch(fromSomeEndpoint)
    .then((data) => {
        if(isEmpty(data[1], data[2], data[3])) {
            attachPieChart(pieChartEmpty)
        } else {
            pieChart.section1 = data[1]
            pieChart.section2 = data[2]
            pieChart.section3 = data[3]
            attachPieChart(pieChart)
        }
    })
    .catch(() => {
        attachPieChart(pieChartEmpty)
    })
{% endhighlight %}

My issue is why are we swapping out all these different objects?
