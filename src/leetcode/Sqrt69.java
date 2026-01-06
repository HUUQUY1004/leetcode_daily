package leetcode;

public class Sqrt69 {
//	Binary Search - O(log n )
	public int mySqrt(int x) {
		if(x <2) return x;
		int left = 1, right = x/2, anwser=0;
		while(left <=right) {
			int mid = (left + right)/2;
			long sq = (long) mid * mid;
			if(sq == x) return mid;
			if(sq < x) {
				anwser = mid;
				left = mid + 1;
			}
			else {
				right = mid -1;
			}
		}
		return anwser;
		
	}
	
//	Newton-Raphson - O(log n)
	public int mySqrt2(int x) {
		if(x <2 ) return x;
		long r = x;
		while(r*r > x) {
			r = (r+ x/r)/2;
			
		}
		return (int) r;
	}

}
