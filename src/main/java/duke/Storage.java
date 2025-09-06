package duke;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Storage {
    private final String home = System.getProperty("user.home");
    private final String project_dir = java.nio.file.Paths.get(home, "OneDrive", "Desktop", "CS2103T", "ip", "src").toString();
    private Path data_path;

    public Storage(String file_path) {
        this.data_path = Paths.get(project_dir, file_path);
    }

    public void writeTasks(TaskList tasks) {
        try (FileWriter fw = new FileWriter(data_path.toString())) {
            for (int i = 0; i < tasks.getTaskCount(); i++) {
                fw.write(tasks.getTask(i).toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Task parseTask(String line) throws UnknownTaskError {
        String type = line.substring(1, 2);
        String description = line.substring(6, line.length()).trim();

        if(type.length() <= 0 || description.length() <= 0) {
            throw new UnknownTaskError("Error: Invalid task format");
        }
        Task newTask;

        if(type.equals("T")) {
            newTask = new ToDos(description);
        } else if(type.equals("E")) {
            newTask = new Events(description);
        } else if(type.equals("D")) {
            newTask = new Deadlines(description);
        } else {
            throw new UnknownTaskError("Error: Unknown task type");
        }

        return newTask;
    }

    public TaskList loadTasks() throws IOException {
        try {
            List<String> lines = Files.readAllLines(data_path);
            TaskList tasks = new TaskList();
            for (String line : lines) {
                // Parse each line and add the task to the TaskList
                Task task = this.parseTask(line);
                tasks.addTask(task);
            }
            return tasks;
        } catch (UnknownTaskError e) {
            throw new IOException("Error loading tasks from file", e);
        }
    }
}
