/********************************
Name: Solomon Lisk
Username: ua110
Problem Set: PS4
Due Date: October 1, 2018
********************************/
public class PS3Problem2 {
	public static int findEvenSum( int[] a, int sum, int i ) {
		while(i>=0) {
			if(a[i]%2==0) {
				sum=sum+a[i];
			}
			i=i-1;
			findEvenSum(a,sum,i);
		}
		
		return sum;
	}
	
	public static int printCalcRecursively( int num, int i ) {
		if(i<=num) {
			System.out.print(num*num*num+" ");
			i++;
			printCalcRecursively(num,i);
		}

		return 0;
}
	
	
	
	public static void main(String[] args) {
		int a[]= {2,4,6,5};
		System.out.println(findEvenSum(a,0,a.length-1));
		System.out.println(printCalcRecursively(3,1));
		
	}


}
