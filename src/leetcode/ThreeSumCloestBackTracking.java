package leetcode;

public class ThreeSumCloestBackTracking {
	int closestSum = Integer.MAX_VALUE;
	int minDiff = Integer.MAX_VALUE;
	public int threeSumClosest(int[] nums, int target) {
		backtrack(nums, target, 0, 0, 0);
		return closestSum;
	}
	public void backtrack(int[] nums, int target,int start ,int count, int sum) {
		if(count == 3) {
			 int diff = Math.abs(sum - target);
            if (diff < minDiff) {
                minDiff = diff;
                closestSum = sum;
            }
            return;
		}
		for(int i = start ; i < nums.length ; i++ ) {
			backtrack(nums, target, i+1, count +1, sum + nums[i]);
		}
	}
	public static void main(String[] args) {
		ThreeSumCloestBackTracking threeSums  = new ThreeSumCloestBackTracking();
		int[] nums = {-1, 2, 1, -4};
        int target = 10;
        System.out.println(threeSums.threeSumClosest(nums, target));
        System.out.println("==============");
	}
}
