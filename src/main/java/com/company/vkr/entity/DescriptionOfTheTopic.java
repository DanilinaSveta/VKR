package com.company.vkr.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;

import java.util.UUID;

@JmixEntity
@Table(name = "DESCRIPTION_OF_THE_TOPIC", indexes = {
        @Index(name = "IDX_DESCRIPTION_OF_THE_TOPIC_TOPIC", columnList = "TOPIC_ID")
})
@Entity
public class DescriptionOfTheTopic {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "SHORT_DESCRIPTION", length = 100)
    private String shortDescription;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "LITERATURE_RECOMMENDATIONS")
    private String literatureRecommendations;

    @Column(name = "RECOMMENDED_SKILLS")
    private String recommendedSkills;

    @JoinColumn(name = "TOPIC_ID")
    @OnDeleteInverse(DeletePolicy.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY)
    private Topic topic;

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public String getRecommendedSkills() {
        return recommendedSkills;
    }

    public void setRecommendedSkills(String recommendedSkills) {
        this.recommendedSkills = recommendedSkills;
    }

    public String getLiteratureRecommendations() {
        return literatureRecommendations;
    }

    public void setLiteratureRecommendations(String literatureRecommendations) {
        this.literatureRecommendations = literatureRecommendations;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}