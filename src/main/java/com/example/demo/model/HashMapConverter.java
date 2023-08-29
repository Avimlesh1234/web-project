package com.example.demo.model;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
@Converter

public class HashMapConverter implements AttributeConverter<Map<String, Object>, String> {

    @Override
    public String convertToDatabaseColumn(Map<String, Object> attribute) {
		return null;
        // Convert Map to a JSON or other string representation
        // For example, you can use Jackson library to serialize the map to JSON
        // Return the serialized string
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String dbData) {
		return null;
        // Convert the stored string back to a Map
        // For example, you can use Jackson library to deserialize the JSON string
        // Return the deserialized map
    }
}
