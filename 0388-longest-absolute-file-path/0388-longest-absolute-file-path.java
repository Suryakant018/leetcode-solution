class Solution {
    public int lengthLongestPath(String input) {
        int max = 0;
        String[] tokens = input.split("\n");
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{-1, 0}); // root level and size 0 dummy for convenience
        for (String token : tokens) {
            int level = 0;
            for (int i = 0; token.charAt(i) == '\t'; i++) {
                level++;
            }
            int size = token.length() - level;
            while (stack.peek()[0] >= level) {
                stack.pop();
            }
            // + 1 because of the separator / and there will always be a parent in the stack that's why the root is level -1
            int absoluteSize = size + 1 + stack.peek()[1]; 
            stack.push(new int[]{level,  absoluteSize});
            if (token.indexOf(".") != -1) {
                // the first directory doesn't have a separator so one needs to be subtracted.
                max = Math.max(max, absoluteSize - 1);
            }
        }

        return max;
    }
}