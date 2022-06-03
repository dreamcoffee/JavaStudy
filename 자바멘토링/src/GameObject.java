import java.util.Scanner;

public abstract class GameObject {
    protected int distance; // 움직이는 거리
    protected int x, y; // 시작 좌표

    public GameObject(int startX, int startY, int distance){
        this.x = startX;
        this.y = startY;
        this.distance = distance;
    }
    public int getX() {return x;}
    public int getY() {return y;}
    public boolean collide(GameObject p){
        if (this.x == p.getX() && this.y == p.getY())
            return true;
        else
            return false;
    }
    protected abstract void move();
    protected abstract char getShape();
}

class bear extends GameObject{
    Scanner sc = new Scanner(System.in);
    String input;
    public bear(){
        super(0,0,1);
    }

    @Override
    protected void move(){
        System.out.print("왼쪽(a), 아래(s), 위(d), 오른쪽(f) >> ");
        input = sc.next();
        if(input.equals("a") && x>0) x-=distance;
        else if(input.equals("s") && y<9) y+=distance;
        else if(input.equals("d") && y>0) y-=distance;
        else if(input.equals("f") && x<9) x+=distance;
    }

    @Override
    protected char getShape(){
        return 'B';
    }
}

class fish extends GameObject{
    int cnt = 1;
    public fish(){
        super((int)(Math.random()*10), (int)(Math.random()*10),1);
    }

    @Override
    protected void move(){
        int random;
        boolean check= true;
        cnt++;
        if(cnt % 5 == 0 || cnt % 5 == 4){
            while(check){
                random = (int)(Math.random()*4);
                if(random == 1 && x>0) {
                    x-=distance;
                    check = false;
                }
                else if(random == 2 && y<9) {
                    y+=distance;
                    check = false;
                }
                else if(random == 3 && y>0) {
                    y-=distance;
                    check = false;
                }
                else if(random == 4 && x<9) {
                    x+=distance;
                    check = false;
                }
            }
        }
    }

    @Override
    protected char getShape(){
        return 'F';
    }
}

class Game {
    public static void main(String[] args){
        bear b = new bear();
        fish f = new fish();
        System.out.println("** Bear의 Fish 먹기 게임을 시작합니다. **");
        while(!b.collide(f)){
            for(int i = 0; i<10; i++){
                for(int j =0; j<10; j++){
                    if(b.getX() == j && b.getY() == i) {System.out.print(b.getShape());}
                    else if(f.getX() == j && f.getY() == i) {System.out.print(f.getShape());}
                    else {System.out.print("-");}
                }
                System.out.println("");
            }
            b.move();
            f.move();
        }
        System.out.println("Bear Wins!!");
    }
}
