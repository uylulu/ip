public class Uy {
    private static String lines = "---------------------------------------";
    private static String[] messages = new String[100];
    private static int count = -1;

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
            if(message.equals("list")) {
                for(int i = 0;i <= count;i++) {
                    System.out.println(i + ". " + messages[i]);
                }
                System.out.println(lines);
            } else if(message.equals("bye")) {
                print("Bye. Hope to see you again soon!");
                break;
            } else {
                count++;
                messages[count] = message;
                print("added: " + message);
            }
        }
    }
}
