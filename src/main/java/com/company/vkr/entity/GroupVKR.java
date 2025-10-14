package com.company.vkr.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "GROUP_VKR", indexes = {
        @Index(name = "IDX_GROUP_VKR_TEACHRT_NAME", columnList = "")
})
@Entity
public class GroupVKR {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "SUDENT_NAME")
    private String studentName;

    @JoinTable(name = "GROUP_VKR_TEACHER_LINK",
            joinColumns = @JoinColumn(name = "GROUP_V_K_R_ID"),
            inverseJoinColumns = @JoinColumn(name = "TEACHER_ID"))
    @ManyToMany
    private List<Teacher> teachrtName;

    @Column(name = "PRIORITY")
    private String priority;

    public void setTeachrtName(List<Teacher> teachrtName) {
        this.teachrtName = teachrtName;
    }

    public List<Teacher> getTeachrtName() {
        return teachrtName;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}