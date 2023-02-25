package org.example.manyToOne_ColumJoin;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="employee")
class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name="name")
    public String name;

    public Employee(String name, Integer salary, Date joinDate) {
        this.name = name;
        this.salary = salary;
        this.joinDate = joinDate;
    }

    @Column(name="salary")
    public Integer salary;

    @Column(name="join_date")
    public Date joinDate;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", joinDate=" + joinDate +
                '}';
    }

    public Employee() {

    }
}
