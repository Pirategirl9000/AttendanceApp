
// Not sure what you meant by (package private) Course section1 in your documentation. I assume you want us to import things as a package
// so that is what we did, as far as I know it wouldn't be necessary since they could all go in the default package and there would be no need for importing packages
import com.example.Input;
import com.example.Course;

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
        section1.setName(Input.getLine("Enter Section 2's Course Name: "));
    }

    private void setupStudents(Course course) throws Exception {
        while (true) {
            String name = Input.getLine("Enter " + course.getName() + " Student Name: ");

            if (name.equalsIgnoreCase("q")) {
                break;
            }

            int seat = Input.getIntRange("Enter the Seat Number for " + name + ": ", 0, Integer.MAX_VALUE);

            course.addStudent(seat, name);
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

            switch (response) {
                case 0:
                    return;
                case 1:
                    break; //REMOVE LATER
            }




        }
    }


}
