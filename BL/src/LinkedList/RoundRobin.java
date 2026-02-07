import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
  round robin scheduler using a circular linked list
  each node is a process (pid, burst, priority)
  it simulates fixed time quantum execution and removes finished processes
*/
class RoundRobinScheduler {

    /*
      process node for circular linked list
      stores original burst for final calculations
    */
    private static class ProcessNode {
        int pid;
        int burst;
        int remaining;
        int priority;
        ProcessNode next;

        ProcessNode(int pid, int burst, int priority) {
            this.pid = pid;
            this.burst = burst;
            this.remaining = burst;
            this.priority = priority;
        }
    }

    private ProcessNode tail; // tail.next is head

    // add process at end
    public void addProcess(int pid, int burst, int priority) {
        ProcessNode node = new ProcessNode(pid, burst, priority);

        // empty list case
        if (tail == null) {
            tail = node;
            tail.next = tail;
            return;
        }

        // insert after tail and move tail
        node.next = tail.next;
        tail.next = node;
        tail = node;
    }

    // remove by pid
    public boolean removeProcess(int pid) {
        if (tail == null) return false;

        ProcessNode prev = tail;
        ProcessNode curr = tail.next;

        // single node case
        if (curr == tail && curr.pid == pid) {
            tail = null;
            return true;
        }

        // traverse until we come back to head
        do {
            if (curr.pid == pid) {
                prev.next = curr.next;

                // if removing tail, update tail
                if (curr == tail) tail = prev;

                return true;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != tail.next);

        return false;
    }

    // display queue once in circular manner
    public void displayQueue() {
        if (tail == null) {
            System.out.println("queue is empty");
            return;
        }

        ProcessNode head = tail.next;
        ProcessNode curr = head;

        System.out.print("queue: ");
        do {
            System.out.print("[pid=" + curr.pid + ", rem=" + curr.remaining + ", pr=" + curr.priority + "] ");
            curr = curr.next;
        } while (curr != head);

        System.out.println();
    }

    /*
      simulate round robin with fixed quantum
      assumes all processes arrive at time 0
      calculates turnaround and waiting after completion
    */
    public void simulate(int quantum) {
        if (tail == null) {
            System.out.println("nothing to schedule");
            return;
        }

        // maps for metrics
        Map<Integer, Integer> burstMap = new HashMap<>();
        Map<Integer, Integer> finishTime = new HashMap<>();

        // store original bursts
        ProcessNode head = tail.next;
        ProcessNode t = head;
        do {
            burstMap.put(t.pid, t.burst);
            t = t.next;
        } while (t != head);

        int time = 0;
        ProcessNode prev = tail;
        ProcessNode curr = tail.next;

        System.out.println("\nstarting round robin (quantum = " + quantum + ")\n");

        while (tail != null) {
            // show queue after each round start
            displayQueue();

            // execute current process for min(quantum, remaining)
            int run = Math.min(quantum, curr.remaining);
            curr.remaining -= run;
            time += run;

            System.out.println("ran pid " + curr.pid + " for " + run + " units, time now = " + time);

            // if finished, record completion and remove node
            if (curr.remaining == 0) {
                finishTime.put(curr.pid, time);

                int finishedPid = curr.pid;
                curr = curr.next; // move first, because we are deleting

                // remove finished node using prev pointer style deletion
                if (tail != null) {
                    // if only one node existed
                    if (prev.next == prev && prev.pid == finishedPid) {
                        tail = null;
                        break;
                    }

                    // delete the node which was prev.next if it matches
                    if (prev.next.pid == finishedPid) {
                        ProcessNode del = prev.next;
                        prev.next = del.next;

                        // if deleted was tail, shift tail
                        if (del == tail) tail = prev;
                    } else {
                        // fallback: safe removal (rare if pointers got shifted)
                        removeProcess(finishedPid);
                    }
                }

                System.out.println("pid " + finishedPid + " finished and removed\n");

                // reset curr and prev if list became empty
                if (tail == null) break;

                // if we removed head, ensure curr is correct
                curr = prev.next;
                continue;
            }

            // move to next process
            prev = curr;
            curr = curr.next;

            System.out.println();
        }

        // compute averages
        if (burstMap.isEmpty()) return;

        double totalTurnaround = 0;
        double totalWaiting = 0;
        int n = burstMap.size();

        System.out.println("final results:");
        for (int pid : burstMap.keySet()) {
            int bt = burstMap.get(pid);
            int ct = finishTime.getOrDefault(pid, 0);
            int tat = ct;            // arrival time is 0
            int wt = tat - bt;

            totalTurnaround += tat;
            totalWaiting += wt;

            System.out.println("pid=" + pid + " burst=" + bt + " completion=" + ct + " turnaround=" + tat + " waiting=" + wt);
        }

        System.out.println("\navg turnaround = " + (totalTurnaround / n));
        System.out.println("avg waiting    = " + (totalWaiting / n));
    }
}

/*
  demo runner for uc6
*/
public class RoundRobin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RoundRobinScheduler rr = new RoundRobinScheduler();

        // sample input
        rr.addProcess(101, 10, 1);
        rr.addProcess(102, 5, 2);
        rr.addProcess(103, 8, 3);

        System.out.print("enter time quantum: ");
        int q = sc.nextInt();

        rr.simulate(q);
        sc.close();
    }
}