package com.move.heart.dao;

import com.move.heart.dao.bean.RelationEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: wg
 * @Date: 2020/6/13 5:46 下午
 */
@Repository
public interface RelationDao {

    void concern(@Param("relationEntity") RelationEntity relationEntity);

    List<RelationEntity> queryUserConcern(String userId, int start, int limit);
}
