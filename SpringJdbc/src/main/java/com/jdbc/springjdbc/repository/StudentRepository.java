package com.jdbc.springjdbc.repository;

import com.jdbc.springjdbc.model.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class StudentRepository
{
    private JdbcTemplate jdbcTemplate;
    private RowMapper<Student> rowMapper = new BeanPropertyRowMapper<>(Student.class);  // advance no need to map manuly like rowmapper

   //private StudentRowMapper rowmapper=new StudentRowMapper(); // you can use this when variable name diff in maprow
    StudentRepository(JdbcTemplate jdbcTemplate) {
                this.jdbcTemplate=jdbcTemplate;
            }

    public void createStudent(Student student) {
        String sql= """
                          INSERT INTO student (name,email,age)
                          VALUES (?,?,?)
                          """;

        int res=jdbcTemplate.update(sql,student.getName(),student.getEmail(),student.getAge());

            if(res==1)
            {
                System.out.println("Successfully inserted into students");
            }
            else
            {
                System.out.println("Failed to insert into students");
            }
        }

    public List<Student> getStudent() {
        String sql= """
                          SELECT id,name,email,age FROM student;
                    """;
        List<Student> students=jdbcTemplate.query(sql, rowMapper);
        return students;
    }

    public Student getById(Long id) {
        String sql= """
                    SELECT name,email,age,id
                    FROM student
                    WHERE id=?
                    """;
        Student student=jdbcTemplate.queryForObject(sql, rowMapper, id); // rowmapper object to map krta h student
        if(student==null)
        {
            System.out.println("No student with id="+id);
        }
        else
        {
            System.out.println("Found student with id="+id);
        }
        return student;
    }

    public void deleteStudent(Long id) {
        String sql= """
                delete from student where id=?
                """;

        int res=jdbcTemplate.update(sql,id);
        if(res==1)
        {
            System.out.println("Successfully deleted student");

        }
        else
        {
            System.out.println("Failed to deleted student");
        }
    }

    public void updateStudent(Student student,Long id) {
        String sql = """
                 UPDATE student
                 SET name = ?,
                     email = ?,
                     age = ?
                 WHERE id = ?
                 """;

        int res=jdbcTemplate.update(sql,
                student.getName(),
                student.getEmail(),
                student.getAge(),id);
        if(res==1)
        {
            System.out.println("Successfully updated student");
        }

        else
        {
            System.out.println("Failed to updated student");
        }
    }
}

