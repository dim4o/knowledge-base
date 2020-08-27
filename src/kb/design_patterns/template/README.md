# Template pattern
Define the skeleton of an algorithm in an operation, deferring some steps to subclasses. Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure.

# When to use
- When you want to let clients extend only particular steps of an algorithm, but not the whole algorithm or its structure.
- when you have several classes that contain almost identical algorithms with some minor differences. 

# Real word API examples

Template method is recognizable by behavioral methods which already have a "default" behavior defined by an abstract type.

All non-abstract methods of:
- `java.io.InputStream`
- `java.io.OutputStream`
- `java.io.Reader`
- `java.io.Writer`
All non-abstract methods of:
- `java.util.AbstractList`
- `java.util.AbstractSet`
- `java.util.AbstractMap`

All the doXXX() methods by default sends a HTTP 405 "Method Not Allowed" error to the response. You're free to implement none or any of them:
- `javax.servlet.http.HttpServlet`
