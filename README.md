# Result Wrapper

## Introduction

### Inspiration

This package is inspired by the `Ok` `Err` `Some` `None` system in Rust.

### Problem

When a method in Java cannot complete a certain operation, typically the method will indicate this either by returning `null` or by raising an exception.

The former approach can be suitable in some cases, in particular when a null result unambiguously indicates that the operation has failed. However there are some cases where this is ambiguous.

With regard to the latter approach, I would argue that exceptions are properly used to handle errors which _cannot_ be anticipated.

An example of this would be some exceptions raised during IO operations, where it is not possible to know whether the operation will succeed until it is tried, at which point it throw an exception on failure.

An example where I would argue that exceptions are misused would be catching a `NullPointerException` instead of checking whether an object is null before operating on it. I call this _exceptions as flow control_ and I consider it bad practice. I accept that this may be a matter of style/taste.

### Solution

The classes in this package offer an alternative to the above approaches. Instead of returning `null` or raising an exception when an operation cannot be carried out, a method can instead return one of the classes found in this package. In addition to indicating success/failure of the operation in a clearer and more orderly way than the above mentioned approaches, on failure each class includes a message indicating the reason for failure which can, for example, be used for messages to end users.
