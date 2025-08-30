import java.nio.file.Path;
import java.nio.file.Paths;

public class Storage {
    private static final String home = System.getProperty("user.home");
    private static final String project_dir = java.nio.file.Paths.get(home, "OneDrive", "Desktop", "CS2103T", "ip", "src").toString();
    private static Path data_path;

    public Storage(String file_path) {
        data_path = Paths.get(project_dir, file_path);
    }

}
