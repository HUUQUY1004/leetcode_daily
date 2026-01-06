package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		
		List<List<Integer>> results = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        
        for(int i = 0;i < nums.length -3; i++) {
        	if( i> 0 && nums[i] == nums[i- 1]) continue;
        	for(int j = i+1; j< nums.length ; j++) {
        		if (j > i + 1 && nums[j] == nums[j - 1]) continue;
        		
        		int left = j +1; 
        		int right =  nums.length -1;
        		while(left < right) {
        			int sum = nums[i] + nums[j] + nums[left] + nums[right];
        			if (sum == target) {
                        results.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
        		}
        	}
        }
        
        return results;
    }
	public static void main(String[] args) {
		int[] nums = {1,0,-1,0,-2,2};
		int[] nums1 = {2,2,2,2,2};
		int target = 0;
		System.out.println(fourSum(nums1, 8));
	}
}
