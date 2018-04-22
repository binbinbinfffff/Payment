package com.moviemarket.dao;

import com.moviemarket.model.Comment;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}