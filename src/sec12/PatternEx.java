package sec12;

import java.util.regex.Pattern;

public class PatternEx {
    public static void main(String[] args) {
        // 전화번호 정규표현식
        String regExp = "(02|010)-\\d{3,4}-\\d{4}";
        String data = "010-1234-5678";

        boolean result = Pattern.matches(regExp, data);

        if(result){
            System.out.println("매치합니다.");
        }else{
            System.out.println("매치하지않습니다.");
        }

        regExp = "\\w+@\\w+\\.\\w+(\\.\\w)?";
        data = "angel@mycompaycom";
        result = Pattern.matches(regExp, data);

        if(result){
            System.out.println("매치합니다.");
        }else{
            System.out.println("매치하지않습니다.");
        }
    }
}
