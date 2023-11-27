package model.service;

import model.dao.IStudentDao;
import model.dao.StudentDaoImpl;
import model.entity.Student;

import java.util.List;

public class StudentServiceIMPL implements IStudentService{
    IStudentDao studentDao = new StudentDaoImpl();
    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public boolean addOrEdit(Student student) {
        return studentDao.addOrEdit(student);
    }

    @Override
    public void delete(Integer integer) {
        studentDao.delete(integer);
    }

    @Override
    public Student findById(Integer integer) {
        return studentDao.findById(integer);
    }
}
