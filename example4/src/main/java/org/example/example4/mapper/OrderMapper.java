package org.example.example4.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.example4.config.Master;
import org.example.example4.config.Slave;

@Mapper
public interface OrderMapper {

    @Master
    @Insert("insert into t_order(user_id, total_price, state, create_time, update_time) values(#{user_id}, #{total_price}, #{state}, now(), now())")
    void insert(@Param("user_id") String user_id, @Param("total_price") String total_price, @Param("state") Integer state);

    @Slave
    @Select("select user_id from t_order where order_id = #{order_id}")
    String getUserId(@Param("order_id") String order_id);
}
