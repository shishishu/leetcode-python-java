// method 1: brute force
class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (m == 0){
            return 0;
        }
        int i = 0, j = 0;
        while (i < n && j < m){
            if (haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        return (i - j <= n -m)? (i - j): -1;
    }
}

// method 2: KMP
class Solution {

    private int[] createNext(String p){
        int m = p.length();
        int[] next = new int[m];
        next[0] = -1;
        int t = -1, j = 0;
        while (j < m - 1){
            if ( t < 0 || p.charAt(j) == p.charAt(t)){
                next[++j] = ++t;
            } else {
                t = next[t];
            }
        }
        return next;
    }

    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (m == 0){
            return 0;
        }
        int[] next = createNext(needle);
        int i = 0, j = 0;
        while (i < n && j < m){
            if (haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            } else {
                if (j == 0){
                    i++;
                } else {
                    j = next[j];
                }
            }
        }
        return (j == m)? (i - j): -1;
    }
}