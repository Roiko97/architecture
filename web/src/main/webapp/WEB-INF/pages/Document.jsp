<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>文档填写</title>
    <link rel="shortcut icon" href="/src/favicon.ico">
    <link href="/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">

    <link href="/css/nav.css" rel="stylesheet">
    <link href="/css/document.css" rel="stylesheet">
    <script type="text/javascript" charset="utf-8" src="/js/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="/js/ueditor.all.min.js"></script>
    <!-- 建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败
        这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文 -->
    <script type="text/javascript" charset="utf-8" src="/lang/zh-cn/zh-cn.js"></script>
    <script src="/js/jquery-3.3.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/modula.js"></script>
</head>

<body>
    <!--右侧内容开始-->
    <div class="main" id="main">
        <div class="flex-banner">
            <div class="btn-group">
                <button class="btn btn-default" onclick="javascript:location.href='/jump/toCommunicate'"><span
                        class="glyphicon glyphicon-arrow-up"></span></button>
                <button class="btn btn-default" onclick="javascript:location.href='/jump/toTestUnit'"><span
                        class="glyphicon glyphicon-arrow-down"></span></button>
            </div>
        </div>
        <div class="main-content">
            <nav class="nav-top"><button class="btn btn-info btn-bg pull-left nav-btn" onclick="navStatus()"><span
                        class="glyphicon glyphicon-th-list"></span>导航</button><select class="title-select hidden"
                    onchange="amendTeam(this)">
                </select>
                <div class="pull-right nav-top-right"><a class="btn" onclick="showInfo()"><span
                            class="glyphicon glyphicon-user"></span></a><a class="btn" onclick="openNews()"><span
                            class="glyphicon glyphicon-envelope"></span></a>
                </div>
            </nav>
            <nav class="navbar-left hidden" role="navigation">
                <div class="left-nav">
                    <ul class="nav">
                        <hr><small>前期准备</small>
                        <li><span class="glyphicon glyphicon-home"></span><a
                                href="/jump/toSummarize">主页</a></li>
                        <hr><small>开发</small>
                        <li><span class="glyphicon glyphicon-console"></span><a
                                href="/jump/toDevelopment">开发模式</a></li>
                        <li><span class="glyphicon glyphicon-file"></span><a
                                href="/jump/toDemand">文档选择</a></li>
                        <li><span class="glyphicon glyphicon-phone-alt"></span><a
                                href="/jump/toCommunicate">开发交流</a></li>
                        <hr><small>测试计划</small>
                        <li><span class="glyphicon glyphicon-pencil"></span><a
                                href="/jump/toDocument">文档填写</a></li>
                        <li><span class="glyphicon glyphicon-list-alt"></span><a
                                href="/jump/toTestUnit">测试用例</a></li>
                        <hr><small>结尾</small>
                        <li><span class="glyphicon glyphicon-send"></span><a
                                href="/jump/toFileExport">文档导出</a></li>
                    </ul>
                </div>
            </nav>
            <button type="button" class="btn btn-info revise-text" onclick="showEditor(this)">修改内容</button>
            <div id="show-text" class="show-text">
            </div>
            <div class="content-main">
                <script id="editor" class="editor" type="text/plain"></script>
            </div>
            <div class="fixed-nav hidden">
                <button class="btn btn-warning"
                    onclick="UE.getEditor('editor').setHeight(300);getLocalData()">恢复草稿</button>
                <button class="btn btn-default" onclick="getText()">载入文档</button>
                <button class="btn btn-success" onclick="getContent()">保存提交</button>
                <button class="btn btn-danger" onclick="clearLocalData()">清空</button>
            </div>
        </div>
    </div>
    <!--右侧内容结束-->
    <!-- <div class="header">
                <p class="title">项目开发需求记录及设计</p>
                <p class="info">编者初期认为,需求分析是一个极其繁琐,枯燥的事情.它要求你完成[用户需求分析],[画出时序图,找出实体类],[详细指定实体类与数据库表]等一系列操作.但是随着软件工程项目的逐步推进,
                    假使脱离该步骤,那么最终会导致整个项目崩盘.原因如下：</p>
                <ol>
                    <li>想法的不集中,体现在是集体开发,没有书面的表述,每个人都有天马行空的想法,最终的结果往往差强人意。</li>
                    <li>大肆的变动实体类与数据库中的表 这将导致后端代码会出现大幅度的变动,从而引发意想不到的后果。</li>
                </ol>
                <p class="suggest">编者建议：在项目需求分析及其设计上,建议花费整体开发时间的1/3时常来进行.同期,可以进行技术的分析,以及相应测试需求的编写.最终可能会达到意想不到的效果</p>
            </div> -->
    <script type="text/javascript" src="/js/document.js"></script>
    <script src="/js/btnList.js"></script>
    <script src="/js/nav.js"></script>
</body>

</html>