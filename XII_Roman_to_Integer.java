import java.util.HashMap;

class XII_Roman_to_Integer {
    public static HashMap<Character, Integer> retRomMap() {
        HashMap<Character, Integer> rom = new HashMap<>();
        rom.put('I', 1);
        rom.put('V', 5);
        rom.put('X', 10);
        rom.put('L', 50);
        rom.put('C', 100);
        rom.put('D', 500);
        rom.put('M', 1000);
        return rom;
    }

    public static int romanToInt(String s) {
        HashMap<Character, Integer> rom = retRomMap();
        int sum = 0;
        int p = 0;
        while (p < s.length() - 1) {
            if (rom.get(s.charAt(p)) < rom.get(s.charAt(p + 1))) {
                sum += rom.get(s.charAt(p + 1)) - rom.get(s.charAt(p));
                p++;
            } else {
                sum += rom.get(s.charAt(p));
            }
            p++;
        }
        if (p == s.length() - 1) {
            sum += rom.get(s.charAt(p));
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "XVII";
        System.out.println(romanToInt(s));
    }
}

/*
 * Question:
 * 
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D
 * and M.
 * 
 * Symbol Value
 * I 1
 * V 5
 * X 10
 * L 50
 * C 100
 * D 500
 * M 1000
 * For example, 2 is written as II in Roman numeral, just two ones added
 * together. 12 is written as XII, which is simply X + II. The number 27 is
 * written as XXVII, which is XX + V + II.
 * 
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is
 * written as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX. There
 * are six instances where subtraction is used:
 * 
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 * Example 2:
 * 
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 3:
 * 
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 15
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */