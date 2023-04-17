package com.hotstar.orchestration.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import com.hotstar.orchestration.service.PathFinderNode;

@Service
public class PathFinderNodeImpl implements PathFinderNode {

    @Override
    public List<String> findNodePath(Map<String, Map<String, Map<String,String>>> graph, String source, String destination) {
        Queue<String> queue = new LinkedList<>();
        Map<String,String> parent = new HashMap<>();
        queue.add(source);
        parent.put(source, null);

        while(!queue.isEmpty()){
            String current = queue.poll();
            if(current.equals(destination)){
                break;
            }
            for(Entry<String, Map<String, String>> entry : graph.get(current).entrySet()){
                String neighbor = entry.getKey();
                if(!parent.containsKey(neighbor)){
                    queue.add(neighbor);
                    parent.put(neighbor,current);
                }
            }
        }

        if(!parent.containsKey(destination)){
            return null;
        }

        List<String> path = new ArrayList<>();
        String current = destination;
        while(current!=null){
            path.add(0,current);
            current=parent.get(current);
        }

        return path;
    }
    
}
