package com.example.crud.repository;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity //this annotation represent relational db tables
@Table(name = "users") //we are using this annotation for our table name, this annotation used when our table name is not the same with our class name
public class User {


    @Id //it is for our pm key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//its annotation says our hibernate , id is generating by db
    private Long id;
    //@Column(name = "name") //uses when db column name and model name is not same.
    private String name;
    private String email;
    @Column(name = "birth")
    private LocalDate birthday;
    private Integer age;//-128 -- 127

    public User(Long id, String name, String email, LocalDate birthday, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.age = age;
    }
    //empty constructor we need the for connection hibernate
    //withour empty constructor hibernate not working correctly
    public User(long l, String johnDoe, String mail, LocalDate localDate) {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", age=" + age +
                '}';
    }
}
