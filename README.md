IT Help Desk Ticketing System

1. Project Description

The IT Help Desk Ticketing System is a console-based Java application that manages technical support requests. It allows users to create tickets, view and search ticket records, and manage the waiting queue for technical assistance.

The system uses ArrayLists to store ticket information, a FIFO queue to manage ticket processing, and two sorting algorithms to organize records.

2. Objectives

Create and display technical support tickets.

Store ticket information using ArrayLists.

Search for tickets using ticket numbers.

Manage waiting tickets using a FIFO queue.

Implement Bubble Sort and Selection Sort manually.

Apply basic input validation.

3. Use Cases and Features

Add Ticket – Records the requester's name and technical concern and assigns a ticket number.

Display All Tickets – Shows all registered tickets.

Search Ticket – Finds a ticket using its ticket number.

Add Existing Ticket to Queue – Adds a registered ticket to the waiting queue if it is not already there.

Peek Next Ticket – Displays the next ticket to be processed without removing it.

Process Next Ticket – Removes the next ticket from the queue and displays its details.

Display Queue – Shows the tickets waiting for processing.

Bubble Sort by Requester Name – Arranges ticket records alphabetically by requester name.

Selection Sort by Concern – Arranges ticket records alphabetically by technical concern.

Exit – Closes the application.

4. Data Structures Used

ArrayList

The system uses three ArrayLists:

ticketNumbers – Stores ticket numbers.

requesterNames – Stores requester names.

concerns – Stores technical concerns.

The lists use matching indexes to keep each ticket's information connected. When records are sorted, the corresponding information is also swapped to maintain accuracy.

Queue

The system uses a Queue<Integer> implemented with LinkedList to manage waiting tickets.

It follows the FIFO (First In, First Out) principle, meaning the first ticket added to the queue is the first ticket processed. The queue supports adding tickets, viewing the next ticket, processing tickets, and displaying the waiting list.

5. Sorting Algorithms

Bubble Sort

Bubble Sort compares neighboring requester names and swaps their records when they are in the wrong alphabetical order. The process repeats until the records are sorted.

Selection Sort

Selection Sort finds the alphabetically smallest technical concern in the unsorted portion of the list and places it in the correct position.

Both algorithms are implemented manually without using Java's built-in sorting methods. They have an average and worst-case time complexity of O(n²).

Sorting changes the order of the displayed ticket records but does not change the order of tickets waiting in the queue.

6. Input Validation

The system includes basic input validation:

Accepts only whole numbers for menu choices and ticket numbers.

Prevents empty requester names and technical concerns.

Displays a message when a ticket cannot be found.

Prevents adding a ticket to the queue if it does not exist or is already waiting.

Displays appropriate messages when the queue is empty.

7. How to Run the Program

Install Java on your computer.

Open the project folder in VS Code.

Open the Terminal.

Compile the program:

javac Main.java

Run the program:

java Main


## 7. Screenshots of the System

### Main Menu

<img width="318" height="254" alt="Screenshot 2026-10-28 at 4 15 02 PM" src="https://github.com/user-attachments/assets/4172711e-958d-4570-be32-da15e2bee0f7" />


### Adding a Ticket

<img width="323" height="93" alt="Screenshot 2026-10-28 at 4 34 03 PM" src="https://github.com/user-attachments/assets/9b941b9e-9b8f-4065-a5b4-75d3073e0a2f" />


### Displaying and Searching Tickets

<img width="353" height="82" alt="Screenshot 2026-10-28 at 4 38 32 PM" src="https://github.com/user-attachments/assets/33f41579-e6a2-440d-b9c1-cc8169297ae6" />


### Bubble Sort 

<img width="350" height="222" alt="Screenshot 2026-10-28 at 4 37 37 PM" src="https://github.com/user-attachments/assets/70617063-bd4e-426f-9bb1-bcfd2c71f992" />

### Selection Sort by Concern
<img width="353" height="82" alt="Screenshot 2026-10-28 at 4 38 32 PM" src="https://github.com/user-attachments/assets/96c289d7-ea0d-46aa-93f5-b60748967c64" />



### Ticket Queue and Processing

<img width="323" height="93" alt="Screenshot 2026-10-28 at 4 34 03 PM" src="https://github.com/user-attachments/assets/446697f5-1d9f-4afe-a671-0f6aa3f15f35" />


## 8. Project Files

- `Main.java` – Java source code.
- `Main.class` – Java source code.
- `README.md` – Project documentation.
- `screenshots/` – Screenshots showing the system's features.

## 9. Conclusion

The IT Help Desk Ticketing System demonstrates how ArrayLists, queues, and sorting algorithms can be used to manage technical support requests. It organizes ticket records, allows users to search for tickets, and processes waiting tickets using the FIFO principle.

