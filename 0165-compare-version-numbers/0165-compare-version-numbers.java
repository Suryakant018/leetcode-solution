class Solution {
    public int compareVersion(String version1, String version2) {
        String[] first = version1.split("\\.");
        String[] second = version2.split("\\.");
        int i = 0, j = 0;
        while (i < first.length && j < second.length) {
            int k = Integer.parseInt(first[i]);
            int l = Integer.parseInt(second[j]);
            // System.out.println(k + " " + l);
            if (k < l) return -1;
            if (k > l) return 1;
            i++;
            j++;
        }

        while (i < first.length) {
            int k = Integer.parseInt(first[i]);
            if (k < 0) return -1;
            if (k > 0) return 1;
            i++;
        }

        while (j < second.length) {
            int l = Integer.parseInt(second[j]);
            if (l < 0) return 1;
            if (l > 0) return -1;
            j++;
        }
        return 0;
    }
}
