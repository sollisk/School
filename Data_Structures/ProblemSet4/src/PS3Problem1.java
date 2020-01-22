/********************************
Name: Solomon Lisk
Username: ua110
Problem Set: PS4
Due Date: October 1, 2018
********************************/
public class PS3Problem1 {
	public static int findGreatestCommonDivisor(int a, int b) {
		if(a<b) {
			int temp=a;
			a=b;
			b=temp;
		}
		int remainder = a%b;
		if(remainder !=0) {

			a=b;
			b=remainder;
			findGreatestCommonDivisor(a,b);
		}
		else if(remainder==0) {
			System.out.println(b);
		}
		return b;
	}
	
	public static void main(String[]args) {
		findGreatestCommonDivisor(17,52);
	}

}
