class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new LinkedList<>();
        if (k < 1 || n < 1) return result;
        
        combineHelper(k, n, result, 1, new LinkedList<>());
        return result;
    }
    
    private void combineHelper(int k, int n, List<List<Integer>> result, int idx, List<Integer> current) {
        if (current.size() == k && n == 0) {
            result.add(new LinkedList<>(current));
            return;
        }
        
        for (int i = idx; i <= 9; i++) {
            current.add(i);
            combineHelper(k, n - i, result, i + 1, current);
            current.remove(current.size() - 1);
        }
    }
}