package com.company.vkr.entity;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;


public enum TopicActivity implements EnumClass<String> {

    ;

    private final String id;

    TopicActivity(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static TopicActivity fromId(String id) {
        for (TopicActivity at : TopicActivity.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}