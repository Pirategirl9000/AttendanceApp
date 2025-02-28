import java.util.ArrayList;
import java.util.List;

public class Course {
    private final List<Student> allStudents; //Made final since it can be
    private String name;

    public Course() {
        this.name = null;
        this.allStudents = new ArrayList<Student>();
    }

    public String getName() {
        return this.name;
    }

    public Student getStudent(int seat) throws Exception {
        int index = this.allStudents.indexOf(new Student(seat));

        if (index == -1)
            return null;
        else
            return this.allStudents.get(index);
    }

    public void setName(String name) throws java.lang.Exception {
        name = name.trim();

        if (name.isEmpty()) {
            throw new java.lang.Exception("Name cannot be empty");
        }

        this.name = name;
    }


    public void addStudent(int seat, String name) throws Exception {
        Student student = getStudent(seat);
        if (student == null)
            allStudents.add(new Student(seat, name));
        else
            throw new Exception("Seat " + seat + " is already taken by " + student.getName() + "!");
    }

    public void displaySummaryReport() {
        int late = 0;
        int onTime = 0;
        int excused = 0;
        int unexcused = 0;
        Student currentStudent;


        for (int i = 0; i < this.allStudents.size(); i++) {
            currentStudent = this.allStudents.get(i);
            late += currentStudent.getLate();
            onTime += currentStudent.getOnTime();
            excused += currentStudent.getExcused();
            unexcused += currentStudent.getUnexcused();
        }

        System.out.println("OnTime=" + onTime + ", Late=" + late + ", Excused=" + excused + ", Unexcused=" + unexcused);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
