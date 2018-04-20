package com.moviemarket.dao;

import com.moviemarket.model.shoppingTrolley;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingTrolleyDao {
    int deleteByPrimaryKey(Integer id);

    int insert(shoppingTrolley record);

    int insertSelective(shoppingTrolley record);

    shoppingTrolley selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(shoppingTrolley record);

    int updateByPrimaryKey(shoppingTrolley record);
}