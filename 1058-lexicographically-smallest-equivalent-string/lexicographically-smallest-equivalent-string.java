class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] parent = new int[26];

        // Initialize parent of each character to itself
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        // Find operation with path compression
        for (int i = 0; i < s1.length(); i++) {
            int a = s1.charAt(i) - 'a';
            int b = s2.charAt(i) - 'a';
            union(a, b, parent);
        }

        // Build the result string using the representative of each character
        StringBuilder result = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            int root = find(c - 'a', parent);
            result.append((char) (root + 'a'));
        }

        return result.toString();
    }

    private int find(int x, int[] parent) {
        if (x != parent[x]) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }

    private void union(int x, int y, int[] parent) {
        int rootX = find(x, parent);
        int rootY = find(y, parent);
        if (rootX == rootY) return;

        // Always attach larger to smaller to keep lexicographical order
        if (rootX < rootY) {
            parent[rootY] = rootX;
        } else {
            parent[rootX] = rootY;
        }
    }
}
