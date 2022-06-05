package week3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class SortString implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        if(o1.length()>o2.length()) return 1;
        else if(o1.length()<o2.length()) return -1;
        else return o1.compareTo(o2);
    }
}

public class Boj1181 {
    public static void main(String[] args){
        Scanner Sc = new Scanner(System.in);
        int input = Sc.nextInt();
        String[] arr = new String[input];
        for(int i = 0; i<input; i++){
            arr[i] = Sc.next();
        }

        Arrays.sort(arr, new SortString());

        System.out.println(arr[0]);
        for(int i =1; i<input; i++){
            if(!arr[i].equals(arr[i-1]))
                System.out.println(arr[i]);
        }
    }
}