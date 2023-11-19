class Solution {
  public int[][] generateMatrix(int n) {
	var matrix = new int[n][n];
	var firstRow = 0;
	var firstCol = 0;
	var lastRow = n - 1;
	var lastCol = n - 1;
	var x = 1;

	while (firstRow <= lastRow && firstCol <= lastCol) {
		// first row
		for (var j = firstCol; j <= lastCol; j++)
			matrix[firstRow][j] = x++;
		firstRow++;

		// last col
		for (var i = firstRow; i <= lastRow; i++)
			matrix[i][lastCol] = x++;
		lastCol--;

		if (firstRow > lastRow || firstCol > lastCol)
			break;

		// last row
		for (var j = lastCol; j >= firstCol; j--)
			matrix[lastRow][j] = x++;
		lastRow--;

		// first col
		for (var i = lastRow; i >= firstRow; i--)
			matrix[i][firstCol] = x++;
		firstCol++;
	}

	return matrix;
}
}