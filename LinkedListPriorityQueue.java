/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package priorityqueue;

/**
 *
 * @author 2004
 */

public class LinkedListPriorityQueue {

    private Node head;
    private int size;

    public LinkedListPriorityQueue() {
        this.head = null;
        this.size = 0;
    }

    // Node class with getter and setter methods
    public static class Node {
        String appointmentName;
        private String dateTime;
        private String venue;
        private int priority;
        private Node next;

        // Constructor
        public Node(String appointmentName, String dateTime, String venue, int priority) {
            this.appointmentName = appointmentName;
            this.dateTime = dateTime;
            this.venue = venue;
            this.priority = priority;
            this.next = null;
        }

        // Getters and Setters
        public String getAppointmentName() {
            return appointmentName;
        }

        public void setAppointmentName(String appointmentName) {
            this.appointmentName = appointmentName;
        }

        public String getDateTime() {
            return dateTime;
        }

        public void setDateTime(String dateTime) {
            this.dateTime = dateTime;
        }

        public String getVenue() {
            return venue;
        }

        public void setVenue(String venue) {
            this.venue = venue;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    // Enqueue method: adds nodes based on priority
    public void enqueue(String appointmentName, String dateTime, String venue, int priority) {
        Node newNode = new Node(appointmentName, dateTime, venue, priority);

        if (head == null || head.getPriority() > priority) {
            newNode.setNext(head);
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null && current.getNext().getPriority() <= priority) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
        size++;
    }

    // Dequeue method: removes and returns the highest-priority node
    public Node dequeue() {
        if (head == null) {
            return null;
        }
        Node temp = head;
        head = head.getNext();
        size--;
        return temp;
    }

    // Checks if the queue is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Returns the current size of the queue
    public int size() {
        return size;
    }

    // Find a node by appointment name
    public Node find(String appointmentName) {
        Node current = head;
        while (current != null) {
            if (current.getAppointmentName().equals(appointmentName)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    // Delete the last node in the list
    public void deleteLastNode() {
        if (head == null) {
            return;
        }

        if (head.getNext() == null) {
            head = null;
        } else {
            Node current = head;
            while (current.getNext().getNext() != null) {
                current = current.getNext();
            }
            current.setNext(null);
        }
        size--;
    }

    // Delete a node by its priority
    public void deleteNode(int priority) {
        if (head == null) {
            return;
        }

        if (head.getPriority() == priority) {
            head = head.getNext();
            size--;
            return;
        }

        Node current = head;
        while (current.getNext() != null) {
            if (current.getNext().getPriority() == priority) {
                current.setNext(current.getNext().getNext());
                size--;
                return;
            }
            current = current.getNext();
        }
    }

    // Add a node to the end of the queue
    public void addNodeToEnd(String appointmentName, String dateTime, String venue, int priority) {
        Node newNode = new Node(appointmentName, dateTime, venue, priority);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    // Print all the appointments in the queue
    public void printAppointments() {
        if (head == null) {
            System.out.println("No appointments scheduled.");
        } else {
            Node current = head;
            while (current != null) {
                System.out.println("Appointment: " + current.getAppointmentName() + 
                                   ", DateTime: " + current.getDateTime() + 
                                   ", Venue: " + current.getVenue() + 
                                   ", Priority: " + current.getPriority());
                current = current.getNext();
            }
        }
    }
}
