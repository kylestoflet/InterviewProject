import static org.junit.Assert.*;
import org.junit.Test;

public class ReverseLinkedListTest {

	@Test
	public void testLinkedListOutput() {
      	ReverseLinkedList list = new ReverseLinkedList();
        list.head = new ReverseLinkedList.Node(3);
        list.head.next = new ReverseLinkedList.Node(5);
        list.head.next.next = new ReverseLinkedList.Node(6);
        list.head.next.next.next = new ReverseLinkedList.Node(2);
        list.head.next.next.next.next = new ReverseLinkedList.Node(1);
        
      	//Reverse, and print the reversed LinkedList
        list.head = list.reverse(list.head);
        
        //Manually construct a list that mocks the list above, but reversed
      	ReverseLinkedList reversedList = new ReverseLinkedList();
      	reversedList.head = new ReverseLinkedList.Node(1);
      	reversedList.head.next = new ReverseLinkedList.Node(2);
      	reversedList.head.next.next = new ReverseLinkedList.Node(6);
      	reversedList.head.next.next.next = new ReverseLinkedList.Node(5);
      	reversedList.head.next.next.next.next = new ReverseLinkedList.Node(3);
      	
      	//Make sure each Node element is the same
        assertEquals(list.head, reversedList.head);
        assertEquals(list.head.next, reversedList.head.next);
        assertEquals(list.head.next.next, reversedList.head.next.next);
        assertEquals(list.head.next.next.next, reversedList.head.next.next.next);
        assertEquals(list.head.next.next.next.next, reversedList.head.next.next.next.next);
	}
}