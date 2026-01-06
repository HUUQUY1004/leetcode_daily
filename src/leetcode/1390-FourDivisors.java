class Solution {
    public int sumFourDivisors(int[] nums) {
        int res = 0 ;
        for(int n: nums){
            int sum = 1+ n;
            int count = 2;
            for(int i = 2; i <= Math.sqrt(n); i++){
                if(n % i == 0){
                    if(i * i == n){
                        sum += i;
                        count++;
                    } else {
                        sum += i + n / i;
                        count += 2;
                    }
                }
                if(count > 4) break;
            }
            if(count == 4) res += sum;
        }
        return res;
    }
}