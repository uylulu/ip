package duke;
public class UI {
    private String lines = "---------------------------------------";

    public UI() {

    }

    public String showWelcome() {
        return "Hello I'm Uy, what can I do for you?";
    }

    public String showGoodbye() {
        return "Bye. Hope to see you again soon!";
    }

    public String showLoadingError() {
        return "Error loading tasks. Please try again.";
    }

    public String showTasks(TaskList tasks) {
        return "Here are the tasks in your list:\n"
                + tasks.toString() + "\n"
                + lines;
    }

    public String showMatchingTasks(TaskList tasks) {
        return "Here are the matching tasks in your list:\n"
                + tasks.toString();
    }

    public String showMarkedTask(Task task) {
        return "Nice, I have marked this task as done:\n"
                + task.toString();
    }

    public String showUnmarkedTask(Task task) {
        return "OK, I've marked this task as not done yet:\n"
                + task.toString();
    }

    public String showAddTask(Task task, TaskList tasks) {
        return "Got it. I've added this task:\n"
                + task.toString() + "\n"
                + "Now you have " + tasks.getTaskCount() + " tasks in your list";
    }

    public String showDeleteTask(Task task, TaskList tasks) {
        return "I've deleted this task:\n"
                + task.toString() + "\n"
                + "Now you have " + tasks.getTaskCount() + " tasks in your list";
    }

    public String showError(String errorMessage) {
        return "Error: " + errorMessage;
    }

}
