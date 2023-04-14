package com.hotstar.orchestration.service;

import java.util.List;
import java.util.Map;

public interface PathFinderEdge {

    public List<String> findEdgePath(Map<String,Map<String,String>> graph, String source, String destination);
    
}
