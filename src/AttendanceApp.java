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

    private void setUpCourses() {

    }
}
