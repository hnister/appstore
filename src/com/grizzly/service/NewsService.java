package com.grizzly.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.grizzly.model.News;;

public interface NewsService {
    public String listAll(HttpSession session);

    public String addNews(News news);

    public String delNews(Integer nid);

    public String toAddNews();

    public String toEditNews(Integer nid, Model model);

    public Map<String, Object> getNewsBynid(Integer nid);

    public String updateNews(News news);

    public String toNewsPage(Model model);

    public String toShowNews(Model model, Integer nid);
}
