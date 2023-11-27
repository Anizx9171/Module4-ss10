package model.dao;

import model.entity.Student;
import utils.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements IStudentDao{
    @Override
    public List<Student> findAll() {
        Connection connection = null;
        List<Student> students = new ArrayList<>();
        try {
            connection = ConnectionDB.openDB();
            CallableStatement statement = connection.prepareCall("{CALL SHOW_STUDENT}");
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getDate("birthdate"),
                        rs.getString("email"));
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeDB(connection);
        }
        return students;
    }

    @Override
    public boolean addOrEdit(Student student) {
        Connection connection = null;
        int rs;
        try {
            connection = ConnectionDB.openDB();
            if (findById(student.getStudentId()) == null){
                CallableStatement statement = connection.prepareCall("{CALL ADD_STUDENT(?,?,?,?)}");
                statement.setString(1, student.getStudentName());
                statement.setString(2, student.getStudentEmail());
                statement.setDate(3, student.getStudentBirthdate());
                statement.setString(4, student.getStudentAddress());
                rs = statement.executeUpdate();
            }else {
                CallableStatement statement = connection.prepareCall("{CALL EDIT_STUDENT(?,?,?,?,?)}");
                statement.setInt(1, student.getStudentId());
                statement.setString(2, student.getStudentName());
                statement.setString(3, student.getStudentEmail());
                statement.setDate(4, student.getStudentBirthdate());
                statement.setString(5, student.getStudentAddress());
                rs = statement.executeUpdate();
            }
            if (rs > 0){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeDB(connection);
        }
        return false;
    }

    @Override
    public void delete(Integer integer) {
        Connection connection = null;
        try {
            connection = ConnectionDB.openDB();
            CallableStatement statement = connection.prepareCall("{CALL DELETE_STUDENT(?)}");
            statement.setInt(1, integer);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeDB(connection);
        }
    }

    @Override
    public Student findById(Integer integer) {
        List<Student> students = findAll();
        for (Student student:students) {
            if (student.getStudentId() == integer){
                return student;
            }
        }
        return null;
    }
}
