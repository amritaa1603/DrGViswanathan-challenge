class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[3]; 
            int distinct = 0;

            for (int j = i; j < n; j++) {
                int idx = s.charAt(j) - 'a';

                if (!seen[idx]) {
                    seen[idx] = true;
                    distinct++;
                }

                if (distinct == 3) {
                    count += n - j;
                    break;
                }
            }
        }

        return count;
    }
}