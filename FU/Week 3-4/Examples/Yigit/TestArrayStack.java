public class TestArrayStack {
    public static void main(String[] args) {
        Stack<String> yigit = new ArrayStack<String>();
        yigit.push("a");
        yigit.push("b");
        System.out.println("Yigittaki son eleman: " + yigit.top());
        yigit.push("c");
        String s = yigit.pop();
        System.out.println("Yigittan silinen eleman: " + s);
        yigit.push("d");
    }
}