package sec15;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// Student를 DTO를 위한 클래스로 사용한다.
class Student {
    @Getter
    private static int nextId = 1; // 자동으로 학번을 관리하기 위한 멤버

    private int id; // 학번 (고유)
    private String name;
    private String phone;
    private int score;

    public Student(String name, String phone){
        this.id = nextId++;
        this.name = name;
        this.phone = phone;
        this.score = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", score=" + score +
                '}';
    }
}
public class HashMapEx2 {
    public static void main(String[] args) {
        Map<Integer, Student> map = new HashMap<>();

        map.put(Student.getNextId(), new Student("홍길동", "010-1234-1222"));
        map.put(Student.getNextId(), new Student("강아지", "010-1234-1222"));
        map.put(Student.getNextId(), new Student("고양이", "010-1234-1222"));

        for(var entry: map.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
