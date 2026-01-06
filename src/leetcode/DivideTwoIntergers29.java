package leetcode;

public class DivideTwoIntergers29 {
	public int divide(int dividend, int divisor) throws Exception {
		if(divisor == 0) throw new Exception("Divior must different 0 !");
		
		
		return (int)(dividend / divisor);
	        
	}
	public int devideBit(int dividend, int divisor) {
		if(divisor == 0 ) throw new ArithmeticException("Not Zero");
		if(dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}
		
//		Dấu I using XOR
		boolean negative = (dividend < 0) ^ (divisor < 0);
		
		long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        long result = 0;
        
//        Using shift 
		while(a >=b) {
			long temp = b, multiple = 1;
			while(a >= (temp <<1)) {
				temp <<=1;
				multiple <<=1;
			}
			a -= temp;
			result += multiple;
		}
		return negative ? (int) -result : (int) result;
		
	}
	public static void main(String[] args) throws Exception {
		DivideTwoIntergers29 instant = new DivideTwoIntergers29();
		System.out.println(instant.divide(10,3));
		System.out.println(instant.devideBit(7,-3));
	}
}
