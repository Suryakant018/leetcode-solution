import java.util.*;

class Solution {
    public int maxFrequencyElements(int[] nums) {
        int freq, max = 0, count, a = 0;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Map<Integer, Integer> hmap = new HashMap<>();
        for (int i : nums) {
            arr.add(i);
        }
        while (arr.size() != 0) {
            freq = 0;
            count = 0;
            for (int i = 0; i < arr.size(); i++) {
                a = arr.get(i);
                for (int k = 0; k < arr.size(); k++) {
                    int b = arr.get(k);
                    if (a == b) {
                        freq++;
                    }
                }
                hmap.put(a, freq);
                break;
            }
            while (count != arr.size()) {
                if (a == arr.get(count)) {
                    arr.remove(count);
                } else {
                    count++;
                }
            }

        }

        List<Integer> values = new ArrayList<>(hmap.values());
        max = Collections.max(values);
        a = Collections.frequency(values, max);
        max = max * a;

        return max;
    }
}