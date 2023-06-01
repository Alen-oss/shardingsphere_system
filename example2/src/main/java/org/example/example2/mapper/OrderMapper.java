package org.example.example2.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {

    @Insert("insert into t_order(user_id, total_price, state, create_time, update_time) values(#{user_id}, #{total_price}, #{state}, now(), now())")
    void insert(@Param("user_id") String user_id, @Param("total_price") String total_price, @Param("state") Integer state);
}
