package week2;

import java.util.Scanner;

abstract class Stack{
    abstract int length();
    abstract String pop();
    abstract boolean push(String ob);
}

class StringStack extends Stack{
    int rear = 0;
    String[] itemArray = new String[length()];

    @Override
    int length(){
        return 5;
    }

    @Override
    String pop(){
        if(rear == 0){
            return "underflow";
        }
        else{
            rear--;
            return itemArray[rear];
        }
    }

    @Override
    boolean push(String ob){
        if (rear == itemArray.length){
            System.out.println("overflow");
            return false;
        }
        else{
            itemArray[rear] = ob;
            rear ++;
            return true;
        }
    }
}

public class StackManager {
    public static void main(String[] args){
        Scanner Sc = new Scanner(System.in);
        StringStack stack = new StringStack();

        for(int i =0; i< stack.length(); i++){
            stack.push(Sc.next());
        }

        for(int i =0; i< stack.length(); i++){
            System.out.print(stack.pop() + " ");
        }
    }
}
