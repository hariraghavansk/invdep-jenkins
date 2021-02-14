package com.sl.ms.inventorymanagement;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class StringMapConverter implements AttributeConverter<Map<String, String>, String> {

  private static ObjectMapper mapper;

  static {
    mapper = new ObjectMapper();
  }

  @Override
  public String convertToDatabaseColumn(Map<String, String> file) {
    if (null == file) { 
      // You may return null if you prefer that style
      return "{}";
    }
    
    try {
      return mapper.writeValueAsString(file);
      
    } catch (IOException e) {
      throw new IllegalArgumentException("Error converting map to JSON", e);
    }
  }

  @Override
  public Map<String, String> convertToEntityAttribute(String s) {
    if (null == s) {
      // You may return null if you prefer that style
      return new HashMap<>();
    }

    try {
      return mapper.readValue(s, new TypeReference<Map<String, String>>() {});
      
    } catch (IOException e) {
      throw new IllegalArgumentException("Error converting JSON to map", e);
    }
  }
}
