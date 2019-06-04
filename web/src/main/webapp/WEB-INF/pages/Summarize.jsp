<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>主页</title>
    <link rel="shortcut icon" href="/src/favicon.ico">
    <link href="/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">

    <link href="/css/nav.css" rel="stylesheet">
    <link href="/css/summarize.css" rel="stylesheet">
    <script src="/js/jquery-3.3.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
</head>

<body>
    <!--右侧内容开始-->
    <div class="main" id="main">
        <div class="flex-banner">
            <div class="btn-group">
                <button class="btn btn-default" disabled><span class="glyphicon glyphicon-arrow-up"></span></button>
                <button class="btn btn-default" onclick="javascript:location.href='/jump/toDevelopment'"><span
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
            <div class="content-main">
                <div class="content-header">
                    <div class="header">
                        <p class="h1 header-title">面向大学生,基于软件工程思维的协同开发系统</p>
                        <p class="h4 header-info">在这里系统上,你能够解决协同开发所带来的一些非技术性难题<br>
                            并且只要你仔细阅读,你将会感受到软件工程的气息!</p>
                    </div>
                    <div class="list">
                        <a class="list-a" href="/jump/toDevelopment">创建队伍</a>
                        <img src="/src/left.png" alt="右箭头">
                        <a class="list-a" href="/jump/toDevelopment">邀请队友</a>
                        <img src="/src/left.png" alt="右箭头">
                        <a class="list-a" href="/jump/toDemand">共同书写文档</a>
                        <img src="/src/left.png" alt="右箭头">
                        <a class="list-a" href="/jump/toCommunicate">交流开发心得</a>
                        <img src="/src/left.png" alt="右箭头">
                        <a class="list-a" href="/jump/toTestUnit">共同修复BUG</a>
                        <img src="/src/left.png" alt="右箭头">
                        <a class="list-a" href="/jump/toFileExport">文档导出</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--右侧内容结束-->
    <script src="/js/nav.js"></script>
</body>

</html>