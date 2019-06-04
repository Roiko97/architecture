<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>文档导出</title>
    <link rel="shortcut icon" href="/src/favicon.ico">
    <link href="/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">

    <link href="/css/nav.css" rel="stylesheet">
    <link href="/css/fileexport.css" rel="stylesheet">
    <script src="/js/jquery-3.3.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
</head>

<body>
    <!--右侧内容开始-->
    <div class="main" id="main">
        <div class="flex-banner">
            <div class="btn-group">
                <button class="btn btn-default" onclick="javascript:location.href='/jump/toTestUnit'"><span
                        class="glyphicon glyphicon-arrow-up"></span></button>
                <button class="btn btn-default" disabled><span class="glyphicon glyphicon-arrow-down"></span></button>
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
            <div class="content-header">
                <h1>文档导出&nbsp;&nbsp;&nbsp;&nbsp;<small>——通过文档的形式导出——</small></h1>
            </div>
            <div class="content-body">
                <div class="body-text">
                    <h2>《面向大学生，基于软件工程思维的协同开发系统》</h2>
                    <p>
                        将软件工程的思维内涵进行拆分，以协同的方式分别倾注到学生的每一个阶段。
                    </p>
                    <p>
                        从全局角度来看，学生使用系统的频率、从中学习到知识的深度将会呈现阶梯递增态；从局部来看，每一个"阶梯”，我们都以不同的形式传达软件工程思维。从而达到学生由被动接受，到主动使用，最后到灵活利用，甚至产生创新性的过程。
                    </p>
                    <p>
                        最后，你可以将团队中所有阶段性产物生成一份有效报告。
                    </p>
                </div>
                <div class="body-btn">
                    <form action="/word/exWord" class="download-form" method="post">
                        <button type="submit" class="btn btn-lg btn-primary download">
                            <span class="glyphicon glyphicon-download-alt pull-left"></span>&nbsp;&nbsp;&nbsp;&nbsp;—&nbsp;开发文档下载&nbsp;—
                        </button>
                    </form>
                    <form action="/word/testExport" class="download-form" method="post">
                        <button type="submit" class="btn btn-lg btn-default download">
                            <span class="glyphicon glyphicon-download-alt pull-left"></span>&nbsp;&nbsp;&nbsp;&nbsp;—&nbsp;测试文档下载&nbsp;—
                        </button>
                    </form>
                    <form action="/word/cooperationExport" class="download-form" method="post">
                        <button type="submit" class="btn btn-lg btn-default download">
                            <span class="glyphicon glyphicon-download-alt pull-left"></span>&nbsp;&nbsp;&nbsp;&nbsp;—&nbsp;交流文档下载&nbsp;—
                        </button>
                    </form>
                    <div class="body-banner">
                        <p>
                            <i>支持文档格式：</i>
                            <img src="/src/WORD.png" alt="word" title="dox格式">
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--右侧内容结束-->
    <script src="/js/nav.js"></script>
</body>

</html>