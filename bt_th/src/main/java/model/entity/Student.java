package model.entity;

import java.sql.Date;

public class Student {
   private int studentId;
    private String studentName;
    private String studentAddress;
    private Date studentBirthdate;
    private String studentEmail;

    public Student() {
    }

    public Student(int studentId, String studentName, String studentAddress, Date studentBirthdate, String studentEmail) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.studentBirthdate = studentBirthdate;
        this.studentEmail = studentEmail;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public Date getStudentBirthdate() {
        return studentBirthdate;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public void setStudentBirthdate(Date studentBirthdate) {
        this.studentBirthdate = studentBirthdate;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }
}
