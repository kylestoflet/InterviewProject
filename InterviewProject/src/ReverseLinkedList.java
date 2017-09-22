//*********************************************************************************************************************************
/*	1	Reverse a single list.

Time Complexity:	O(n)
Space Complexity:	O(1)

NOTE:	I included the solution with the given Node class and reverse method.
		I also thought of a Collections API alternative, so I included that for what it's worth.

*///*********************************************************************************************************************************

import java.util.*;

public class ReverseLinkedList {
 
    public static Node head;
 
    public static class Node {
        Node next; //Reference to the next node
      	int value;
 
        Node(int newValue) {
          	next = null;
          	value = newValue;
        }
    }
 
    public static void main(String[] args) {
      	//For the sake of the exercise
      	nodeDemonstration();
      
      	//Using Collections API LinkedList Object, end to end - without defining the Node Object, and reverse method manually
      	collectionsDemonstration();
    }
  
  	public static void nodeDemonstration() {
      	//Create and populate the LinkedList with Nodes
        ReverseLinkedList list = new ReverseLinkedList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        
      	//Print the LinkedList
        System.out.println("LinkedList:");
        list.printLinkedList(head);
        System.out.println(""); //New line
      
      	//Reverse, and print the reversed LinkedList
        head = list.reverse(head);
        System.out.println("Reversed LinkedList:");
        list.printLinkedList(head);
        System.out.println(""); //New line
    }
  
  	public static void collectionsDemonstration() {
      	//Create java.util.LinkedList type Object
      	java.util.LinkedList<Integer> javaLinkedList = new java.util.LinkedList<Integer>();
      	javaLinkedList.add(1);
      	javaLinkedList.add(2);
      	javaLinkedList.add(3);
      	javaLinkedList.add(4);
      
      	//Print the java.util.LinkedList
      	System.out.println("java.util.LinkedList:");
      	System.out.println(javaLinkedList);
      
      	//Reverse, and print the reversed java.util.LinkedList
      	System.out.println("Reversed java.util.LinkedList:");
      	Collections.reverse(javaLinkedList);
      	System.out.println(javaLinkedList);
    }
  
  	//Method to reverse a linked list
    public Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }
 
    //Method to print a LinkedList
    public void printLinkedList(Node node) {
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
    }
}