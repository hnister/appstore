<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>
<div class="clearfix"></div>
<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>修改开发者基础信息 <i class="fa fa-user"></i><small>${devUserSession.devName}</small></h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <form  id="form" class="form-horizontal form-label-left" action="infoupdate" method="post"
                      enctype="multipart/form-data">
                    <input type="hidden" name="id" id="id" value="${devUser.id}">
                    
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">登录名 <span
                                class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="devCode" type="text" class="form-control col-md-7 col-xs-12"
                                   name="devCode" value="${devUser.devCode}" readonly="readonly">
                        </div>
                    </div>

                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">用户名<span
                                class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="devName" class="form-control col-md-7 col-xs-12"
                                   name="devName" value="${devUser.devName}" required="required"
                                   data-validate-length-range="20" data-validate-words="1"
                                   placeholder="请输入用户名" type="text">
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">电子邮箱 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="devEmail" class="form-control col-md-7 col-xs-12"
                                   data-validate-length-range="20" data-validate-words="1" required="required"
                                   name="devEmail" value="${devUser.devEmail}"
                                   placeholder="请输入电子邮箱" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-6 col-md-offset-3">
                            <button id="send" type="button" class="btn btn-success">提交</button>
                            <button type="button" class="btn btn-primary" id="back" onclick="javascript:history.go(-1);">返回</button>
                            <br/><br/>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="common/footer.jsp" %>
<script src="${pageContext.request.contextPath }/statics/localjs/devinfomodify.js"></script>