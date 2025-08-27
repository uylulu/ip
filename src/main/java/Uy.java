public class Uy {
    public String lines = "---------------------------------------";
    private void print(String s) {
        System.out.println(lines);
        System.out.println(s);
    }

    String input() {
        return System.console().readLine();
    }

    public static void main(String[] args) {
        print("Hello I'm Uy, what can I do for you?");
        print("Bye. Hope to see you again soon!");
    }
}
