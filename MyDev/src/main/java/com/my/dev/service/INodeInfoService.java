package com.my.dev.service;


import com.my.common.ResultUtils;
import com.my.dev.entity.nodeinfo.NodeInfoEntity;
import com.my.dev.entity.vo.NodeInfoVo;
import java.util.List;

public interface INodeInfoService {

    ResultUtils saveNode(NodeInfoVo vo);
    NodeInfoVo findNodeInfo(Integer nodeId);
    List<NodeInfoEntity> findTreeRoots();
    List<NodeInfoEntity> findTreeNode(Integer nodeId);
}
