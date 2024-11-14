package com.StudentManagement.utils;

public final class UrlConstraint {
    private UrlConstraint() {

    }

    public static class StudentManagement {
        public static final String ROOT = "/student";
        public static final String CREATE = "/create";
        public static final String GET_ALL="/all";
        public static final String GET_STUDENT_BYID ="/get/{id}";
        public static final String DELETE="/delete/{id}";
        public static final String EDIT="/edit/{id}";
        public static final String GET_STUDENT_NAME_AND_AGE ="/name-and-age";


    }

}
