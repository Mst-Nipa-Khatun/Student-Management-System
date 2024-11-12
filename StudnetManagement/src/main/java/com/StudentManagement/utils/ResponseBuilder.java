package com.StudentManagement.utils;

import com.StudentManagement.Dto.Response;
import org.springframework.http.HttpStatus;

public final class ResponseBuilder {
    private ResponseBuilder() {

    }

    public static Response getSuccessResponse(HttpStatus httpStatus,Object content, String message) {
        Response response = new Response();
        response.setStatusCode(httpStatus.value());
        response.setStatus(httpStatus.getReasonPhrase());
        response.setMessage(message);
        response.setContent(content);
        return response;
    }
    public static Response getFailureResponse(HttpStatus httpStatus,Object content, String message) {
        Response response = new Response();
        response.setStatusCode(httpStatus.value());
        response.setStatus(httpStatus.getReasonPhrase());
        response.setMessage(message);
        response.setContent(content);
        return response;
    }

}
