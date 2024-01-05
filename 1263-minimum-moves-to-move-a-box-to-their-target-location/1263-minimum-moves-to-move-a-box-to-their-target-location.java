class Solution {
    int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    int[] start = new int[2];
    int[] player = new int[2];
    int[] target = new int[2];

    public int minPushBox(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'S') {
                    player[0] = i;
                    player[1] = j;
                } else if (grid[i][j] == 'B') {
                    start[0] = i;
                    start[1] = j;
                } else if (grid[i][j] == 'T') {
                    target[0] = i;
                    target[1] = j;
                }
            }
        }

        if (Arrays.equals(start, target)) return 0;

        Deque<List<List<Integer>>> queue = new ArrayDeque<>();
        Set<List<List<Integer>>> visited = new HashSet<>();
        int step = 0;

        char[][] updatedGrid = getCopiedGrid(grid, Arrays.asList(start[0], start[1]));
        dfs(player, updatedGrid);
        for (int i = 0; i < 4; i++) {
            int[] playerLoc = new int[]{start[0] + directions[i][0], start[1] + directions[i][1]};
           
            if (isAccessible(playerLoc, updatedGrid)) {
                List<List<Integer>> record = getRecord(start, playerLoc);
                queue.add(record);
                visited.add(record);
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<List<Integer>> current = queue.poll();
                List<Integer> curBox = current.get(0);
                updatedGrid = getCopiedGrid(grid, curBox);
                if (grid[curBox.get(0)][curBox.get(1)] == 'T') {
                    return step;
                }
                List<Integer> curPlayer = current.get(1);
                dfs(new int[]{curPlayer.get(0), curPlayer.get(1)}, updatedGrid);
                for (int j = 0; j < 4; j++) {
                    List<Integer> nextBox = Arrays.asList(curBox.get(0) + directions[j][0], curBox.get(1) + directions[j][1]);
                    if (nextBox.get(0) < 0 || nextBox.get(0) >= grid.length || nextBox.get(1) < 0 || nextBox.get(1) >= grid[0].length || grid[nextBox.get(0)][nextBox.get(1)] == '#') {
                        continue;
                    }

                    List<Integer> nextPlayer = Arrays.asList(curBox.get(0) - directions[j][0], curBox.get(1) - directions[j][1]);

                    List<List<Integer>> nextRecord = new ArrayList<>();
                    nextRecord.add(nextBox);
                    nextRecord.add(curBox);
                    if (visited.contains(nextRecord)) continue;

                    if (isAccessible(new int[]{nextPlayer.get(0), nextPlayer.get(1)}, updatedGrid)) {
                        queue.add(nextRecord);
                        visited.add(nextRecord);
                    }
                }
            }
            System.out.println(step);
            step++;
        }
        return -1;
    }

    private char[][] getCopiedGrid(char[][] grid, List<Integer> curBox) {
        char[][] result = new char[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                result[i][j] = grid[i][j];
            }
        }
        result[start[0]][start[1]] = '.';
        result[player[0]][player[1]] = '.';
        result[target[0]][target[1]] = '.';
        result[curBox.get(0)][curBox.get(1)] = 'B';
        return result;
    }

    private List<List<Integer>> getRecord(int[] box, int[] playerLoc) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(box[0], box[1]));
        result.add(Arrays.asList(playerLoc[0], playerLoc[1]));
        return result;
    }

    private boolean isAccessible(int[] end, char[][] grid) {
        if (end[0] < 0 || end[0] >= grid.length || end[1] < 0 || end[1] >= grid[0].length || grid[end[0]][end[1]] == '#') {
            return false;
        }

        return grid[end[0]][end[1]] == '*';
    }

    public void dfs(int[] current, char[][] grid) {
        if (current[0] < 0 || current[0] >= grid.length || current[1] < 0 || current[1] >= grid[0].length) {
            return;
        }

        if (grid[current[0]][current[1]] == '*') {
            return;
        }

        if (grid[current[0]][current[1]] == '#' || grid[current[0]][current[1]] == 'B') {
            return;
        }

        grid[current[0]][current[1]] = '*';

        for (int i = 0; i < 4; i++) {
            int[] next = new int[]{ current[0] + directions[i][0], current[1] + directions[i][1] };
            dfs(next, grid);
        }
    }
}
