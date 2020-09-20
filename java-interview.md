# Java Interview questions
- [Collections](#collections)
- [Data Structures and Algorithms](#data-structures-and-algorithms)
- [Concurrency](#concurrency)
- [Phone interview](#phone-interview)
- [Generics](#generics)
- [Frequently Asked Questions](#Frequently-Asked-Questions);
- [Other Core Java Questions](#Other-Core-Java-Questions)
- Top 10 Tricky Java interview questions and Answers ([link](https://www.java67.com/2012/09/top-10-tricky-java-interview-questions-answers.html))


## Collections
Source: https://javarevisited.blogspot.com/2011/11/collection-interview-questions-answers.html
1. How does `HashMap` work in Java? (*Variations: Why `HashMap` keys need to be immutable? what is race conditions on `HashMap` and how `HashMap` resize in Java?*) ([answer](https://javarevisited.blogspot.com/2011/11/collection-interview-questions-answers.html))

1. What is the difference between `poll()` and `remove()` method of `Queue` interface?

1. What is the difference between **fail-fast** and **fail-safe** Iterators? ([answer](https://www.java67.com/2015/06/what-is-fail-safe-and-fail-fast-iterator-in-java.html))

1. How do you remove an entry from a `Collection`? and subsequently what is the difference between the `remove()` method of Collection and `remove()` method of `Iterator`, which one you will use while removing elements during iteration?

1.  What is the difference between **Synchronized Collection** and **Concurrent Collection**? ([answer](https://javarevisited.blogspot.com/2011/04/difference-between-concurrenthashmap.html))

1. What is the difference between `Iterator` and `Enumeration`? ([answer](https://javarevisited.blogspot.com/2010/10/what-is-difference-between-enumeration.html))

1. How does `HashSet` is implemented in Java, How does it use Hashing? ([answer](https://www.java67.com/2014/01/how-hashset-is-implemented-or-works-internally-java.html))

1. What do you need to do to use a custom object as a key in Collection classes like `Map` or `Set`?

1. The difference between `HashMap` and `Hashtable`? ([answer](https://javarevisited.blogspot.com/2015/08/difference-between-HashMap-vs-TreeMap-vs-LinkedHashMap-Java.html))

1. When do you use `ConcurrentHashMap` in Java? ([answer](https://javarevisited.blogspot.com/2011/04/difference-between-concurrenthashmap.html))

1. What is the difference between `Set` and `List` in Java? ([answer](https://www.java67.com/2012/08/difference-between-list-and-set-in-java.html))

1. How do you Sort objects on the collection? What is the different between `Comparable` and `Comparator`. ([answer](http://java67.blogspot.com/2012/07/sort-list-ascending-descending-order-set-arraylist.html))

1. What is the difference between `Vector` and `ArrayList`? ([answer](https://www.java67.com/2012/09/arraylist-vs-vector-in-java-interview.html))

1. What is the difference between `HashMap` and `HashSet`? ([answer](https://www.java67.com/2012/08/difference-between-hashset-and-hashmap.html))

1. What is `NavigableMap` in Java? What is a benefit over `Map`? ([answer](https://javarevisited.blogspot.com/2013/01/what-is-navigablemap-in-java-6-example-submap-head-tail.html))

1. Which one you will prefer between `Array` and `ArrayList` for Storing object and why? ([answer](https://www.java67.com/2012/12/difference-between-array-vs-arraylist-java.html)). *See "Effective Java", Item 28: Prefer lists to arrays*.

1. Can we replace `Hashtable` with `ConcurrentHashMap`?

1. What is `CopyOnWriteArrayList`, how it is different than `ArrayList` and `Vector`? ([answer](https://www.java67.com/2015/06/difference-between-synchronized-arraylist-and-copyOnWriteArrayList-java.html))

1. Why `ListIterator` has `added()` method but Iterator doesn't or Why to `add()` method is declared in `ListIterator` and not on Iterator. ([answer](https://javarevisited.blogspot.com/2011/11/collection-interview-questions-answers.html))

1. When does `ConcurrentModificationException` occur on iteration? ([answer](https://www.java67.com/2015/10/how-to-solve-concurrentmodificationexception-in-java-arraylist.html))


1. Difference between `Set`, `List` and `Map` Collection classes? ([answer](java67.blogspot.com/2013/01/difference-between-set-list-and-map-in-java.htmll))

1. What is `BlockingQueue`, how it is different than other collection classes? ([answer](java67.blogspot.com/2013/01/difference-between-set-list-and-map-in-java.htmll))


1. How does `LinkedList` is implemented in Java, is it a Singly or Doubly linked list?
Hint: `LinkedList` in Java is a doubly linked list.

1. How do you iterator over Synchronized `HashMap`, do you need to lock iteration and why?

1. What is `Deque`? when do you use it?

## Data Structures and Algorithms
Source: https://javarevisited.blogspot.com/2013/03/top-15-data-structures-algorithm-interview-questions-answers-java-programming.html

## Concurrency
Source: https://javarevisited.blogspot.com/2014/07/top-50-java-multithreading-interview-questions-answers.html#axzz6UiZ28HdV

1. What is `Thread` in Java? ([answer](https://www.java67.com/2014/01/10-points-about-thread-and-javalangthread-in-java.html))

1.  What is the difference between `Thread` and `Process` in Java? ([answer](https://www.java67.com/2012/12/what-is-difference-between-thread-vs-process-java.html))

1. How do you implement `Thread` in Java? ([answer](https://javarevisited.blogspot.com/2011/02/how-to-implement-thread-in-java.html))

1. When to use `Runnable` vs `Thread` in Java? ([answer](http://javarevisited.blogspot.com/2012/01/difference-thread-vs-runnable-interface.html))

1. What is the difference between `start()` and `run()` method of Thread class? ([answer](https://javarevisited.blogspot.com/2012/03/difference-between-start-and-run-method.html))

1. What is the difference between `Runnable` and `Callable` in Java? ([answer](https://www.java67.com/2013/01/difference-between-callable-and-runnable-java.html))

1. What is the difference between `CyclicBarrier` and `CountDownLatch` in Java? ([answer](http://javarevisited.blogspot.com/2012/07/cyclicbarrier-example-java-5-concurrency-tutorial.htmll))

1. What is Java Memory model?

1. What is volatile variable in Java? ([answer](https://www.java67.com/2012/08/what-is-volatile-variable-in-java-when.html))

1. What is thread-safety? is Vector a thread-safe class? ([answer](https://javarevisited.blogspot.com/2011/09/difference-vector-vs-arraylist-in-java.html))

1. What is race condition in Java? Given one example? ([answer](https://javarevisited.blogspot.com/2012/02/what-is-race-condition-in.html#axzz6WxIPsJA1))

1. How to stop a thread in Java?([answer](https://www.java67.com/2015/07/how-to-stop-thread-in-java-example.html))

1. What happens when an `Exception` occurs in a thread?

1. How do you share data between two thread in Java? (*Producer-consumer pattern*)

1. What is the difference between `notify` and `notifyAll` in Java? ([answer](https://javarevisited.blogspot.com/2012/10/difference-between-notify-and-notifyall-java-example.html))

1. Why wait, `notify` and `notifyAll` are not inside `Thread` class? ([answer](What is ThreadLocal variable in Java?))

1. What is `ThreadLocal` variable in Java? ([answer](https://javarevisited.blogspot.com/2012/05/how-to-use-threadlocal-in-java-benefits.html))

1. What is `FutureTask` in Java?

1. What is the difference between the `interrupted()` and `isInterrupted()` method in Java?

1. Why wait and notify method are called from synchronized block? ([answer](https://javarevisited.blogspot.com/2011/05/wait-notify-and-notifyall-in-java.html))

1. Why should you check condition for waiting in a loop? ([answer](https://javarevisited.blogspot.com/2015/07/how-to-use-wait-notify-and-notifyall-in.html))

1. What is the difference between **synchronized** and **concurrent** collection in Java?

1. What is the difference between Stack and Heap in Java? ([answer](https://javarevisited.blogspot.com/2014/07/top-50-java-multithreading-interview-questions-answers.html#axzz6UiZ28HdV))

1. What is **thread pool**? Why should you thread pool in Java?

1. Write code to solve **Producer-Consumer** problem in Java?
 ([see](src/kb/concurrent/producer_consumer/ProducerConsumerWithLock.java))

1. How do you avoid **deadlock** in Java? Write Code? ([answer](https://javarevisited.blogspot.com/2018/08/how-to-avoid-deadlock-in-java-threads.html))

1. What is the difference between **livelock** and **deadlock** in Java?

1. How do you check if a Thread holds a lock or not?

1. How do you take thread dump in Java?

1. Which JVM parameter is used to control stack size of a thread?

1. What is the difference between synchronized and ReentrantLock in Java? ([answer](https://javarevisited.blogspot.com/2013/03/reentrantlock-example-in-java-synchronized-difference-vs-lock.html))

1. There are three threads T1, T2, and T3? How do you ensure sequence T1, T2, T3 in Java? ([answer](https://www.java67.com/2015/07/how-to-join-two-threads-in-java-example.html))

1. What does yield method of `Thread` class do? ([answer](https://www.java67.com/2012/08/difference-between-yield-and-wait.html))

1. What is the concurrency level of ConcurrentHashMap in Java? ([answer](https://javarevisited.blogspot.com/2013/02/concurrenthashmap-in-java-example-tutorial-working.html))

1. What is Semaphore in Java?

1. What happens if you submit a task when the queue of the thread pool is already filled?

1. What is the difference between the submit() and execute() method thread pool in Java? ([answer](https://javarevisited.blogspot.com/2013/07/how-to-create-thread-pools-in-java-executors-framework-example-tutorial.html))

1. What is blocking method in Java? ([answer](https://javarevisited.blogspot.com/2012/02/what-is-blocking-methods-in-java-and.html))

1. How to create an Immutable object in Java? ([answer](https://javarevisited.blogspot.com/2013/03/how-to-create-immutable-class-object-java-example-tutorial.html))

1. What is `ReadWriteLock` in Java?

1. What is busy spin in multi-threading?

1. What is the difference between the volatile and atomic variable in Java?

1. What happens if a thread throws an Exception inside synchronized block?

1. How to create thread-safe Singleton in Java?

1. List down 3 multi-threading best practice you follow?

1. How do you force to start a Thread in Java?

1. What is the fork-join framework in Java? ([answer](https://javarevisited.blogspot.com/2014/07/top-50-java-multithreading-interview-questions-answers.html#axzz6UiZ28HdV))

1. What is the difference between calling `wait()` and `sleep()` method in Java multi-threading? ([answer](https://javarevisited.blogspot.com/2011/12/difference-between-wait-sleep-yield.html))


## Phone interview
Source: https://javarevisited.blogspot.com/2018/07/top-30-java-phone-interview-questions.html

1. Why is String immutable in Java? ([answer](javarevisited.blogspot.sg/2010/10/why-string-is-immutable-in-java.html))

1. Can abstract class have a constructor in Java?

1. Which two methods are overridden by an Object, intended to be used as a key in `HashMap`? ([answer](https://javarevisited.blogspot.com/2013/08/10-equals-and-hashcode-interview.html))

1. What is the difference between wait and sleep in Java? ([answer](https://javarevisited.blogspot.com/2011/12/difference-between-wait-sleep-yield.html))

1. Difference between List and Set in Java? (easy)

1. Difference between List and Set in Java? ([answer](https://javarevisited.blogspot.com/2013/03/how-to-create-immutable-class-object-java-example-tutorial.html))

1. Which data type you should use to represent currency in Java? (easy)

1. When to use abstract class and interface in Java? (easy)

1. Difference between Hashtable and HashMap in Java? (easy)

1. What is the difference between ArrayList and LinkedList in Java? (easy)

1. What is the difference between Overloading and Overriding in Java? *(Compile time vs Runtime polymorphism. See [this](https://javarevisited.blogspot.com/2012/03/what-is-static-and-dynamic-binding-in.html) and [this](https://javarevisited.blogspot.com/2011/12/method-overloading-vs-method-overriding.html))*

1. Difference between checked and unchecked exception in Java?

1. Difference between checked and unchecked exception in Java? ([answer](javarevisited.blogspot.sg/2011/12/checked-vs-unchecked-exception-in-java.html))

1. Does Java array is an instance of Object?

1. Does `List<Number>` can hold Integers? (easy)

1. Can we pass `ArrayList<Number>` to a method which accepts `List<Number>` in Java?

1. Can we pass `ArrayList<Integer>` to a method which accepts `List<Number>`?

1. What is a volatile variable in Java?

1. What is the difference between `CountDownLatch` and `CyclicBarrier` in Java?

1. Does `BlockingQueue` is thread-safe in Java?

1. Why wait and notify method should be called in a loop?

1. What is the difference between `"ABC".equals(unknown string)` and `unknown.equals("ABC")`? (`NullPointerException`)

1. What is a **marker** or **tag** interface in Java? ([answer](https://javarevisited.blogspot.com/2012/01/what-is-marker-interfaces-in-java-and.html))

1. Can `Enum` types implement interface in Java? (Yes)

1. Can `Enum` extend a class in Java?  (No)

1. How to prevent your class from being subclassed? ([answer](https://javarevisited.blogspot.com/2015/04/3-ways-to-prevent-method-overriding-in.html))

1. Can we override a static method in Java? Compilation error? ([answer](https://javarevisited.blogspot.com/2013/03/can-we-overload-and-override-static-method-java.html))

1. Which design pattern have you used recently?

1. What is the difference between `StringBuffer` and `StringBuilder` in Java?


## Generics
Source: https://javarevisited.blogspot.com/2020/04/50-java-collection-and-generics-interview-questions-answers.html, https://javarevisited.blogspot.com/2020/04/50-java-collection-and-generics-interview-questions-answers.html

1. What is Generics in Java ? What are advantages of using Generics?

1. How Generics works in Java ? What is type erasure?

1. What is Bounded and Unbounded wildcards in Generics? *What is the difference between bounded and unbounded wildcards in Java generics? What is difference between `List<? extends T>`  and  `List <? super T>`?*

1. Write a program to implement LRU cache using Generics ?

1. Can you pass `List<String>` to a method which accepts `List<Object>`?

1. Can we use Generics with Array?

1. Difference between `List<Object>` and raw type `List` in Java?

1. Difference between `List<?>` and `List<Object>` in Java?

1. Difference between `List<String>` and raw type `List`?

1. What is an "unchecked" warning?

1. What is a bridge method?

1. How can I avoid "unchecked cast" warnings?

1. What is the "diamond" operator?

1. Difference between `ArrayList` and `ArrayList<?>` in Java? *(Raw type vs Wildcard)*



## Frequently Asked Questions
Source: https://www.java67.com/2014/07/21-frequently-asked-java-interview-questions-answers.html

## Other Core Java Questions

1. What are the types of Java Threads? ([See](https://www.geeksforgeeks.org/daemon-thread-java/))

1. What is a class loader?

1. What is volatile "happens-before" relationship - *"A happens-before relationship is a guarantee that memory written to by statement A is visible to statement B, that is, that statement A completes its write before statement B starts its read."*

 1. Why multiple inheritance is not supported in Java? ([answer](https://javarevisited.blogspot.com/2011/07/why-multiple-inheritances-are-not.html))

 1. Does Java Pass by Value or Pass by Reference? ([answer](https://javarevisited.blogspot.com/2012/12/does-java-pass-by-value-or-pass-by-reference.html))

 1. Can You Run Java Program Without a Main Method? ([answer](https://www.java67.com/2014/02/can-you-run-java-program-without-main-method.html))

 1. Why main method is public static and void in Java? ([answer](https://www.java67.com/2012/08/what-is-main-method-in-java-why-main-is.html))

 1. Why character array is better than String for Storing password in Java? (See [this](https://javarevisited.blogspot.com/2012/03/why-character-array-is-better-than.html) and [this](https://www.geeksforgeeks.org/use-char-array-string-storing-passwords-java/) answer)

 1. Why Default or No Argument Constructor is Important in Java Class? ([answer](https://javarevisited.blogspot.com/2014/01/why-default-or-no-argument-constructor-java-class.html))

 1. Can we have a static & final method? (Yes)

 1. Can we have an abstract & final method? (No)

 1. What are the implications of declaring a constructor private?

 1. Can there be a private/constructor in an abstract class? ([see](https://stackoverflow.com/questions/11625635/private-constructor-in-abstract-class))

 1. `new String(“str”);` how many objects will be created? ([see](https://stackoverflow.com/questions/1881922/questions-about-javas-string-pool))

 1. Can a constructor be final? (No, [see](https://www.tutorialspoint.com/Can-a-constructor-be-made-final-in-Java))

 1. How to sort values in `HashMap`? ([answer](https://www.java67.com/2015/01/how-to-sort-hashmap-in-java-based-on.html))
