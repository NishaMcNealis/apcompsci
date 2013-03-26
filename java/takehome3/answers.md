Name: Max Bernstein & Chris Hinstorff<br>
Period: 2

*Object*
* Meaning
  * The superclass of all classes.
  `public class AllTheClasses_BANG extends Object { }`  

*Comparable*
* Meaning
  * An interface that, when implemented, enables an instance of a class to be compared with another.
* Methods that should be written:
  * `public int compareTo(T o) { }` 

*.equals*
* Meaning
  * Method of all objects that tests if an instance is the same as another instance
  * `public boolean equals(Object obj) { }`
* Default return value:
  * `true` if the two instances are equal
  * `false` if the two instances are not equal

*.compareTo*
* Meaning
  * Method of Comparable interface
  * Compares two objects
* Parameters
  * `T o`
* Return value(s)
  * negative `int`
  * `0`
  * positive `int`

*Superclass*
* Keyword
  * `super` *extends arm*
* Meaning
  * a class that other classes extend from

*Subclass*
* Keyword
  * `extends`
* Meaning
  * a class that is extended off of a superclass

*public* methodName
* Meaning
  * a method accessible from anywhere

*protected* methodName 
* Meaning
  * a method accessible from only the Class, Package, and Subclasses

*private* methodName
* Meaning
  * a method accessible from only the class

methodName (no modifier)
* Meaning
  * a method accessible from only the class and the package

*void*
* Meaning
  * {}
  * completely empty