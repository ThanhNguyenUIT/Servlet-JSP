package com.thanh.exercise8.controller;

import com.thanh.Exercise1.FileUtils;
import com.thanh.Exercise1.Student;
import com.thanh.Exercise2.DatabaseUtils;
import com.thanh.exercise8.service.FileService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UploadController", urlPatterns = "/upload")
public class UploadController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileUrl = FileService.storeFileUploaded(request, response);

        if (fileUrl.equals("")) {
            request.setAttribute("isStored", "Fail!");
        } else {
            request.setAttribute("isStored", "Upload Success!");

            List<Student> students = FileUtils.getListStudent(fileUrl);

            DatabaseUtils.insertStudents((ArrayList<Student>) students);
        }
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/upload.jsp");
        dispatcher.forward(request, response);
    }
}
