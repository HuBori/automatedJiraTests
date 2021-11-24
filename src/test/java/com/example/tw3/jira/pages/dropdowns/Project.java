package com.example.tw3.jira.pages.dropdowns;

public enum Project {
    MTP("Main Testing Project"),
    COALA("COALA project"),
    JETI("JETI project"),
    TOUCAN("TOUCAN project");

    private String fullName;

    Project(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getFullNameWithKey() {
        return fullName + " (" + this.name() + ")";
    }
}
