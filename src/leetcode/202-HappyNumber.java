class Solution{
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        
        while (n != 1) {
            if (seen.contains(n)) {
                return false;
            }
            seen.add(n);
            n = getNext(n);
        }
        
        return true;
    }
    
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int digit = n % 10;
            totalSum += digit * digit;
            n /= 10;
        }
        return totalSum;
    }
}

//  Solution 2
class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast =n;
        
        do {
            slow = getSum(slow);
            fast = getSum(getSum(fast));
        } while (slow != fast);
        
        return fast == 1;
    }

    private int getSum(int n) {
        int totalSum = 0;
        while (n > 0) {
            int digit = n % 10;
            totalSum += digit * digit;
            n /= 10;
        }
        return totalSum;
    }
}