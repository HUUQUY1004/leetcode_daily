package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets90Part2 {
	public List<List<Integer>> Subsets(int[] nums){
		List<List<Integer>> resluts = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		backtrack(nums, 0, null, resluts);
		return resluts;
		
	}
	public void backtrack(int[] nums , int start, List<Integer> current ,List<List<Integer>> resluts ) {
		resluts.add(new ArrayList<Integer>(current));
		for(int i= start ; i < nums.length ; i++) {
			if (i > start && nums[i] == nums[i - 1]) continue;
			current.add(nums[i]);
			backtrack(nums, i+1, current, resluts);
			current.remove(current.size() -1);
		}
	}

}
