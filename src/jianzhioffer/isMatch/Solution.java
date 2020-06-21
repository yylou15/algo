package jianzhioffer.isMatch;

public class Solution {

    public boolean isMatch(String s, String p) {
        return dfs(s, p);
    }

    private boolean dfs(String s, String p) {
        if ("".equals(p) && "".equals(s)) {
            return true;
        }
        if ("".equals(p)) {
            return false;
        }
        if ("".equals(s)){
            if (p.length() == 1 || p.length() % 2 != 0){
                return false;
            }
            for (int i = 1; i < p.length(); i+=2) {
                if (p.charAt(i) != '*'){
                    return false;
                }
            }
            return true;
        }

        if (p.length() == 1 || p.charAt(1) != '*') {
            if (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0)) {
                return dfs(s.substring(1), p.substring(1));
            } else {
                return false;
            }
        }

        if (p.charAt(1) == '*') {
            if (dfs(s, p.substring(2))) {
                return true;
            }
            for (int i = 0; i < s.length(); i++) {
                if (p.charAt(0) == '.' || s.charAt(i) == p.charAt(0)) {
                    if (dfs(s.substring(i + 1),p.substring(2))){
                        return true;
                    };
                }else {
                    break;
                }
            }
            return false;
        }

        System.out.println("!!!");
        return false;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("aa", "a"));
    }
}
