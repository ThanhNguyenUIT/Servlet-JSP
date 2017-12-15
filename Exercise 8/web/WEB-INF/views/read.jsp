<%@ page import="com.thanh.Exercise1.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Read</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <meta charset="UTF-8">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-offset-4 col-md-4" style="margin-top: 50px; padding-top: 20px; border: 1px solid #cccccc;">
            <div>
                ${isReadable}
            </div>
            <%
                ArrayList<Student> students = (ArrayList<Student>) request.getAttribute("students");
                for(Student student : students){
            %>
            <div>
                <%= student.toString() %>
            </div>
            <%
                }
            %>
        </div>
    </div>
</div>
</body>
</html>