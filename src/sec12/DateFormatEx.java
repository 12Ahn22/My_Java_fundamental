package sec12;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateFormatEx {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(dtf.format(now));

        dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss");
        System.out.println(dtf.format(now));

        dtf = DateTimeFormatter.ofPattern("오늘은 E요일");
        System.out.println(dtf.format(now));

        // 월 구분이 없는 일(1~365)
        dtf = DateTimeFormatter.ofPattern("오늘은 D번째 날");
        System.out.println(dtf.format(now));

        dtf = DateTimeFormatter.ofPattern("이달의 d번째 날");
        System.out.println(dtf.format(now));

        dtf = DateTimeFormatter.ofPattern("W번째 주");
        System.out.println(dtf.format(now));
    }
}
