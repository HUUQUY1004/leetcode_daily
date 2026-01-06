package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfSequencesThatSatisfyTheGivenSumCondition {
	 public int numSubseq(int[] nums, int target) {
		 Arrays.sort(nums);
		 int n = nums.length;
		 int mod = 1_000_000_007;
		 int[] pow2 = new int[n]; 
		 pow2[0] = 1;
		 for (int i = 1; i < n; i++) {
		     pow2[i] = (pow2[i - 1] * 2) % mod;
		 }
		 int left = 0, right = n - 1;
		 int count = 0;
		 while (left <= right) {
			    if (nums[left] + nums[right] <= target) {
			        count = (count + pow2[right - left]) % mod;
			        left++;
			    } else {
			        right--;
			    }
			}

		 return count;
	 }
    public static void main(String[] args) {
        NumberOfSequencesThatSatisfyTheGivenSumCondition sol = new NumberOfSequencesThatSatisfyTheGivenSumCondition();
        int[] nums = {3, 5, 6, 7};
        int target = 9;
        System.out.println(sol.numSubseq(nums, target)); // Output: 4
    }
		
}
