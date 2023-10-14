---
layout: post
title:  "Structuring: Using Sane Defaults"
date:   2021-03-16 00:00:00
categories: Programing, CodingStyle, ChooseWhereYourComplexityIs
section: 1
---

I'd like to advocate for a coding style I've grown fond of, associated with a few specific phrases:

- Using sane defaults
- Write your code so that it is always true
- [Null object pattern](https://en.wikipedia.org/wiki/Null_object_pattern#JavaScript)
- Dynamic Dispatch

It’s not that the latter two (3 and 4) are synonymous with the first two, but rather, I perceive Null Object Patterns as sane defaults and view Dynamic Dispatch as a means to ensure your code always holds true. However, I’ll save the detailed discussion on Null Objects and Dynamic Dispatch for another day.

A recent issue brought this philosophy to the forefront for me, revolving around updating a pie chart. This pie chart could adopt multiple states, but for clarity, we'll consider three primary ones:

1. Loading
2. Empty
3. Populated

During the pie chart's initialization code, I observed the following:

{% highlight javascript %}
const pieChartEmpty = {
   text: 'This pie chart is empty, something broke!'
}
const pieChartLoading = {
   text: 'Please wait while the data loads...'
};
const pieChart = {
};
{% endhighlight %}

Notice where this is headed?

{% highlight javascript %}
   attachPieChart(pieChartLoading)
{% endhighlight %}

Let's fetch some data.

{% highlight javascript %}
function fetchData() {
   fetch(fromSomeEndpoint)
       .then((data) => {
           if(isEmpty(data)) {
               attachPieChart(pieChartEmpty)
           } else {
               pieChart.data = data
               attachPieChart(pieChart)
           }
       })
       .catch(() => {
           attachPieChart(pieChartEmpty)
       })
}
{% endhighlight %}

Maybe the user manipulates the data in some way.

{% highlight javascript %}
handleSomeUserInteraction(data) {
   if(isEmpty(data)) {
       attachPieChart(pieChartEmpty)
   } else {
       pieChart.data = data
       attachPieChart(pieChart)
   }   
}
{% endhighlight %}

Why are we devising special cases? I bet this empty pie chart and the loading pie chart aren’t dramatically different from the standard pie chart. It's likely we only need to supply appropriate data for it to function. The main issue is the developer's mindset that necessitates special scenarios, which then litters the codebase with if/else checks to determine the current scenario before executing a specific instruction set.

A stronger approach would be to:

1. **Validate your input/Use sane defaults.** If your system struggles with nulls and undefined values, intercept these at your system's boundary. Substitute these problematic values with safer ones, like integer zeros, which pie charts handle with ease. Occasionally, the source of such problematic input is our own system.
2. **Make your component robust/Ensure your code always holds true.** If your input already contains zeros, and your component struggles with it, consider strategies to handle that gracefully. For instance, a pie section with zero value could be rendered invisible. If all values are zeros, perhaps gray out the entire chart.
3. **Decide where complexity should reside.** This deserves its own post, but I'd like to emphasize that sometimes, good engineering is about dictating where complexity sits. 

Now, let's reimagine this with the above recommendations:

```javascript
// ... (code snippet) ...
```

Our `attachPieChart` function may require enhancements to adapt to a mutable object. That's alright; it's a feature worth having.

tags:

---

Here are some potential tags based on the content:
- `#CodeQuality`
- `#ProgrammingPhilosophy`
- `#CleanCode`
- `#ErrorHandling`
- `#WebDevelopment`
- `#PieCharts`
- `#DataVisualization`
- `#CodingBestPractices`

I hope these suggestions and edits help you!