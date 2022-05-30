interface Queue{
    boolean isEmpty(); //큐가 비어 있는지 검사
    void Enqueue(int x); //큐에 데이터 삽입
    int Dequeue(); //큐에서 데이터 삭제(출력)
}

class myQueue implements Queue{
    int[] itemArray = new int[50];
    int rear;
    int front;
    int count;

    public myQueue(){
        this.rear = 0;
        this.front = 0;
        this.count = 0;
    }

    @Override
    public boolean isEmpty(){
        if (front == rear){
            rear = 0;
            front = 0;
        }
        return (front == rear);
    }

    @Override
    public void Enqueue(int x){
        if (rear == 50){
            System.out.println("큐가 꽉 찼습니다.");
        }
        else{
            itemArray[rear] = x;
            rear++;
            count ++;
        }
    }

    @Override
    public int Dequeue(){
        if(isEmpty()){System.out.println("큐가 비었습니다.");}
        int out = itemArray[front]; // 변수에 출력될 데이터를 저장
        front++; // 배열의 첨자를 증가
        count --; // 원소의 개수를 감소
        return out;
    }
}

public class QueueTest {
    public static void main(String[] args){
        myQueue q = new myQueue();
        for(int i =0; i<10; i++){
            q.Enqueue(i);
            System.out.println(i + "입력 : " + " 원소개수 " + q.count);
        }
        for(int i =0; i<10; i++){
            System.out.println(q.Dequeue() + "출력 : " + " 원소개수 " + q.count);
        }

        q.Dequeue();
    }
}
