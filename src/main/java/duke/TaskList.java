package duke;

import java.util.ArrayList;

public class TaskList {

    private ArrayList<Task> tasks = new ArrayList<>();

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public Task getTask(int index) {
        return tasks.get(index);
    }

    /**
     * Marks a task as done.
     * @param index the index of the task to mark
    */
    public void markTask(int index) {
        tasks.get(index).mark();
    }

    /**
     * Adds a task to the list.
     * @param task the Task object to add
    */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Deletes a task from the list.
     * @param task the Task object to delete
    */
    public void deleteTask(Task task) {
        tasks.remove(task);
    }

    /**
     * Returns the number of tasks in the list.
     * @return the number of tasks
    */
    public int getTaskCount() {
        return tasks.size();
    }

    /**
     * Unmarks a task as not done.
     * @param index the index of the task to unmark
    */
    public void unmarkTask(int index) {
        tasks.get(index).unmark();
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < tasks.size(); i++) {
            result += (i + 1) + "." + tasks.get(i).toString() + "\n";
        }
        return result;
    }
}
