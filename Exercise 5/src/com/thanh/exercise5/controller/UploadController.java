package com.thanh.exercise5.controller;

import com.thanh.Exercise1.FileUtils;
import com.thanh.Exercise1.Student;
import com.thanh.exercise5.service.FileService;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@WebServlet(name = "UploadController", urlPatterns = "/upload")
public class UploadController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletOutputStream out = response.getOutputStream();
        String fileUrl = FileService.storeFileUploaded(request, response);

        if (fileUrl.equals("")) {
            out.println("Fail!");
        } else {
            out.println("Upload Success!");

            List<Student> students = FileUtils.getListStudent(fileUrl);

            for (Student student : students) {
                System.out.println(student.toString());
            }
        }
    }
}
