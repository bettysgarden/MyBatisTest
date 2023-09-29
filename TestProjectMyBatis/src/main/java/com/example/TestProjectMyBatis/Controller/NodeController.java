package com.example.TestProjectMyBatis.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TestProjectMyBatis.Entity.Node;
import com.example.TestProjectMyBatis.Service.NodeService;

@RestController
@RequestMapping("/v1/nodes")
public class NodeController {

    @Autowired
    private NodeService nodeService;

    @PostMapping("/")
    public ResponseEntity<Node> addNode(@RequestBody Node node) {
        Node createdNode = nodeService.save(node);
        return new ResponseEntity<>(createdNode, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Node>> getAllNodes() {
        List<Node> nodes = nodeService.getAllNodes();
        return new ResponseEntity<>(nodes, HttpStatus.OK);
    }

    @GetMapping("/root")
    public ResponseEntity<List<Node>> getAllRootNodes() {
        List<Node> nodes = nodeService.getAllRootNodes();
        return new ResponseEntity<>(nodes, HttpStatus.OK);
    }

    @GetMapping("/{nodeId}/children")
    public ResponseEntity<List<Node>> getChilsdrenForNode(@PathVariable Integer nodeId) {
        List<Node> nodes = nodeService.getChilsdrenForNode(nodeId);
        return new ResponseEntity<>(nodes, HttpStatus.OK);
    }

    @GetMapping("/{nodeId}")
    public ResponseEntity<Node> getNodeById(@PathVariable Integer nodeId) {
        Node node = nodeService.getNodeById(nodeId);
        return new ResponseEntity<>(node, HttpStatus.OK);
    }

    @PutMapping("/{nodeId}")
    public ResponseEntity<Node> updateNode(@PathVariable Integer nodeId, @RequestBody Node updatedNode) {
        Node updated = nodeService.save(updatedNode);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{nodeId}")
    public ResponseEntity<Void> deleteNode(@PathVariable Integer nodeId) {
        nodeService.deleteNode(nodeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
