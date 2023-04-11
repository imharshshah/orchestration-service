package com.hotstar.orchestration.models;

import java.util.List;

import lombok.Data;

@Data
public class Table {

    private String table_name;
    private List<Column> columns;
    private List<ForeignKey> foreignKeys;
    
}
