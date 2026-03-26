class Pair {
    String word;
    int steps;

    Pair(String word, int steps) {
        this.word = word;
        this.steps = steps;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int M = beginWord.length();
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord))
            return 0;
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(beginWord, 1));
        set.remove(beginWord);
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            String word = pair.word;
            int steps = pair.steps;
            char[] charArrayOfWord = word.toCharArray();
            for (int i = 0; i < M; i++) {
                char original = charArrayOfWord[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    charArrayOfWord[i] = ch;
                    String transformedWord = new String(charArrayOfWord);
                    if (transformedWord.equals(endWord))
                        return steps + 1;
                    if (set.contains(transformedWord)) {
                        queue.offer(new Pair(transformedWord, steps + 1));
                        set.remove(transformedWord);
                    }
                }
                charArrayOfWord[i] = original;
            }
        }
        return 0;
    }
}

// T.C => O(N * M * 26)
// S.C => O(N) for set + O(N) for queue + O(M) for char array + O(M) for string
