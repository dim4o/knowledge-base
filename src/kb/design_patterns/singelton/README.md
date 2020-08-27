# Singleton pattern
**Singleton** pattern restricts the instantiation of a class to one "single" instance.

## When to use
A singleton is used when you do want an actual object (with its own internal state and everything), and you want to limit your system to exactly one instance of that object.

## Real word API examples
Singleton is recognisable by creational methods returning the same instance (usually of itself) everytime.

- `java.lang.Runtime#getRuntime()`
- `java.awt.Desktop#getDesktop()`
- `java.lang.System#getSecurityManager()`