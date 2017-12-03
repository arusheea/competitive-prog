package personal_projects;

import java.util.Arrays;
import java.util.Scanner;

public class ChargingBatteries_HR {
	
	//https://www.hackerrank.com/contests/101hack51/challenges/charging-the-batteries/problem
	
	public static int[] calculateDistBW(int[] distances, int m, int n) {
		int[] distBW = new int[m];
        for(int i=0; i<m; i++) {
            if(i==m-1) {
                distBW[i] = (4*n)-distances[i]+distances[0];
            } else {
                distBW[i] = distances[i+1] - distances[i];
            }
        }
        return distBW;
	}
	
	public static int calculateMinTime(int[] distBW, int m, int n, int k) {
		int[] window = new int[k-1];
        int upd = 0;
        int min = 0;
        int tempMin = -1;
        for(int i=0; i<m+k; i++) {
            if(i<window.length) {
                window[i] = distBW[i];
                min += distBW[i];
                upd++;
            }
            if(i>=window.length) {
                if(upd == window.length) {
                    upd = 0;
                }
                if(tempMin == -1)
                    tempMin = min;
                tempMin -= window[upd];
                if(i<m)
                    window[upd] = distBW[i];
                else 
                    window[upd] = distBW[i-m];
                tempMin += window[upd];
                upd++;
                if(tempMin < min)
                    min = tempMin;
            }
        }
        return min;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[] distances = new int[m];
        for(int a0 = 0; a0 < m; a0++){
            int x = in.nextInt();
            int y = in.nextInt();
            if(x==0) {
                distances[a0] = y;
            } else if(y==0) {
                distances[a0] = (4*n)-x;
            } else if(x==n) {
                distances[a0] = (3*n)-y;
            } else if(y==n) {
                distances[a0] = n+x;
            }
        }
        Arrays.sort(distances);
        // Write Your Code Here
        int[] distBW = calculateDistBW(distances, m, n);
        int min = calculateMinTime(distBW, m, n, k);
        System.out.println(min);
        in.close();
	}

}
