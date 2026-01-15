class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxRow = maxConsecutive(hBars) +1;
        int maxCol = maxConsecutive(vBars) +1;

        int side = Math.min(maxRow, maxCol);
        return side*side;
    }
    public int maxConsecutive(int[] bars){
        if(bars.length ==0) return 0;
        Arrays.sort(bars);
        int max = 1;
        int curr =1;
         for (int i = 1; i < bars.length; i++) {
            if (bars[i] == bars[i - 1] + 1) {
                curr++;
                max = Math.max(max, curr);
            } else {
                curr = 1;
            }
        }
        return max;

    }
}