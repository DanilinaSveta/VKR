package com.company.vkr.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "TOPIC")
@Entity
public class Topic {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "TOPIC_NAME")
    private String topicName;

    @JoinTable(name = "TOPIC_TEACHER_LINK",
            joinColumns = @JoinColumn(name = "TOPIC_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "TEACHER_ID", referencedColumnName = "ID"))
    @ManyToMany
    private List<Teacher> teacher;

    @JoinTable(name = "TOPIC_STUDENT_LINK",
            joinColumns = @JoinColumn(name = "TOPIC_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID"))
    @ManyToMany
    private List<Student> student;

    @Column(name = "TOPIC_STATUS")
    private String topicStatus;

    @Column(name = "ACTIVITY_TOPIC")
    private String activityTopic;

    @Column(name = "AUTHOR_TOPIC")
    private String authorTopic;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "topic")
    private DescriptionOfTheTopic descriptionOfTheTopic;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "topic")
    private DirectorGraduateStudent directorGraduateStudent;

    public DirectorGraduateStudent getDirectorGraduateStudent() {
        return directorGraduateStudent;
    }

    public void setDirectorGraduateStudent(DirectorGraduateStudent directorGraduateStudent) {
        this.directorGraduateStudent = directorGraduateStudent;
    }

    public DescriptionOfTheTopic getDescriptionOfTheTopic() {
        return descriptionOfTheTopic;
    }

    public void setDescriptionOfTheTopic(DescriptionOfTheTopic descriptionOfTheTopic) {
        this.descriptionOfTheTopic = descriptionOfTheTopic;
    }

    public String getAuthorTopic() {
        return authorTopic;
    }

    public void setAuthorTopic(String authorTopic) {
        this.authorTopic = authorTopic;
    }

    public TopicActivity getActivityTopic() {
        return activityTopic == null ? null : TopicActivity.fromId(activityTopic);
    }

    public void setActivityTopic(TopicActivity activityTopic) {
        this.activityTopic = activityTopic == null ? null : activityTopic.getId();
    }

    public TopicStatus getTopicStatus() {
        return topicStatus == null ? null : TopicStatus.fromId(topicStatus);
    }

    public void setTopicStatus(TopicStatus topicStatus) {
        this.topicStatus = topicStatus == null ? null : topicStatus.getId();
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public List<Teacher> getTeacher() {
        return teacher;
    }

    public void setTeacher(List<Teacher> teacher) {
        this.teacher = teacher;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}