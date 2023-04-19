package com.hotstar.orchestration.service;

import java.util.List;
import java.util.Map;

public interface PathFinderNode {

    public List<List<String>> findNodePath(Map<String,Map<String,Map<String,String>>> graph, String source, String destination);
    
}
