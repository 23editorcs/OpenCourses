package model;

import exceptions.CourseFullException;
import exceptions.GPATooLowException;
import exceptions.MissingPrereqException;
import exceptions.NoCoursesTakenException;

import java.util.ArrayList;
import java.util.List;

public class Transcript {

    private String name;
    private int year;
    private int id;
    private double gpa;
    private List<Course> currentCourses;
    private List<Course> pastCourses;

    public Transcript(String studentName, int academicYear, int studentID) {
        name = studentName;
        year = academicYear;
        id = studentID;
        currentCourses = new ArrayList<>();
        pastCourses = new ArrayList<>();
    }

    // getters
    public String getName() {
        return name;
    }

    public int getAcademicYear() {
        return year;
    }

    public int getId() {
        return id;
    }

    public List<Course> getCurrentCourses() {
        return currentCourses;
    }

    public List<Course> getPastCourses() {
        return pastCourses;
    }

    // EFFECTS: computes cGPA. In this case, we take it to mean that it is the total grades received so far, divided
    //          by the number of past courses taken
    public double computeGPA() throws NoCoursesTakenException {
        if (pastCourses.size() == 0) { throw new NoCoursesTakenException("The student has taken no courses at all."); }
        else {
            gpa = averagePer() / 20 - 1;
        }
        return gpa;
    }

    private double averagePer() {
        double total = 0.0;
        for (Course c : pastCourses) {
            total += c.getGrade();
        }
        return (total / pastCourses.size());
    }

    // REQUIRES: the GPA computed from the pastCourses field needs to be over 2.6 (out of 4.0 scale)
    // EFFECTS: promotes the student represented by the transcript
    //          to the next academic year if the REQUIRES clause is met, and return true
    //          else return false with no change to the year field
    public boolean promoteStudent() throws GPATooLowException, NoCoursesTakenException {
        gpa = computeGPA();
        if (gpa <= 2.6) { throw new GPATooLowException("The GPA of the student is not above 2.6."); }
        else {
            year++;
            return true;
        }
    }


    // MODIFIES: this
    // EFFECTS: adds the given course to the list of past courses and returns true,
    //          unless pastCourses contains given course, then does not add and returns false
    public boolean addToPastCourses(Course c) {
        if (pastCourses.contains(c)) {
            return false;
        }
        else {
            pastCourses.add(c);
            return true;
        }
    }

    // REQUIRES: this transcript must have all the necessary prerequisites in the pastCourses field
    //           The course you want to add must have space for more students to register
    // MODIFIES: this
    // EFFECTS: adds a course (c) into the record
    public boolean addCourse(Course course) throws MissingPrereqException, CourseFullException {
        // You have to realize that there are a number of cases that your code needs to consider. What if the course
        // you wish to add has no prerequisites? What if the course you want to add is already full?
        // Careful consideration of these cases will lead to code that is correct
        if (course.isCourseFull()) { throw new CourseFullException("So sorry! The course is full."); }
        else if (course.getPrereq().size() == 0) {
            currentCourses.add(course);
            course.addStudent();
            return true; }
        else {
            for (Course c : course.getPrereq()) {
                if (!pastCourses.contains(c)) {
                    throw new MissingPrereqException("The student hadn't taken the pre-required course: " + c.getName() + ".");
                }
            }
            currentCourses.add(course);
            course.addStudent();
            return true;
        }
    }


}