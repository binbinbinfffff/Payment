package com.moviemarket.dao;

import com.moviemarket.model.Movie;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Movie record);

    int insertSelective(Movie record);

    Movie selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Movie record);

    int updateByPrimaryKey(Movie record);
}