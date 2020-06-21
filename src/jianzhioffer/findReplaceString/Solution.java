package jianzhioffer.findReplaceString;

public class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder stringBuffer = new StringBuilder();
        int now = 0;
        for (int i = 0; i < indexes.length; i++) {
            stringBuffer.append(S, now, indexes[i]);
            now += sources[i].length();
            stringBuffer.append(targets[i]);
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        new Solution().findReplaceString("abcd",new int[]{0,2},new String[]{"a","ef"},new String[]{"eee","ffff"});
    }
}