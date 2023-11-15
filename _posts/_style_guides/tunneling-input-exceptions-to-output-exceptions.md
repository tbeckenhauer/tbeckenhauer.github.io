---
layout: post
title:  "Exceptions: Tunneling Input Exceptions to Output Exceptions"
date:   2023-09-20 12:00:00 -0700
categories: programming python testing
tags: exceptions tunneling unit-tests jekyll github-pages
---

Software development often involves handling exceptions to ensure applications are resilient and user-friendly. One nuanced practice in this domain is the "tunneling" of exceptions from one layer or component to another. In this post, we'll dive deep into the concept of exception tunneling and its implementation in Python. Moreover, we'll demonstrate how to effectively test this behavior using unit tests.

## What is Exception Tunneling?

Exception tunneling refers to catching exceptions in one layer or component and re-throwing them, often as a different exception type, to be handled by an outer layer or component. This is especially valuable in layered architectures or proxy-like designs.

For instance, a low-level data access exception might be caught and re-thrown as a more general "service error" for the presentation layer to handle, without it needing knowledge of the specifics of the data layer.

## Python Example

Consider the following Python example:

```python
class DataAccessError(Exception):
    pass

class ServiceError(Exception):
    pass

def data_access_function():
    raise DataAccessError("Database connection failed.")

def service_function():
    try:
        data_access_function()
    except DataAccessError as e:
        raise ServiceError("A service error occurred.") from e
```

Here, a `DataAccessError` occurring in the `data_access_function` is tunneled through the `service_function` as a `ServiceError`.

## Unit Testing Tunneling Behavior in Python

Now, how do we ensure this behavior works as intended? Through unit tests, of course!

Let's use Python's `unittest` module to validate our exception tunneling:

```python
import unittest

class TestExceptionTunneling(unittest.TestCase):

    def test_service_function_raises_service_error(self):
        with self.assertRaises(ServiceError) as context:
            service_function()

        self.assertIsInstance(context.exception.__cause__, DataAccessError)
        self.assertEqual(str(context.exception), "A service error occurred.")

if __name__ == "__main__":
    unittest.main()
```

This unit test checks two things:

1. That the `service_function` raises a `ServiceError`.
2. That the original cause (`__cause__`) of the `ServiceError` is a `DataAccessError`.

## Conclusion

Tunneling exceptions provide a structured way to handle errors, allowing each layer or component to deal with only the level of error granularity relevant to it. Combined with rigorous unit testing, this practice ensures that our software behaves predictably even in unexpected situations.
