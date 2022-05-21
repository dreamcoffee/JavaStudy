import java.util.Scanner;

class Player{
    private String name;
    private String word;

    public String getPlayer() {
        return name;
    }

    public void setPlayer(String player) {
        this.name = player;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}

class WordGameApp{
    Scanner Sc = new Scanner(System.in);
    private Player[] py; // 객체 배열 정의
    private final String basicWord = "와이파이";
    int number;

    public WordGameApp(){
        createPlayers();
    }

    private void createPlayers() {
        System.out.print("게임에 참가하는 인원은 몇명입니까>> ");
        number = Sc.nextInt();
        py = new Player[number]; // 배열 동적 할당

        for (int i = 0; i < number; i++) {
            System.out.print("참가자의 이름을 입력하세요>>");
            this.py[i] = new Player(); // py 배열의 각 객체 인스턴스 동적 메모리 할당
            this.py[i].setPlayer(Sc.next()); // 이름 설정
        }
    }

    public void run() {
        int count = 0;
        String word;
        char startWord;
        char endWord;

        System.out.println("시작하는 단어는 " + basicWord + "입니다.");
        endWord = basicWord.charAt(basicWord.length() - 1); // 단어의 끝 추출

        while (true) {
            word = Sc.next();
            py[count % number].setWord(word); // Player 클래스에 단어 저장
            startWord = word.charAt(0); // 플레이어가 입력한 첫 글자를 추출

            if (endWord != startWord) {
                System.out.println(py[count % number].getPlayer() + "이 졌습니다.");
                break;
            }

            count ++;
            endWord = word.charAt(word.length() - 1); // 플레이어가 입력한 단어의 끝 글자 추출
        }
    }

    public static void main(String[] args){
        WordGameApp main = new WordGameApp();
        main.run();
    }
}

