package sec12;

import java.lang.reflect.Method;

public class PrintAnnotationEx {
    public static void main(String[] args) throws Exception{
//        Service클래스에 선언된 메서드를 리플렉션해서
//        @PrintAnnotation 설정 정보를 얻어낸 후,
//        구분선을 출력하고 해당 메서드를 호출하는 실행 클래스이다.

        // Service 클래스에 선언된 모든 메서드 가져오기(method1,2,3)
        Method[] declaredMethods = Service.class.getDeclaredMethods();

        for(Method method : declaredMethods){
            // PrintAnnotation 정보를 얻기
            PrintAnnotation printAnnotation = method.getAnnotation(PrintAnnotation.class);
            printLine(printAnnotation); // 어노테이션 정보로 출력
            method.invoke(new Service()); // 리플렉션으로 메서드 호출
        }
    }

    public static void printLine(PrintAnnotation printAnnotation){
        if(printAnnotation != null){
            // number 속성 값 얻기
            int number = printAnnotation.number();
            String value = printAnnotation.value();
            for(int i=0; i<number; i++){
                System.out.print(value);
            }
            System.out.println();
        }
    }
}
