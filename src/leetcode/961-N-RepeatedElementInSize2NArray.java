//  Solution 1
class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length;
        boolean[] seen = new boolean[10000 + 1];

        for (int num : nums) {
            if (seen[num]) {
                return num;
            }
            seen[num] = true;
        }

        return -1;
    }
}
//  Solution 2
class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }

        return -1;
    }
}
//  Solution 3
class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }

        return -1;
    }
}
