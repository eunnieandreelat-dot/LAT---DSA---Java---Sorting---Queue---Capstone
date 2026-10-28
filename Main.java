
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static ArrayList<Integer> ticketNumbers = new ArrayList<>();
    static ArrayList<String> requesterNames = new ArrayList<>();
    static ArrayList<String> concerns = new ArrayList<>();

    static Queue<Integer> ticketQueue = new LinkedList<>();
    static int nextTicketNumber = 1001;

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== IT HELP DESK TICKETING SYSTEM =====");
            System.out.println("1. Add Ticket");
            System.out.println("2. Display All Tickets");
            System.out.println("3. Search Ticket");
            System.out.println("4. Add Existing Ticket to Queue");
            System.out.println("5. Peek Next Ticket");
            System.out.println("6. Process Next Ticket");
            System.out.println("7. Display Queue");
            System.out.println("8. Bubble Sort by Requester Name");
            System.out.println("9. Selection Sort by Concern");
            System.out.println("0. Exit");

            choice = readInt("Enter choice: ");

            switch (choice) {
                case 1:
                    addTicket();
                    break;
                case 2:
                    displayTickets();
                    break;
                case 3:
                    searchTicket();
                    break;
                case 4:
                    enqueueTicket();
                    break;
                case 5:
                    peekTicket();
                    break;
                case 6:
                    processTicket();
                    break;
                case 7:
                    displayQueue();
                    break;
                case 8:
                    bubbleSortByName();
                    break;
                case 9:
                    selectionSortByConcern();
                    break;
                case 0:
                    System.out.println("Thank you for using the system!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        sc.close();
    }

    static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a whole number.");
            }
        }
    }

    static String readText(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("Input cannot be empty.");
        }
    }

    static void addTicket() {
        int number = nextTicketNumber++;
        String name = readText("Enter requester name: ");
        String concern = readText("Enter technical concern: ");

        ticketNumbers.add(number);
        requesterNames.add(name);
        concerns.add(concern);
        ticketQueue.offer(number);

        System.out.println("Ticket created successfully!");
        System.out.println("Ticket Number: " + number);
        System.out.println("Ticket added to the waiting queue.");
    }

    static void displayTickets() {
        if (ticketNumbers.isEmpty()) {
            System.out.println("No tickets have been registered.");
            return;
        }

        System.out.println("\n--- ALL TICKETS ---");
        for (int i = 0; i < ticketNumbers.size(); i++) {
            printTicket(i);
        }
    }

    static void printTicket(int i) {
        System.out.println(
            "Ticket #" + ticketNumbers.get(i)
            + " | Requester: " + requesterNames.get(i)
            + " | Concern: " + concerns.get(i)
        );
    }

    static int findTicketIndex(int number) {
        for (int i = 0; i < ticketNumbers.size(); i++) {
            if (ticketNumbers.get(i) == number) {
                return i;
            }
        }
        return -1;
    }

    static void searchTicket() {
        int number = readInt("Enter ticket number: ");
        int index = findTicketIndex(number);

        if (index == -1) {
            System.out.println("Ticket not found.");
        } else {
            System.out.println("Ticket found:");
            printTicket(index);
        }
    }

    static void enqueueTicket() {
        int number = readInt("Enter ticket number to enqueue: ");

        if (findTicketIndex(number) == -1) {
            System.out.println("Ticket does not exist.");
        } else if (ticketQueue.contains(number)) {
            System.out.println("Ticket is already in the queue.");
        } else {
            ticketQueue.offer(number);
            System.out.println("Ticket added to the queue.");
        }
    }

    static void peekTicket() {
        Integer number = ticketQueue.peek();

        if (number == null) {
            System.out.println("The queue is empty.");
            return;
        }

        System.out.println("Next ticket to process: " + number);
        int index = findTicketIndex(number);

        if (index != -1) {
            printTicket(index);
        }
    }

    static void processTicket() {
        Integer number = ticketQueue.poll();

        if (number == null) {
            System.out.println("No tickets are waiting to be processed.");
            return;
        }

        System.out.println("Processing ticket #" + number);
        int index = findTicketIndex(number);

        if (index != -1) {
            printTicket(index);
        }

        System.out.println("Ticket processed successfully.");
    }

    static void displayQueue() {
        if (ticketQueue.isEmpty()) {
            System.out.println("The queue is empty.");
            return;
        }

        System.out.println("\n--- WAITING QUEUE (FIFO) ---");
        for (Integer number : ticketQueue) {
            int index = findTicketIndex(number);

            if (index != -1) {
                printTicket(index);
            }
        }
    }

    static void bubbleSortByName() {
        if (requesterNames.isEmpty()) {
            System.out.println("No tickets available to sort.");
            return;
        }

        System.out.println("\nBefore Bubble Sort:");
        displayTickets();

        int n = requesterNames.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (requesterNames.get(j).compareToIgnoreCase(
                        requesterNames.get(j + 1)) > 0) {
                    swapRecords(j, j + 1);
                }
            }
        }

        System.out.println("\nAfter Bubble Sort (Requester Name):");
        displayTickets();
    }

    static void selectionSortByConcern() {
        if (concerns.isEmpty()) {
            System.out.println("No tickets available to sort.");
            return;
        }

        System.out.println("\nBefore Selection Sort:");
        displayTickets();

        int n = concerns.size();

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (concerns.get(j).compareToIgnoreCase(
                        concerns.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                swapRecords(i, minIndex);
            }
        }

        System.out.println("\nAfter Selection Sort (Concern):");
        displayTickets();
    }

    static void swapRecords(int a, int b) {
        int tempNumber = ticketNumbers.get(a);
        ticketNumbers.set(a, ticketNumbers.get(b));
        ticketNumbers.set(b, tempNumber);

        String tempName = requesterNames.get(a);
        requesterNames.set(a, requesterNames.get(b));
        requesterNames.set(b, tempName);

        String tempConcern = concerns.get(a);
        concerns.set(a, concerns.get(b));
        concerns.set(b, tempConcern);
    }
}

