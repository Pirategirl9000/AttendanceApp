public class Student {
    private int seat;
    private String name;
    private int onTime;
    private int late;
    private int excused;
    private int unexcused;

    private Student() {
        this.seat = 0;
        this.name = "?";
    }

    public Student(int seat) throws java.lang.Exception {
        this();
    }

    public Student(int seat, String name) throws java.lang.Exception{
        this();

    }

    public int getSeat() {
        return this.seat;
    }

    public int getOnTime() {
        return this.onTime;
    }

    public int getLate() {
        return this.late;
    }

    public int getExcused() {
        return this.excused;
    }

    public int getUnexcused() {
        return this.unexcused;
    }

    public void setSeat(int seat) throws Exception {
        if (seat < 0) {
            throw new Exception("Seat cannot be negative");
        }
        this.seat = seat;
    }

    public void setName(String name) throws Exception{
        name = name.trim();
        if (name.isBlank()) {
            throw new Exception("Student name cannot be blank");
        }
        this.name = name;
    }

    public void updateAttendance(int type) {

    }

    public void displayAttendance() {

    }

    @Override
    public boolean equals(Object obj) {

    }

    @Override
    public String toString() {

    }




}
