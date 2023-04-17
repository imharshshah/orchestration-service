package com.hotstar.orchestration.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotstar.orchestration.models.Table;
import com.hotstar.orchestration.service.GraphBuilder;
import com.hotstar.orchestration.service.JsonParser;
import com.hotstar.orchestration.service.PathFinderEdge;
import com.hotstar.orchestration.service.PathFinderNode;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;


@AllArgsConstructor
@RestController
@RequestMapping("/graph")
public class GraphBuilderController {
    
    GraphBuilder graphBuilder;
    JsonParser jsonParser;
    PathFinderNode pathFinderNode;
    PathFinderEdge pathFinderEdge;

    @GetMapping("/build_payments_graph")
    public Map<String, Map<String, Map<String, String>>> buildGraphPayments() throws IOException{
        List<Table> tables = jsonParser.parse("payments_schema.json");
        Map<String, Map<String, Map<String, String>>> graph = graphBuilder.build(tables);
        return graph;
    }

    @GetMapping("/build_subscriptions_graph")
    public Map<String, Map<String, Map<String, String>>> buildGraphSubscriptions() throws IOException{
        List<Table> tables = jsonParser.parse("subscription_schema.json");
        Map<String, Map<String, Map<String, String>>> graph = graphBuilder.build(tables);
        return graph;
    }

    @GetMapping("/build_combined_graph")
    public Map<String, Map<String, Map<String, String>>> buildGraphCombined() throws IOException{
        List<Table> tables = jsonParser.parse("Combined_schema.json");
        Map<String, Map<String, Map<String, String>>> graph=graphBuilder.build(tables);
        return graph;
    }
    
    @GetMapping("/find_node_path_payments")
    public List<String> findNodePathPayments() throws IOException{
        List<Table> tables = jsonParser.parse("payments_schema.json");
        Map<String, Map<String, Map<String, String>>> graph = graphBuilder.build(tables);
        List<String> path = pathFinderNode.findNodePath(graph,"charges","customers");
        return path;
    }

    @GetMapping("/find_node_path_combined")
    public List<String> findNodePathCombined() throws IOException{
        List<Table> tables = jsonParser.parse("Combined_schema.json");
        Map<String, Map<String, Map<String, String>>> graph = graphBuilder.build(tables);
        List<String> path = pathFinderNode.findNodePath(graph, "charges", "subscriptions");
        return path;
    }

    @GetMapping("/find_node_path_subscriptions")
    public List<String> findNodePathSubscriptions() throws IOException{
        List<Table> tables = jsonParser.parse("subscription_schema.json");
        Map<String, Map<String, Map<String, String>>> graph = graphBuilder.build(tables);
        List<String> path = pathFinderNode.findNodePath(graph, "orders", "subscriptions");
        return path;
    }

    @GetMapping("/find_edge_path_payments")
    public List<Map<String, String>> findEdgePathPayments() throws IOException{
        List<Table> tables = jsonParser.parse("payments_schema.json");
        Map<String, Map<String, Map<String, String>>> graph = graphBuilder.build(tables);
        List<Map<String, String>> edges = pathFinderEdge.findEdgePath(graph, "charges", "customers");
        return edges;
    }

    @GetMapping("/find_edge_path_subscriptions")
    public List<Map<String, String>> findEdgePathSubscriptions() throws IOException{
        List<Table> tables = jsonParser.parse("subscription_schema.json");
        Map<String, Map<String, Map<String, String>>> graph = graphBuilder.build(tables);
        List<Map<String, String>> edges = pathFinderEdge.findEdgePath(graph, "orders", "subscriptions");
        return edges;
    }

    @GetMapping("/find_edge_path_combined")
    public List<Map<String, String>> findEdgePathCombined() throws IOException{
        List<Table> tables = jsonParser.parse("Combined_schema.json");
        Map<String, Map<String, Map<String, String>>> graph = graphBuilder.build(tables);
        List<Map<String, String>> edges = pathFinderEdge.findEdgePath(graph, "charges", "subscriptions");
        return edges;
    }
    

}
