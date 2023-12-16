
class Solution {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> bulls = new HashMap<>();
        Set<Character> bullsSet = new HashSet<>();
        for (int i = 0; i < secret.length(); i++) {
            char bull = secret.charAt(i);
            int frequency = bulls.getOrDefault(bull, 0);
            frequency++;
            bulls.put(bull, frequency);
            bullsSet.add(bull);
        }

        int bullsTotal = 0;
        int cows = 0;
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == secret.charAt(i)) {
                bullsTotal++;
                int frequency = bulls.get(guess.charAt(i));
                frequency--;
                bulls.put(guess.charAt(i), frequency);
            } 
        }

        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == secret.charAt(i)) {
                continue;
            } else if (bullsSet.contains(guess.charAt(i))) {
                int frequency = bulls.get(guess.charAt(i));
                if (frequency > 0) {
                    cows++;
                    frequency--;
                    bulls.put(guess.charAt(i), frequency);
                }
            }
        }

        return String.valueOf(bullsTotal) + "A"  + String.valueOf(cows) + "B";
    }
}