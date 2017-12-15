package com.thanh.exercise6.controller;

import com.thanh.Exercise1.Student;
import com.thanh.exercise6.service.StudentService;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ReadController", urlPatterns = "/read")
public class ReadController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletOutputStream out = response.getOutputStream();

        List<Student> students = StudentService.readStudents();

        for (Student student : students) {
            System.out.println(student.toString());
        }

        out.println("Read Success!");
    }
}
