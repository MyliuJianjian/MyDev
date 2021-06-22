package com.my.dev.entity.vo;

import com.my.dev.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 功能描述
 *
 * @author LIUJIANJIAN
 * @date 2021年6月22日14:31:58$
 */
@Data
public class NodeInfoVo implements Serializable {

    private Integer nodeId;

    private Integer nodeLevel;

    private Integer nodeParent;

    private String nodeName;

    private String textInfo;

    public Integer getNodeId() {
        return nodeId;
    }

    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeLevel() {
        return nodeLevel;
    }

    public void setNodeLevel(Integer nodeLevel) {
        this.nodeLevel = nodeLevel;
    }

    public Integer getNodeParent() {
        return nodeParent;
    }

    public void setNodeParent(Integer nodeParent) {
        this.nodeParent = nodeParent;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getTextInfo() {
        return textInfo;
    }

    public void setTextInfo(String textInfo) {
        this.textInfo = textInfo;
    }
}
