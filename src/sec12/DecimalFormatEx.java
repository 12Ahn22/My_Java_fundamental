package sec12;

import java.text.DecimalFormat;

public class DecimalFormatEx {
    public static void main(String[] args) {
        double num = 1234567.89;

        DecimalFormat df;
//      10진수, 빈자리 채우지않음
        df = new DecimalFormat("#,###"); // 1,234,568
        System.out.println(df.format(num));

//      무조곤 소수 첫째자리까지만
        df = new DecimalFormat("#,###.0"); //1,234,567.9
        System.out.println(df.format(num));

        // +는 부호, 0은 빈 자리는 0으로 채움
        df = new DecimalFormat("+0000000000.000"); // +0001234567.890
        System.out.println(df.format(num));

//        통화 기호 붙이기
        df = new DecimalFormat("\u00A4 #,###");
        System.out.println(df.format(num)); // ₩ 1,234,568
    }
}
