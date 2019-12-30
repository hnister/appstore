package com.grizzly.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.*;

public class News {
    private int nid;
    private String ntitle;
    private String npublisher;
    private int nviwer;
    private String ncontent;

    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ndate;

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public String getNtitle() {
        return ntitle;
    }

    public void setNtitle(String ntitle) {
        this.ntitle = ntitle;
    }

    public Date getNdate() {
        return ndate;
    }

    public void setNdate(Date ndate) {
        this.ndate = ndate;
    }

    public String getNpublisher() {
        return npublisher;
    }

    public void setNpublisher(String npublisher) {
        this.npublisher = npublisher;
    }

    public int getNviwer() {
        return nviwer;
    }

    public void setNviwer(int nviwer) {
        this.nviwer = nviwer;
    }

    public String getNcontent() {
        return ncontent;
    }

    public void setNcontent(String ncontent) {
        this.ncontent = ncontent;
    }

    @Override
    public String toString() {
        return "News [nid=" + nid + ", ntitle=" + ntitle + ", npublisher=" + npublisher + ", nviwer=" + nviwer
                + ", ncontent=" + ncontent + ", ndate=" + ndate + "]";
    }

}
