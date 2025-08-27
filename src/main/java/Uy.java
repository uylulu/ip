public class Uy {
    public static String lines = "---------------------------------------";
    private static void print(String s) {
        System.out.println(lines);
        System.out.println(s);
    }

    private static String input() {
        return System.console().readLine();
    }

    public static void main(String[] args) {
        print("Hello I'm Uy, what can I do for you?");
        while (true) {
            String message = input();
            if(message.equals("bye")) {
                print("Bye. Hope to see you again soon!");
                break;
            }
            print(message);
        }
    }
}
