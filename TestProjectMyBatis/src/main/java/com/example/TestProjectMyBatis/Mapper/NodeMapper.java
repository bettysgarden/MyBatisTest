package com.example.TestProjectMyBatis.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.TestProjectMyBatis.Entity.Node;

@Mapper
public interface NodeMapper {

    public Node getById(Integer id);

    public void insert(@Param("node") Node node);

    public void update(@Param("node") Node node);

    public void deleteById(Integer id);

    public List<Node> getAll();

    public List<Node> getAllRootNodes();

    public List<Node> getByParentId(Integer id);

}
