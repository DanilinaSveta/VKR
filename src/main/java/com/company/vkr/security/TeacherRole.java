package com.company.vkr.security;

import com.company.vkr.entity.*;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityflowui.role.annotation.MenuPolicy;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "TeacherRole", code = TeacherRole.CODE)
public interface TeacherRole {
    String CODE = "teacher-role";

    @MenuPolicy(menuIds = {"Topic.list", "Teacher.list"})
    @ViewPolicy(viewIds = {"Topic.list", "Teacher.list", "DescriptionOfTheTopic.detail", "Topic.detail", "Teacher.detail", "GroupVKR.list", "Student.list"})
    void screens();

    @EntityAttributePolicy(entityClass = DescriptionOfTheTopic.class, attributes = {"id", "topic"}, action = EntityAttributePolicyAction.VIEW)
    @EntityAttributePolicy(entityClass = DescriptionOfTheTopic.class, attributes = {"shortDescription", "description", "literatureRecommendations", "recommendedSkills"}, action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = DescriptionOfTheTopic.class, actions = EntityPolicyAction.ALL)
    void descriptionOfTheTopic();

    @EntityAttributePolicy(entityClass = GroupVKR.class, attributes = "id", action = EntityAttributePolicyAction.VIEW)
    @EntityAttributePolicy(entityClass = GroupVKR.class, attributes = {"priority", "studentName"}, action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = GroupVKR.class, actions = EntityPolicyAction.ALL)
    void groupVKR();

    @EntityAttributePolicy(entityClass = Student.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Student.class, actions = EntityPolicyAction.READ)
    void student();

    @EntityAttributePolicy(entityClass = Teacher.class, attributes = "id", action = EntityAttributePolicyAction.VIEW)
    @EntityAttributePolicy(entityClass = Teacher.class, attributes = {"name", "numberOfTopic", "maxNumberStudent", "skills", "topics", "directorGraduateStudent", "groupVKRs"}, action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Teacher.class, actions = EntityPolicyAction.ALL)
    void teacher();

    @EntityAttributePolicy(entityClass = Topic.class, attributes = {"topicName", "student", "topicStatus", "activityTopic", "authorTopic", "description"}, action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Topic.class, actions = EntityPolicyAction.ALL)
    void topic();

    @EntityAttributePolicy(entityClass = Skills.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Skills.class, actions = EntityPolicyAction.READ)
    void skills();
}