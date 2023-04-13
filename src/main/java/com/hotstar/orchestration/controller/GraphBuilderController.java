package com.hotstar.orchestration.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotstar.orchestration.models.Table;
import com.hotstar.orchestration.service.GraphBuilder;
import com.hotstar.orchestration.service.JsonParser;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;


@AllArgsConstructor
@RestController
@RequestMapping("/buildgraph")
public class GraphBuilderController {
    
    GraphBuilder graphBuilder;
    JsonParser jsonParser;

    @GetMapping("/payments")
    public Map<String, List<String>> buildGraph() throws IOException{
        List<Table> tables = jsonParser.parse("payments_schema.json");
        Map<String,List<String>> graph = graphBuilder.build(tables);
        return graph;
    }

    @GetMapping("/subscriptions")
    public Map<String, List<String>> build() throws IOException{
        List<Table> tables = jsonParser.parse("subscription_schema.json");
        Map<String,List<String>> graph = graphBuilder.build(tables);
        return graph;
    }

    

}
