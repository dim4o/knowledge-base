# Facade pattern

Facade pattern hides the complexities of the system and provides an interface to the client using which the client can access the system.

![Facade UML Diagram](uml_diagram.jpg)

## Real world API examples

Facade is recognizable by behavioral methods which internally uses instances of different independent abstract/interface types.

- `javax.faces.context.FacesContext`, it internally uses among others the abstract/interface types `LifeCycle`, `ViewHandler`, `NavigationHandler` and many more without that the enduser has to worry about it (which are however overridable by injection).
- `javax.faces.context.ExternalContext`, which internally uses `ServletContext`, `HttpSession`, `HttpServletRequest`, `HttpServletResponse`, etc.  