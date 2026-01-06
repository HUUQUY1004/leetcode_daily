class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;
    }
}

// Time Complexity: O(n), where n is the length of the input array nums. We traverse the array once.
// Space Complexity: O(1), as we use only a constant amount of extra space.

// Test Cases:
// Example 1: Input: nums = [2,3,1,1,4] Output: true

/* 
 i= 0 => maxReach = 0 + 2 = 2
 i= 1 => maxReach = max(2, 1 + 3) = 4
 i= 2 => maxReach = max(4, 2 + 1) = 4
 i= 3 => maxReach = max(4, 3 + 1) = 4
 true
*/



// Example 2: Input: nums = [3,2,1,0,4] Output: false

/*
 i= 0 => maxReach = 0 + 3 = 3
 i= 1 => maxReach = max(3, 1 + 2) = 3
 i= 2 => maxReach = max(3, 2 + 1) = 4
 i= 3 => maxReach = max(4, 3 + 0) = 4
 false
 */