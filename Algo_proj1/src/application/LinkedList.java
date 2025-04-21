package application;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
	// Node class represents each element in the LinkedList
	private class Node {
		T data; // Data of the node
		Node next; // Reference to the next node in the list

		// Constructor to create a new node with data
		Node(T data) {
			this.data = data;
			this.next = null; // Initially, the next node is null
		}
	}

	private Node head; // The head (first element) of the LinkedList
	private int size; // The size of the LinkedList (number of elements)

	// Constructor to create an empty LinkedList
	public LinkedList() {
		head = null; // No elements in the list initially
		size = 0; // List size is 0
	}

	// Method to add a new node at the end of the list
	public void add(T data) {
		Node newNode = new Node(data); // Create a new node with the provided data
		if (head == null) {
			head = newNode; // If the list is empty, the new node becomes the head
		} else {
			Node current = head;
			// Traverse the list to find the last node
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode; // Link the last node to the new node
		}
		size++; // Increase the size of the list
	}

	// Method to remove a node with the specified data
	public void remove(T data) {
		if (head == null) {
			return; // If the list is empty, there’s nothing to remove
		}

		// If the data to remove is at the head node
		if (head.data.equals(data)) {
			head = head.next; // Move the head to the next node
			size--; // Decrease the size of the list
			return;
		}

		Node current = head;
		// Traverse the list to find the node to remove
		while (current.next != null) {
			if (current.next.data.equals(data)) {
				current.next = current.next.next; // Skip the node to remove it
				size--; // Decrease the size of the list
				return;
			}
			current = current.next; // Move to the next node
		}
	}

	// Method to check if a node with the specified data exists in the list
	public boolean contains(T data) {
		Node current = head;
		// Traverse the list to search for the data
		while (current != null) {
			if (current.data.equals(data)) {
				return true; // Return true if data is found
			}
			current = current.next; // Move to the next node
		}
		return false; // Return false if the data was not found
	}

	// Method to print the elements of the list
	public void printList() {
		Node current = head;
		// Traverse the list and print each node's data
		while (current != null) {
			System.out.print(current.data + " -> ");
			current = current.next; // Move to the next node
		}
		System.out.println("null"); // Print "null" to indicate the end of the list
	}

	// Method to get the data of the first node in the list
	public T getFirst() {
		return head != null ? head.data : null; // Return the first node's data, or null if the list is empty
	}

	// Method to check if the list is empty
	public boolean isEmpty() {
		return head == null; // Return true if the list is empty (head is null)
	}

	// Override the iterator method to make the LinkedList iterable
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private Node current = head; // Start from the head of the list

			@Override
			public boolean hasNext() {
				return current != null; // Return true if there is a next node
			}

			@Override
			public T next() {
				if (!hasNext()) {
					throw new java.util.NoSuchElementException("No more elements");
				}
				T data = current.data; // Get the current node's data
				current = current.next; // Move to the next node
				return data; // Return the current node's data
			}
		};
	}

	// Method to get the data of a node at a specific index
	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds"); // Check if the index is valid
		}

		Node current = head;
		// Traverse the list to find the node at the specified index
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.data; // Return the data of the node at the specified index
	}

	// Method to get the size (number of elements) of the list
	public int size() {
		return size; // Return the size of the list
	}

	@Override
	public String toString() {
		String result = ""; // Initialize an empty string to store the result.
		int count = 0; // Counter to track the number of printed elements on the current line.

		for (T data : this) { // Iterate through each element in the collection.
			result += data + "\t"; // Append the current element and a tab space to the result string.

			count++; // Increment the counter for each element printed.

			// If 6 elements have been printed, start a new line.
			if (count == 5) {
				result += "\n"; // Add a new line after 6 elements.
				count = 0; // Reset the counter to 0 for the next line.
			}
		}

		return result; // Return the formatted result string.
	}

}
