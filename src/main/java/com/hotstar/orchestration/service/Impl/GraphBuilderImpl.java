package com.hotstar.orchestration.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hotstar.orchestration.models.ForeignKey;
import com.hotstar.orchestration.models.Table;
import com.hotstar.orchestration.service.GraphBuilder;

@Service
public class GraphBuilderImpl implements GraphBuilder {

    @Override
    public Map<String, List<String>> build(List<Table> tables) {
        Map<String, List<String>> graph = new HashMap<>();
        for(Table table: tables){
            String tableName = table.getTable_name();
            List<String> foreignKeys = new ArrayList<>();
            for(ForeignKey foreignKey:table.getForeignKeys()){
                foreignKeys.add(foreignKey.getPk_table());
            }
            graph.put(tableName,foreignKeys);
        }
        return graph;
    }
    
}
