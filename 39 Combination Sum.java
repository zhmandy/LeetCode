class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return ret;
        Arrays.sort(candidates);
        sumHelper(candidates, 0, target, ret, new ArrayList<>());
        return ret;
    }
    
    private void sumHelper(int[] candidates, int pos, int target, List<List<Integer>> ret, List<Integer> current) {
        if (pos >= candidates.length || target < 0)
            return;
        else if (pos < candidates.length && target == 0) {
            ret.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = pos; i < candidates.length; i++) {
            current.add(candidates[i]);
            sumHelper(candidates, i, target - candidates[i], ret, current);
            current.remove(current.size() - 1);
        }
    }
}