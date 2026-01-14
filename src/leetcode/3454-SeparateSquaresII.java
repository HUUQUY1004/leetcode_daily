import java.util.*;

class Solution {

    static class Event {
        double x;
        double y1, y2;
        int type; // +1 add, -1 remove

        Event(double x, double y1, double y2, int type) {
            this.x = x;
            this.y1 = y1;
            this.y2 = y2;
            this.type = type;
        }
    }

    public double separateSquares(int[][] squares) {
        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;

        for (int[] s : squares) {
            low = Math.min(low, s[1]);
            high = Math.max(high, s[1] + s[2]);
        }

        // Binary search
        for (int i = 0; i < 60; i++) {
            double mid = (low + high) / 2.0;

            List<double[]> belowRects = new ArrayList<>();
            List<double[]> aboveRects = new ArrayList<>();

            for (int[] s : squares) {
                double x = s[0];
                double y = s[1];
                double l = s[2];
                double top = y + l;

                if (mid > y) {
                    double h = Math.min(mid, top) - y;
                    if (h > 0) {
                        belowRects.add(new double[]{x, x + l, y, y + h});
                    }
                }

                if (mid < top) {
                    double h = top - Math.max(mid, y);
                    if (h > 0) {
                        aboveRects.add(new double[]{x, x + l, top - h, top});
                    }
                }
            }

            double belowArea = unionArea(belowRects);
            double aboveArea = unionArea(aboveRects);

            if (belowArea < aboveArea) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }

    // Sweep line to compute UNION AREA of rectangles
    private double unionArea(List<double[]> rects) {
        List<Event> events = new ArrayList<>();

        for (double[] r : rects) {
            events.add(new Event(r[0], r[2], r[3], +1));
            events.add(new Event(r[1], r[2], r[3], -1));
        }

        events.sort(Comparator.comparingDouble(e -> e.x));

        TreeMap<Double, Integer> active = new TreeMap<>();
        double area = 0.0;

        for (int i = 0; i < events.size() - 1; i++) {
            Event e = events.get(i);

            active.put(e.y1, active.getOrDefault(e.y1, 0) + e.type);
            active.put(e.y2, active.getOrDefault(e.y2, 0) - e.type);

            double width = events.get(i + 1).x - e.x;
            if (width == 0) continue;

            double coveredY = 0.0;
            int count = 0;
            double prevY = 0;

            for (Map.Entry<Double, Integer> entry : active.entrySet()) {
                double y = entry.getKey();
                if (count > 0) {
                    coveredY += y - prevY;
                }
                count += entry.getValue();
                prevY = y;
            }

            area += coveredY * width;
        }

        return area;
    }
}
