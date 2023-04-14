package com.hotstar.orchestration.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.springframework.stereotype.Service;

import com.hotstar.orchestration.service.PathFinderEdge;

@Service
public class PathFinderEdgeImpl implements PathFinderEdge {

    @Override
    public List<String> findEdgePath(Map<String, Map<String, String>> graph, String source, String destination) {
        Queue<String> queue = new LinkedList<>();
        Map<String,String> parent = new HashMap<>();
        Map<String,String> edge = new HashMap<>();

        queue.add(source);
        parent.put(source,null);

        while(!queue.isEmpty())
        {
            String current = queue.poll();
            if(current.equals(destination)){
                break;
            }
            for(Map.Entry<String,String> entry: graph.get(current).entrySet()){
                String neighbor = entry.getKey();
                if(!parent.containsKey(neighbor)){
                    queue.add(neighbor);
                    parent.put(neighbor,current);
                    edge.put(neighbor,entry.getValue());
                }
            }
        }

        if(!parent.containsKey(destination)){
            return null;
        }

        List<String> edges = new ArrayList<>();

        String current = destination;
        while(current!=null){
            String parentOfCurrent = parent.get(current);
            if(parentOfCurrent!=null){
                edges.add(0, edge.get(current));
            }
            current = parentOfCurrent;
        }
        return edges;
    }
    
}
