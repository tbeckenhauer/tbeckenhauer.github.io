--
layout: post
title:  "What are Exceptions?"
categories: exceptions javascript
tags: [Programing, GeneralAdvice, Docker, Tools]
---

# Handling Exceptions in Vue.js: A Practical Guide

Let's learn how JS exceptions propagate, manage state through Vuex getters, and handle network request errors in GraphQL.

## How Exceptions Propagate

When an exception isn't caught, it propagates up the call stack until the runtime catches it, often leading to undesirable outcomes. The key is catching these exceptions where they occur or letting them bubble to a level where they can be handled appropriately.

## Vuex Getters: Keeping an Eye on Errors

Vuex getters are functions that grant us real-time responses to state changes. They're perfect for handling the error states in our application. Let's see how:

```javascript
// store.js
export default new Vuex.Store({
  state: {
    error: null, // other state properties...
  },
  getters: {
    error: state => state.error, // other getters...
  },
  // ...mutations and actions
});
```

Here, any component can access the `error` state through this getter, allowing for reactive error handling.

## Network Request with GraphQL: Handling 400-599 Errors

Network requests are unpredictable. When utilizing GraphQL, we must anticipate and handle errors gracefully. Here’s how we can handle network errors specifically for status codes 400-599:

```javascript
import { gql } from '@apollo/client/core';

const query = gql`
  query GetData {
    data {
      field1
      field2
    }
  }
`;

this.$apollo.query({ query })
  .then(response => {
    // Handle success...
  })
  .catch(error => {
    if (       error.networkError && 
        400 <= error.networkError.statusCode && 
               error.networkError.statusCode <= 599) {
      // Handle errors between 400 and 599
      this.$store.commit('setError', error.message);
    }
  });
```

This approach ensures that network errors don’t slip through the cracks.

## Vue Component Methods: Catching Bubbling Exceptions

Vue’s lifecycle hooks provide a powerful way to catch exceptions thrown during rendering or watchers. The `errorCaptured` hook is designed for this:

```javascript
<template>
  <div v-if="hasError">An error occurred: {{ errorMessage }}</div>
  <!-- other template code -->
</template>

<script>
export default {
  data() {
    return {
      hasError: false,
      errorMessage: '',
    };
  },
  created() {
    this.getData();
  },
  methods: {
    getData() {
      // We're simulating the call to the GraphQL API here.
      this.$store.dispatch('fetchData')
        .catch(error => {
          this.hasError = true;
          this.errorMessage = this.$store.getters.error;
        });
    },
  },
  errorCaptured(err, vm, info) {
    this.hasError = true;
    this.errorMessage = err.message;
    return false; // false prevents the error from propagating further
  },
};
</script>
```

Here, the `errorCaptured` hook catches errors, while the `getData` method retrieves data and handles errors using the Vuex 'error' state.

## Conclusion

Exception handling in Vue.js is both an art and a science. It involves understanding how errors propagate through your app, using Vuex to manage and react to error states, handling errors during network requests, and utilizing Vue’s lifecycle hooks to catch and handle exceptions properly.

Keep coding, and stay tuned to `soft-wa.re/exceptions` for more tips on writing resilient Vue.js applications!
