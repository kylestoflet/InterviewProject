//*********************************************************************************************************************************
/*	1	Reverse a single list.

NOTE:	Here are a few example test cases to prove the functionality of ListToKGroups

*///*********************************************************************************************************************************


import static org.junit.Assert.*;

import org.junit.Test;

public class ListToKGroupsTest {
	
	//Test case to make sure a known case is solved as expected
	@Test
	public void testListToKGroups() {
		ListToKGroups test = new ListToKGroups();
		int array[] = {8, 4, 6, 2, 3, 1};
		boolean isPossible = false;
		int n = array.length;
		int k = 2;

		isPossible = test.isKGroupsPossible(array, n, k);
		assertEquals(isPossible, true);

		k = 4;
		isPossible = test.isKGroupsPossible(array, n, k);
		assertEquals(isPossible, false);

	}
	
	//Test case that expects failure if k groups exceeds size of array
	@Test
	public void testTooManyGroups() {
		ListToKGroups test = new ListToKGroups();
		int array[] = {2, 4, 7, 2, 5, 1};
		int n = array.length;
		int k = 2;
		boolean isPossible = false;
		
		k = 7;
		isPossible = test.isKGroupsPossible(array, n, k);
		assertEquals(isPossible, false);
	}
	
	//Test case for a single group that should always be true
	@Test
	public void testSingleGroup() {
		ListToKGroups test = new ListToKGroups();
		int array[] = {8, 4, 6};
		int n = array.length;
		int k = 2;
		boolean isPossible = false;
		
		k = 1;
		isPossible = test.isKGroupsPossible(array, n, k);
		assertEquals(isPossible, true);
	}
}