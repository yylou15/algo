package jianzhioffer.reverseWords;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public String reverseWords(String s) {
        List<String> list = Arrays.asList(s.trim().split(" ")).stream().map(it->it.replaceAll(" ","")).filter(it -> !"".equals(it)).collect(Collectors.toList());
        Collections.reverse(list);
        return String.join(" ", list);
    }
}