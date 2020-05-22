class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        if (n < 1 || k < 1 || n < k) return ret;
        
        combineHelper(n, k, 1, ret, new ArrayList<>());
        return ret;
    }
    
    private void combineHelper(int n, int k, int idx, List<List<Integer>> ret, List<Integer> current) {
        if (current.size() == k) {
            ret.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = idx; i <= n; i++) {
            current.add(i);
            combineHelper(n, k, i + 1, ret, current);
            current.remove(current.size() - 1);
        }
    }
}