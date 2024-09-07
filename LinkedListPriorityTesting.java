/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package priorityqueueTest;

import static org.junit.Assert.*;
import org.junit.Test;
import priorityqueue.LinkedListPriorityQueue;

/**
 * Test class for LinkedListPriorityQueue.
 *
 * @author 2004
 */

public class LinkedListPriorityTesting {

    /**
     * Test of enqueue method in LinkedListPriorityQueue.
     * Ensures that the element is added based on priority.
     */
    @Test
    public void testEnqueue() {
        System.out.println("Testing enqueue...");
        String appointmentName = "Dentist";
        String dateTime = "2024-09-07 09:00 AM";
        String venue = "Clinic";
        int priority = 2;
        LinkedListPriorityQueue instance = new LinkedListPriorityQueue();

        instance.enqueue(appointmentName, dateTime, venue, priority);

        // Dequeue to check if the enqueued node was added at the correct position
        LinkedListPriorityQueue.Node result = instance.dequeue();
        assertNotNull(result);
        assertEquals(appointmentName, result.getAppointmentName());
        assertEquals(dateTime, result.getDateTime());
        assertEquals(venue, result.getVenue());
        assertEquals(priority, result.getPriority());
    }

    /**
     * Test of dequeue method in LinkedListPriorityQueue.
     * Ensures the correct node (highest priority) is dequeued.
     */
    @Test
    public void testDequeue() {
        System.out.println("Testing dequeue...");
        LinkedListPriorityQueue instance = new LinkedListPriorityQueue();
        instance.enqueue("Doctor", "2024-09-06 11:00 AM", "Hospital", 1);
        instance.enqueue("Dentist", "2024-09-07 09:00 AM", "Clinic", 2);

        LinkedListPriorityQueue.Node result = instance.dequeue();

        // Check if the node with the highest priority was dequeued
        assertNotNull(result);
        assertEquals("Doctor", result.getAppointmentName());
        assertEquals("2024-09-06 11:00 AM", result.getDateTime());
        assertEquals("Hospital", result.getVenue());
    }

    /**
     * Test of isEmpty method in LinkedListPriorityQueue.
     * Verifies if the queue correctly identifies when it is empty or not.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("Testing isEmpty...");
        LinkedListPriorityQueue instance = new LinkedListPriorityQueue();
        boolean result = instance.isEmpty();

        // Expecting true since the queue is initially empty
        assertTrue(result);

        // Add an element and check again
        instance.enqueue("Appointment", "2024-09-07 09:00 AM", "Clinic", 2);
        result = instance.isEmpty();

        // Expecting false after adding an element
        assertFalse(result);
    }

    /**
     * Test of size method in LinkedListPriorityQueue.
     * Verifies if the queue correctly tracks its size.
     */
    @Test
    public void testSize() {
        System.out.println("Testing size...");
        LinkedListPriorityQueue instance = new LinkedListPriorityQueue();

        // Initially, the size should be 0
        assertEquals(0, instance.size());

        // Enqueue some elements and check the size
        instance.enqueue("Doctor", "2024-09-06 11:00 AM", "Hospital", 1);
        instance.enqueue("Dentist", "2024-09-07 09:00 AM", "Clinic", 2);

        // After enqueuing two elements, the size should be 2
        assertEquals(2, instance.size());
    }

    /**
     * Test of find method in LinkedListPriorityQueue.
     * Verifies that nodes can be found by appointment name.
     */
    @Test
    public void testFind() {
        System.out.println("Testing find...");
        LinkedListPriorityQueue instance = new LinkedListPriorityQueue();

        // Add nodes
        instance.enqueue("Doctor", "2024-09-06 11:00 AM", "Hospital", 1);
        instance.enqueue("Meeting", "2024-09-06 15:00 PM", "Office", 2);

        // Test finding an existing appointment
        LinkedListPriorityQueue.Node result = instance.find("Doctor");
        assertNotNull(result);
        assertEquals("Doctor", result.getAppointmentName());

        // Test finding a non-existing appointment
        result = instance.find("Date");
        assertNull(result);
    }

    /**
     * Test of deleteLastNode method in LinkedListPriorityQueue.
     * Verifies that the last node is correctly deleted.
     */
    @Test
    public void testDeleteLastNode() {
        System.out.println("Testing deleteLastNode...");
        LinkedListPriorityQueue instance = new LinkedListPriorityQueue();
        instance.enqueue("Doctor", "2024-09-06 11:00 AM", "Hospital", 1);
        instance.enqueue("Meeting", "2024-09-06 15:00 PM", "Office", 2);

        // Delete the last node
        instance.deleteLastNode();

        // Ensure the last node is deleted and the size is updated
        assertEquals(1, instance.size());
        assertNull(instance.find("Meeting"));
    }

    /**
     * Test of deleteNode method in LinkedListPriorityQueue.
     * Verifies that nodes can be deleted by priority.
     */
    @Test
    public void testDeleteNode() {
        System.out.println("Testing deleteNode...");
        LinkedListPriorityQueue instance = new LinkedListPriorityQueue();
        instance.enqueue("Doctor", "2024-09-06 11:00 AM", "Hospital", 1);
        instance.enqueue("Meeting", "2024-09-06 15:00 PM", "Office", 2);

        // Delete the node with priority 1
        instance.deleteNode(1);

        // The node with priority 1 should no longer exist
        assertNull(instance.find("Doctor"));
    }

    /**
     * Test of addNodeToEnd method in LinkedListPriorityQueue.
     * Ensures a node is added at the end of the queue.
     */
    @Test
    public void testAddNodeToEnd() {
        System.out.println("Testing addNodeToEnd...");
        String appointmentName = "Workshop";
        String dateTime = "2024-09-10 10:00 AM";
        String venue = "Conference Room";
        int priority = 3;
        LinkedListPriorityQueue instance = new LinkedListPriorityQueue();

        instance.addNodeToEnd(appointmentName, dateTime, venue, priority);

        // Ensure the node was added at the end
        LinkedListPriorityQueue.Node result = instance.find(appointmentName);
        assertNotNull(result);
        assertEquals(appointmentName, result.getAppointmentName());
    }

    /**
     * Test of printAppointments method in LinkedListPriorityQueue.
     * Ensures the method prints appointments without throwing exceptions.
     */
    @Test
    public void testPrintAppointments() {
        System.out.println("Testing printAppointments...");
        LinkedListPriorityQueue instance = new LinkedListPriorityQueue();

        // Add some appointments
        instance.enqueue("Doctor", "2024-09-06 11:00 AM", "Hospital", 1);
        instance.enqueue("Meeting", "2024-09-06 15:00 PM", "Office", 2);

        // Ensure that printing does not throw exceptions
        instance.printAppointments();
    }
}
