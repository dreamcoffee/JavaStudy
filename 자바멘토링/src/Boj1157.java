import java.util.Scanner;

public class Boj1157 {
    public static void main(String[] args){
        Scanner Sc = new Scanner(System.in);
        String word;
        int[] count = new int[26];
        int high = 0;
        int value;
        char alphabet = 'a';

        word = Sc.next().toUpperCase();

        for(int i = 0; i<word.length(); i++){
            value = word.charAt(i) - 65;
            count[value]++;

            if(count[value] > high){
                high = count[value];
                alphabet = word.charAt(i);
            }
            else if(count[value] == high){
                alphabet = '?';
            }
        }
        System.out.println(alphabet);
    }
}
