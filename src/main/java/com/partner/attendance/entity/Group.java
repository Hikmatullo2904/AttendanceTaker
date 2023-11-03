package com.partner.attendance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Group {
    @Id
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "group")
    private List<Student> students;

    @ManyToMany(mappedBy = "groups")
    private List<Teacher> teachers;

}
