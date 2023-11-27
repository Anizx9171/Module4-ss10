package controller;

import model.dao.StudentDaoImpl;
import model.entity.Student;
import model.service.IStudentService;
import model.service.StudentServiceIMPL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "StudentController", value = "/student")
public class StudentController extends HttpServlet {
    private final IStudentService studentService = new StudentServiceIMPL();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            showTable(request, response);
        } else {
            switch (action) {
                case "add":
                    response.sendRedirect("views/AddTable.jsp");
                    break;
                case "edit":
                    int idEdit = Integer.parseInt(request.getParameter("id"));
                    request.setAttribute("id",idEdit);
                    request.getRequestDispatcher("views/editTable.jsp").forward(request,response);
                    break;
                case "delete":
                    int idDelete = Integer.parseInt(request.getParameter("id"));
                    studentService.delete(idDelete);
                    showTable(request, response);
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            showTable(request, response);
        } else {
            switch (action) {
                case "add":
                    addStudent(request,response);
                    break;
                case "edit":
                    editStudent(request,response);
                    break;
            }
        }
    }

    private void editStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int studentId = Integer.parseInt(request.getParameter("id"));
        String studentName = request.getParameter("name");
        String studentEmail = request.getParameter("email");
        String studentAddress = request.getParameter("address");
        Date studentBirthDate = Date.valueOf(request.getParameter("date"));
        Student student = new Student(studentId,studentName,studentAddress,studentBirthDate,studentEmail);
        studentService.addOrEdit(student);
        showTable(request, response);
    }

    private void addStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    String studentName = request.getParameter("name");
    String studentEmail = request.getParameter("email");
    String studentAddress = request.getParameter("address");
    Date studentBirthDate = Date.valueOf(request.getParameter("date"));
        System.out.println(studentBirthDate);
    Student student = new Student();
    student.setStudentEmail(studentEmail);
    student.setStudentAddress(studentAddress);
    student.setStudentBirthdate(studentBirthDate);
    student.setStudentName(studentName);
    studentService.addOrEdit(student);
    showTable(request, response);
    }


    private void showTable(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = studentService.findAll();
        request.setAttribute("students",students);
        request.getRequestDispatcher("views/table.jsp").forward(request,response);
    }
}