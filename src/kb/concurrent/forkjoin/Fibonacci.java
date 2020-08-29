package kb.concurrent.forkjoin;

import java.util.List;
import java.util.concurrent.RecursiveTask;

@SuppressWarnings("serial")
public class Fibonacci extends RecursiveTask<Integer> {
    int n;

    public Fibonacci(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1)
            return 1;

        Fibonacci fn_1 = new Fibonacci(n - 1);
        Fibonacci fn_2 = new Fibonacci(n - 2);
        fn_1.fork();
        fn_2.fork();

        return fn_1.join() + fn_2.join();
    }

    public static void main(String[] args) {
        List<Integer> inputs = List.of(1, 2, 3, 4, 5);

        for (Integer input : inputs)
            System.out.println(String.format("N%s -> %s", input, new Fibonacci(input).compute()));
    }

}
