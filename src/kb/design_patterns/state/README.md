# State pattern
State pattern is one of the behavioral design pattern. State design pattern is used when an Object changes its behavior based on its internal state.

## When to use
Use the State pattern when you have an object that behaves differently depending on its current state, the number of states is enormous, and the state-specific code changes frequently. The pattern suggests that you extract all state-specific code into a set of distinct classes.

## Real word API examples
State pattern is recognizable by behavioral methods which changes its behavior depending on the instance's state which can be controlled externally.

- `javax.faces.lifecycle.LifeCycle#execute()` (controlled by `FacesServlet`, the behavior is dependent on current phase (state) of JSF lifecycle)