class Solution {
    public int minDistance(String word1, String word2) {
        int[][] table = buildDpTable(word1.length(), word2.length());

        // System.out.println(Arrays.deepToString(table));

        for (int i = 1; i < table.length; i++) {
            for (int j = 1; j < table[i].length; j++) {
                int up = table[i-1][j];
                int left = table[i][j-1];
                int diag = table[i-1][j-1];

                char word1Char = word1.charAt(i - 1);
                char word2Char = word2.charAt(j - 1);

                if (word1Char == word2Char) {
                    table[i][j] = diag;
                } else {
                    int min = Math.min(Math.min(up, left), diag);
                    table[i][j] = min + 1;
                }
            }
        }

        // System.out.println(Arrays.deepToString(table));

        int lastRow = table.length - 1;
        int lastCol = table[lastRow].length - 1;

        return table[lastRow][lastCol];
    }

    private int[][] buildDpTable(int w1Len, int w2Len) {
        int[][] table = new int[w1Len + 1][w2Len + 1];

        for (int i = 0; i < w1Len + 1; i++) {
            for (int j = 0; j < w2Len + 1; j++) {

                // if first row
                if (i == 0) {
                    table[i][j] = j;
                    continue;
                }

                // if first column
                if (j == 0) {
                    table[i][j] = i;
                }

                // if not the first row or first column
                break;

            }
        }

        return table;
    }
}