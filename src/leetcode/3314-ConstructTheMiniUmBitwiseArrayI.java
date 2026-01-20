class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            
            if ((num & 1) == 0) {
                ans[i] = -1;
                continue;
            }
            int pos = 0;
            while (((num >> pos) & 1) == 1) {
                pos++;
            }
            ans[i] = num ^ (1 << (pos - 1));
        }
        
        return ans;
    }
}