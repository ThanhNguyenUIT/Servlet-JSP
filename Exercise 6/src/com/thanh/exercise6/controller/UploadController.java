package com.thanh.exercise6.controller;

import com.thanh.Exercise1.Student;
import com.thanh.exercise6.service.FileService;
import com.thanh.exercise6.service.StudentService;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UploadController", urlPatterns = "/upload")
public class UploadController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletOutputStream out = response.getOutputStream();
        String fileUrl = FileService.storeFileUploaded(request);

        if (fileUrl.equals("")) {
            out.println("Fail!");
        } else {
            out.println("Upload Success!");
            List<Student> students = FileService.getListStudent(fileUrl);
            StudentService.insertStudents((ArrayList<Student>) students);
        }
    }
}
