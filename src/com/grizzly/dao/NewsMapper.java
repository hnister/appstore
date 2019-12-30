package com.grizzly.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.grizzly.model.News;
import org.springframework.stereotype.Repository;

@Repository("newsMapper")
@Mapper
public interface NewsMapper {
    public List<News> listAll();

    public int addNews(News news);

    public int updateNews(News news);

    public int delNews(Integer nid);

    public News getNewsBynid(Integer nid);

    public List<News> getTopNews();
}
