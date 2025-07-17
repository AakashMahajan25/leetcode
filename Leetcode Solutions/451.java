// TC->O(nlogk) SC->O(n)
class Pair {
    char character;
    int frequency;

    Pair(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
    }
}
class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.frequency - a.frequency);

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            char character = p.character;
            int frequency = p.frequency;
            while (frequency > 0) {
                sb.append(character);
                frequency--;
            }
        }
        return sb.toString();
    }
}