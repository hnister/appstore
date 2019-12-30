package com.grizzly.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.grizzly.model.News;
import com.grizzly.service.NewsService;

@Controller
public class NewsController {
	
    @Autowired
    private NewsService newsService;

    @RequestMapping("/tonewspage")
    public String toNewsPage(Model model) {
        return newsService.toNewsPage(model);
    }

    @RequestMapping("/newslist")
    public String listAll(HttpSession session) {
        return newsService.listAll(session);
    }

    @RequestMapping("/addnews")
    public String addNews(News news) {
        return newsService.addNews(news);
    }

    @RequestMapping("/delnews")
    public String delNews(Integer nid) {
        return newsService.delNews(nid);
    }

    @RequestMapping("/toaddnews")
    public String toAddNews() {
        return newsService.toAddNews();
    }

    @RequestMapping("/toeditnews")
    public String toEditNews(Integer nid, Model model) {
        return newsService.toEditNews(nid, model);
    }

    @RequestMapping("/updatenews")
    public String updateNews(News news) {
        return newsService.updateNews(news);
    }

    @ResponseBody
    @RequestMapping("/getnewsbynid")
    public Object getNewsBynid(Integer nid) {
        return newsService.getNewsBynid(nid);
    }

    @RequestMapping("/toshownews")
    public Object toShowNews(Model model, Integer nid) {
        return newsService.toShowNews(model, nid);
    }
}
