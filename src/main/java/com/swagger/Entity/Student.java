package com.swagger.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;

    @Column(name = "student_name")
    protected String name;
    
    @Column(name = "student_email")
    protected String email;
    
    @Column(name = "student_city")
    protected String city;
    
    @Column(name = "student_age")
    protected Integer age;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", city=" + city + ", age=" + age + "]";
	}

    
}
