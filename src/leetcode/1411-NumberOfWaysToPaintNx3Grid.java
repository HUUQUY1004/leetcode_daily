class Solution {
    public int numOfWays(int n) {
        long mod = 1_000_000_007;
        long same = 6; // 121 or 212
        long diff = 6; // 123

        for (int i = 2; i <= n; i++) {
            long newSame = (same * 3 + diff * 2) % mod;
            long newDiff = (same * 2 + diff * 2) % mod;
            same = newSame;
            diff = newDiff;
        }

        return (int) ((same + diff) % mod);
    }
}