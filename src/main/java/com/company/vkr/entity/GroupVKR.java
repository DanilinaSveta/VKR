package com.company.vkr.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;

import java.util.UUID;

@JmixEntity
@Table(name = "GROUP_VKR")
@Entity
public class GroupVKR {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "STUDENT_NAME")
    private String studentName;

    @JoinColumn(name = "TEACHER_NAME_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher teacherName;

    @Column(name = "PRIORITY")
    private String priority;

    public void setTeacherName(Teacher teacherName) {
        this.teacherName = teacherName;
    }

    public Teacher getTeacherName() {
        return teacherName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}