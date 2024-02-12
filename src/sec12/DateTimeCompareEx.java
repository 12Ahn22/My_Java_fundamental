package sec12;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeCompareEx {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss");

        // 정확한 날짜 비교를 위해서 시분초는 0으로 설정한다.
        LocalDateTime start = LocalDateTime.of(2021, 1, 1, 0, 0, 0);
        LocalDateTime end = LocalDateTime.of(2021, 12, 31, 0, 0, 0);

//        날짜 비교해보기
        if (start.isBefore(end)) {
            System.out.println("아직 날짜가 진행 중입니다.");
        } else if (start.isEqual(end)) {
            System.out.println("날짜가 같습니다.");
        } else if (start.isAfter(end)) {
            System.out.println("날짜가 지나갔습니다.");
        }

//        남은 일자들 계산하기
        long remainYear = start.until(end, ChronoUnit.YEARS);
        long remainMonth = start.until(end, ChronoUnit.MONTHS);
        long remainDay = start.until(end, ChronoUnit.DAYS);
        long remainHour = start.until(end, ChronoUnit.HOURS);
        long remainMinute = start.until(end, ChronoUnit.MINUTES);
        long remainSecond = start.until(end, ChronoUnit.SECONDS);

//        남은 일자를 각각 맞는 일자로 계산해서 보여줌
        System.out.println("남은 일자 결과");
        System.out.println(remainYear + "년 " + remainMonth + "월 " + remainDay + "일 " + remainHour + "시간 " + remainMinute + "분 " + remainSecond + "초");
    }
}
