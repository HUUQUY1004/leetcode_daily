//  O(n^2)
class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        int sum = 0;
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            sum = Math.max(sum, events[i][2]);
        }
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = i + 1; j < n; j++) {
                if (events[j][0] < events[i][1] + 1) {
                    continue;
                }

                int current = events[i][2] + events[j][2];
                max = Math.max(max, current);
            }
            sum = Math.max(sum, max);
        }

        return sum;
    }
}
//  O(n log n)
class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int[] maxFromRight = new int[n];
        maxFromRight[n - 1] = events[n - 1][2];
        for (int i = n - 2; i >= 0; i--) {
            maxFromRight[i] = Math.max(
                maxFromRight[i + 1],
                events[i][2]
            );
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, events[i][2]);

            int nextIndex = findNextEvent(events, events[i][1] + 1);
            if (nextIndex < n) {
                ans = Math.max(
                    ans,
                    events[i][2] + maxFromRight[nextIndex]
                );
            }
        }

        return ans;
    }
    private int findNextEvent(int[][] events, int target) {
        int left = 0, right = events.length - 1;
        int res = events.length;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (events[mid][0] >= target) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}

