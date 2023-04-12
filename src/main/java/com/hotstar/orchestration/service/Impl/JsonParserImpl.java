package com.hotstar.orchestration.service.Impl;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotstar.orchestration.models.Table;
import com.hotstar.orchestration.service.JsonParser;

@Service
public class JsonParserImpl implements JsonParser {

    @Override
    public List<Table> parse(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filePath);
        return Arrays.asList(objectMapper.readValue(file,Table[].class));
    }
    
}
