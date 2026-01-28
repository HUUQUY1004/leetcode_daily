class Solution{
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int maxPairSum = 0;

        while (left < right) {
            int pairSum = nums[left] + nums[right];
            maxPairSum = Math.max(maxPairSum, pairSum);
            left++;
            right--;
        }

        return maxPairSum;
    }
}