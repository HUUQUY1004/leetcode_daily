class Solution {
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backtrack(s, 0, new ArrayList<>());
        return res;
    }

    void backtrack(String s, int idx, List<String> path) {
        if (path.size() == 4) {
            if (idx == s.length()) {
                res.add(String.join(".", path));
            }
            return;
        }


        for (int len = 1; len <= 3; len++) {
            if (idx + len > s.length()) break;

            String part = s.substring(idx, idx + len);

            if (part.length() > 1 && part.startsWith("0")) continue;
            int val = Integer.parseInt(part);
            if (val > 255) continue;

            path.add(part);
            backtrack(s, idx + len, path);
            path.remove(path.size() - 1);
        }
    }
}
