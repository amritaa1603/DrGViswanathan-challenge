class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int bestIndex = -1;
    }

    TrieNode root = new TrieNode();
    String[] container;

    
    private void updateBest(TrieNode node, int idx) {

        if (node.bestIndex == -1) {
            node.bestIndex = idx;
            return;
        }

        String current = container[node.bestIndex];
        String next = container[idx];

    
        if (next.length() < current.length()) {
            node.bestIndex = idx;
        }

     
        else if (next.length() == current.length()
                && idx < node.bestIndex) {
            node.bestIndex = idx;
        }
    }

    private void insert(String word, int idx) {

        TrieNode node = root;

        updateBest(node, idx);

        for (int i = word.length() - 1; i >= 0; i--) {

            int ch = word.charAt(i) - 'a';

            if (node.children[ch] == null) {
                node.children[ch] = new TrieNode();
            }

            node = node.children[ch];

            updateBest(node, idx);
        }
    }
    private int search(String word) {

        TrieNode node = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            int ch = word.charAt(i) - 'a';
                        if (node.children[ch] == null) {
                break;
            }
            node = node.children[ch];
        }
        return node.bestIndex;
    }
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        container = wordsContainer;       
        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i);
        }
        int[] ans = new int[wordsQuery.length];
        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = search(wordsQuery[i]);
        }

        return ans;
    }
}