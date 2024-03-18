package 과제4_부서관리;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class Emp {
    private Integer empno;
    private String name;
    private int mgr;
    private String job;
    private String date;
    private int sal;
    private String dept;
    private Integer deptno;
    private String loc;
    private Integer grade;


    public void print() {
        System.out.printf("%-6s%-12s%-6s%-10s%-16s%-6s%-10s%-10s%-6s\n", empno, name, mgr, job, date, sal, dept, loc, grade);
    }

    public void printDetail() {
        System.out.println("사번: " + empno);
        System.out.println("이름: " + name);
        System.out.println("매니저 사번: " + mgr);
        System.out.println("직책: " + job);
        System.out.println("입사일: " + date);
        System.out.println("급여: " + sal);
        System.out.println("부서: " + dept);
        System.out.println("지역: " + loc);
        System.out.println("급여 등급: " + grade);
    }
}
