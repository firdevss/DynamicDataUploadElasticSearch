package com.siber.project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.io.IOException;
import java.util.ArrayList;

public class ResultVm {

    private boolean IsSuccess;
    private ArrayList<String> ResultMessage;
    private Object ResultSet;
    private String ErrorCode;
    private String NavigationUrl;

    public ResultVm(boolean isSuccess, Object resultSet) {
        ResultSet = resultSet;
        IsSuccess = isSuccess;
        ResultMessage = new ArrayList<String>();
    }

    public ResultVm(Object resultSet) {
        ResultSet = resultSet;
        IsSuccess = true;
        ResultMessage = new ArrayList<String>();
    }

    public ResultVm() {
        ResultMessage = new ArrayList<String>();
    }

    public static String asJson(ResultVm vm) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(vm);
    }

    @JsonProperty("errorCode")
    public String getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(String errorCode) {
        ErrorCode = errorCode;
    }

    @JsonProperty("navigationUrl")
    public String getNavigationUrl() {
        return NavigationUrl;
    }

    public void setNavigationUrl(String navigationUrl) {
        NavigationUrl = navigationUrl;
    }

    @JsonProperty("isSuccess")
    public boolean isIsSuccess() {
        return IsSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        IsSuccess = isSuccess;
    }

    @JsonProperty("resultMessage")
    public ArrayList<String> getResultMessage() {
        return ResultMessage;
    }

    public void setResultMessage(ArrayList<String> resultMessage) {
        ResultMessage = resultMessage;
    }

    @JsonProperty("resultSet")
    public Object getResultSet() {
        return ResultSet;
    }

    public void setResultSet(Object resultSet) {
        ResultSet = resultSet;
    }

    public void addError(String string) {
        this.setIsSuccess(false);
        this.ResultMessage.add(string);

    }

    public void addMessage(String message) {
        ResultMessage.add(message);
    }

    public HttpServletResponse WriteToResponse(HttpServletResponse response) throws IOException {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json-charset=UTF-8");
        new ObjectMapper().getFactory().createGenerator(response.getOutputStream(), JsonEncoding.UTF8).writeObject(this);
        return response;
    }

    public boolean isValidBinding(BindingResult br) {

        if (br.hasErrors()) {
            ResultMessage.add("Hatalı istek.");

            ArrayList<String> errors = new ArrayList<String>();

            for (FieldError error : br.getFieldErrors()) {
                errors.add(error.getField() + " " + error.getDefaultMessage());
            }

            for (ObjectError error : br.getGlobalErrors()) {
                errors.add(error.getDefaultMessage());
            }

            ResultSet = errors;

            return false;
        } else {
            return true;
        }
    }
}
