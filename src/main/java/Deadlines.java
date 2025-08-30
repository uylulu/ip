import java.time.LocalDate;
import java.util.regex.*;

public class Deadlines extends Task {
    protected LocalDate deadline;

    public Deadlines(int index) {
        super("Deadlines", false, index, "D");

        String line = Uy.input.nextLine();

        Pattern pattern = Pattern.compile("^(.*?) /by (.*?)$");
        Matcher matcher = pattern.matcher(line);

        if(matcher.find()) {
            String task_name = matcher.group(1);
            String deadline = matcher.group(2);
            this.task_name = task_name;
            this.deadline = Uy.parse_date(deadline);
        } else {
            // TODO: NEED TO THROW ERROR
        }

        this.task_name = task_name;
    }

    @Override
    public String toString() {
        return super.toString() + " (by: " + Uy.format_date(this.deadline) + ")";
    }
}