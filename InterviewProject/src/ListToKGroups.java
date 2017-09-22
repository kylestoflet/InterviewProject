//*********************************************************************************************************************************
/* 3	Given a list of numbers, separate them in to k groups such that each group has the same sum.

Time complexity:  O(2^n)
Space complexity: O(n)

*///*********************************************************************************************************************************

public class ListToKGroups {
	
	public static void main(String[] args) {
		//Initialize test array
		int array[] = {4, 2, 5, 3, 1, 1};
		int n = array.length;
		int k = 2;
		
      	//k = 2 is Possible - (4, 2, 1, 1) = 8 and (5,3) = 8
		if (isKGroupsPossible(array, n, k)) {
			System.out.println("Separation in to " + k + " groups is possible!");
		} else {
			System.out.println("Separation in to " + k + " groups is NOT possible!");
		}
		
      	//k = 3 is NOT possible
		k = 3;
		
		if (isKGroupsPossible(array, n, k)) {
			System.out.println("Separation in to " + k + " groups is possible!");
		} else {
			System.out.println("Separation in to " + k + " groups is NOT possible!");
		}
	}

	public static boolean isKGroupsPossible(int array[], int n, int k) {
		//If k is 1, the whole array is the only group
		if (k ==1) {
			return true;
		}
		
		//Can't split into more groups than existing items
		if (n < k) {
			return false;
		}
		
		//If we can't divide the sum by k, we can't divide into k groups
		int sum = 0;
		
		for (int i = 0; i < n; i++) {
			sum += array[i];
		}
		
		if (sum % k !=0) {
			return false; 
		}
		
		//Each subset will be sum / k
		int subset = sum / k;
		int subsetSum[] = new int[k];
		boolean used[] = new boolean[n];
		
		//Initialize each subset
		for (int i = 0; i < k; i++) {
			subsetSum[i] = 0; 
		}
		
		//Initialize items that aren't yet used in a subset
		for (int i = 0; i < n; i++) {
			used[i] = false;
		}
		
		//Initialize subset sum as the last element of our array and mark as used
		subsetSum[0] = array[n - 1];
		used[n - 1] = true;
		
		//Recursion to check k substitution
		return isKGroupsPossibleRecursive(subset, k, n, 0, n - 1, array, subsetSum, used);
    }

	public static boolean isKGroupsPossibleRecursive(int subset, int k, int n, int index, int limit, int array[], int subsetSum[], boolean used[]) {
		
		if (subsetSum[index] == subset) {
			//Index k - 2 represents k - 1 subsets of equal sum, last group will have sum = subset
			if (index == k - 2) {
				return true;
            }
			//Recursion
          	return isKGroupsPossibleRecursive(subset, k, n, index + 1, n-1, array, subsetSum, used);
        }
		
		for (int i = limit; i >= 0; i--) {
			//If used, continue
			if (used[i]) {
				continue;
			}
			
			//If temp < subset, include the item and call recursive method
			int temp = subsetSum[index] + array[i];
			
			if (temp <= subset) {
				//Mark as used, include in current group sum
				used[i] = true;
				subsetSum[index] += array[i];
				boolean next = isKGroupsPossibleRecursive(subset, k, n, index, i-1, array, subsetSum, used);
				//Mark as not used, remove from current group sum
				used[i] = false;
				subsetSum[index] -= array[i];
				if (next) {
					return true;
				}
			}
		}
		return false;
	}
}