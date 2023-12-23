class Solution {
 public int minimumTotal(List<List<Integer>> triangle) {
        int sum = 0;
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> currentRow = triangle.get(i);

            if (i > 0) {
                for (int j = 0; j < currentRow.size(); j++) {
                    // Update each element with the minimum sum
                    if (j == 0) {
                        currentRow.set(j, currentRow.get(j) + triangle.get(i - 1).get(j));
                    } else if (j == currentRow.size() - 1) {
                        currentRow.set(j, currentRow.get(j) + triangle.get(i - 1).get(j - 1));
                    } else {
                        currentRow.set(j, currentRow.get(j) +
                            Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j)));
                    }
                }
            }
        }

        // Find the minimum sum in the last row
        List<Integer> lastRow = triangle.get(triangle.size() - 1);
        sum = Collections.min(lastRow);

        return sum;
    }
}