package com.grizzly.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.grizzly.dao.NewsMapper;
import com.grizzly.model.News;
import com.grizzly.service.NewsService;

@Service("News")
@Transactional
public class NewsServicImpl implements NewsService {
    @Resource
    public NewsMapper newsMapper;

    @Override
    public String toNewsPage(Model model) {
        // TODO Auto-generated method stub
        List<News> allnews = newsMapper.listAll();
        model.addAttribute("allnews", allnews);
        return "news";
    }

    @Override
    public String toAddNews() {
        // TODO Auto-generated method stub
        return "news/newsadd";
    }

    @Override
    public String toEditNews(Integer nid, Model model) {
        // TODO Auto-generated method stub
        News news = newsMapper.getNewsBynid(nid);
        model.addAttribute("news", news);
        return "news/newsedit";
    }

    @Override
    public String listAll(HttpSession session) {
        // TODO Auto-generated method stub
        List<News> allnews = newsMapper.listAll();
        session.setAttribute("allnews", allnews);
        return "news/newslist";
    }

    @Override
    public String addNews(News news) {
        // TODO Auto-generated method stub
        news.setNdate(new Date());
        System.out.println(news.toString());
        newsMapper.addNews(news);
        return "redirect:newslist.do";
    }


    @Override
    public String updateNews(News news) {
        // TODO Auto-generated method stub
        news.setNdate(new Date());
        newsMapper.updateNews(news);
        return "redirect:newslist.do";
    }

    @Override
    public String delNews(Integer nid) {
        // TODO Auto-generated method stub
        newsMapper.delNews(nid);
        return "redirect:newslist.do";
    }

    @Override
    public Map<String, Object> getNewsBynid(Integer nid) {
        // TODO Auto-generated method stub
        Map<String, Object> map = new HashMap<String, Object>();
        News news = newsMapper.getNewsBynid(nid);
        map.put("news", news);
        System.out.println(map.toString());
        return map;
    }

    @Override
    public String toShowNews(Model model, Integer nid) {
        // TODO Auto-generated method stub
        News news = newsMapper.getNewsBynid(nid);
        model.addAttribute("news", news);
        return "newsshow";
    }

}
