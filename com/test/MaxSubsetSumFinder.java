package com.test;

/**
 * @author vinod
 *
 */
public class MaxSubsetSumFinder {
	
	private static int ofNonConsecutiveElements (int... elements) {
	    int maxsofar,maxi2,maxi1;

	    maxi1 = maxsofar = elements[0];
	    maxi2 = 0;

	    for (int i = 1; i < elements.length; i++) {
	        maxsofar =  Math.max(maxi2 + elements[i], maxi1);
	        maxi2 =  maxi1;
	        maxi1 = maxsofar;
	    }
	    return maxsofar;        
	}

	public static void main(String args[]) {
	    System.out.println(ofNonConsecutiveElements(9, 17, 11, 20, 15, 3));
	}

}

