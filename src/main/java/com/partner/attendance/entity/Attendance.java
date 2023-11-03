package com.partner.attendance.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @Column(name = "is_present", nullable = false)
    private boolean isPresent;
    @Column(name = "local_date", nullable = false)
    private LocalDate localDate;
}
