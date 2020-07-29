import java.util.concurrent.Semaphore;

public class Baidu {

    private static Semaphore[] semaphores = new Semaphore[] {
        new Semaphore(1), new Semaphore(0), new Semaphore(0)
    };

    public static void main(String[] args) {
// 多线程依次打印abc10遍
        for (int i = 0; i < 3; i++) {
            final int i1 = i;
            new Thread(() -> {
                try {
                    for (int j = 0; j < 10; j++) {
                        semaphores[i1].acquire();
                        System.out.print((char)('a' + i1));
                        semaphores[(i1 + 1) % 3].release();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();
        }

    }

    //123321  56765 判断回文数
    public static boolean f(int num) {
        num = Math.abs(num);
        int oldNum = num;
        int tmp = 0;
        while (num > 0) {
            int mod = num % 10;
            num /= 10;
            tmp = tmp * 10 + mod;
        }
        return tmp == oldNum;
    }

    // 查询所有成绩都在80分以上的学生列表
    String  sql = "select user.name from user,course,user_course where user.id = user_course.user_id and user_course.course_id = course.id"
        + "group by user.id having Min(user_course.score) > 80";
}
