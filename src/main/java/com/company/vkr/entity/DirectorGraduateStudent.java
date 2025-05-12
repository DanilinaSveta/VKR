package com.company.vkr.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;

import java.util.UUID;

@JmixEntity
@Table(name = "DIRECTOR_GRADUATE_STUDENT", indexes = {
        @Index(name = "IDX_DIRECTOR_GRADUATE_STUDENT_TOPIC", columnList = "TOPIC_ID"),
        @Index(name = "IDX_DIRECTOR_GRADUATE_STUDENT_TEACHER", columnList = "TEACHER_ID"),
        @Index(name = "IDX_DIRECTOR_GRADUATE_STUDENT_STUDENT", columnList = "STUDENT_ID")
})
@Entity
public class DirectorGraduateStudent {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @JoinColumn(name = "TOPIC_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private Topic topic;

    @JoinColumn(name = "TEACHER_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private Teacher teacher;

    @JoinColumn(name = "STUDENT_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}