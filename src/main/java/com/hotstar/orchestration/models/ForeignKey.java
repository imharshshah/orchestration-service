package com.hotstar.orchestration.models;

import lombok.Data;

@Data
public class ForeignKey {
    String fk_column;
    String pk_table;
}
