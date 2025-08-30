package duke;
import java.time.LocalDate;
import java.util.regex.*;

public class Events extends Task {
    protected LocalDate from;
    protected LocalDate to;

    /**
     * Constructor for Events
     * @param task_name of the event
     * @param from start date of the event
     * @param to end date of the event
    */ 
    public Events(String task_name, LocalDate from, LocalDate to) {
        super(task_name, false, "E");
        this.from = from;
        this.to = to;
    }

    /**
     * Constructor for Events
     * @param description of the event task with the following format: <task_name> /from <from_date> /to <to_date>
     */
    public Events(String description) throws IllegalArgumentException {
        super("Event", false, "E");

        Pattern user_input_pattern = Pattern.compile("^(.*?) /from (.*?) /to (.*)$");
        Matcher user_input_matcher = user_input_pattern.matcher(description);

        Pattern database_entry_pattern = Pattern.compile("^(.*?) \\(from: (.*?) to: (.*?)\\)$");
        Matcher database_entry_matcher = database_entry_pattern.matcher(description);

        if(user_input_matcher.find()) {
            String task_name = user_input_matcher.group(1);
            String from = user_input_matcher.group(2);
            String to = user_input_matcher.group(3);
            this.task_name = task_name;
            this.from = Uy.parse_date(from);
            this.to = Uy.parse_date(to);

        } else if (database_entry_matcher.find()){
            String task_name = database_entry_matcher.group(1);
            String from = database_entry_matcher.group(2);
            String to = database_entry_matcher.group(3);
            this.task_name = task_name;
            this.from = Uy.parse_date(from);
            this.to = Uy.parse_date(to);
        
        } else {
            throw new IllegalArgumentException("Invalid event format");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " (from: " + Uy.format_date(this.from) + " to: " + Uy.format_date(this.to) + ")";
    }
}

