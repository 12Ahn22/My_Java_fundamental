package 과제4_부서관리;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Dept {
    private Integer deptno;
    private String name;
    private String loc;

    public void print(){
        System.out.printf("%-6s%-12s%-16s\n", deptno, name, loc);
    }

    public void printDetail(){
        System.out.println("부서번호: " + deptno);
        System.out.println("부서명: " + name);
        System.out.println("부서지역: " + loc);
    }
}
