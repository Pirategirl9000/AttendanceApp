
// Not sure what you meant by (package private) Course section1 in your documentation. I assume you want us to import things as a package
// so that is what we did, as far as I know it wouldn't be necessary since they could all go in the default package and there would be no need for importing packages
import com.example.*;

public class AttendanceApp {
    private static final String DOUBLE_DASH_LINE = String.format("%50s","").replace(" ", "=");
    private static final String SINGLE_DASH_LINE = DOUBLE_DASH_LINE.replace("=","-");
    private Course section1;
    private Course section2;

    public AttendanceApp() {
        section1 = new Course();
        section2 = new Course();
    }

    private void displayAppHeading() {
        System.out.println(DOUBLE_DASH_LINE);
        System.out.println("Welcome to the Attendance App");
        System.out.println(DOUBLE_DASH_LINE);
    }

    private void setupCourses() throws Exception {
        section1.setName(Input.getLine("Enter Section 1's Course Name: "));
        setupStudents(section1);
        section2.setName(Input.getLine("Enter Section 2's Course Name: "));
        setupStudents(section2);
    }

    private void setupStudents(Course course) throws Exception {
        while (true) {
            String name = Input.getLine("Enter " + course.getName() + " Student Name or 'q' to quit: ");

            if (name.equalsIgnoreCase("q")) {
                break;
            }

            int seat = Input.getIntRange("Enter the Seat Number for " + name + ": ", 1, Integer.MAX_VALUE);

            try {
                course.addStudent(seat, name);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Unable to add student");
            }
        }
    }

    private void studentAttendance(Student student) throws Exception {
        System.out.println(SINGLE_DASH_LINE);
        System.out.println("Enter #" + student.getSeat() + " " + student.getName() + " Attendance: ");
        System.out.println(SINGLE_DASH_LINE);

        System.out.println("1 = On Time");
        System.out.println("2 = Late");
        System.out.println("3 = Excused");
        System.out.println("4 = Unexcused");
        System.out.println(SINGLE_DASH_LINE);

        int status = Input.getIntRange("Enter Status: ", 1, 4);
        student.updateAttendance(status);
    }

    private void courseAttendance(Course course) throws Exception {
        int seatNumber;
        Student student;

        while (true) {
            seatNumber = Input.getIntRange("Enter " + course.getName() + "'s Student seat or 0 to quit: ", 0, Integer.MAX_VALUE);

            if (seatNumber == 0) {
                return;
            }

            student = course.getStudent(seatNumber);

            if (student == null) {
                System.out.println("Invalid seat, please try again!");
                continue;
            }

            this.studentAttendance(student);
        }
    }

    private void mainMenu() throws Exception {
        int response;

        while (true) {
            System.out.println(SINGLE_DASH_LINE);
            System.out.println("Main Menu");
            System.out.println(SINGLE_DASH_LINE);

            System.out.println("0 = End Attendance App");
            System.out.println("1 = Take 9:00 am Attendance");
            System.out.println("2 = Take 10:00 am Attendance");
            System.out.println("3 = Display Attendance Report");

            System.out.println(SINGLE_DASH_LINE);
            response = Input.getIntRange("Menu Choice: ", 0, 3);
            System.out.println(SINGLE_DASH_LINE);

            switch (response) {
                case 0:
                    return;
                case 1:
                    this.courseAttendance(section1);
                    break;
                case 2:
                    this.courseAttendance(section2);
                    break;
                case 3:
                    section1.displayDetailReport();
                    section2.displayDetailReport();
                    break;
            }






        }
    }

    public static void main(String[] args) throws Exception {
        AttendanceApp app = new AttendanceApp();
        app.displayAppHeading();

        // Setup App
        app.setupCourses();

        // Loops until QUIT
        app.mainMenu();
    }
}
