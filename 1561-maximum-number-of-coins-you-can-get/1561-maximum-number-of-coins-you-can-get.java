class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);

        int leftPointer = 0;
        int rightPointer = piles.length - 1;

        int yourCoins = 0;

        while(leftPointer < rightPointer) {
            yourCoins += piles[rightPointer - 1];

            rightPointer -= 2;
            leftPointer++;
        }

        return yourCoins;
    }
}