package kickstart.round2020.B.RobotPathDecoding;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = Integer.parseInt(scanner.nextLine());
        for (int kase = 1; kase <= T; kase++) {
            System.out.println(String.format("Case #%s: %s", kase, solve()));
        }
    }

    private static Object solve() {
        String command = parse(scanner.nextLine());
        int x = 1, y = 1;
        for (int i = 0; i < command.length(); i++) {
            switch (command.charAt(i)) {
                case 'N':
                    y--;
                    if (y == 0) {
                        y += 1000000000;
                    }
                    break;
                case 'S':
                    y++;
                    if (y > 1000000000) {
                        y -= 1000000000;
                    }
                    break;
                case 'W':
                    x--;
                    if (x == 0) {
                        x += 1000000000;
                    }
                    break;
                case 'E':
                    x++;
                    if (x > 1000000000) {
                        x -= 1000000000;
                    }
                    break;
            }
        }
        return x + " " + y;
    }

    private static String parse(String command) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);
            if (c == ')') {
                while (answer.length() != 0) {
                    char now = pop(answer);
                    if (now == '(') {
                        int times = pop(answer) - '1' + 1;
                        for (int j = 0; j < times; j++) {
                            answer.append(stringBuilder.reverse().toString());
                        }
                        stringBuilder = new StringBuilder();
                        break;
                    } else {
                        stringBuilder.append(now);
                    }
                }
            } else {
                answer.append(c);
            }
        }
        return answer.toString();
    }

    private static char pop(StringBuilder answer) {
        char c = answer.charAt(answer.length() - 1);
        answer.deleteCharAt(answer.length() - 1);
        return c;
    }

    //private static String dfs(String s){
    //    Matcher matcher = pattern.matcher(s);
    //    StringBuilder stringBuilder = new StringBuilder();
    //    boolean flag = false;
    //    while (matcher.find()){
    //        flag = true;
    //        System.out.println(matcher.group(1));
    //        System.out.println(matcher.group(2));
    //        String sub = dfs(matcher.group(2));
    //        for (int i = 0; i < Integer.parseInt(matcher.group(1)); i++) {
    //            stringBuilder.append(sub);
    //        }
    //    }
    //    if (!flag){
    //        return s;
    //    }else {
    //        return stringBuilder.toString();
    //    }
    //}
}
