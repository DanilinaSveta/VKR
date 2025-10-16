package com.company.vkr.security;

import com.company.vkr.entity.*;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityflowui.role.annotation.MenuPolicy;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "StudentRole", code = StudentRole.CODE)
public interface StudentRole {
    String CODE = "student-role";

    @MenuPolicy(menuIds = {"GroupVKR.list", "Student.list", "TopicStudent.list"})
    @ViewPolicy(viewIds = {"GroupVKR.list", "Student.list", "DescriptionOfTheTopic.detail", "GroupVKR.detail", "Student.detail", "Teacher.list", "TopicStudent.detail", "TopicStudent.list"})
    void screens();

    @EntityAttributePolicy(entityClass = DescriptionOfTheTopic.class, attributes = {"id", "topic"}, action = EntityAttributePolicyAction.VIEW)
    @EntityAttributePolicy(entityClass = DescriptionOfTheTopic.class, attributes = {"shortDescription", "description", "literatureRecommendations", "recommendedSkills"}, action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = DescriptionOfTheTopic.class, actions = EntityPolicyAction.ALL)
    void descriptionOfTheTopic();

    @EntityAttributePolicy(entityClass = GroupVKR.class, attributes = "id", action = EntityAttributePolicyAction.VIEW)
    @EntityAttributePolicy(entityClass = GroupVKR.class, attributes = {"priority", "teacherName"}, action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = GroupVKR.class, actions = EntityPolicyAction.ALL)
    void groupVKR();

    @EntityAttributePolicy(entityClass = Skills.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Skills.class, actions = EntityPolicyAction.READ)
    void skills();

    @EntityAttributePolicy(entityClass = Student.class, attributes = "id", action = EntityAttributePolicyAction.VIEW)
    @EntityAttributePolicy(entityClass = Student.class, attributes = {"name", "skills", "numberOfTopic", "topics"}, action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Student.class, actions = EntityPolicyAction.ALL)
    void student();

    @EntityAttributePolicy(entityClass = Teacher.class, attributes = {"id", "name", "numberOfTopic", "maxNumberStudent", "skills", "topics", "groupVKRs"}, action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Teacher.class, actions = EntityPolicyAction.READ)
    void teacher();

    @EntityAttributePolicy(entityClass = Topic.class, attributes = {"id", "directorGraduateStudent"}, action = EntityAttributePolicyAction.VIEW)
    @EntityAttributePolicy(entityClass = Topic.class, attributes = {"topicName", "teacher", "topicStatus", "activityTopic", "authorTopic", "description"}, action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Topic.class, actions = EntityPolicyAction.ALL)
    void topic();
}