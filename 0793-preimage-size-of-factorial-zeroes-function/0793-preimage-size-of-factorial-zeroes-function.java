class Solution {
    public int preimageSizeFZF(int k) {
        return (int)(rightBoundOfKTrailingZeros(k) - leftBoundOfKTrailingZeros(k) + 1);
    }

    private long leftBoundOfKTrailingZeros(int k) {
        long start = 0;
        long end = 5L * (k + 1);
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (trailingZeroes(mid) < k) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (trailingZeroes(start) == k) {
            return start;
        } else {
            return end;
        }
    }

    private long rightBoundOfKTrailingZeros(int k) {
        long start = 0;
        long end = 5L * (k + 1);
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (trailingZeroes(mid) <= k) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (trailingZeroes(end) == k) {
            return end;
        } else {
            return start;
        }
    }

    private int trailingZeroes(long n) {
        int result = 0;

        long divisor = 5;
        while (divisor <= n) {
            result += n / divisor;
            divisor *= 5;
        }
        return result;
    }

}