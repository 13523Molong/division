package com.example.demo.pojo;

import lombok.Data;

public enum RequirementStatus {
    DRAFT("草稿"),
    PHASE1("阶段一"),
    PHASE2("阶段二");

    private final String description;

    RequirementStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
