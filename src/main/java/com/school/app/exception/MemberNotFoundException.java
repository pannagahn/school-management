package com.school.app.exception;

public class MemberNotFoundException extends RuntimeException{

    private String member;
    private String resource;
    private int id;

    public MemberNotFoundException(String member, String resource, int id) {
        this.member = member;
        this.resource = resource;
        this.id = id;
    }

    @Override
    public String toString() {
        return "MemberNotFoundException{" +
                "member='" + member + '\'' +
                ", resource='" + resource + '\'' +
                ", id=" + id +
                '}';
    }
}
