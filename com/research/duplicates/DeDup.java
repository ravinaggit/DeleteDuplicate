package com.research.test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class DeDup {

	public Integer[] deleteDupBruteForceNoOrder(int[] randomIntegers) throws Exception{

		int newLength = randomIntegers.length;
		// find length w/o duplicates:
		for (int i = 1; i < randomIntegers.length; i++) {
			for (int j = 0; j < i; j++) {
				if (randomIntegers[i] == randomIntegers[j]) {   // if duplicate founded then decrease length by 1
					newLength--;
					break;
				}
			}
		}
		Integer[] newArrays = new Integer[newLength]; 
		newArrays[0] = randomIntegers[0];  // 1st element goes to new array
		int inx = 1; 
		for (int i = 1; i < randomIntegers.length; i++) {
			boolean isDup = false;
			for (int j = 0; j < i; j++) {
				if (randomIntegers[i] == (randomIntegers[j]) ) {
					isDup = true;
				}
			}
			if(!isDup)
			{
				newArrays[inx] = randomIntegers[i];
				inx++;
			}
		}

		//Arrays.sort(newArrays);
		for (int i : newArrays) {
			System.out.print(" " + i);
		}
		System.out.println();
		return newArrays;
	}


	public Integer[] deleteDupNoOrder(int[] randomIntegers) throws Exception{

		Set<Integer> resultSet = new HashSet<Integer>();
		for (int i = 0; i < randomIntegers.length; i++) {
			resultSet.add(randomIntegers[i]);
		}
		System.out.println("Unique Value, No Order  : " + resultSet);
		return resultSet.toArray(new Integer[resultSet.size()]);
	}


	public Integer[] deleteDupInsertionOrder(int[] randomIntegers) throws Exception{

		Set<Integer> resultSet = new LinkedHashSet<Integer>();
		for (int i = 0; i < randomIntegers.length; i++) {
			resultSet.add(randomIntegers[i]);
		}
		System.out.println("Unique Value, Insertion Order : " + resultSet);
		return resultSet.toArray(new Integer[resultSet.size()]);
	}


	public static void main(String [] args) {
		
		int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
			20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,
			13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};
		
		try{
			DeDup dD = new DeDup();
			dD.deleteDupBruteForceNoOrder(randomIntegers);
			dD.deleteDupNoOrder(randomIntegers);
			dD.deleteDupInsertionOrder(randomIntegers);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
