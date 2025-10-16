package com.company.vkr.security;

import com.company.vkr.entity.Teacher;
import com.company.vkr.entity.Topic;
import io.jmix.security.role.annotation.JpqlRowLevelPolicy;
import io.jmix.security.role.annotation.RowLevelRole;

@RowLevelRole(name = "TeacherRowLevelRole", code = TeacherRowLevelRole.CODE)
public interface TeacherRowLevelRole {
    String CODE = "teacher-row-level-role";

    @JpqlRowLevelPolicy(entityClass = Teacher.class, where = "{E}.name.id = :current_user_id")
    void teacher();

}