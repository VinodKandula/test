package com.test;

/**
 * @author vinod
 *
 */
public class MaxSubsetSumFinder {
	
	private static int findNonConsecutiveElementsMaxSum(int... elements) {
	    int maxsofar,currentSum,previousSum;

	    maxsofar = currentSum = previousSum = 0;
	    boolean isFirst = true;
	    for (int i = 0; i < elements.length; i++) {
	    	for (int j=i+2; j<elements.length; j++) {
	    		if (isFirst) {
	    			maxsofar = elements[i] + elements[j];
	    			previousSum =  maxsofar;
	    			isFirst = false;
	    			continue;
	    		} else {
	    			maxsofar =  Math.max(elements[i] + elements[j], previousSum);
	    		}
	    		previousSum = maxsofar;
	    	}
	    }
	    int lastMax = Math.max(elements[elements.length-2],  elements[elements.length-1]);
	    return Math.max(lastMax,maxsofar);        
	}
	
	private static int ofNonConsecutiveElements(int... elements) {
	    int maxsofar,maxi2,maxi1;

	    maxi1 = maxsofar = elements[0];
	    maxi2 = 0;

	    for (int i = 1; i < elements.length; i++) {
	        maxsofar =  Math.max(maxi2 + elements[i], maxi1);
	        maxi2 =  maxi1;
	        maxi1 = maxsofar;
	    }
	    int lastMax = Math.max(elements[elements.length-2],  elements[elements.length-1]);
	    return Math.max(lastMax,maxsofar);        
	}

	public static void main(String args[]) {
		//O(n2)
		//System.out.println(findNonConsecutiveElementsMaxSum(-9, -17, -11, -20, -15, -3, -6650));
		//O(n)
	    System.out.println(ofNonConsecutiveElements(-9, -17, -11, -20, -15, -3, -6650, -1));
	}

}

