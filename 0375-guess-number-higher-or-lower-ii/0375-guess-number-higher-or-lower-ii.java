class Solution {
    public int getMoneyAmount(int n) {
        return getMoneyAmount(1, n + 1, new HashMap());
    }

    public int getMoneyAmount(int left, int right, Map<Integer, Integer> mamo) {
        if (left >= right - 1) return 0;
        int bestCost = Integer.MAX_VALUE , mamoKey = left + (right * 201);
        if (mamo.containsKey(mamoKey)) return mamo.get(mamoKey);
        for (int i = (left + right) / 2 - 1 ; i < right; i++){
            int currentCost = Math.max(getMoneyAmount(left,i,mamo) , getMoneyAmount(i + 1, right, mamo)) + i;
            bestCost = Math.min(bestCost, currentCost);
        }
        mamo.put(mamoKey, bestCost);
        return bestCost;
    }
}
