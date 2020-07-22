package dailyKill;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class T2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Map<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i),1,Integer::sum);
        }
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((a,b)->{
            if (a.getValue().equals(b.getValue())){
                return a.getKey()-b.getKey();
            }
            return a.getValue() - b.getValue();
        });

        list.forEach(characterIntegerEntry -> {
            for (int i = 0; i < characterIntegerEntry.getValue(); i++) {
                System.out.print(characterIntegerEntry.getKey());
            }
        });
        System.out.print("\n");
    }
}
