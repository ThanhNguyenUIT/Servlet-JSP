package com.thanh.exercise8.service;

import com.thanh.Exercise1.Student;
import com.thanh.exercise8.persistence.StudentDao;

import java.util.ArrayList;

public class StudentService {
    public static void insertStudents(ArrayList<Student> students){
        StudentDao.insertStudents(students);
    }

    public static ArrayList<Student> readStudents(){
        return StudentDao.readStudents();
    }
}
