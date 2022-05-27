import java.util.Random;
import java.util.Scanner;

class BaseballGame {
    Scanner Sc = new Scanner(System.in);
    Random random = new Random();
    static final int MAX_THROW = 10;
    int[] answer;
    int cnfThrow = 0;

    public BaseballGame(){
        answer = new int[3];
        for(int i = 0; i<answer.length; i++){
            answer[i] = random.nextInt(9);
            for(int j =0; j<i; j++){
                if(answer[i] == answer[j])
                    i--;
            }
        }
        System.out.println("[테스트]"+answer[0]+" "+answer[1]+" "+answer[2]);
        play();
    }

    public void play(){
        int[] player;
        System.out.println("숫자 야구 게임!");
        while(true){
            System.out.print("공을 던져주세요 : ");
            player = judge(Sc.nextInt(), Sc.nextInt(), Sc.nextInt());
            cnfThrow++;
            if (player[0] == 3){
                System.out.println("정답!! 총"+cnfThrow+"번 던지셨습니다.");
                break;
            }
            else if (cnfThrow == MAX_THROW){
                System.out.println("졌습니다. 정답은 "+answer[0]+" "+answer[1]+" "+answer[2]+" 입니다.");
                break;
            }
            else System.out.println(player[0]+" strike "+player[1]+" ball 입니다.");
        }
    }

    private int[] judge(int a, int b, int c){
        int[] stball = new int[2];
        int strike = 0;
        int ball = 0;
        if (answer[0] == a) strike++;
        if (answer[1] == b) strike++;
        if (answer[2] == c) strike++;

        if (answer[0] == b || answer[0] == c) ball++;
        if (answer[1] == b || answer[1] == c) ball++;
        if (answer[2] == b || answer[2] == c) ball++;

        stball[0] = strike;
        stball[1] = ball;
        return stball;
    }
}

class Main2{
    public static void main(String[] args){
        BaseballGame game = new BaseballGame();
    }
}