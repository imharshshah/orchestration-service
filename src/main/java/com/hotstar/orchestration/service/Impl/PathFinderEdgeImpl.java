package com.hotstar.orchestration.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import com.hotstar.orchestration.service.PathFinderEdge;

@Service
public class PathFinderEdgeImpl implements PathFinderEdge {

    @Override
    public List<Map<String,String>> findEdgePath(Map<String, Map<String, Map<String,String>>> graph, String source, String destination) {
        Queue<String> queue = new LinkedList<>();
        Map<String,String> parent = new HashMap<>();
        Map<String,Map<String,String>> edgeInfo = new HashMap<>();

        queue.add(source);
        parent.put(source,null);

        while(!queue.isEmpty())
        {
            String current = queue.poll();
            if(current.equals(destination)){
                break;
            }
            for(Entry<String, Map<String, String>> entry: graph.get(current).entrySet()){
                String neighbor = entry.getKey();
                if(!parent.containsKey(neighbor)){
                    queue.add(neighbor);
                    parent.put(neighbor,current);
                    edgeInfo.put(neighbor,entry.getValue());
                }
            }
        }

        if(!parent.containsKey(destination)){
            return null;
        }

        List<Map<String,String>> edges = new ArrayList<>();

        String current = destination;
        while(current!=null){
            String parentOfCurrent = parent.get(current);
            if(parentOfCurrent!=null){
                Map<String,String> edge = new HashMap<>();
                Map<String,String> edgeData = edgeInfo.get(current);
                edge.put("pk_column",edgeData.get("pk_column"));
                edge.put("fk_column",edgeData.get("fk_column"));
                edge.put("is_embedded",edgeData.get("is_embedded"));

                edges.add(0, edge);
            }
            current = parentOfCurrent;
        }
        return edges;
    }
    
}
