package jianzhioffer.letterCombinations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    private List<String> ret = new ArrayList<>();
    private Map<String,List<String>> map = new HashMap<String, List<String>>(){{
        put("2",new ArrayList<String>(){{
            add("a");
            add("b");
            add("c");
        }});
        put("3",new ArrayList<String>(){{
            add("d");
            add("e");
            add("f");
        }});
        put("4",new ArrayList<String>(){{
            add("g");
            add("h");
            add("i");
        }});
        put("5",new ArrayList<String>(){{
            add("j");
            add("k");
            add("l");
        }});
        put("6",new ArrayList<String>(){{
            add("m");
            add("n");
            add("o");
        }});
        put("7",new ArrayList<String>(){{
            add("p");
            add("q");
            add("r");
            add("s");
        }});
        put("8",new ArrayList<String>(){{
            add("t");
            add("u");
            add("v");
        }});
        put("9",new ArrayList<String>(){{
            add("w");
            add("x");
            add("y");
            add("z");
        }});

    }};

    public List<String> letterCombinations(String digits) {
        if ("".equals(digits)){
            return new ArrayList<>();
        }
        dfs(digits,"");
        return ret;
    }

    private void dfs(String s,String now) {
        if ("".equals(s)){
            this.ret.add(now);
            return;
        }
        map.get(s.substring(0,1)).forEach(ch -> dfs(s.substring(1),now + ch));
    }

    public static void main(String[] args) {
        new Solution().letterCombinations("23");
    }
}