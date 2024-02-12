package sec12;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD}) // 메서드에 적용
@Retention(RetentionPolicy.RUNTIME) // 런타임
public @interface PrintAnnotation {
    String value() default "-"; // 선의 종류
    int number() default 15; // 출력 횟수
}
