package sec12;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeOpEx {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now(); // 컴퓨터 현재 시간을 가져오기
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss");
//        현재 시간
        System.out.println("현재 시간: " + now.format(dtf));

//        1년 덧셈
        LocalDateTime result1 = now.plusYears(1);
        System.out.println("현재 시간 now: " + now.format(dtf));
        System.out.println("+1년 result1: " + result1.format(dtf));

//        2개월 뺄셈
        LocalDateTime result2 = now.minusMonths(2);
        System.out.println("현재 시간 now: " + now.format(dtf));
        System.out.println("-2월 result2: " + result2.format(dtf));

//        7일 덧셈
        LocalDateTime result3 = now.minusDays(7);
        System.out.println("현재 시간 now: " + now.format(dtf));
        System.out.println("-7일 result3: " + result3.format(dtf));
    }
}
