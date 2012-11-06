##ArrayList

* ArrayList is a Java Class
* Search time is O(1)
* Insert time is O(1) (on average, but O(n) for worst-case)
* Delete time is O(n)

This data structure is backed by an Array, with some range checking and list-type operations (such as add, remove, get, etc). There is some small overhead when using ArrayList instead of Array; the range checking and such must happen to ensure no out of bounds exceptions are raised.

##Set

* Set is a Java Interface
* Search time is O(1)
* Insert time is O(1)
* Delete time is O(1)

This data structure is a subinterface of Collection and Iterable. It is a Collection with no duplicate elements, similar to the mathematical "set" idea. It's worth noting that the contents should generally not be mutable; the behavior when the .equals() functionality changes is undefined.

##TreeSet

* TreeSet is a Java Class
* Search time is O(log n)
* Insert time is O(log n)
* Delete time is O(log n)

This data structure has slower lookup times, but supposedly adds "better" (user-defined, I guess) support for tree-like structures - nested arrays, in essence. This implementation is not necessarily thread-safe; the user must "synchronize" the structure externally, according to the Oracle Java Docs.