package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        // Các phần tử giống nhau sẽ cạnh nhau -> có lợi cho cách xử lí ở dưới
        // giảm độ phức tạp từ O(n^3) -> O(n^2)
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // Bỏ qua các phần tử trùng nhau
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int total = nums[i] + nums[left] + nums[right];
                if (total == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // Bỏ qua phần tử trùng ở bên trái
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Bỏ qua phần tử trùng ở bên phải
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (total < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
	public static void main(String[] args) {
		int[] nums  = {-1,0,1,2,-1,-4};
		int[] nums1  = {0,1,1};
		
		ThreeSum t = new ThreeSum();
		System.out.println(t.threeSum(nums).toString());
	}

}
