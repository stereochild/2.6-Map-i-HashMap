package com.kodilla;

import java.lang.reflect.Array;
import java.util.*;

//HashMap key
public class Student {
    private Integer schoolDiaryNumber;
    private String firstName;
    private String lastName;

    public Student(Integer schoolDiaryNumber, String firstName, String lastName){
        this.schoolDiaryNumber = schoolDiaryNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        final Student e = (Student) o;
        return schoolDiaryNumber.equals(e.schoolDiaryNumber)
               && firstName.equals(e.firstName) && lastName.equals(e.lastName);
    }

    public int hashCode(){
        return schoolDiaryNumber;
    }

    public String toString(){
        return "(" + schoolDiaryNumber + ")" + " " + firstName + " " + lastName;
    }
}
//HashMap value
class StudentGrades {
    private List<Double> grades = new ArrayList<>();

    //pozwala podac dowolna liczbe elementow
    public StudentGrades(Double... grades){
        //zmiana tablicy na liste
        this.grades = Arrays.asList(grades);
    }

    double sum = 0;
    double average = 0;
    public double countAverage() {
        for(int i = 0; i <grades.size(); i++)
            sum += grades.get(i);
            average = sum / grades.size();

            return average;
    }
}

class AverageGradesHashMap {
    public static void main(String[] args) {

        Student firstStudent = new Student(5, "Andrzej", "Robak");
        Student secondStudent = new Student(13, "Janusz", "Polak");
        Student thirdStudent = new Student(26, "Anna", "Panna");
        Student fourthStudent = new Student (19,"Joanna", "Myszka");

        StudentGrades firstGrades = new StudentGrades(6.0, 5.5, 4.0, 4.0, 5.0, 3.5);
        StudentGrades secondGrades = new StudentGrades(2.0, 6.0, 3.0);
        StudentGrades thirdGrades = new StudentGrades(4.5, 3.0, 6.0, 5.0);
        StudentGrades fourthGrades = new StudentGrades(1.0, 3.0, 2.0, 3.0, 5.0, 6.0, 4.0, 1.0, 6.0);

        Map<Student, StudentGrades> studentGrades = new HashMap<>();
        studentGrades.put(firstStudent, firstGrades);
        studentGrades.put(secondStudent, secondGrades);
        studentGrades.put(thirdStudent, thirdGrades);
        studentGrades.put(fourthStudent, fourthGrades);

        for(Map.Entry<Student, StudentGrades> entry: studentGrades.entrySet()){
            System.out.println("Average grades of student: " + entry.getKey() + " is: "
                + entry.getValue().countAverage());
        }
    }
}