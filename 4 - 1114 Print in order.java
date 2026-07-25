import java.util.concurrent.atomic.AtomicInteger;

class Foo {

    private AtomicInteger step = new AtomicInteger(1);

    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        // Signal that step 1 is done
        step.set(2);
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // Wait until first() finishes
        while (step.get() != 2) {
            // Busy-spin / yield
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        // Signal that step 2 is done
        step.set(3);
    }

    public void third(Runnable printThird) throws InterruptedException {
        // Wait until second() finishes
        while (step.get() != 3) {
            // Busy-spin / yield
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
