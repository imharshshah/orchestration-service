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
    public List<List<String>> findNodePath(Map<String, Map<String, Map<String,String>>> graph, String source, String destination) {
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

        List<List<String>> paths = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        temp.add(source);
        for(int i=0;i<path.size()-1;i++){
            if(graph.get(path.get(i)).get(path.get(i + 1)).get("is_embedded").equals("true")){
                temp.add(path.get(i+1));
            }
            else{
                paths.add(new ArrayList<>(temp));
                temp.clear();
                temp.add(path.get(i+1));
            }
        }
        paths.add(temp);

        return paths;
    }
    
}
