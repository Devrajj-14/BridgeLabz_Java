import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerSharedResource {

    private static final int POISON_PILL = -1;

    static class Producer extends Thread {
        private final BlockingQueue<Integer> queue;
        private final int taskCount;

        Producer(BlockingQueue<Integer> queue, int taskCount) {
            super("Producer");
            this.queue = queue;
            this.taskCount = taskCount;
        }

        @Override
        public void run() {
            try {
                for (int i = 1; i <= taskCount; i++) {
                    queue.put(i); // blocks if queue is full (safe coordination)
                    System.out.println("Produced: " + i);
                    // Optional small delay to visualize interleaving
                    // Thread.sleep(50);
                }
                // Signal consumer to stop
                queue.put(POISON_PILL);
                System.out.println("Producer sent stop signal.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Producer interrupted.");
            } catch (Exception e) {
                System.err.println("Producer error: " + e.getMessage());
            }
        }
    }

    static class Consumer extends Thread {
        private final BlockingQueue<Integer> queue;

        Consumer(BlockingQueue<Integer> queue) {
            super("Consumer");
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    int task = queue.take(); // blocks until an item is available
                    if (task == POISON_PILL) {
                        System.out.println("Consumer received stop signal. Exiting.");
                        return;
                    }
                    System.out.println("Consumed: " + task);

                    // Simulate processing
                    // Thread.sleep(80);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Consumer interrupted.");
            } catch (Exception e) {
                System.err.println("Consumer error: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter number of tasks to produce (positive integer): ");
            int taskCount = sc.nextInt();
            if (taskCount <= 0) {
                System.err.println("Invalid task count. Must be > 0.");
                return;
            }

            // Shared resource
            BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

            Producer producer = new Producer(queue, taskCount);
            Consumer consumer = new Consumer(queue);

            producer.start();
            consumer.start();

            producer.join();
            consumer.join();

            System.out.println("Done. Producer and consumer finished safely.");

        } catch (InputMismatchException e) {
            System.err.println("Invalid input. Please enter integers only.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Main thread interrupted.");
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}