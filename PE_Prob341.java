package personal_projects;

import java.util.HashMap;
import java.util.Scanner;

public class PE_Prob341 {
	
	/*
	 * Project Euler #341
	 * 
	 * The Golomb's self-describing sequence {G(n)} is the only nondecreasing sequence of natural numbers 
	 * such that n appears exactly G(n) times in the sequence. The values of G(n) for the first few n are

		n	    1	2	3	4	5	6	7	8	9	10	11	12	13	14	15 ...
		G(n) 	1	2	2	3	3	4	4	4	5	5	5	6	6	6	6 ...
		
		You are given that G(103) = 86, G(106) = 6137.
		You are also given that ΣG(n3) = 153506976 for 1 ≤ n < 103.
		Find ΣG(n3) for 1 ≤ n < 106.
	 */
	
	public static long genGolombsSummation(long n) {
		long currentVal = 2;			//value of current G(n) in the loop
		long sum = 3;				//number of indices we have filled 
		long counter = 2;			//value of current n in the loop
		HashMap<Long, Long> map = new HashMap<Long, Long>();	//map counter to the number of indices filled after we encounter it
		map.put(1L, 1L);				//start with counter=1, 1 spot filled
		map.put(2L, 3L);				//counter=2, 3 spots filled
		long i = 2L;					//update when we find every i^3th number for the summation of G(n^3)
		long summation = 1L;			
		while(sum < n) {				//when sum >= n, we have filled n or more indices in mythical series array, no need to go further
			counter++;
			sum += currentVal;
			if(map.get(currentVal) <= counter) {		//if current G(n) fills up to counter indices, update currentVal to get G(n+1)
				currentVal++;
			}
			map.put(counter, sum);	//counter fills up to sum number of indices in the mythical series array 
									//eg. 2 fills up to index 3, 3 fills up to index 5, 4 fills up to 8, etc. 
			if(sum >= (long)Math.pow(i, 3)) {		//if sum is greater than i^3 for i<=n, update i and add counter to summation
				summation += counter;
				i++;
			}
		}
		summation -= counter; //upper limit is exclusive so subtract counter
		return summation;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long summation = genGolombsSummation((long)Math.pow(n, 3));
		System.out.println(summation);
		sc.close();
	}

}
