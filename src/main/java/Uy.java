
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Uy {

    private static String lines = "---------------------------------------";
    private static TaskList tasks = new TaskList();

    public static Scanner input = new Scanner(System.in);
    private static final String home = System.getProperty("user.home");
    private static final String project_dir = java.nio.file.Paths.get(home, "OneDrive", "Desktop", "CS2103T", "ip", "src").toString();
    private static final Path data_path = java.nio.file.Paths.get(project_dir, "data", "Duke.txt");

//  DATE FORMATING
    private static final DateTimeFormatter date_formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter output_date_formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");

    private static void print(String s) {
        System.out.println(lines);
        System.out.println(s);
    }

    public static LocalDate parse_date(String date) {
        return LocalDate.parse(date, date_formatter);
    }

    public static String format_date(LocalDate date) {
        return date.format(output_date_formatter);
    }

    public static String readString() {
        return input.next();
    }

    public static int readInt() {
        return input.nextInt();
    }

    public static void main(String[] args) {
        print("Hello I'm Uy, what can I do for you?");
        while (true) {
            try {
                String message = readString();
                if (message.equals("list")) {
                    System.out.println("Here are the tasks in your list:");
                    System.out.println(tasks.toString());
                    System.out.println(lines);

                } else if (message.equals("bye")) {
                    print("Bye. Hope to see you again soon!");
                    break;
                } else if (message.equals("mark")) {

                    int x = readInt();
                    tasks.markTask(x - 1);
                    System.out.println("Nice, I have marked this task as done:");
                    System.out.println(tasks.getTask(x - 1).toString());

                } else if (message.equals("unmark")) {

                    int x = readInt();
                    tasks.unmarkTask(x - 1);
                    System.out.println("OK, I've marked this task as not done yet:");
                    System.out.println(tasks.getTask(x - 1).toString());

                } else if (message.equals("todo")) {
                    tasks.addTask(new ToDos(tasks.getTaskCount() + 1));

                    System.out.println("Got it. I've added this task:");
                    System.out.println(tasks.getTask(tasks.getTaskCount() - 1).toString());
                    System.out.println("Now you have " + tasks.getTaskCount() + " tasks in your list");
                } else if (message.equals("deadline")) {
                    tasks.addTask(new Deadlines(tasks.getTaskCount() + 1));

                    System.out.println("Got it. I've added this task:");
                    System.out.println(tasks.getTask(tasks.getTaskCount() - 1).toString());
                    System.out.println("Now you have " + tasks.getTaskCount() + " tasks in your list");
                } else if (message.equals("event")) {
                    tasks.addTask(new Events(tasks.getTaskCount() + 1));

                    System.out.println("Got it. I've added this task:");
                    System.out.println(tasks.getTask(tasks.getTaskCount() - 1).toString());
                    System.out.println("Now you have " + tasks.getTaskCount() + " tasks in your list");
                } else if (message.equals("delete")) {
                    int index = readInt();
                    System.out.println("I've deleted this task:");
                    System.out.println(tasks.getTask(index - 1).toString());
                    System.out.println("Now you have " + tasks.getTaskCount() + " tasks in your list");

                    tasks.deleteTask(tasks.getTask(index - 1));
                } else {
                    System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
                try (FileWriter fw = new FileWriter(data_path.toString())) {
                    for (int i = 0; i < tasks.getTaskCount(); i++) {
                        fw.write(tasks.getTask(i).toString());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
