class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        
        if (coordinates[0][0] == coordinates[1][0]) {
            for (int i = 2; i < coordinates.length; i++) {
                if (coordinates[i][0] != coordinates[0][0])
                    return false;
            }
        } else if (coordinates[0][1] == coordinates[1][1]) {
            for (int i = 2; i < coordinates.length; i++) {
                if (coordinates[i][1] != coordinates[0][1])
                    return false;
            }
        } else {
            int n = (coordinates[0][0] * coordinates[1][1] - coordinates[0][1] * coordinates[1][0]) / (coordinates[0][0]-coordinates[1][0]);
            int m = (coordinates[0][1] - coordinates[1][1]) / (coordinates[0][0] - coordinates[1][0]);

            for (int i = 2; i < coordinates.length; i++) {
                if ((coordinates[i][0] * m + n) != coordinates[i][1])
                    return false;
            }
        }
        
        return true;
    }
}