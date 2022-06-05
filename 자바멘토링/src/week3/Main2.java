package week3;

import java.util.Scanner;
class Game_process{
    Basic_charactor ch = new Basic_charactor();
    Scanner Sc = new Scanner(System.in);
    public Game_process(){
        play_game(5);
        change_job();
        play_game();
    }

    public void change_job(){
        int menu;
        System.out.println("레벨업을 하였습니다. 전직하고 싶은 직업을 고르세요");
        while(true){
            System.out.print("[1.전사 2.마법사 3.궁수 4.치료사] : ");
            menu = Sc.nextInt();
            if (menu == 1){
                ch = new Warrior();
                ch.job_info();
                break;
            }
            else if(menu == 2){
                ch = new Magicion();
                ch.job_info();
                break;
            }
            else if(menu == 3){
                ch = new Archor();
                ch.job_info();
                break;
            }
            else if(menu == 4){
                ch = new Healer();
                ch.job_info();
            }
            else
                System.out.println("잘못된 값을 입력하셨습니다.");
        }
    }

    public void play_game(){
        int menu;
        while(true){
            System.out.print("[1. 무기정보\t 2.스킬사용\t 3.게임종료] : ");
            menu = Sc.nextInt();
            if(menu == 1)
                ch.weapon();
            else if(menu == 2)
                ch.skill();
            else if(menu == 3){
                System.out.println("게임을 종료합니다.");
                break;
            }
            else
                System.out.println("잘못 입력하셨습니다.");
        }
    }
    public void play_game(int skill_count){
        int count = skill_count;
        int menu;
        ch.job_info();
        while(count != 0){
            System.out.print("[1. 무기정보\t 2.스킬사용\t 3.게임종료] : ");
            menu = Sc.nextInt();
            if (menu == 1)
                ch.weapon();
            else if (menu == 2){
                ch.skill();
                count--;
            }
            else if(menu == 3){
                System.out.println("게임을 종료합니다.");
                System.exit(0);
            }
        }
    }
}

class Basic_charactor{
    String name = "초보자";
    public void job_info(){
        System.out.println("*********게임 시작 **********");
        System.out.println("초보자 캐릭터가 생성되었습니다.");
    }
    public void weapon(){System.out.println("초보자는 방망이을(를) 사용합니다.");}
    public void skill(){System.out.println("초보자는 [휘두르기] 스킬을 사용합니다.");}
}

class Warrior extends Basic_charactor{
    @Override
    public void job_info(){System.out.println(super.name+"에서 전사로 전직하였습니다.");}
    @Override
    public void weapon(){System.out.println("전사는 검을(를) 사용합니다.");}
    @Override
    public void skill(){System.out.println("전사는 [베기] 스킬을 사용합니다.");}
}

class Magicion extends Basic_charactor{
    @Override
    public void job_info(){{System.out.println(super.name+"에서 마법사로 전직하였습니다.");}}
    @Override
    public void weapon(){System.out.println("마법사는 완드를(을) 사용합니다");}
    @Override
    public void skill(){System.out.println("마법사는 [매직클로] 스킬을 사용합니다");}
}

class Archor extends Basic_charactor{
    @Override
    public void job_info(){System.out.println(super.name+"에서 궁수로 전직하였습니다.");}
    @Override
    public void weapon(){System.out.println("궁수는 활을(를) 사용합니다.");}
    @Override
    public void skill(){System.out.println("궁수는 [저격] 스킬을 사용합니다");}
}

class Healer extends Basic_charactor{
    @Override
    public void job_info(){{System.out.println(super.name+"에서 치료사로 전직하였습니다.");}}
    @Override
    public void weapon(){System.out.println("치료사는 오브를(을) 사용합니다");}
    @Override
    public void skill(){System.out.println("치료사는 [치료] 스킬을 사용합니다");}
}

public class Main2 {
    public static void main(String[] args){
        Game_process game = new Game_process();
    }
}
