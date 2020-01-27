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

## Usage

### Outcome

The `Outcome` class is used for operations which perform an action but do not return any object as a result on success. This would be used for example for a method which previously would have returned `void` or perhaps `boolean` `true` for success and `false` for failure.

An example might be writing out a String to a file.

```

import java.io.FileNotFoundException;
import java.io.PrintWriter;

Outcome writeToFile(
  String filePath,
  String contents
) {
  Outcome outcome = new Outcome();
  try {
    PrintWriter writer = new PrintWriter(
      filePath
    );
    writer.println(contents);
    writer.close();
    outcome.succeed();
  } catch (FileNotFoundException e) {
    outcome.fail(
      "No file could be found at the path provided";
    )
  }
  return outcome;
}

public static void main(
  String[] args
) {
  String filePath = "/path/to/file.txt";
  String contents = "Test String
  Outcome writingOut = writeToFile(
    filePath,
    contents
  );
  if (writingOut.failed()) {
    // Show message to use, log error, try something else
    System.out.println(
      String.format(
        "Writing out to file failed with: %s",
        writingOut.failureReason()
      )
    );
  }
}

```

### Result

The result class can be used for an operation that should produce a result which needs to be returned to the calling method and that may fail. An example would be to abstract away the exception handling when parsing a number out from a string.

```
Result<Integer> stringToInteger(
  String toParse
) {
  Result<Integer> result = new Result<Integer>();
  try {
    Integer i = Integer.parseInt(toParse);
    result.succeed(i);
  } catch (NumberFormatException e) {
    result.fail(
      String.format(
        "The string provided (%s) does not represent a valid integer",
        toParse
      )
    );
  }
  return result;
}

public static void main(
  String[] args
) {

  String toParse1 = "76";
  String toParse2 = "19.284";

  Result<Integer> firstParsing = stringToInteger(
    toParse1
  );
  Result<Integer> secondParsing = stringToInteger(
    toParse2
  );

  // Display messages, log errors, etc...

  if (firstParsing.success()) {
    System.out.println(
      String.format(
        "Success! String %s parsed to integer %d",
        toParse1,
        firstParsing.result()
      )
    );
  } else {
    System.out.println(
      String.format(
        "Error! String %s could not be parsed as integer",
        toParse1,
      )
    );
  }

  if (secondParsing.success()) {
    System.out.println(
      String.format(
        "Success! String %s parsed to integer %d",
        toParse2,
        secondParsing.result()
      )
    );
  } else {
    System.out.println(
      String.format(
        "Error! String %s could not be parsed as integer",
        toParse2,
      )
    );
  }

}
```
