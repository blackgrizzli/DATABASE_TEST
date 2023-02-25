package org.example.manyToOne_ColumJoin;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="task")
class EmployeeTask
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name="name")
    public String name;

    @ManyToOne
    @JoinColumn(name="employee_id", nullable=true)
    public Employee employee;

    @Override
    public String toString() {
        return "EmployeeTask{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employee=" + employee +
                ", deadline=" + deadline +
                '}';
    }

    public EmployeeTask(String name, Employee employee, Date deadline) {
        this.name = name;
        this.employee = employee;
        this.deadline = deadline;
    }

    @Column(name="deadline")
    public Date deadline;

    public EmployeeTask() {

    }
}
