public class Duke {
    public String lines = "---------------------------------------";
    private void print(String s) {
        System.out.println(lines);
        System.out.println(s);
    }

    public static void main(String[] args) {
        print("Hello I'm Uy, what can I do for you?");
        print("Bye. Hope to see you again soon!");
    }
}
