import java.util.Scanner;

public class Yigin {
    public int top = 0;

    public void push(int x, int a[], int top) {
        a[top] = x;
        ++top;
        this.top = top;
    }

    public int pop(int a[], int top) {
        --top;
        this.top = top;
        return a[top];
    }

    public static void main(String[] args) {
        Yigin metot = new Yigin();
        String str = "";
        int x = 0, a = 0, b = 0;
        int stk[] = new int[120];
        Scanner oku = new Scanner(System.in);

        System.out.println("\nPostfix ifadeyi giriniz\n");
        str = oku.nextLine();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '+') {
                b = metot.pop(stk, metot.top);
                a = metot.pop(stk, metot.top);
                metot.push(a + b, stk, metot.top);
                System.out.println("\na+b =" + (a + b));
            } else if (str.charAt(i) == '-') {
                b = metot.pop(stk, metot.top);
                a = metot.pop(stk, metot.top);
                metot.push(a - b, stk, metot.top);
                System.out.println("\na-b =" + (a - b));
            } else if (str.charAt(i) == '/') {
                b = metot.pop(stk, metot.top);
                a = metot.pop(stk, metot.top);
                metot.push(a / b, stk, metot.top);
                System.out.println("\na/b= " + a / b);
            } else if (str.charAt(i) == '*') {
                b = metot.pop(stk, metot.top);
                a = metot.pop(stk, metot.top);
                metot.push(a * b, stk, metot.top);
                System.out.println("\na*b= " + a * b);
            } else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                x = str.charAt(i) - '0';
                metot.push(x, stk, metot.top);
            }
        }
        System.out.println("\nPostfix ifadesinin işlem sonucu=" + metot.pop(stk, metot.top));
    }
}