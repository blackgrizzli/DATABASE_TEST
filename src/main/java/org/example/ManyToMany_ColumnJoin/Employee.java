package org.example.ManyToMany_ColumnJoin;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Column(name = "employee_name")
    public int nameEmployee;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_task", joinColumns = @JoinColumn(name = "employee_id",
            referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "task_id",referencedColumnName = "id"))
    public Set<EmployeeTask> set = new HashSet<>();
}
