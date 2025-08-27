import java.util.regex.*;

public class Events extends Task {
    protected String from;
    protected String to;

    public Events(String task_name, int index, String from, String to) {
        super(task_name, false, index, "E");
        this.from = from;
        this.to = to;
    }

    public Events(int index) {
        super("", false, index, "E");
        String line = Uy.input.nextLine();

        Pattern pattern = Pattern.compile("^(.*?) /from (.*?) /to (.*)$");
        Matcher matcher = pattern.matcher(line);

        if(matcher.find()) {
            String task_name = matcher.group(1);
            String from = matcher.group(2);
            String to = matcher.group(3);
            this.task_name = task_name;
            this.from = from;
            this.to = to;
        } else {
            // TODO: NEED TO THROW ERROR
        }

        this.task_name = task_name;
    }

    @Override
    public String toString() {
        return super.toString() + " (from: " + from + " to: " + to + ")";
    }
}

