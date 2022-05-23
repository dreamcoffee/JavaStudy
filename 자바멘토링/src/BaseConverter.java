import java.util.Scanner;

class BaseConverter{
    Scanner Sc = new Scanner(System.in);
    public BaseConverter(){
        int select;

        while(true){
            System.out.println("-- 진법 변환기 --");
            System.out.println("1. 10진법 -> 2진법");
            System.out.println("2. 2진법 -> 10진법");
            System.out.println("3. 종료");
            System.out.print("입력 : ");

            select = Sc.nextInt();

            if (select == 3)
                break;
            else if (select == 1){
                System.out.print("변환할 10진수 입력 : ");
                convert(Sc.nextInt());
            }
            else if (select == 2){
                System.out.print("변환할 2진수 입력 : ");
                convert(Sc.next());
            }
            else{
                System.out.println("잘못된 번호를 선택하셨습니다.");
            }
        }
    }

    public void convert(int num) {
        String value = "";

        while (num != 1) {
            value = num % 2 + value;
            num = num / 2;
        }
        value = num + value;
        System.out.println(value);
    }

    public void convert(String num){
        int value = 0;
        int square = num.length()-1;
        for(int i = 0; i<num.length(); i++){
            value = (int) (value + (Math.pow(2, square)*(num.charAt(i)-'0')));
            square--;
        }
        System.out.print("2진수 "+num+"은(는) 10진수로 "+value+"입니다.\n");
    }

}

class Main{
    public static void main(String[] args){
        BaseConverter BC = new BaseConverter();
    }
}
