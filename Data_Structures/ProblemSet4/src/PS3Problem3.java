/********************************
Name: Solomon Lisk
Username: ua110
Problem Set: PS4
Due Date: October 1, 2018
********************************/
public class PS3Problem3 {
	
	public static double calcVariance( int[] a, int n, double variance,double avg,double varianceNum) {
		
		while(n<=a.length-1){
			varianceNum=varianceNum+(a[n]-avg)*(a[n]-avg);
			variance=varianceNum/(a.length-1);
			n++;
			calcVariance(a,n,variance,avg,varianceNum);
		}
		
		return variance;
	}

	
	public static double calcAverage( int[] a, int n,double sum, double avg) {
		while(n<=a.length-1) {
			sum=(sum+a[n]);
			avg= sum/a.length;
			n++;
			calcAverage(a,n,sum,avg);
		}
		
		return avg;
	}
	
	public static void main(String[] args) {
		int a[]= {1,2,3,4,5,6,7,8};
		//n starts at 0 because that is where we START counting at, not the end.
		System.out.println("The variance is " +calcVariance(a,0,0,calcAverage(a,0,0,0),0));
		System.out.println("The average is " +calcAverage(a,0,0,0));
	}
	 


}
