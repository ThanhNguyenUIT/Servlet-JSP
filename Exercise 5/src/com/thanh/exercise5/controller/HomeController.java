package com.thanh.exercise5.controller;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HomeController", urlPatterns = {"/", "/home"})
public class HomeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletOutputStream out = response.getOutputStream();
        out.println("<html>\n" +
                "  <head>\n" +
                "    <title>Exercise 5</title>\n" +
                "      <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n" +
                "  </head>\n" +
                "  <body>\n" +
                "  <div class=\"container\">\n" +
                "      <div class=\"row\">\n" +
                "          <div class=\"col-md-offset-4 col-md-4\" style=\"margin-top: 50px; padding-top: 20px; border: 1px solid #cccccc;\">\n" +
                "              <form action=\"/upload\" method=\"post\" enctype=\"multipart/form-data\">\n" +
                "                  <div class=\"form-group\">\n" +
                "                      <input type=\"file\" name=\"file\">\n" +
                "                  </div>\n" +
                "\n" +
                "                  <button type=\"submit\" class=\"btn btn-default\">Submit</button>\n" +
                "              </form>\n" +
                "          </div>\n" +
                "      </div>\n" +
                "  </div>\n" +
                "  </body>\n" +
                "</html>\n");
        out.close();
    }
}
