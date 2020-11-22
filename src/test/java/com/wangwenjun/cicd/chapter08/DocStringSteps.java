package com.wangwenjun.cicd.chapter08;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.DocStringType;
import io.cucumber.java.en.Given;

public class DocStringSteps
{
    private static ObjectMapper objectMapper = new ObjectMapper();

    @DocStringType
    public JsonNode json(String docString) throws JsonProcessingException
    {
        return objectMapper.readValue(docString, JsonNode.class);
    }

    @Given("the action type is {string} and payload as below:")
    public void docString(String type, JsonNode docString)
    {
        System.out.println(type);
        System.out.println(docString);
    }
}
