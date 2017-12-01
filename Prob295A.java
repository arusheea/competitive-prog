package personal_projects;

import java.util.Scanner;

public class Prob295A {
	
	/*Greg has an array a = a1, a2, ..., an and m operations. 
	 * Each operation looks as: li, ri, di, (1 ≤ li ≤ ri ≤ n). 
	 * To apply operation i to the array means to increase all array 
	 * elements with numbers li, li + 1, ..., ri by value di. 
	 * Greg wrote down k queries on a piece of paper. 
	 * Each query has the following form: xi, yi, (1 ≤ xi ≤ yi ≤ m). 
	 * That means that one should apply operations with numbers xi, xi + 1, ..., yi to the array. 
	 * Now Greg is wondering, what the array a will be after all the queries are executed. Help Greg.
	 * 
	 * Input
	 * The first line contains integers n, m, k (1 ≤ n, m, k ≤ 105). 
	 * The second line contains n integers: a1, a2, ..., an (0 ≤ ai ≤ 105) — the initial array.
	 * Next m lines contain operations, the operation number i is written as three integers: li, ri, di, (1 ≤ li ≤ ri ≤ n), (0 ≤ di ≤ 105).
	 * Next k lines contain the queries, the query number i is written as two integers: xi, yi, (1 ≤ xi ≤ yi ≤ m).
	 * The numbers in the lines are separated by single spaces.
	 * 
	 * Output
	 * On a single line print n integers a1, a2, ..., an — the array after executing all the queries. 
	 * Separate the printed numbers by spaces.*/
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		long[] arr = new long[n+1];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();	//initial array
		}
		int[] l = new int[m+1];
		int[] r = new int[m+1];
		int[] d = new int[m+1];
		for(int i=0; i<m; i++) {
			l[i] = sc.nextInt();
			r[i] = sc.nextInt();
			d[i] = sc.nextInt();
		}
		int[] x = new int[k+1];
		int[] y = new int[k+1];
		for(int i=0; i<k; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		int[] numoccur = new int[m+1];
		for(int i=0; i<k; i++) {
			numoccur[x[i]-1] += 1;
			numoccur[y[i]] -= 1; 
		}
		long[] addition = new long[n+1];
		long a = 0L;
		for(int i=0; i<m; i++) {
			a += numoccur[i];
			long dd = a * d[i];
			addition[l[i]-1] += dd;
			addition[r[i]] -= dd;
		}
		long add = 0L;
		for(int i=0; i<n; i++) {
			add += addition[i];
			arr[i] += add;
			if(i > 0)
				System.out.print(" ");
			System.out.print(arr[i]);
		}
		
		//INITIAL BAD IMPLEMENTATION
		/*int[][] ops = new int[m][3];
		for(int i=0; i<m; i++) {
			ops[i][0] = sc.nextInt();	//li
			ops[i][1] = sc.nextInt();	//ri
			ops[i][2] = sc.nextInt();	//di
		}
		for(int i=0; i<k; i++) {
			int x = sc.nextInt();		//xi
			int y = sc.nextInt();		//yi
			arr = query(arr, ops, x, y);
		}*/
		//printArray(arr);
		
		sc.close();
	}
	
	/*public static long[] query(long[] arr, int[][] ops, int x, int y) {
		for(int i=x-1; i<y; i++) {
			int[] currentOp = ops[i];
			for(int j=currentOp[0]-1; j<currentOp[1]; j++) {
				arr[j] += currentOp[2];
			}
		}
		return arr;
	}
	
	public static void printArray(long[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}*/
	
	}
