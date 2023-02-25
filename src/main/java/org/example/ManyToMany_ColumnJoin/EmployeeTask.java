package org.example.ManyToMany_ColumnJoin;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee_task")
public class EmployeeTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Column(name = "task_name")
    public String nameTask;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_task",
    joinColumns = @JoinColumn(name = "task_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "employee_id",referencedColumnName = "id"))
    Set<Employee> set = new HashSet<>();
}
