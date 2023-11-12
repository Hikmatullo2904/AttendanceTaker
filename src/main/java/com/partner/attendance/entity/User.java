    package com.partner.attendance.entity;

    import jakarta.persistence.*;
    import jakarta.validation.constraints.Email;
    import jakarta.validation.constraints.Size;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;

    import java.util.HashSet;
    import java.util.Set;

    @Getter
    @Setter
    @NoArgsConstructor
    @Entity
    @Table(name = "users")
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;
        @Email
        @Column(nullable = false, unique = true)
        private String email;
        @Size(min = 8, max = 30)
        private String password;

        @ManyToMany
        @JoinTable(
                name = "teacher_subject",
                joinColumns = @JoinColumn(name = "teacher_id"),
                inverseJoinColumns = @JoinColumn(name = "subject_id")
        )
        private Set<Subject> subjects = new HashSet<>();

        @ManyToMany
        @JoinTable(
                name = "group_teachers",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "group_id")
        )
        private Set<Group> groups;

        @Enumerated(value = EnumType.STRING)
        private Set<Role> roles = new HashSet<>();

        public User(String name, String email, String password) {
            this.name = name;
            this.email = email;
            this.password = password;
        }
    }
