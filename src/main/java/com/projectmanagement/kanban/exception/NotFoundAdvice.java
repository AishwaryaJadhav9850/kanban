package com.projectmanagement.kanban.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class NotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> exceptionHandler(UserNotFoundException e)
    {
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("Error Message: ",e.getMessage());
        return errorMap;
    }

    @ResponseBody
    @ExceptionHandler(TeamNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> exceptionHandler(TeamNotFoundException e)
    {
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("Error Message: ",e.getMessage());
        return errorMap;
    }

    @ResponseBody
    @ExceptionHandler(MilestoneNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> exceptionHandler(MilestoneNotFoundException e)
    {
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("Error Message: ",e.getMessage());
        return errorMap;
    }

    @ResponseBody
    @ExceptionHandler(ProjectNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> exceptionHandler(ProjectNotFoundException e)
    {
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("Error Message: ",e.getMessage());
        return errorMap;
    }

    @ResponseBody
    @ExceptionHandler(TeamMilestoneNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> exceptionHandler(TeamMilestoneNotFoundException e)
    {
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("Error Message: ",e.getMessage());
        return errorMap;
    }

    @ResponseBody
    @ExceptionHandler(UserTaskNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> exceptionHandler(UserTaskNotFoundException e)
    {
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("Error Message: ",e.getMessage());
        return errorMap;
    }
    @ResponseBody
    @ExceptionHandler(TaskNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> exceptionHandler(TaskNotFoundException e)
    {
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("Error Message: ",e.getMessage());
        return errorMap;
    }
}
