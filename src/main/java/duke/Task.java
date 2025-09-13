package duke;


public class Task extends Comparable<Task> {
    protected String task_name;
    protected Boolean marked = false;
    protected String type;

    public Task(String task_name, Boolean marked, String type) throws IllegalArgumentException {
        if(task_name.length() == 0) {
            throw new IllegalArgumentException("OOPS!!! The description of a task cannot be empty.");
        }
        this.task_name = task_name;
        this.marked = marked;
        this.type = type;
    }

    public Task(String task_name, Boolean marked) {
        this.task_name = task_name;
        this.marked = marked;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public Boolean getMarked() {
        return marked;
    }

    public void mark() {
        this.marked = true;
    }

    public void unmark() {
        this.marked = false;
    }

    public String getMarkedString() {
        if(this.marked) {
            return "[X]";
        } else {
            return "[]";
        }
    }

    public String getType() {
        return "[" + this.type + "]";
    }

    @Override
    public int compareTo(Task other) {
        return this.type.compareTo(other.type);
    }

    @Override
    public String toString() {
        return this.getType() + this.getMarkedString() + " " + this.task_name;
    }
}
