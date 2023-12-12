
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int count = 0;

        for (int[] p1 : points) {
            Map<Integer, Integer> distanceMap = new HashMap<>();
            for (int[] p2 : points) {
                if (p1 != p2) {
                    int d = distance(p1, p2);
                    distanceMap.put(d, distanceMap.getOrDefault(d, 0) + 1);
                }
            }

            for (int d : distanceMap.keySet()) {
                int frequency = distanceMap.get(d);
                count += frequency * (frequency - 1);
            }
        }

        return count;
    }

    private int distance(int[] p1, int[] p2) {
        int dx = p1[0] - p2[0];
        int dy = p1[1] - p2[1];
        return dx * dx + dy * dy;
    } 
}