<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>

<head>
    <meta charset="UTF-8">
    <title>ueditor demo</title>
    <title>完整demo</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <script type="text/javascript" charset="utf-8" src="ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="lang/zh-cn/zh-cn.js"></script>
</head>
<body>

    <script id="container" type="text/plain" style="width:1024px;height:300px;"></script>

    <button onclick="getContent()">获得内容</button>
    <script type="text/javascript">
        var ue = UE.getEditor('container');
        function getContent() {
        var  arr=[];
        arr.push(UE.getEditor('container').getContent());
        alert(arr.join("\n"));
    }
    </script>

</body>

</html>