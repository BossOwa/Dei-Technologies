/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package priorityqueue;

/**
 *
 * @author 2004
 */

public class LinkedListPriorityQueueTest {

    public static void main(String[] args) {
        LinkedListPriorityQueue pq = new LinkedListPriorityQueue();

        // Enqueue appointments
        pq.enqueue("Interview", "2024-09-09 10:00 AM", "HR's Office", 3);
        pq.enqueue("Meeting", "2024-09-09 12:00 PM", "Mr Kuna's Office", 1);
        pq.enqueue("Lunch", "2024-09-11 01:00 PM", "Coffee Shop", 4);
        pq.enqueue("Class", "2024-09-12 01:00 PM", "MCS 102", 2);

        // Print all appointments after enqueue
        System.out.println("All Appointments:");
        pq.printAppointments();

        // Print size of the queue
        System.out.println("\nCurrent size of the queue: " + pq.size());

        // Dequeue the highest priority appointment
        System.out.println("\nDequeuing highest priority appointment...");
        LinkedListPriorityQueue.Node dequeued = pq.dequeue();
        if (dequeued != null) {
            System.out.println("Dequeued Appointment: " + dequeued.getAppointmentName());
        }

        // Print the remaining appointments
        System.out.println("\nRemaining Appointments:");
        pq.printAppointments();

        // Print size of the queue after dequeue
        System.out.println("\nCurrent size of the queue: " + pq.size());

        // Add an appointment to the end
        System.out.println("\nAdding an appointment to the end...");
        pq.addNodeToEnd("Book Collection", "2024-09-08 3:00 PM", "Unitech Bookshop", 5);

        // Print all appointments
        System.out.println("\nUpdated Appointments:");
        pq.printAppointments();

        // Print size of the queue after adding an appointment
        System.out.println("\nCurrent size of the queue: " + pq.size());

        // Find a specific appointment
        System.out.println("\nFinding 'Class' appointment...");
        LinkedListPriorityQueue.Node found = pq.find("Class");
        if (found != null) {
            System.out.println("Found Appointment: " + found.getAppointmentName() + ", Priority: " + found.getPriority());
        } else {
            System.out.println("Appointment 'Class' not found.");
        }

        // Delete a node with a specific priority
        System.out.println("\nDeleting node with priority 2 (Class)...");
        pq.deleteNode(2);

        // Print all updated appointments
        System.out.println("\nUpdated Appointments after deleting 'Class':");
        pq.printAppointments();

        // Print size of the queue after deleting a node
        System.out.println("\nCurrent size of the queue: " + pq.size());

        // Delete the last node
        System.out.println("\nDeleting the last node...");
        pq.deleteLastNode();

        // Print all updated appointments
        System.out.println("\nUpdated Appointments after deleting last node:");
        pq.printAppointments();

        // Print size of the queue after deleting the last node
        System.out.println("\nCurrent size of the queue: " + pq.size());
    }
}

