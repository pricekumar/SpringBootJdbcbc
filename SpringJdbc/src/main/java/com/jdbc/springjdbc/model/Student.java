package com.jdbc.springjdbc.model;

public class Student {
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String name;
    private String email;
    private int age;

    public Student ()
    {

    }

    public Student( String name, String email,int age) {
        this.age = age;
        this.email = email;
        this.name = name;
    }

    @Override
    public String toString() { //proide by println
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emial='" + email + '\'' +
                ", age=" + age +
                '}';
    }



}