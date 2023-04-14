package com.hotstar.orchestration.service.Impl;

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
    public Map<String, Map<String,String>> build(List<Table> tables) {
        Map<String, Map<String,String>> graph = new HashMap<>();
        for(Table table: tables){
            String tableName = table.getTable_name();
            Map<String,String> foreignKeys = new HashMap<>();
            for(ForeignKey foreignKey:table.getForeignKeys()){
                foreignKeys.put(foreignKey.getPk_table(),foreignKey.getFk_column());
            }
            graph.put(tableName,foreignKeys);
        }
        return graph;
    }
    
}
