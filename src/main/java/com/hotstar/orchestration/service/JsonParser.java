package com.hotstar.orchestration.service;

import java.io.IOException;
import java.util.List;

import com.hotstar.orchestration.models.Table;

public interface JsonParser {

    public List<Table> parse(String filePath) throws IOException;
    
}
