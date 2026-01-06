public int countTrapezoids(int[][] points) {
    int n = points.length;
    long totalTrapezoids = 0;

    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (points[i][1] == points[j][1]) {
                continue; // Skip horizontal lines
            }

            int upperCount = 0;
            int lowerCount = 0;

            for (int k = 0; k < n; k++) {
                if (k != i && k != j) {
                    if (isAboveLine(points[i], points[j], points[k])) {
                        upperCount++;
                    } else if (isBelowLine(points[i], points[j], points[k])) {
                        lowerCount++;
                    }
                }
            }

            totalTrapezoids += (long) upperCount * lowerCount;
        }
    }

    return (int) (totalTrapezoids % 1_000_000_007);
}