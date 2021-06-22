package com.my.dev.JpaRepository;

import com.my.dev.entity.nodeinfo.NodeTextEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NodeTextRepository extends JpaSpecificationExecutor<NodeTextEntity>, JpaRepository<NodeTextEntity, Integer>{
}
