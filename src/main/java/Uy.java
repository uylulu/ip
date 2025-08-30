import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.*;
import java.io.FileWriter;

public class Uy {
    private static String lines = "---------------------------------------";
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static int count = -1;
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
                if(message.equals("list")) {
                    System.out.println("Here are the tasks in your list:");
                    for(int i = 0;i <= count;i++) {
                        System.out.println((i + 1) + "." + tasks.get(i).toString());
                    }
                    System.out.println(lines);

                } else if(message.equals("bye")) {
                    print("Bye. Hope to see you again soon!");
                    break;
                } else if(message.equals("mark")) {
                    int x = readInt();
                    tasks.get(x - 1).mark();
                    System.out.println("Nice, I have marked this task as done:");
                    System.out.println(tasks.get(x - 1).toString());
                } else if(message.equals("unmark")) {
                    int x = readInt();
                    tasks.get(x - 1).unmark();
                    System.out.println("OK, I've marked this task as not done yet:");
                    System.out.println(tasks.get(x - 1).toString());
                } else if(message.equals("todo")) {
                    count++;
                    tasks.add(new ToDos(count));

                    System.out.println("Got it. I've added this task:");
                    System.out.println(tasks.get(count).toString());
                    System.out.println("Now you have " + (count + 1) + " tasks in your list:");
                } else if(message.equals("deadline")) {
                    count++;
                    tasks.add(new Deadlines(count));

                    System.out.println("Got it. I've added this task:");
                    System.out.println(tasks.get(count).toString());
                    System.out.println("Now you have " + (count + 1) + " tasks in your list:");
                } else if(message.equals("event")) {
                    count++;
                    tasks.add(new Events(count));

                    System.out.println("Got it. I've added this task:");
                    System.out.println(tasks.get(count).toString());
                    System.out.println("Now you have " + (count + 1) + " tasks in your list:");
                } else if(message.equals("delete")) {
                    int index = readInt();
                    System.out.println("I've deleted this task:");
                    System.out.println(tasks.get(index).toString());
                    System.out.println("Now you have " + (count) + " tasks in your list:");

                    tasks.remove(index - 1);
                    count--;

                } else {
                    System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
                try (FileWriter fw = new FileWriter(data_path.toString())) {
                    for(int i = 0;i <= count;i++) {
                        fw.write(tasks.get(i).toString());
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
