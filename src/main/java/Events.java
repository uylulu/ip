import java.time.LocalDate;
import java.util.regex.*;

public class Events extends Task {
    protected LocalDate from;
    protected LocalDate to;

    public Events(String task_name, int index, LocalDate from, LocalDate to) {
        super(task_name, false, index, "E");
        this.from = from;
        this.to = to;
    }

    public Events(int index) {
        super("Event", false, index, "E");
        String line = Uy.input.nextLine();

        Pattern pattern = Pattern.compile("^(.*?) /from (.*?) /to (.*)$");
        Matcher matcher = pattern.matcher(line);

        if(matcher.find()) {
            String task_name = matcher.group(1);
            String from = matcher.group(2);
            String to = matcher.group(3);
            this.task_name = task_name;
            this.from = Uy.parse_date(from);
            this.to = Uy.parse_date(to);
        } else {
            // TODO: NEED TO THROW ERROR
        }

        this.task_name = task_name;
    }

    @Override
    public String toString() {
        return super.toString() + " (from: " + Uy.format_date(this.from) + " to: " + Uy.format_date(this.to) + ")";
    }
}

