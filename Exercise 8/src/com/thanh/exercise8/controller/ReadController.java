package com.thanh.exercise8.controller;

import com.thanh.Exercise1.Student;
import com.thanh.exercise8.service.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ReadController", urlPatterns = "/read")
public class ReadController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = StudentService.readStudents();

        if(students != null){
            request.setAttribute("students", students);
            request.setAttribute("isReadable", "Read Data Success!");
        } else {
            request.setAttribute("isReadable", "Read Fail!");
        }

        RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/read.jsp");
        requestDispatcher.forward(request, response);
    }
}
