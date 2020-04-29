class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0) return result;
        
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);
        
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(0);
            List<Integer> prev = result.get(i - 1);
            
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(prev.get(j - 1) + prev.get(j));
            }
            row.add(1);
            result.add(row);
        }
        
        return result;
    }
}