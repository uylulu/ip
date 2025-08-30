
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Uy {

    private static String lines = "---------------------------------------";
    private TaskList tasks = new TaskList();
    private Storage storage;

    public static Scanner input = new Scanner(System.in);

//  DATE FORMATING
    private static final DateTimeFormatter date_formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter output_date_formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");

    public Uy(String filePath) {
        this.storage = new Storage(filePath);

        try {
            this.tasks = storage.loadTasks();
        } catch (Exception e) {
            e.printStackTrace();
            this.tasks = new TaskList();
        }
    }

    public void run() {
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
                    tasks.addTask(new ToDos(Uy.input.nextLine().trim()));

                    System.out.println("Got it. I've added this task:");
                    System.out.println(tasks.getTask(tasks.getTaskCount() - 1).toString());
                    System.out.println("Now you have " + tasks.getTaskCount() + " tasks in your list");
                } else if (message.equals("deadline")) {
                    tasks.addTask(new Deadlines(Uy.input.nextLine().trim()));

                    System.out.println("Got it. I've added this task:");
                    System.out.println(tasks.getTask(tasks.getTaskCount() - 1).toString());
                    System.out.println("Now you have " + tasks.getTaskCount() + " tasks in your list");
                } else if (message.equals("event")) {
                    tasks.addTask(new Events(Uy.input.nextLine().trim()));

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
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void print(String s) {
        System.out.println(lines);
        System.out.println(s);
    }

    public static LocalDate parse_date(String date) {
        try {
            return LocalDate.parse(date, date_formatter);
        } catch (DateTimeParseException e) {
            return LocalDate.parse(date, output_date_formatter);
        } catch (Exception e) {
            System.err.println("Error parsing date: " + e.getMessage());
        }
        return null;
    }

    public static String format_date(LocalDate date) {
        return date.format(output_date_formatter);
    }

    public String readString() {
        return input.next();
    }

    public int readInt() {
        return input.nextInt();
    }

    public static void main(String[] args) {
        Uy uy = new Uy("data/Duke.txt");
        uy.run();
    }
}
