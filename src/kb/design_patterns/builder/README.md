# Bulder pattern

## When to use
We use **Builder** pattern when:
- Too many constructor arguments(i.e. more than three).
- The constructor overloading can lead to incorrect object state.
- We need of flexible API.
- We want to add new parameters to a constructor without producing error-prone and hard to read code.

## Real word API examples

### Java API

```Java
Calendar cal = new Calendar.Builder()
            .setCalendarType("iso8601")
            .setWeekDate(2013, 1, MONDAY)
            .build();
```
```Java
Locale loc = new Builder()
            .setLanguage("sr")
            .setScript("Latn")
            .setRegion("RS")
            .build();
```
