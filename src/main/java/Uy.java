import java.util.Scanner;

public class Uy {
    private static String lines = "---------------------------------------";
    private static Task[] tasks = new Task[100];
    private static int count = -1;
    private static Scanner input = new Scanner(System.in);

    private static void print(String s) {
        System.out.println(lines);
        System.out.println(s);
    }

    private static String readString() {
        return input.next();
    }

    private static int readInt() {
        return input.nextInt();
    }

    public static void main(String[] args) {
        print("Hello I'm Uy, what can I do for you?");
        while (true) {
            String message = readString();
            if(message.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for(int i = 0;i <= count;i++) {
                    System.out.println(tasks[i].toString());
                }
                System.out.println(lines);
            } else if(message.equals("bye")) {
                print("Bye. Hope to see you again soon!");
                break;
            } else if(message.equals("mark")) {
                int x = readInt();
                tasks[x - 1].mark();
                System.out.println("Nice, I have marked this task as done:");
                System.out.println(tasks[x - 1].toString());
            } else if(message.equals("unmark")) {
                int x = readInt();
                tasks[x - 1].unmark();
                System.out.println("OK, I've marked this task as not done yet:");
                System.out.println(tasks[x - 1].toString());
            } else  {
                count++;
                String suffix = input.nextLine();
                tasks[count] = new Task(message + suffix, false, count + 1);
                print("added: " + message + suffix);
            }
        }
    }
}
