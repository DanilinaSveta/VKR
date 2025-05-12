package com.company.vkr.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jdk.jshell.Snippet;

import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "TEACHER")
@Entity
public class Teacher implements author {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "NUMBER_OF_TOPIC")
    private Integer numberOfTopic;

    @Column(name = "MAX_NUMBER_STUDENT")
    private Integer maxNumberStudent;

    @JoinTable(name = "TEACHER_SKILLS_LINK",
            joinColumns = @JoinColumn(name = "TEACHER_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "SKILLS_ID", referencedColumnName = "ID"))
    @ManyToMany
    private List<Skills> skills;

    @JoinTable(name = "TOPIC_TEACHER_LINK",
            joinColumns = @JoinColumn(name = "TEACHER_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "TOPIC_ID", referencedColumnName = "ID"))
    @ManyToMany
    private List<Topic> topics;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "teacher")
    private DirectorGraduateStudent directorGraduateStudent;

    public DirectorGraduateStudent getDirectorGraduateStudent() {
        return directorGraduateStudent;
    }

    public void setDirectorGraduateStudent(DirectorGraduateStudent directorGraduateStudent) {
        this.directorGraduateStudent = directorGraduateStudent;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public List<Skills> getSkills() {
        return skills;
    }

    public void setSkills(List<Skills> skills) {
        this.skills = skills;
    }

    public Integer getMaxNumberStudent() {
        return maxNumberStudent;
    }

    public void setMaxNumberStudent(Integer maxNumberStudent) {
        this.maxNumberStudent = maxNumberStudent;
    }

    public Integer getNumberOfTopic() {
        return numberOfTopic;
    }

    public void setNumberOfTopic(Integer numberOfTopic) {
        this.numberOfTopic = numberOfTopic;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAuthor(){
        String author = "Test";
        return author;
    }
    public Integer countTopic(){
        return getNumberOfTopic();
    }
    public Snippet.Status status(){
        return status();
    }
}