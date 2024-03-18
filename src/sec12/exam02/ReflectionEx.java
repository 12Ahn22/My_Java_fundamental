package sec12.exam02;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionEx {
    public static void main(String[] args) {
        Class clazz = Car.class;

        System.out.println("[생성자 정보]");
        Constructor[] constructors = clazz.getDeclaredConstructors(); // 생성자들 정보
        for (Constructor constructor : constructors) {
            System.out.print(constructor.getName() + "(");
            Class[] parameters = constructor.getParameterTypes();
            printParameters(parameters);
            System.out.println(")");
        }
        System.out.println();

        System.out.println("[필드 정보]");
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields){
            System.out.println(field.getType().getSimpleName() + " " + field.getName());
        }
        System.out.println();

        System.out.println("[메서드 정보]");
        Method[] methods = clazz.getDeclaredMethods();
        for(Method method : methods){
            System.out.print(method.getName() + "(");
            Class[] parameters = method.getParameterTypes();
            printParameters(parameters);
            System.out.println(")");
        }
    }

    public static void printParameters(Class[] parameters) {
        for (int i = 0; i < parameters.length; i++) {
            System.out.print(parameters[i].getSimpleName());
            if (i < (parameters.length - 1)) {
                System.out.print(",");
            }
        }
    }
}

