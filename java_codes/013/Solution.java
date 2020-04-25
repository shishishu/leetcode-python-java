import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        int res = 0;
        char p = 'I';
        for(int i = s.length() - 1; i >= 0; i--){
            char c = s.charAt(i);
            res = map.get(c) < map.get(p) ? res - map.get(c): res + map.get(c);
            p = c;
        }
        return res;
    }
}