class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        if (n <= 0) return ret;
        generateHelper(n, 0, 0, "", ret);
        return ret;
    }
    
    private void generateHelper(int n, int leftNum, int rightNum, String current, List<String> ret) {
        if (current.length() == 2 * n) {
            ret.add(current);
            return;
        }
        
        if (leftNum < n) {
            generateHelper(n, leftNum + 1, rightNum, current + "(", ret);
        }
        
        if (rightNum < leftNum) {
            generateHelper(n, leftNum, rightNum + 1, current + ")", ret);
        }
    }
}