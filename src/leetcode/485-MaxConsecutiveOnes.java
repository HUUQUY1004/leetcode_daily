class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int temp = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                temp++;
                count = Math.max(count, temp);
            } else {
                temp = 0;
            }
        }
        return count;
    }
}
