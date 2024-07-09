public class TestLinkedListStack {
    public static void main(String[] args) {
        Stack<Character> yigit = new LinkedListStack<Character>();
        yigit.push('a');
        yigit.push('b');
        yigit.push('c');
        System.out.println("Yigittaki elemanlar cikariliyor: ");
        while (!yigit.empty()) {
            System.out.println(yigit.pop());
        }
    }
}