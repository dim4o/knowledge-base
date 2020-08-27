# Composite pattern
Composite design pattern is a structural pattern which modifies the structure of an object. This pattern is most suitable in cases where you need to work with objects which form a tree like hierarchy.

## When to use
- When application has hierarchical structure and needs generic functionality across the structure.
- When application needs to aggregate data across a hierarchy.
- When application wants to treat composite and individual objects uniformly.

## Real word API examples

The **composite** pattern recognizable by behavioral methods taking an instance of same abstract/interface type into a tree structure - for example the UI component hierarchy.
- `java.awt.Container#add(Component)` (practically all over Swing thus)
- `javax.faces.component.UIComponent#getChildren()` (practically all over JSF UI thus)