package com.my.dev.entity.nodeinfo;

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
@Entity //声明一个实体，用的是Java规范下的注解
@Table(name = "node_info") //映射的表名称
public class NodeInfoEntity extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "node_id")
    private Integer nodeId;

    @Column(name = "node_level",columnDefinition = " int COMMENT '节点层级'")
    private Integer nodeLevel;

    @Column(name = "node_parent",columnDefinition = " int COMMENT '父节点'")
    private Integer nodeParent;

    @Column(name = "node_name",columnDefinition = " varchar(20) COMMENT '节点名称'")
    private String nodeName;
}
