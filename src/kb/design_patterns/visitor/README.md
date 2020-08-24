# Visitor pattern

The **Visitor** is used when:
- we have to perform an operation on a group Objects/Items.
- there are many distinct and unrelated operation/algorithms needed to be performed. **Visitor** pattern allow to create different visitor for each algorithm: `item.accept(visitor1)`, `item.accept(visitor2)`...
- it is not desirable to change the Item structure but is very probable to have a new operation to be added.