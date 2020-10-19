/**
 * @(#)Solution.java, 10月 19, 2020.
 * <p>
 * Copyright 2020 yyinedu.com. All rights reserved.
 * YYINEDU.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package dailyKill.backspaceCompare;

import java.util.Stack;

/**
 * @author louyuanyang
 */
public class Solution {

    public boolean backspaceCompare(String S, String T) {
        StringBuilder sb = new StringBuilder();
        String finalS = "", finalT = "";
        while (!"".equals(S)){
            if (S.charAt(0) == '#'){
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }else {
                sb.append(S.charAt(0));
            }
            S = S.substring(1);
        }
        finalS = sb.toString();
        sb = new StringBuilder();

        while (!"".equals(T)){
            if (T.charAt(0) == '#'){
                if (sb.length() > 0){
                    sb.deleteCharAt(sb.length() - 1);
                }
            }else {
                sb.append(T.charAt(0));
            }
            T = T.substring(1);
        }
        finalT = sb.toString();
        return finalS.equals(finalT);
    }

    public static void main(String[] args) {
        new Solution().backspaceCompare("y#fo##f","y#f#o##f");
    }
}