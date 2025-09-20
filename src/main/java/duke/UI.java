package duke;
public class UI {
    private String lines = "---------------------------------------";

    public UI() {

    }

    public String showWelcome() {
        return "Welcome, I am Uy—your Zen Productivity Coach. Take a deep breath, and let’s begin your mindful journey.";
    }

    public String showGoodbye() {
        return "Farewell for now. Remember: progress is a path, not a race. Be kind to yourself.";
    }

    public String showLoadingError() {
        return "Hmm, a ripple in the pond. I couldn’t load your tasks. Let’s try again, calmly.";
    }

    public String showTasks(TaskList tasks) {
        return "Here are your pebbles for today:\n"
                + tasks.toString() + "\n"
                + "(Remember: move one pebble at a time.)\n"
                + lines;
    }

    public String showMatchingTasks(TaskList tasks) {
        return "These tasks align with your current path:\n"
                + tasks.toString();
    }

    public String showMarkedTask(Task task) {
        return "Another pebble moved. Well done.\n"
                + task.toString();
    }

    public String showUnmarkedTask(Task task) {
        return "This pebble is back on your path. Every journey has its turns.\n"
                + task.toString();
    }

    public String showAddTask(Task task, TaskList tasks) {
        return "A new pebble on your path:\n"
                + task.toString() + "\n"
                + "Now you have " + tasks.getTaskCount() + " pebbles to move. Walk gently.";
    }

    public String showDeleteTask(Task task, TaskList tasks) {
        return "Letting go is part of the journey:\n"
                + task.toString() + "\n"
                + "Now you have " + tasks.getTaskCount() + " pebbles remaining.";
    }

    public String showError(String errorMessage) {
        return "Even the calmest pond has ripples: '" + errorMessage + "'. Lets try again, mindfully.";
    }

}
