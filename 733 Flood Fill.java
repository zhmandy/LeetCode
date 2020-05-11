class Solution {
    private void fillHelper(int[][] image, int sr, int sc, int color, int newColor) {
        if (image[sr][sc] == color) {
            image[sr][sc] = newColor;
            if (sr >= 1) {
                fillHelper(image, sr - 1, sc, color, newColor);
            }
            if (sc >= 1) {
                fillHelper(image, sr, sc - 1, color, newColor);
            }
            if (sr + 1 < image.length) {
                fillHelper(image, sr + 1, sc, color, newColor);
            }
            if (sc + 1 < image[0].length) {
                fillHelper(image, sr, sc + 1, color, newColor);
            }
        }    
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) {
            fillHelper(image, sr, sc, color, newColor);
        }
        return image;
    }
}