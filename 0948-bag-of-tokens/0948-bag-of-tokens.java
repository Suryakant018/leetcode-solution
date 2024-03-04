class Solution {

    public int bagOfTokensScore(int[] tokens, int power) {
        int score = 0, i = 0, j = tokens.length - 1, maxScore = 0;
        Arrays.sort(tokens);
        while (i <= j) {
            if (power >= tokens[i]) {
                power -= tokens[i++];
                score++;
                maxScore = Math.max(maxScore, score);
            } else if (score >= 1) {
                power += tokens[j--];
                score--;
            } else {
                break;
            }
        }
        return maxScore;
    }
}
