class Solution {
    public double separateSquares(int[][] squares) {
        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;
        for (int[] sq : squares) {
            double y = sq[1];
            double l = sq[2];
            low = Math.min(low, y);
            high = Math.max(high, y + l);
        }

        // Binary search
        for (int i = 0; i < 60; i++) {
            double mid = (low + high) / 2.0;

            double above = 0.0;
            double below = 0.0;

            for (int[] sq : squares) {
                double y = sq[1];
                double l = sq[2];
                double top = y + l;

                if (mid <= y) {
                    above += l * l;
                } else if (mid >= top) {
                    below += l * l;
                } else {
                    below += l * (mid - y);
                    above += l * (top - mid);
                }
            }

            if (above > below) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
