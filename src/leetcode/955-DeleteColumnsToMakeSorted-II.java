public int minDeletionSize(String[] strs){
    int n = strs.length, m = strs[0].length();
    boolean[] sorted = new boolean[n - 1];
    int deletions = 0;

    for (int col = 0; col < m; col++) {
        boolean needDeletion = false;

        for (int row = 0; row < n - 1; row++) {
            if (!sorted[row] && strs[row].charAt(col) > strs[row + 1].charAt(col)) {
                needDeletion = true;
                break;
            }
        }

        if (needDeletion) {
            deletions++;
        } else {
            for (int row = 0; row < n - 1; row++) {
                if (strs[row].charAt(col) < strs[row + 1].charAt(col)) {
                    sorted[row] = true;
                }
            }
        }
    }

    return deletions;
}