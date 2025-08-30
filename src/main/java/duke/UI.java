package duke;
public class UI {
    private String lines = "---------------------------------------";

    public UI() {

    }

    public void showWelcome() {
        System.out.println("Hello I'm Uy, what can I do for you?");
    }

    public void showGoodbye() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    public void showLoadingError() {
        System.out.println("Error loading tasks. Please try again.");
    }

    public void showTasks(TaskList tasks) {
        System.out.println("Here are the tasks in your list:");
        System.out.println(tasks.toString());
        System.out.println(lines);
    }

    public void showMatchingTasks(TaskList tasks) {
        System.out.println("Here are the matching tasks in your list:");
        System.out.println(tasks.toString());
    }

    public void showMarkedTask(Task task) {
        System.out.println("Nice, I have marked this task as done:");
        System.out.println(task.toString());
    }

    public void showUnmarkedTask(Task task) {
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println(task.toString());
    }

    public void showAddTask(Task task, TaskList tasks) {
        System.out.println("Got it. I've added this task:");
        System.out.println(task.toString());
        System.out.println("Now you have " + tasks.getTaskCount() + " tasks in your list");
    }

    public void showDeleteTask(Task task, TaskList tasks) {
        System.out.println("I've deleted this task:");
        System.out.println(task.toString());
        System.out.println("Now you have " + tasks.getTaskCount() + " tasks in your list");
    }

    public void showError(String errorMessage) {
        System.out.println("Error: " + errorMessage);
    }

}
