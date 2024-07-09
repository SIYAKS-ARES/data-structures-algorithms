import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        String str[] = { "Bilgisayar", "Dolap", "Masa", "Sandalye", "Sıra" };
        Stack<String> s = new Stack<>();
        for (int i = 0; i < str.length; i++)
            s.push(str[i]);
        while (!s.empty())
            System.out.println(s.pop());
    }
}