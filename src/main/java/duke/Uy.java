package duke;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Uy {

    private TaskList tasks = new TaskList();
    private Storage storage;
    private UI ui = new UI();
    private Parser parser = new Parser();

    public static Scanner input = new Scanner(System.in);

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

    /**
     * Start the chat bot
    */
    public void run() {
        ui.showWelcome();
        while (true) {
            try {
                String message = readString();
                parser.parseAndRun(message, tasks, ui, storage);

                if(message.equals("bye")) {
                    break;
                }
            } catch (Exception e) {
                ui.showError(e.getMessage());
            }
        }
    }

    /**
     * Parses a date string into a LocalDate object.
     * @param date the date string to parse
     * @return the parsed LocalDate object
     */
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

    /**
     * Formats a LocalDate object into a string.
     * @param date the LocalDate object to format
     * @return the formatted date string
    */
    public static String format_date(LocalDate date) {
        return date.format(output_date_formatter);
    }

    /**
     * Reads a string from the user input.
     * @return the input string
    */  
    public static String readString() {
        return input.next();
    }

    /**
     * Reads an integer from the user input.
     * @return the input integer
    */  
    public static int readInt() {
        return input.nextInt();
    }

    public static void main(String[] args) {
        Uy uy = new Uy("data/Duke.txt");
        uy.run();
    }
}
