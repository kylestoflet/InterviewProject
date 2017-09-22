//*********************************************************************************************************************************
/*	2	Sum of multidimensional array.

Time complexity:  O(2^n)
Space complexity: O(n)

NOTE:	I couldn't seem to think of a way to solve this without recursion with the provided information.
		I figured I'd put forth my best attempt to show the work that I did do trying to solve this one.
		
		This will not run and provide an output due to the assumed method, mArray, and lengthofDimension
		
		I had the majority of the other questions done well before this one. This definitely took the most effort.

*///*********************************************************************************************************************************

import java.util.ArrayList;
import java.util.List;

class MultidimensionalArray {
	
	List<Integer> indexList = new ArrayList<Integer>();
	int dimensions = 0;
	int iteration = 0;
	Long sum = (long) 0;
	
  //This is a provided function, assume it works
  public static Long getValue(Object... indexOfDimension) {
	  Long value = (long) 0;
      //... 
      return value;
  }
	
  //lengthOfDimension: each dimension's length, assume it is valid: lengthOfDimension[i]>0.
  public Long sum(MultidimensionalArray mArray, int[] lengthOfDimension) { 
	  	dimensions = lengthOfDimension.length;
		loopDimension(mArray, lengthOfDimension);
		return sum;
  }
	
	public void loopDimension(MultidimensionalArray mArray, int[] lengthOfDimension) {
		if (iteration < dimensions) {
			iteration++;
			for(int i = 0; i < lengthOfDimension[iteration-1]; i++) {
				//Store index i
				indexList.add(i);
				loopDimension(mArray, lengthOfDimension);
				if (indexList.size() == dimensions) {
					//Sum
					sum += mArray.getValue(indexList.toArray());
				} else {
					iteration--;
				}
				//Remove last index
				indexList.remove(indexList.size() - 1);
			}
		}
	}
}
