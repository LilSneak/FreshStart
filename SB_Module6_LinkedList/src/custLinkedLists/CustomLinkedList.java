package custLinkedLists;

import java.io.*;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CustomLinkedList {//UPDATED LINES 90, 142, 145
	private Node head;
	
	public void insertion(int data) {
		Node node = new Node(data);//Creating a new node
		
		if(head == null) {//if this is 1st node/ empty list
			head = node;
		}
		else {
			Node n = head;
			while (n.next != null){//iterates through list until the end
				n = n.next;
			}
			n.next = node;//When we are @ end of list then the node with its data will be added.
		}
	}
	
	public void deletion(int item) {
		Node currNode = head;
		Node previous = null;
		
		//if head has the item
		if(currNode != null && currNode.data == item) {
			head = currNode.next;
			
			System.out.println(item + " was found and deleted");
		}
		
		//used to keep iterating through loop until end or item is found
		while(currNode != null && currNode.data != item) {
			 
			previous = currNode;
			currNode = currNode.next;
		}
		
		//if item is in the current node
		if(currNode != null) {
			previous.next = currNode.next;//this unlinks the current node from list
			
			System.out.println(item + " was found and deleted");
		}
		
		//If item isn't found in list the current node will still be null
		if(currNode == null) {
			System.out.println(item + " was not found");
		}
	}
	
	private class Node{//Creates a new node with given data
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	
	public void printList(CustomLinkedList list) {
		
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}
	
	public void fromFile(CustomLinkedList list, File input) throws FileNotFoundException{
		
		Scanner scnr = new Scanner(input);
		int hasInts = 0;
		
		
		while(scnr.hasNextInt()) {
			int num = scnr.nextInt();
			
			list.insertion(num);
			hasInts++;
		}
		
		if(hasInts == 0) {//UPDATED: if the file contains no integers
			System.out.println("\nFile does not contain the appropriate elements to sort. Make sure all elements are an integer");
		}
		
		scnr.close();
	}
	private Iterator<Integer> iterator(){
		return new LinkedListIterator();
		
	}
	
	private class LinkedListIterator implements Iterator<Integer>{
		private Node current = head;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}
		@Override
		public Integer next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			int data = current.data;
			current = current.next;
			return data;
		}
	}
	
	public static void main(String[] args) {
		CustomLinkedList list = new CustomLinkedList();
		
		list.insertion(3);
		list.insertion(32);
		list.insertion(65);
		list.insertion(9);
		list.insertion(8);
		
		System.out.println("Linked List: ");
		list.printList(list);
		
		System.out.println("\nLinked List after deletion of 9: ");
		list.deletion(9);
		list.printList(list);
		
		System.out.println("\nLinked List after deletion of 0: ");
		list.deletion(0);
		list.printList(list);
		
		CustomLinkedList list2 = new CustomLinkedList();
		
		//Opening a file on desktop
		File input = new File("tryOut2.txt");// UPDATED: FIXED the file input
			try {
				list2.fromFile(list2, input);
			} catch (FileNotFoundException e) {//UPDATED: custom error message
				System.out.println("File Not Found. Check that name of file is accurate or that file exist then try again");
				e.printStackTrace();
			}
		System.out.println("\nLinked List from File");
		list2.printList(list2);
	}

	}


