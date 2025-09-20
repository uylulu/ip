package duke;

public class Parser {
    public Parser() {

    }

    public String parseAndRun(String message, TaskList tasks, UI ui, Storage storage) throws Exception {
        String type = message.split(" ")[0];

        String remaining = message.substring(type.length()).trim();

        if (type.equals("list")) {
            return ui.showTasks(tasks);

        } else if (type.equals("bye")) {
            return ui.showGoodbye();

        } else if (type.equals("mark")) {
            int x = Uy.readInt();
            tasks.markTask(x - 1);
            return ui.showMarkedTask(tasks.getTask(x - 1));

        } else if (type.equals("unmark")) {
            int x = Uy.readInt();
            tasks.unmarkTask(x - 1);
            return ui.showUnmarkedTask(tasks.getTask(x - 1));

        } else if (type.equals("todo")) {
            tasks.addTask(new ToDos(remaining));
            return ui.showAddTask(new ToDos(remaining), tasks);

        } else if (type.equals("deadline")) {
            tasks.addTask(new Deadlines(remaining));
            return ui.showAddTask(new Deadlines(remaining), tasks);

        } else if (type.equals("event")) {
            tasks.addTask(new Events(remaining));
            return ui.showAddTask(new Events(remaining), tasks);

        } else if (type.equals("delete")) {
            int index = Uy.readInt();
            String res = ui.showDeleteTask(tasks.getTask(index - 1), tasks);
            tasks.deleteTask(tasks.getTask(index - 1));
            return res;

        } else if (type.equals("find")) {
            String keyword = remaining;
            TaskList results = tasks.findTasks(keyword);
            return ui.showMatchingTasks(results);

        } else {
            return ui.showError("OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }
}
