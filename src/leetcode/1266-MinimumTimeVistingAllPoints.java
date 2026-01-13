class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int totalTime = 0;
        for (int i = 1; i < points.length -1; i++) {
            int deltaX = Math.abs(points[i][0] - points[i - 1][0]);
            int deltaY = Math.abs(points[i][1] - points[i - 1][1]);
            totalTime += Math.max(deltaX, deltaY);
        }
        return totalTime;
    }
}