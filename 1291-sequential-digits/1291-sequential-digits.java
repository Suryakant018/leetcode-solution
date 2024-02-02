class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();

        int start = 1;
        int next = 2;
        int prefixProduct = start;
        while (start != 9) {
            prefixProduct *= 10;
            prefixProduct += next;

            if (prefixProduct >= low && prefixProduct <= high) {
                result.add(prefixProduct);
            }

            if (next == 9) {
                ++start;
                prefixProduct = start;
                next = start;
            }
            ++next;
        }


        Collections.sort(result);
        return result;
    }
}