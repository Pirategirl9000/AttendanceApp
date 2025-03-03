package com.example;

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

        for (Student currentStudent : this.allStudents) {
            late += currentStudent.getLate();
            onTime += currentStudent.getOnTime();
            excused += currentStudent.getExcused();
            unexcused += currentStudent.getUnexcused();
        }

        System.out.println("OnTime=" + onTime + ", Late=" + late + ", Excused=" + excused + ", Unexcused=" + unexcused);
    }

    public void displayDetailReport() {
        int totalLate = 0;
        int totalOnTime = 0;
        int totalExcused = 0;
        int totalUnexcused = 0;

        for (Student currentStudent : this.allStudents) {
            totalLate += currentStudent.getLate();
            totalOnTime += currentStudent.getOnTime();
            totalExcused += currentStudent.getExcused();
            totalUnexcused += currentStudent.getUnexcused();
        }


        // Total Header
        System.out.println(this.name + ": " + "OnTime=" + totalOnTime + " Late=" + totalLate + " Excused=" + totalExcused + " Unexcused=" + totalUnexcused);

        System.out.printf("%-4s %-15s %-6s %-4s %-7s %-9s\n", "Seat", "Name", "OnTime", "Late", "Excused", "Unexcused");
        System.out.println("==== =============== ====== ==== ======= =========");

        for (Student currentStudent : this.allStudents) {
            System.out.printf("%-4d %-15s %-6d %-4d %-7d %-9d \n", currentStudent.getSeat(), currentStudent.getName(), currentStudent.getOnTime(), currentStudent.getLate(), currentStudent.getExcused(), currentStudent.getUnexcused());
        }

    }

    @Override
    public String toString() {
        return this.name;
    }
}
