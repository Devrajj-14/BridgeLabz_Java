import java.util.InputMismatchException;
import java.util.Scanner;

public class SimpleThreadedCounter {

    // Shared coordinator that enforces strict 1..limit printing order
    static class CounterCoordinator {
        private int current = 1;
        private final int limit;

        CounterCoordinator(int limit) {
            this.limit = limit;
        }

        // Each thread prints only numbers in its assigned [start..end],
        // but must still wait until "current" matches the next number to print.
        public void printRangeInOrder(int start, int end, String threadName) throws InterruptedException {
            while (true) {
                synchronized (this) {
                    // Stop condition: all counting done
                    if (current > limit) {
                        notifyAll();
                        return;
                    }

                    // If current is outside this thread's range, it should just wait.
                    // Another thread will print current.
                    if (current < start || current > end) {
                        wait();
                        continue;
                    }

                    // Now current is within this thread's range => this thread prints it
                    System.out.println(threadName + " prints " + current);
                    current++;

                    // Wake everyone so the next "owner thread" can print next number
                    notifyAll();
                }
            }
        }
    }

    static class CountingWorker extends Thread {
        private final int start;
        private final int end;
        private final CounterCoordinator coordinator;

        CountingWorker(String name, int start, int end, CounterCoordinator coordinator) {
            super(name);
            this.start = start;
            this.end = end;
            this.coordinator = coordinator;
        }

        @Override
        public void run() {
            try {
                coordinator.printRangeInOrder(start, end, getName());
            } catch (InterruptedException e) {
                // Basic error handling: restore interrupt status
                Thread.currentThread().interrupt();
                System.err.println(getName() + " interrupted: " + e.getMessage());
            } catch (Exception e) {
                System.err.println(getName() + " error: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter counting limit (positive integer): ");
            int limit = sc.nextInt();
            if (limit <= 0) {
                System.err.println("Invalid limit. Must be > 0.");
                return;
            }

            System.out.print("Enter number of threads (1..64): ");
            int threads = sc.nextInt();
            if (threads <= 0 || threads > 64) {
                System.err.println("Invalid thread count. Must be between 1 and 64.");
                return;
            }

            // If more threads than numbers, cap threads to limit
            threads = Math.min(threads, limit);

            CounterCoordinator coordinator = new CounterCoordinator(limit);

            // Divide work into nearly equal chunks
            CountingWorker[] workers = new CountingWorker[threads];
            int baseChunk = limit / threads;
            int remainder = limit % threads;

            int start = 1;
            for (int i = 0; i < threads; i++) {
                int chunkSize = baseChunk + (i < remainder ? 1 : 0);
                int end = start + chunkSize - 1;

                workers[i] = new CountingWorker("T" + (i + 1), start, end, coordinator);
                start = end + 1;
            }

            // Start threads
            for (CountingWorker w : workers) w.start();

            // Wait for completion
            for (CountingWorker w : workers) w.join();

            System.out.println("Done. Counted from 1 to " + limit + " in correct order.");

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