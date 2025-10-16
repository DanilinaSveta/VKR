package com.company.vkr.security;

import com.company.vkr.entity.Student;
import com.company.vkr.entity.Topic;
import io.jmix.security.role.annotation.JpqlRowLevelPolicy;
import io.jmix.security.role.annotation.RowLevelRole;

@RowLevelRole(name = "StudentRowLevelRole", code = StudentRowLevelRole.CODE)
public interface StudentRowLevelRole {
    String CODE = "student-row-level-role";

    @JpqlRowLevelPolicy(entityClass = Student.class, where = "{E}.name.id = :current_user_id")
    void student();

}