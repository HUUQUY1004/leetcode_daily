// My solutiion

// PASS 90%
class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Set<Integer> hSet = getDistances(m, hFences);
        Set<Integer> vSet = getDistances(n, vFences);

        int max = -1;
        for (int d : hSet) {
            if (vSet.contains(d)) {
                max = Math.max(max, d);
            }
        }

        return max == -1 ? -1 : max * max;
    }

    private Set<Integer> getDistances(int limit, int[] fences) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int f : fences) list.add(f);
        list.add(limit);

        Collections.sort(list);

        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                res.add(list.get(j) - list.get(i));
            }
        }
        return res;
    }
}
// Optimized solution
class Solution {
  public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
    final int MOD = 1_000_000_007;

    hFences = Arrays.copyOf(hFences, hFences.length + 2);
    vFences = Arrays.copyOf(vFences, vFences.length + 2);

    hFences[hFences.length - 2] = 1;
    hFences[hFences.length - 1] = m;
    vFences[vFences.length - 2] = 1;
    vFences[vFences.length - 1] = n;

    Arrays.sort(hFences);
    Arrays.sort(vFences);

    Set<Integer> hGaps = getGaps(hFences);
    Set<Integer> vGaps = getGaps(vFences);
    int maxGap = -1;

    for (final int hGap : hGaps)
      if (vGaps.contains(hGap))
        maxGap = Math.max(maxGap, hGap);

    return maxGap == -1 ? -1 : (int) ((long) maxGap * maxGap % MOD);
  }

  private Set<Integer> getGaps(int[] fences) {
    Set<Integer> gaps = new HashSet<>();
    for (int i = 0; i < fences.length; ++i)
      for (int j = 0; j < i; ++j)
        gaps.add(fences[i] - fences[j]);
    return gaps;
  }
}