package dailyKill.addBinary;

public class Solution {
    public String addBinary(String a, String b) {

        String ra = new StringBuilder(a).reverse().toString();
        String rb = new StringBuilder(b).reverse().toString();
        StringBuilder answer = new StringBuilder();
        boolean plus = false;
        for (int i = 0; i < ra.length() && i < rb.length(); i++) {
            int sum = Integer.parseInt(ra.substring(i, i + 1)) + Integer.parseInt(rb.substring(i, i + 1)) + (plus ? 1 : 0);
            if (sum > 1) {
                plus = true;
                sum -= 2;
            } else {
                plus = false;
            }
            answer.append(sum);
        }

        if (ra.length() > rb.length()) {
            for (int i = 0; i < ra.length() - rb.length(); i++) {
                int sum = Integer.parseInt(ra.substring(rb.length() + i, rb.length() + i + 1)) + (plus ? 1 : 0);

                if (sum > 1) {
                    plus = true;
                    sum -= 2;
                } else {
                    plus = false;
                }
                answer.append(sum);
            }
        }
        if (rb.length() > ra.length()) {
            for (int i = 0; i < rb.length() - ra.length(); i++) {
                int sum = Integer.parseInt(rb.substring(ra.length() + i, ra.length() + i + 1)) + (plus ? 1 : 0);

                if (sum > 1) {
                    plus = true;
                    sum -= 2;
                } else {
                    plus = false;
                }
                answer.append(sum);
            }
        }
        if (plus) {
            answer.append(1);
        }

        return answer.reverse().toString();
    }
}