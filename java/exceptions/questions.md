#[Questions](docs.oracle.com/javase/tutorial/essential/exceptions/QandE/questions.html)

## Question 1
Yes, it is legal.

## Question 2
All exceptions of the type Exception are caught, meaning all exceptions are caught.

## Question 3
Yes, the catch block for ArithmeticException can never be called, because the ArithmeticException is also an Exception. Therefore, the code will not compile.

## Question 4
* a. 3, compile error
* b. 1, error
* c. 4, no exception
* d. 2, checked exception