import java.util.Scanner;

public class Elevator {
	
	//https://open.kattis.com/contests/n8n4re/problems/elevatortrouble

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int f = in.nextInt();
		int s = in.nextInt();
		int g = in.nextInt();
		int u = in.nextInt();
		int d = in.nextInt();
		
		int diff = g - s;
		int min = 0;
		if(diff < 0) { //we have to step down
			diff = Math.abs(diff);
			if(d == 0) {		//no way to move down
				min = -1;
			} else {
				int quo = diff/d;
				if(diff % d == 0) {	//perfect number of steps in one direction
					min = diff/d;
				} else if (u == 0) {		//need steps in both directions, but can't make
					min = -1;
				} else {
					int remdown = Math.abs(diff - (quo*d));
					int remup = Math.abs(diff - ((quo+1)*d));
					if(remdown % u == 0 && s - (quo*d) + remdown == g) {
						min = quo + remdown/u;
					} 
					if(remup % u == 0 && s - ((quo+1)*d) + remup == g) {
						if(min > quo+1+(remup/u) || min == 0) {
							min = quo + 1 + remup/u;
						}
					}
					if(min == 0) {
						min = -1;
					}
				}
			}
		} else {			//we have to step up
			if(u == 0) {		//no way to move up
				min = -1;
			} else {
				int quo = diff/u;
				if(diff % u == 0) { 		//perfect number of steps in one direction
					min = diff/u;
				} else if (d == 0) {		//need steps in both directions, but can't make
					min = -1;
				} else {
					int remdown = Math.abs(diff - (quo*u));
					int remup = Math.abs(diff - ((quo+1)*u));
					if(remdown % d == 0 && s + (quo*u) - remdown == g) {
						min = quo + remdown/d;
					}
					if(remup % d == 0 && s + ((quo+1)*u) - remup == g) {
						if(min > quo+1+(remup/d) || min == 0) {
							min = quo + 1 + remup/d;
						}
					}
					if(min == 0) {
						min = -1;
					}
				}
			}
		}
		
		if(s == g) {
			System.out.println("0");
		} else if(min <= 0) {
			System.out.println("use the stairs");
		} else {
			System.out.println(min);
		}
		
		in.close();
	}

}
