package com.example.TestProjectMyBatis.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TestProjectMyBatis.Entity.Node;
import com.example.TestProjectMyBatis.Mapper.NodeMapper;

@Service
public class NodeService {

    @Autowired
    private NodeMapper nodeMapper;

    public Node save(Node node) {
        Node existingNode = nodeMapper.getById(node.getId());
        if (existingNode != null) {
            return updateNode(existingNode, node);
        } else {
            return addNode(node);
        }
    }

    private Node updateNode(Node existingNode, Node updatedNode) {
        existingNode.setId(updatedNode.getId());
        existingNode.setParentId(updatedNode.getParentId());
        existingNode.setName(updatedNode.getName());
        existingNode.setIp(updatedNode.getIp());
        existingNode.setPort(updatedNode.getPort());

        nodeMapper.update(existingNode);
        return updatedNode;
    }

    private Node addNode(Node node) {
        nodeMapper.insert(node);
        return node;
    }

    public List<Node> getAllNodes() {
        return nodeMapper.getAll();
    }

    public List<Node> getAllRootNodes() {
        return nodeMapper.getAllRootNodes();
    }

    public Node getNodeById(Integer id) {
        return nodeMapper.getById(id);
    }

    public void deleteNode(Integer id) {
        nodeMapper.deleteById(id);
    }

    public List<Node> getChilsdrenForNode(Integer id) {
        return nodeMapper.getByParentId(id);
    }
}
