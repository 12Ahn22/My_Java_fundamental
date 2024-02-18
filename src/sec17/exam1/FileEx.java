package sec17.exam1;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileEx {
    public static void main(String[] args) throws Exception {
        // 리소스를 사용해 경로 얻기
        // Paths.get 메서드가 매개변수(파라미터)로 URI를 필요로해서 toURI를 해줌.
        Path path = Paths.get(FileEx.class.getResource("test.txt").toURI());


        Stream<String> stream = Files.lines(path, Charset.defaultCharset()); // 경로, 문자인코딩
        stream.forEach(System.out::println);
        stream.close();
    }
}
