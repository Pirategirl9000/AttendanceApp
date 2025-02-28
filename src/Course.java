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

    public Student getStudent(int seat) throws Exception {
        int index = this.allStudents.indexOf(new Student(seat));

        if (index == -1)
            return null;
        else
            return this.allStudents.get(index);
    }

    public void addStudent(int seat, String name) throws Exception {
        Student student = getStudent(seat);
        if (student == null)
            allStudents.add(new Student(seat, name));
        else
            throw new Exception("Seat " + seat + " is already taken by " + student.getName() + "!");
    }
}
