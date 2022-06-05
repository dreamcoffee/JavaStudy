package week3;
import java.util.Scanner;

class Class_1{
    private String name;
    private int salary;
    public Class_1(String name, int salary){
        this.name = name;
        this.salary = salary;
        pm();
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public void getinformation(){
        System.out.println("이름 : " + name + ", 연봉 : " + salary);
    }

    public void pm(){
        System.out.println("부모(상위,슈퍼)클래스");
    }
}

class Class_2 extends Class_1{
    private String department;
    public Class_2(String name, int salary, String department){
        super(name, salary);
        this.department = department;
    }

    public void getinformation(){
        System.out.println("이름 : " + getName() + ", 연봉 : " + getSalary() + ", 부서 : " + department);
    }

    public void pm(){
        System.out.println("자식(서브,하위)클래스");
    }
}

public class Main {
    public static void main(String[] args){
        Scanner Sc = new Scanner(System.in);
        Class_1 c1;
        Class_2 c2;
        String name;
        String department;
        int income;
        boolean con = true;
        int menu;
        System.out.println("직원 정보 확인 프로그램");
        while(true) {
            System.out.println("1. 이름, 연봉 \t 2. 이름, 연봉, 부서 \t 3. 종료");
            System.out.print("메뉴 입럭 : ");
            menu = Sc.nextInt();
            if(menu == 1){
                System.out.print("이름 : ");
                name = Sc.next();
                System.out.print("연뵹 : ");
                income = Sc.nextInt();
                c1 = new Class_1(name, income);
                c1.getinformation();
            }
            else if(menu == 2){
                System.out.println("이름 : ");
                name = Sc.next();
                System.out.println("연봉 : ");
                income = Sc.nextInt();
                System.out.println("부서 : ");
                department = Sc.next();
                c2 = new Class_2(name, income, department);
                c2.getinformation();
            }
            else if(menu == 3){
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            else
                System.out.println("잘못된 값을 입력하셨습니다.");

        }
    }
}
