package LinkedList;

import java.time.LocalDateTime;

/*
  ticket reservation system using circular linked list
  each node stores ticket info and list loops back to head
*/
class TicketReservationSystem {

    /*
      ticket node for circular linked list
    */
    private static class TicketNode {
        int ticketId;
        String customerName;
        String movieName;
        String seatNumber;
        LocalDateTime bookingTime;
        TicketNode next;

        TicketNode(int ticketId, String customerName, String movieName, String seatNumber) {
            this.ticketId = ticketId;
            this.customerName = customerName;
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.bookingTime = LocalDateTime.now();
        }
    }

    private TicketNode tail; // tail.next is head

    // add ticket at end
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber) {
        TicketNode node = new TicketNode(ticketId, customerName, movieName, seatNumber);

        // empty case
        if (tail == null) {
            tail = node;
            tail.next = tail;
            return;
        }

        // insert after tail
        node.next = tail.next;
        tail.next = node;
        tail = node;
    }

    // remove by ticket id
    public boolean removeTicket(int ticketId) {
        if (tail == null) return false;

        TicketNode prev = tail;
        TicketNode curr = tail.next;

        // single node case
        if (curr == tail && curr.ticketId == ticketId) {
            tail = null;
            return true;
        }

        // traverse circle
        do {
            if (curr.ticketId == ticketId) {
                prev.next = curr.next;

                // update tail if needed
                if (curr == tail) tail = prev;

                return true;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != tail.next);

        return false;
    }

    // display all tickets
    public void displayTickets() {
        if (tail == null) {
            System.out.println("no tickets booked");
            return;
        }

        TicketNode head = tail.next;
        TicketNode curr = head;

        System.out.println("current tickets:");
        do {
            System.out.println(
                    "ticketId=" + curr.ticketId +
                            ", customer=" + curr.customerName +
                            ", movie=" + curr.movieName +
                            ", seat=" + curr.seatNumber +
                            ", time=" + curr.bookingTime
            );
            curr = curr.next;
        } while (curr != head);
    }

    // search by customer name or movie name
    public void search(String keyword) {
        if (tail == null) {
            System.out.println("no tickets to search");
            return;
        }

        String key = keyword.toLowerCase();
        TicketNode head = tail.next;
        TicketNode curr = head;

        boolean found = false;

        do {
            boolean matchCustomer = curr.customerName.toLowerCase().contains(key);
            boolean matchMovie = curr.movieName.toLowerCase().contains(key);

            if (matchCustomer || matchMovie) {
                found = true;
                System.out.println(
                        "found: ticketId=" + curr.ticketId +
                                ", customer=" + curr.customerName +
                                ", movie=" + curr.movieName +
                                ", seat=" + curr.seatNumber
                );
            }

            curr = curr.next;
        } while (curr != head);

        if (!found) System.out.println("no match found for: " + keyword);
    }

    // total count
    public int totalTickets() {
        if (tail == null) return 0;

        int count = 0;
        TicketNode head = tail.next;
        TicketNode curr = head;

        do {
            count++;
            curr = curr.next;
        } while (curr != head);

        return count;
    }
}

/*
  demo runner for uc9
*/
public class TicketReservation{
    public static void main(String[] args) {
        TicketReservationSystem trs = new TicketReservationSystem();

        trs.addTicket(1, "dev", "interstellar", "A1");
        trs.addTicket(2, "raj", "interstellar", "A2");
        trs.addTicket(3, "maya", "inception", "B5");

        trs.displayTickets();
        System.out.println("total tickets: " + trs.totalTickets());

        trs.search("interstellar");
        trs.removeTicket(2);

        System.out.println();
        trs.displayTickets();
        System.out.println("total tickets: " + trs.totalTickets());
    }
}