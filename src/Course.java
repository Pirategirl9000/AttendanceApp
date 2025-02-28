import java.util.ArrayList;
import java.util.List;

public class Course {
    private List<Student> allStudents;
    private String name;

    public Course() {
        this.name = null;
        this.allStudents = new ArrayList<Student>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) throws java.lang.Exception {
        name = name.trim();

        if (name.isEmpty()) {
            throw new java.lang.Exception("Name cannot be empty");
        }

        this.name = name;
    }
}
