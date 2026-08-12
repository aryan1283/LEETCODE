class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>();

        for(String word : wordList) {
            set.add(word);
        }

        if(!set.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);
        set.remove(beginWord);

        int steps = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                String word = queue.poll();

                if(word.equals(endWord)) {
                    return steps;
                }

                char[] arr = word.toCharArray();

                for(int j = 0; j < arr.length; j++) {

                    char original = arr[j];

                    for(char ch = 'a'; ch <= 'z'; ch++) {
                        if(ch == original) {
                            continue;
                        }

                        arr[j] = ch;

                        String nextWord = new String(arr);

                        if(set.contains(nextWord)) {
                            set.remove(nextWord);

                            queue.offer(nextWord);
                        }
                    }

                    arr[j] = original;
                }
            }

            steps++;
        }

        return 0;
    }
}