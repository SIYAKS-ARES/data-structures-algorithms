import java.io.*;

class StackChar {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public StackChar(int max) {
        maxSize = max;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char j) {
        stackArray[++top] = j;
    }

    public char pop() {
        return stackArray[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

class Reverse {
    public static void main(String[] args) {
        StackChar y = new StackChar(100);
        String str = "Merhaba";
        for (int i = 0; i < str.length(); i++)
            y.push(str.charAt(i));
        while (!y.isEmpty())
            System.out.println(y.pop());
    }
}