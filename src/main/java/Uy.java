
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Uy {

    private TaskList tasks = new TaskList();
    private Storage storage;
    private UI ui = new UI();

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
        ui.showWelcome();
        while (true) {
            try {
                String message = readString();
                if (message.equals("list")) {
                    ui.showTasks(tasks);
    
                } else if (message.equals("bye")) {
                    ui.showGoodbye();
                    break;

                } else if (message.equals("mark")) {
                    int x = readInt();
                    tasks.markTask(x - 1);
                    ui.showMarkedTask(tasks.getTask(x - 1));

                } else if (message.equals("unmark")) {
                    int x = readInt();
                    tasks.unmarkTask(x - 1);
                    ui.showUnmarkedTask(tasks.getTask(x - 1));
                    System.out.println(tasks.getTask(x - 1).toString());
    
                } else if (message.equals("todo")) {
                    tasks.addTask(new ToDos(Uy.input.nextLine().trim()));
                    ui.showAddTask(tasks.getTask(tasks.getTaskCount() - 1), tasks);

                } else if (message.equals("deadline")) {
                    tasks.addTask(new Deadlines(Uy.input.nextLine().trim()));
                    ui.showAddTask(tasks.getTask(tasks.getTaskCount() - 1), tasks);

                } else if (message.equals("event")) {
                    tasks.addTask(new Events(Uy.input.nextLine().trim()));
                    ui.showAddTask(tasks.getTask(tasks.getTaskCount() - 1), tasks);

                } else if (message.equals("delete")) {
                    int index = readInt();
                    ui.showDeleteTask(tasks.getTask(index - 1), tasks);
                    tasks.deleteTask(tasks.getTask(index - 1));

                } else {
                    ui.showError("OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
                
            } catch (Exception e) {
                ui.showError(e.getMessage());
            }
        }
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
