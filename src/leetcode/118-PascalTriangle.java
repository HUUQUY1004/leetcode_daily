class Solutiion{
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int rowNum = 0; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= rowNum; j++) {
                if (j == 0 || j == rowNum) {
                    row.add(1);
                } else {
                    row.add(triangle.get(rowNum - 1).get(j - 1) + triangle.get(rowNum - 1).get(j));
                }
            }
            triangle.add(row);
        }

        return triangle;
    }
}