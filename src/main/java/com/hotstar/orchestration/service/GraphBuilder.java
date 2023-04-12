package com.hotstar.orchestration.service;

import java.util.List;
import java.util.Map;

import com.hotstar.orchestration.models.Table;

public interface GraphBuilder {
    public Map<String, List<String>> build(List<Table> tables);
}
