package com.moviemarket.dao;

import com.moviemarket.model.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao {
    int deleteByPrimaryKey(Integer order_id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer order_id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}