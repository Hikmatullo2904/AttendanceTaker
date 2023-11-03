    package com.partner.attendance.entity;

    import jakarta.persistence.Entity;
    import jakarta.persistence.JoinColumn;
    import jakarta.persistence.JoinTable;
    import jakarta.persistence.ManyToMany;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;

    import java.util.List;

    @Getter
    @Setter
    @NoArgsConstructor
    @Entity
    public class Teacher extends User{
        @ManyToMany
        @JoinTable(
                name = "teacher_subject",
                joinColumns = @JoinColumn(name = "teacher_id"),
                inverseJoinColumns = @JoinColumn(name = "subject_id")
        )
        private List<Subject> subjects;
        @ManyToMany(mappedBy = "teachers")
        private List<Group> groups;

        public Teacher(List<Subject> subjects, List<Group> groups) {
            this.subjects = subjects;
            this.groups = groups;
        }

        public Teacher(String username, String email, String password, List<Subject> subjects, List<Group> groups) {
            super(username, email, password);
            this.subjects = subjects;
            this.groups = groups;
        }
    }
