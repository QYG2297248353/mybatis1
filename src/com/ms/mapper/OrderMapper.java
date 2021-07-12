package com.ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.ms.pojo.Order;

public interface OrderMapper {
	@Select("select * from order_")
    @Results({
           @Result(property = "id", column = "id"),
           @Result(property = "orderItems", javaType = List.class, column = "id", 
                   many = @Many(select = "com.ms.mapper.OrderItemMapper.listByOrder"))
           })      
   public List<Order> list();
}
