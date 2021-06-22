package com.my.dev.service.impl;

import com.my.common.CopyUtils;
import com.my.common.ResultUtils;
import com.my.dev.JpaRepository.NodeInfoRepository;
import com.my.dev.JpaRepository.NodeTextRepository;
import com.my.dev.entity.nodeinfo.NodeInfoEntity;
import com.my.dev.entity.nodeinfo.NodeTextEntity;
import com.my.dev.entity.vo.NodeInfoVo;
import com.my.dev.service.INodeInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述
 *
 * @author LIUJIANJIAN
 * @date 2021年6月3日15:15:44$
 */
@Service
public class NodeInfoServiceImpl implements INodeInfoService {
    @Autowired
    private NodeInfoRepository nodeInfoRepository;
    @Autowired
    private NodeTextRepository nodeTextRepository;

    @Override
    public ResultUtils saveNode(NodeInfoVo vo) {
        if(null==vo.getNodeParent()){
            ResultUtils.Error("父节点不可为空");
        }
        NodeInfoEntity node=new NodeInfoEntity();
        CopyUtils.copyProperties(vo,node);
        NodeInfoEntity parent=nodeInfoRepository.getById(vo.getNodeParent());
        if(null==parent){
            node.setNodeParent(0);
            node.setNodeLevel(1);
        }else{
            node.setNodeLevel(parent.getNodeLevel()+1);
        }
        node=nodeInfoRepository.save(node);
        NodeTextEntity text=new NodeTextEntity();
        text.setNodeId(node.getNodeId());
        if(!StringUtils.isBlank(vo.getTextInfo())){
            text.setTextInfo(vo.getTextInfo());
        }
        nodeTextRepository.save(text);
        ResultUtils result=new ResultUtils();
        result.setData(node);
        return result;
    }

    @Override
    public NodeInfoVo findNodeInfo(Integer nodeId) {
        NodeInfoVo vo=new NodeInfoVo();
        NodeInfoEntity node=nodeInfoRepository.findById(nodeId).get();
        CopyUtils.copyProperties(node,vo);
        NodeTextEntity text=new NodeTextEntity();
        text.setNodeId(nodeId);
        ExampleMatcher matcher=ExampleMatcher.matching().withMatcher("nodeId",ExampleMatcher.GenericPropertyMatchers.contains());
        Example<NodeTextEntity> example=Example.of(text,matcher);
        text=nodeTextRepository.findOne(example).get();
        if(StringUtils.isNotBlank(text.getTextInfo())){
            vo.setTextInfo(text.getTextInfo());
        }
        return vo;
    }

    @Override
    public List<NodeInfoEntity> findTreeRoots() {
        NodeInfoEntity node=new NodeInfoEntity();
        node.setNodeParent(0);
        node.setNodeLevel(1);
        node.setDeletedFlag(0);
        ExampleMatcher matcher=ExampleMatcher.matching().withMatcher("nodeParent",ExampleMatcher.GenericPropertyMatchers.contains()).withMatcher("nodeLevel",ExampleMatcher.GenericPropertyMatchers.contains()).withMatcher("deletedFlag",ExampleMatcher.GenericPropertyMatchers.contains());
        Example<NodeInfoEntity> example=Example.of(node,matcher);
        return nodeInfoRepository.findAll(example);
    }

    @Override
    public List<NodeInfoEntity> findTreeNode(Integer nodeId) {
        NodeInfoEntity node=new NodeInfoEntity();
        node.setNodeParent(nodeId);
        node.setNodeLevel(1);
        node.setDeletedFlag(0);
        ExampleMatcher matcher=ExampleMatcher.matching().withMatcher("nodeParent",ExampleMatcher.GenericPropertyMatchers.contains()).withMatcher("nodeLevel",ExampleMatcher.GenericPropertyMatchers.contains()).withMatcher("deletedFlag",ExampleMatcher.GenericPropertyMatchers.contains());
        Example<NodeInfoEntity> example=Example.of(node,matcher);
        return nodeInfoRepository.findAll(example);
    }


}
