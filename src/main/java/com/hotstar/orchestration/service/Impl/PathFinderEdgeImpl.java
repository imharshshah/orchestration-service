package com.hotstar.orchestration.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hotstar.orchestration.service.PathFinderEdge;

@Service
public class PathFinderEdgeImpl implements PathFinderEdge {

    @Override
    public List<String> findEdgePath(Map<String, Map<String, String>> graph, String source, String destination) {
       return null;
    }
    
}
