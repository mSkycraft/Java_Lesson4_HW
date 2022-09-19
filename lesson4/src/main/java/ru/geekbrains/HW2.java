package ru.geekbrains;

import java.util.Scanner;

public class HW2 {

    public static class Deque<T>{
        private T[] array;
        private int start;
        private int end;
        private int length;

        public Deque(int len){
            this.start = len-1;
            this.end = len-1;
            this.length = len;
            this.array = (T[]) new Object[len];
        }
    
        public int size(){
            return end-start;
        }
    
        public boolean isEmpty(){
            return end-start==0;
        }
    
        public void push(T value){
            if(end-start<length-1){
                array[start--] = value;
                if(start<10) control();
            } else
                System.out.println("Очередь переполнена");
        }
    
        public T peek(){
            if(this.size()>0)
                return this.array[end];
            else{
                System.out.print("Очередь пуста ");
                return null;
            }  
        }
    
        public T pop(){
            if(this.size()>0){
                return this.array[this.end--];
            } else {
                System.out.print("Очередь пуста ");
                return null;
            }
        }

        private void control(){
            int count = this.length-1;
            for(int i = this.end;i>=start;i--){
                this.array[count--] = this.array[i];
            }
            this.end = length-1;
            this.start = count+1;
        }
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>(5);
        System.out.println("Очередь пуста: " + deque.isEmpty());
        Scanner scanner = new Scanner(System.in);
        String[] str;
        while(true){
            str = scanner.nextLine().split(" ");
            if(str[0].equals("push")){
                deque.push(Integer.parseInt(str[1]));
            }else if(str[0].equals("pop")){
                System.out.println("Изъят из очереди: " +  deque.pop());
            }
            System.out.println("Первый в очереди: "+ deque.peek());
        }
    }
}
