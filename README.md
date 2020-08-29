# Knowledge Base
1. Data Structures
2. Design Patterns
3. Sorting
3. Java Concurrency

## Data Structures
See the packages    [here](https://github.com/dim4o/knolige-base/tree/master/src/kb/data_structures).
  - **List** - implementations of Java `java.util.List` interface
    - [Array List](src/kb/data_structures/list/MyArrayList.java)
      - [Test](https://github.com/dim4o/knolige-base/tree/master/src/kb/data_structures/list/test)
    - [Singly Linked List](src/kb/data_structures/list/MySinglyLinkedList.java)
      - [Test](https://github.com/dim4o/knolige-base/tree/master/src/kb/data_structures/list/test)

- **Hash Table** - implementations of Java `java.util.Map` and `java.util.Set` interface.
  - [Hash Map](src/kb/data_structures/hashtable/JHashTable.java)
    - [Test](https://github.com/dim4o/knolige-base/tree/master/src/kb/data_structures/hashtable/test)
  - [Hash Set](src/kb/data_structures/hashtable/JHashSet.java)
    - [Test](https://github.com/dim4o/knolige-base/tree/master/src/kb/data_structures/hashtable/test)

- **Tree** - implementations Tree data structure.
  - [Binary Search Tree](src/kb/data_structures/tree/BinarySearchTree.java)
  - [Prefix Tree (Trie)](src/kb/data_structures/tree/PrefixTree.java)

## Design patterns
See the packages [here](https://github.com/dim4o/knolige-base/tree/master/src/kb/design_patterns).
- Creational patterns
  - [Builder](https://github.com/dim4o/knolige-base/tree/master/src/kb/design_patterns/builder)
  - [Factory Method](https://github.com/dim4o/knolige-base/tree/master/src/kb/design_patterns/factory_method)
  - [Singleton](https://github.com/dim4o/knolige-base/tree/master/src/kb/design_patterns/singleton)
  - [Prototype](https://github.com/dim4o/knolige-base/tree/master/src/kb/design_patterns/prototype)

- Structural patterns
  - [Adapter](https://github.com/dim4o/knolige-base/tree/master/src/kb/design_patterns/adapter) (Wrapper, or Translator)
  - [Bridge](https://github.com/dim4o/knolige-base/tree/master/src/kb/design_patterns/bridge)
  - [Composite](https://github.com/dim4o/knolige-base/tree/master/src/kb/design_patterns/composite)
  - [Decorator](https://github.com/dim4o/knolige-base/tree/master/src/kb/design_patterns/decorator)
  - [Facade](https://github.com/dim4o/knolige-base/tree/master/src/kb/design_patterns/facade)

- Behavioral patterns
  - [Command](https://github.com/dim4o/knolige-base/tree/master/src/kb/design_patterns/command)
  - [Observer](https://github.com/dim4o/knolige-base/tree/master/src/kb/design_patterns/observer) (or Publish/Subscribe)
  - [State](https://github.com/dim4o/knolige-base/tree/master/src/kb/design_patterns/state)
  - [Strategy](https://github.com/dim4o/knolige-base/tree/master/src/kb/design_patterns/strategy)
  - [Visitor](https://github.com/dim4o/knolige-base/tree/master/src/kb/design_patterns/visitor)

## Sorting Algorithms
See the packages [here](https://github.com/dim4o/knolige-base/tree/master/src/kb/sort).
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
