
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        
        Queue queue = new Queue(num);

        for(int i = 0; i < num; i++){
            String[] str = br.readLine().split(" ");
            switch (str[0]){
                case "push" :
                    queue.push(Integer.parseInt(str[1]));
                    break;
                case "pop":
                    System.out.println(queue.pop());
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    System.out.println(queue.empty());
                    break;
                case "front":
                    System.out.println(queue.front());
                    break;
                case "back":
                    System.out.println(queue.back());
                    break;
            }
        }
        br.close();
    }
}


class Queue {
    private int size;
    private int[] arr;
    private int front;
    private int back;

    public Queue(int size) {
        this.size = size;
        this.arr = new int[size];
        this.front = 0;
        this.back = 0;
    }
    
    public void push(int n) {
        if(front >= back){
            for(int i = front-1; i >= 0; i--){
                arr[i+1] = arr[i];
            }
        }
        arr[0] = n;
        front++;
    }

    public int pop() {
        if(front <= back){
            return -1;
        } else{
            int ans = arr[front-1];
            arr[front-1]=0;
            front--;
            return ans;
        }
    }

    public int size() {
        return front;
    }

    public int empty() {
        if (front <= back) return 1;
        else return 0;
    }

    public int front() {
        if (front <= back) return -1;
        else return arr[front-1];
    }

    public int back() {
        if (front <= back) return -1;
        else return arr[back];
    }

}
