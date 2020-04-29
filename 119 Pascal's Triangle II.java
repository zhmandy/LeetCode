class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        if (rowIndex < 0) return result;
        if (rowIndex == 0) {
            result.add(1);
            return result;
        }
        
        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            
            for (int j = 1; j < i; j++) {
                row.add(prev.get(j - 1) + prev.get(j));
            }
            
            row.add(1);
            prev = row;
            result = row;
        }
        
        return result;
    }
}