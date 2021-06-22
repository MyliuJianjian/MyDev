package com.my.dev.controller;

import com.my.common.ResultUtils;
import com.my.dev.entity.nodeinfo.NodeInfoEntity;
import com.my.dev.entity.userinfo.SysUserEntity;
import com.my.dev.entity.vo.NodeInfoVo;
import com.my.dev.service.INodeInfoService;
import com.my.dev.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 功能描述
 *
 * @author LIUJIANJIAN
 * @date 2021年6月15日19:13:55$
 */
@RestController
@RequestMapping("/node/info")
public class NodeInfoController {
    @Autowired
    private INodeInfoService nodeInfoService;

    @PostMapping("/saveNode")
    public ResultUtils saveNode(@RequestBody NodeInfoVo vo){
        return nodeInfoService.saveNode(vo);
    }
    @GetMapping("/findNodeInfo")
    public NodeInfoVo findNodeInfo(@RequestParam(value = "nodeId") Integer nodeId){
        return nodeInfoService.findNodeInfo(nodeId);
    }
    @GetMapping("/findTreeRoots")
    public List<NodeInfoEntity> findTreeRoots(){
        return nodeInfoService.findTreeRoots();
    }
    @GetMapping("/findTreeNode")
    public List<NodeInfoEntity> findTreeNode(@RequestParam(value = "nodeId") Integer nodeId){
        return nodeInfoService.findTreeNode(nodeId);
    }
}
