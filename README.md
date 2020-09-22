# Knowledge Base
A lightweight programming knowledge base with examples. Although is `Java` oriented the most of the concepts are language agnostic.
## Short content
1. [Java Concurrency](#java-concurrency)
2. [Data Structures](#data-structures)
3. [Design Patterns](#design-patterns)
4. [Sorting Algorithms](#sorting-algorithms)
5. [Java Interview Questions](java-interview.md)

## Java Concurrency
- **Locks**
  - `ReentrantLock` [demo](src/kb/concurrent/lock/ReentrantLockDemo.java)
  - `ReentrantReadWriteLock` [demo](src/kb/concurrent/lock/ReentrantReadWriteLockDemo.java)
- **Synchronizers**
  - [Explanations + diagrams](src/kb/concurrent/synchronizers/README.md)
  - `CountDownLatch` [demo](src/kb/concurrent/synchronizers/CountDownLatchDemo.java)
  - `CyclicBarrierDemo` [demo](src/kb/concurrent/synchronizers/CyclicBarrierDemo.java)
  - `SemaphoreDemo` [demo](src/kb/concurrent/synchronizers/SemaphoreDemo.java)
  - `ThreadLocalDemo` [demo](src/kb/concurrent/synchronizers/ThreadLocalDemo.java)
- **ForkJoin** - some recursive task that are appropriate for ForkJoin computations
  - [Tree printer](src/kb/concurrent/forkjoin/TreePrinter)
  - [Fibonacci](src/kb/concurrent/forkjoin/Fibonacci.java)
- **Problems** - a collection of some common concurrent problems
    - [Producer-consumer with Lock](src/kb/concurrent/problems/ProducerConsumerWithLock.java)
    - [Producer-consumer with Blocking Queue](src/kb/concurrent/problems/ProducerConsumerWithBlockingQueue.java)
    - [Ensure thread sequence with `join`](src/kb/concurrent/problems/EnsureSequenceWithJoin.java)

## Data Structures
See the packages  [here](/src/kb/data_structures).
- **List** - implementations of Java `java.util.List` interface
  - [Array List](src/kb/data_structures/list/MyArrayList.java)
    - [Test](/src/kb/data_structures/list/test)
  - [Singly Linked List](src/kb/data_structures/list/MySinglyLinkedList.java)
      - [Test](/src/kb/data_structures/list/test)
- **Hash Table** - implementations of Java `java.util.Map` and `java.util.Set` interface.
  - [Hash Map](src/kb/data_structures/hashtable/JHashTable.java)
    - [Test](/src/kb/data_structures/hashtable/test)
  - [Hash Set](/src/kb/data_structures/hashtable/JHashSet.java)
    - [Test](/src/kb/data_structures/hashtable/test)
- **Tree** - implementations Tree data structure.
  - [Binary Search Tree](src/kb/data_structures/tree/BinarySearchTree.java)
  - [Prefix Tree (Trie)](src/kb/data_structures/tree/PrefixTree.java)

## Design patterns
See the packages [here](/src/kb/design_patterns).
- Creational patterns
  - [Builder](/src/kb/design_patterns/builder)
  - [Factory Method](/src/kb/design_patterns/factory_method)
  - [Singleton](/src/kb/design_patterns/singleton)
  - [Prototype](/src/kb/design_patterns/prototype)
- Structural patterns
  - [Adapter](/src/kb/design_patterns/adapter) (Wrapper, or Translator)
  - [Bridge](/src/kb/design_patterns/bridge)
  - [Composite](/src/kb/design_patterns/composite)
  - [Decorator](/src/kb/design_patterns/decorator)
  - [Facade](/src/kb/design_patterns/facade)
  - [Proxy](/src/kb/design_patterns/proxy)
- Behavioral patterns
  - [Command](/src/kb/design_patterns/command)
  - [Observer](/src/kb/design_patterns/observer) (or Publish/Subscribe)
  - [State](/src/kb/design_patterns/state)
  - [Strategy](/src/kb/design_patterns/strategy)
  - [Visitor](/src/kb/design_patterns/visitor)

## Sorting Algorithms
See the packages [here](/src/kb/sort).
| Implementation link | Average case | Worst case | Memory | Stable | Restrictions|
|:-|:-|:-|:-|:-|:-|
| [Insertion Sort](src/kb/sort/InsertionSort.java) | `n^2` | `n^2` | `1` | yes | no |
| [Binary Insertion Sort](src/kb/sort/BinaryInsertionSort.java) | `n^2` | `n^2` | `1` | yes | no |
| [Selection Sort](src/kb/sort/SelectionSort.java) | `n^2` | `n^2` | `1` | no | no |
| [Bubble Sort](src/kb/sort/BubbleSort.java) | `n^2` | `n^2` | `1` | yes | no |
| [Merge Sort](src/kb/sort/MergeSort.java) | `n.log(n)` | `n.log(n)` | `n`  | yes  | no
| [Quick Sort](src/kb/sort/QuickSort.java) | `n.log(n)` | `n^2` | `n.log(n)`  | no  | no |
| [Heap Sort](src/kb/sort/HeapSort.java) | `n.log(n)` | `n.log(n)`  | `1`  | no | no |
| [Counting Sort](src/kb/sort/CountingSort.java) | `n` | `n^2` | `n` | yes | integers |
| [Bucket Sort](src/kb/sort/BucketSort.java) | `n` | `n^2` | `n` | yes | integers |
| [Radix Sort](src/kb/sort/RadixSort.java) | `n` | `n` | `n` | no | integers |
