package duke;

public class Parser {
    public Parser() {

    }

    /**
     * Parses the user input and executes the corresponding command.
     * 
     * @param message the user input
     * @param tasks the TaskList object that stores the tasks
     * @param ui the UI object that handles the user interface
     * @param storage the Storage object that handles data storage
    */ 
    public void parseAndRun(String message, TaskList tasks, UI ui, Storage storage) throws Exception {
        if (message.equals("list")) {
            ui.showTasks(tasks);

        } else if (message.equals("bye")) {
            ui.showGoodbye();

        } else if (message.equals("mark")) {
            int x = Uy.readInt();
            tasks.markTask(x - 1);
            ui.showMarkedTask(tasks.getTask(x - 1));

        } else if (message.equals("unmark")) {
            int x = Uy.readInt();
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
            int index = Uy.readInt();
            ui.showDeleteTask(tasks.getTask(index - 1), tasks);
            tasks.deleteTask(tasks.getTask(index - 1));

        } else {
            ui.showError("OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }
}
