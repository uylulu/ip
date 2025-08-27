public class Task {
    private String task_name;
    private Boolean marked = false;
    private int index;

    public Task(String task_name, Boolean marked, int index) {
        this.task_name = task_name;
        this.marked = marked;
        this.index = index;
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

    @Override
    public String toString() {
        return this.index + "." + this.getMarkedString() + " " + this.task_name;
    }
}
