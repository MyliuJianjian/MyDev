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
@Table(name = "node_text") //映射的表名称
public class NodeTextEntity extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "text_id")
    private Integer textId;

    @Column(name = "node_id")
    private Integer nodeId;

    @Column(name = "text_info",columnDefinition = " longtext COMMENT '节点名称'")
    private String textInfo;
}
