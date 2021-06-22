package com.my.dev.entity;

/**
 * 功能描述
 *
 * @author LIUJIANJIAN
 * @date 2021年6月3日14:08:27$
 */
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
@EntityListeners(AuditingEntityListener.class)
@Data
@MappedSuperclass
public abstract class BaseEntity {

    @CreatedBy
    @Column(name = "create_id",columnDefinition = " int COMMENT '创建人ID'")
    public Integer createId;


    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time",columnDefinition = "datetime COMMENT '创建时间'")
    public Date createTime;

    @Column(name = "create_org_id",columnDefinition = "int COMMENT '创建人所属组织'")
    public Integer createOrgId;

    @LastModifiedBy
    @Column(name = "modify_id",columnDefinition = "int COMMENT '修改人ID'")
    public Integer modifyId;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_time",columnDefinition = " datetime COMMENT '修改时间'")
    public Date modifyTime;

    @Column(name = "modify_org_id",columnDefinition = " int COMMENT '修改人所属组织'")
    public Integer modifyOrgId;

    @Column(name = "deleted_flag",columnDefinition = "int COMMENT '逻辑删除 0-未删除 1-已删除'")
    public Integer deletedFlag;

    @Version
    @Column(name = "version_flag",columnDefinition = "int  COMMENT '版本号'")
    public Integer versionFlag;


    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateOrgId() {
        return createOrgId;
    }

    public void setCreateOrgId(Integer createOrgId) {
        this.createOrgId = createOrgId;
    }

    public Integer getModifyId() {
        return modifyId;
    }

    public void setModifyId(Integer modifyId) {
        this.modifyId = modifyId;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getModifyOrgId() {
        return modifyOrgId;
    }

    public void setModifyOrgId(Integer modifyOrgId) {
        this.modifyOrgId = modifyOrgId;
    }

    public Integer getDeletedFlag() {
        return deletedFlag;
    }

    public void setDeletedFlag(Integer deletedFlag) {
        this.deletedFlag = deletedFlag;
    }

    public Integer getVersionFlag() {
        return versionFlag;
    }

    public void setVersionFlag(Integer versionFlag) {
        this.versionFlag = versionFlag;
    }
}
