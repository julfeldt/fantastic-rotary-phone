Triangle Type Checker 
=======

### Triangle type
Instead of using string constants to hold the triangle types, the application uses enums since enum restricts the types
to a set of predefined values. Whereas the string constants could erroneously be replaced with any other strings.

### Main
The logic to build the triangle from user input is separated from the main method to keep the main method short, and
also so it does not depend on the System.in stream but rather an interface. The
com.company.triangle.Main#buildTriangle and com.company.triangle.Main#getInputReader methods have no modifier, so
they are not accessible from outside the package but are still possible to test.

### Triangle validation
The validation of the triangle's side lengths is placed as close to the construction of the triangle as possible, which
makes it impossible to construct an invalid triangle instance. The validation could also  have been moved to the
com.company.triangle.reader.UserInputReader class when accepting the values. However, a new triangle would not be
validated if it was at some point called from elsewhere in the code.

### User input
The com.company.triangle.reader.InputReader interface was introduced to decouple the reading of user input from the
application that creates a triangle and determines its type. Since it is an interface, it is easy to implement and use
another approach to read the side lengths. This also makes testing much easier.

To keep the user input flow simple, one must restart the application if given incorrect input.

### Error handling
Any exceptions are ultimately caught in the com.company.triangle#Main method, so the end user is not shown any
exception stack traces. The exception should instead be logged using a logging library e.g. Log4j but has been left out
to reduce the number of dependencies.
  
### Test 
The tests classes have some additional helper methods to reduce code duplication.