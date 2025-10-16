package com.company.vkr.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "GROUP_VKR", indexes = {
        @Index(name = "IDX_GROUP_VKR", columnList = "")
})
@Entity
public class GroupVKR {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "STUDENT_NAME")
    private String studentName;

    @JoinTable(name = "GROUP_VKR_TEACHER_LINK",
            joinColumns = @JoinColumn(name = "GROUP_V_K_R_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "TEACHER_ID", referencedColumnName = "ID"))
    @ManyToMany
    private List<Teacher> teacherName;

    @Column(name = "PRIORITY")
    private String priority;

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setTeacherName(List<Teacher> teacherName) {
        this.teacherName = teacherName;
    }

    public List<Teacher> getTeacherName() {
        return teacherName;
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