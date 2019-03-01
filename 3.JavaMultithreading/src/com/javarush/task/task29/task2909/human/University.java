package com.javarush.task.task29.task2909.human;

import java.util.LinkedList;
import java.util.List;

public class University{
    private List<Student> students = new LinkedList<>();
    private String name;
    private int age;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        for (Student student: students) {
            if(student.getAverageGrade() == averageGrade) return student;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        Student student1 = null;
        Student student2 = null;

        for (Student student: students) {
            if(student1 == null){
                student1 = student;
                continue;
            }else if(student1 != null){
                student2 = student;
            }

            if((student1 != null && student2 != null) && (student1.getAverageGrade() < student2.getAverageGrade()) ){
                student1 = student2;
            }
        }
        return student1;
    }

    public Student getStudentWithMinAverageGrade() {
        Student student1 = null;
        Student student2 = null;

        for (Student student: students) {
            if(student1 == null){
                student1 = student;
                continue;
            }else if(student1 != null){
                student2 = student;
            }

            if((student1 != null && student2 != null) && (student1.getAverageGrade() > student2.getAverageGrade()) ){
                student1 = student2;
            }
        }
        return student1;
    }

    public void expel(Student student){
        students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}