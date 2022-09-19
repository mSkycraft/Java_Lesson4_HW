package ru.geekbrains;




public final class HW1 {
    public static class Stack<T>{
        private T[] array;
        private int index;
        private int length;

        public Stack(int len){
            this.index = 0;
            this.length = len;
            this.array = (T[]) new Object[len];
        }
    
        public int size(){
            return this.index;
        }
    
        public boolean empty(){
            return this.size()==0;
        }
    
        public void push(T value){
            if(this.size()<this.length)
                this.array[index++] = value;
            else
                System.out.println("Стек переполнен");
        }
    
        public T peek(){
            if(this.size()>0)
                return this.array[index-1];
            else{
                System.out.print("Стек пуст ");
                return null;
            }  
        }
    
        public T pop(){
            if(this.size()>0)
                return this.array[--index];
            else{
                System.out.print("Стек пуст ");
                return null;
            }
        }
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack <>(100);
        stack.push("str1");
        stack.push("str2");
        stack.push("str3");
        stack.push("str4");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
