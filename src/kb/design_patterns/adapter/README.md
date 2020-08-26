# Adapter pattern
An Adapter pattern acts as a connector between two incompatible interfaces that otherwise cannot be connected directly. An Adapter wraps an existing class with a new interface so that it becomes compatible with the client’s interface.

## When to use
- When our application is not compatible with the interface that our client expecting.
- When we want to reuse legacy code without making any changes in the original code.
- When an outside component provides fascinating functionality that we'd like to reuse, but it's incompatible with our application.

## Real word API examples
- `java.util.Arrays#asList()`
- `java.util.Collections#list()`
- `java.util.Collections#enumeration()`
- `java.io.InputStreamReader(InputStream)` (returns a Reader)
- `java.io.OutputStreamWriter(OutputStream)` (returns a Writer)