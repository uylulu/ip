package uy;

import java.util.ArrayList;

public class TaskList {

    private ArrayList<Task> tasks = new ArrayList<>();

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public TaskList findTasks(String keyword) {
        TaskList result = new TaskList();
        for(Task task : this.tasks) {
            if(task.getTask_name().contains(keyword)) {
                result.addTask(task);
            }
        }

        return result;
    }

    public Task getTask(int index) {
        return tasks.get(index);
    }

    /**
     * Marks the task at the given index as done.
     */
    public void markTask(int index) {
        assert (index >= 0 && index < tasks.size());
        tasks.get(index).mark();
    }

    /**
     * Adds a task to the task list and sorts the list.
     */
    public void addTask(Task task) {
        tasks.add(task);
        tasks.sort(null);
    }

    /**
     * Removes a task from the task list and sorts the list.
     */
    public void deleteTask(Task task) {
        tasks.remove(task);
        tasks.sort(null);
    }

    public int getTaskCount() {
        return tasks.size();
    }

    /**
     * Marks the task at the given index as not done.
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
