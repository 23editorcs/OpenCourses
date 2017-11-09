package model;

import java.util.ArrayList;
import java.util.List;

public class Transcript {
    private String studentName;
    private Integer studentID;

    /**
     * INVARIANT: course list and grade list are the same size
     * each course has a grade associated, and vice versa, at matching indeces
     */
    private List<String> courses;
    private List<Double> grades;

    public Transcript(String studentName, int  studentID) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.courses = new ArrayList<>();
        this.grades = new ArrayList<>();
    }

    public String getStudentName() {
        return studentName;
    }

    public void addGrade(String course, double grade) {
        // Require:
        // Modify: this
        // Affect: add a grade to a course
        courses.add(course);
        grades.add(grade);
    }

    public String getCourseAndGrade(String course) {
        // Require: nothing
        // Modify: nothing
        // Affect: return course name and grade in string
        int i = courses.indexOf(course);
        Double grade = grades.get(i);
        return (course + ": " + grade.toString());
    }

    public void printTranscript() {
        // Require: nothing
        // Modify: nothing
        // Affect: prints all the courses and grades
        System.out.print(studentName + ": ");

        courses.forEach((course) -> {
            System.out.print(getCourseAndGrade(course) + " ");
        });

        System.out.println("\n GPA: " + getGPA());
    }

    public double getGPA() {
        // Require: nothing
        // Modify: nothing
        // Affect: returns the average of all grades.
        double sum = 0;
        for(int i = 0; i < grades.size(); i++){
            sum += grades.get(i);
        }

        return sum / grades.size();
    }

    //TODO: specification
    //
    public double calculateAverage(List<Double> selectedGrades){
        return 0.0;
        //once you complete this method, figure out how to add it as a helper to getGPA()
    }

}
