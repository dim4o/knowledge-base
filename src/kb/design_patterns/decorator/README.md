# Decorator

## When to use
This pattern is based on the Open/Close principal. We use Decorator patetrn when:
- We can't change the existing legacy code
- We want to extend the functionality

## Real word API examples
### Java IO
Java IO is a good example of usage of the **Decorator** pattern:

``` Java
// Source: https://stackoverflow.com/a/6366543/2595579
// First open an inputstream of it:
FileInputStream fis = new FileInputStream("/objects.gz");

// We want speed, so let's buffer it in memory:
BufferedInputStream bis = new BufferedInputStream(fis);

// The file is gzipped, so we need to ungzip it:
GZIPInputStream gis = new GZIPInputStream(bis);

// We need to unserialize those Java objects:
ObjectInputStream ois = new ObjectInputStream(gis);

// Now we can finally use it:
SomeObject someObject = (SomeObject) ois.readObject();

```


or
``` Java
ObjectInputStream ois = new ObjectInputStream(
                new GZIPInputStream(new BufferedInputStream(new FileInputStream("/objects.gz"))));

SomeObject someObject = (SomeObject) ois.readObject();
```
