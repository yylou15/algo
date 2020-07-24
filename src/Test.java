import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        Pattern LOG_CONTENT_PATTERN = Pattern.compile("\\[.*?\\]\\[(.*?)\\]\\s-\\s(.*)");
        String serviceRefId = "146";
        List<String> logs = new ArrayList<String>(){{
            add("2020-07-07 20:10:59,888 [83929b26-9ea9-4bd2-b771-612a600a69b2][146] - ----------------END----------------");
            add("2020-07-07 20:10:59,888 [83929b26-9ea9-4bd2-b771-612a600a69b2][146] - asgasgsagasgasgasgas");
            add("2020-07-07 20:10:59,888 [83929b26-9ea9-4bd2-b771-612a600a69b2][147] - gasgas146gasas");
            add("2020-07-07 20:10:59,888 [83929b26-9ea9-4bd2-b771-612a600a69b2][146] - 146agasgsg");
            add("2020-07-07 20:10:59,888 [83929b26-9ea9-4bd2-b771-612a600a69b2][147] - wqtwqyh");
            add("2020-07-07 20:10:59,888 [83929b26-9ea9-4bd2-b771-612a600a69b2][146] - [1460]gsagnoiwqiog");
        }};
        List<String> filteredLogs = logs.stream().filter(log -> {
            Matcher matcher = LOG_CONTENT_PATTERN.matcher(log);
            if (!matcher.find()) {
                return false;
            }
            String refIdStr = matcher.group(1);
            String content = matcher.group(2);
            boolean contentContainRefId = refIdStr != null && !refIdStr.equals(serviceRefId) && content.contains(serviceRefId);
            return !contentContainRefId;
        }).collect(Collectors.toList());

        filteredLogs.forEach(System.out::println);

    }
}
