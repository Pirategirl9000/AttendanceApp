package com.example;

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
        this.onTime = 0;
        this.late = 0;
        this.excused = 0;
        this.unexcused = 0;
    }

    public Student(int seat) throws java.lang.Exception {
        this();
        this.setSeat(seat);
    }

    public Student(int seat, String name) throws java.lang.Exception {
        this();
        this.setSeat(seat);
        this.setName(name);
    }

    public int getSeat() {
        return this.seat;
    }

    public String getName() {
        return this.name;
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

    public void setName(String name) throws Exception {
        name = name.trim();
        if (name.isBlank()) {
            throw new Exception("com.example.Student name cannot be blank");
        }
        this.name = name;
    }

    public void updateAttendance(int status) throws java.lang.Exception{
        switch (status) {
            case 1:
                //onTime
                this.onTime++;
                break;
            case 2:
                //late
                this.late++;
                break;

            case 3:
                //excused
                this.excused++;
                break;

            case 4:
                //unexcused
                this.unexcused++;
                break;

            default:
                throw new java.lang.Exception("Invalid attendance type: " + status);
        }
    }

    public void displayAttendance() {
        System.out.println("OnTime=" + this.onTime + ", Late=" + this.late + ", Excused=" + this.excused + ", Unexcused=" + this.unexcused);
}

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Student))
            return false;

        Student other = (Student)obj;

        return this.seat == other.getSeat();

    }

    @Override
    public String toString() {
        return seat + " " + name;
    }





}
