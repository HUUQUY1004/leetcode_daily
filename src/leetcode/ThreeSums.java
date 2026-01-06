package leetcode;

import java.util.Arrays;

public class ThreeSums {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int n = nums.length;
		int closestSum = 0 ;
		for(int i=0; i < 3; i++) {
			closestSum += nums[i];
		}
		for(int i = 0 ; i < n-2 ; i++) {
			int left = i + 1;
            int right = n - 1;
            while(left < right) {
            	 int currentSum = nums[i] + nums[left] + nums[right];
            	 if (currentSum == target) {
                     return currentSum;
                 }
            	 if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                     closestSum = currentSum;
                 }
            	 if (currentSum < target) {
                     left++;
                 } else {
                     right--;
                 }
            }
		}
		return closestSum;
	}
	public static void main(String[] args) {
		ThreeSums threeSums  = new ThreeSums();
		int[] nums = {-1, 2, 1, -4};
        int target = 10;
        System.out.println(threeSums.threeSumClosest(nums, target));
        System.out.println("==============");
	}
}

