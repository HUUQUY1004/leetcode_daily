package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsets78 {
	public static List<List<Integer>>  subsets(int[] nums) {
		List<List<Integer>> resluts = new ArrayList<List<Integer>>();
		backtracking(nums, 0, new ArrayList<Integer>(), resluts);
		return resluts;
	}
	
	public static void backtracking(int[] nums,int start,  List<Integer> current , List<List<Integer>> resluts) {
		resluts.add(new ArrayList<>(current));
		
		for(int i= start; i< nums.length; i++) {
			current.add(nums[i]);
			backtracking(nums, i+1, current, resluts);
			current.remove(current.size() - 1);
		}
	}
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
        List<List<Integer>> res = subsets(nums);

        System.out.println("Tập con của " + Arrays.toString(nums) + " là:");
        for (List<Integer> subset : res) {
            System.out.println(subset);
        }
	}
	
}
