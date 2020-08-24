# Command pattern

The **Command pattern** should be used when:
- 

The purpose of the pattern is to decouple the `Receiver` from the `Invoker`.

- `Receiver` is the object that "knows" how to perform the action. It hold the business logic. of the application.
- `Invoker` is the actual executor of the command. I doesn't know nothing about the `Receiver`.
- The `Command` takes the `Receiver` object: `Command cmd = new SomeCommand(Receiver r)`.
- The `Client` has responsibilities to instantiate the `Command` object and to inject it to the `Invoker`.
