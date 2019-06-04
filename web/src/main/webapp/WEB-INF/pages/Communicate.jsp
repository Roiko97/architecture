<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>开发交流</title>
    <link rel="shortcut icon" href="/src/favicon.ico">
    <link href="/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">

    <link href="/css/nav.css" rel="stylesheet">
    <link href="/css/communicate.css" rel="stylesheet">
    <script src="/js/jquery-3.3.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/modula.js"></script>
</head>

<body>
    <!--右侧内容开始-->
    <div class="main" id="main">
        <div class="flex-banner">
            <div class="btn-group">
                <button class="btn btn-default" onclick="javascript:location.href='/jump/toDemand'"><span
                        class="glyphicon glyphicon-arrow-up"></span></button>
                <button class="btn btn-default" onclick="javascript:location.href='/jump/toDocument'"><span
                        class="glyphicon glyphicon-arrow-down"></span></button>
            </div>
        </div>
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
                <strong class="h2 text-info">开发交流</strong>
                <p><small class="text-info">在功能开发过程中，需要和队友交流，以确保开发方向正确无误。</small></p>
                <form class="form-group" id="send-communicate" onsubmit="return false">
                    <div class="input-group">
                        <input type="text" class="form-control" id="heading" name="heading" required="required"
                            placeholder="请输入开发相关题目" maxlength="100">
                    </div>
                    <textarea name="data" id="data" style="margin-top:1%;" class="form-control bottom-input" rows="3"
                        required="required" placeholder="请输入开发相关内容" maxlength="1000"></textarea>
                    <div class="btn-group">
                        <button class="btn btn-success pull-left" id="submit" style="margin-top:10%;"
                            data-loading-text="发布中..." onclick="createNews(this)"><img src="/src/submit.png"
                                alt="创建">发布</button>
                    </div>
                </form>
            </div>
            <div class="item hidden" id="">
                <div class="item-header">
                    <p class="item-title pull-left"><strong>题目：</strong></p>
                    <p class="item-author pull-right"><strong>发布者：</strong>何俊泽</p>
                </div>
                <div class="item-body">
                    <p class="item-news">
                    </p>
                </div>
                <div class="item-footer">
                    <span class="label label-primary pull-right">2019年4月3日 18:33:38</span>
                </div>
            </div>
            <div class="item hidden">
                <div class="item-header">
                    <p class="item-title pull-left"><strong>题目：</strong></p>
                    <p class="item-author pull-right"><strong>发布者：</strong></p>
                </div>
                <div class="item-body">
                    <p class="item-news">
                    </p>
                </div>
                <div class="item-footer">
                    <span class="label label-primary pull-right"></span>
                </div>
            </div>
            <div class="item hidden" id="">
                <div class="item-header">
                    <p class="item-title pull-left"><strong>题目：</strong></p>
                    <p class="item-author pull-right"><strong>发布者：</strong></p>
                </div>
                <div class="item-body">
                    <p class="item-news">
                    </p>
                </div>
                <div class="item-footer">
                    <span class="label label-primary pull-right"></span>
                </div>
            </div>
            <div class="item hidden" id="">
                <div class="item-header">
                    <p class="item-title pull-left"><strong>题目：</strong></p>
                    <p class="item-author pull-right"><strong>发布者：</strong></p>
                </div>
                <div class="item-body">
                    <p class="item-news">
                    </p>
                </div>
                <div class="item-footer">
                    <span class="label label-primary pull-right"></span>
                </div>
            </div>
            <div class="item hidden" id="">
                <div class="item-header">
                    <p class="item-title pull-left"><strong>题目：</strong></p>
                    <p class="item-author pull-right"><strong>发布者：</strong></p>
                </div>
                <div class="item-body">
                    <p class="item-news">
                    </p>
                </div>
                <div class="item-footer">
                    <span class="label label-primary pull-right"></span>
                </div>
            </div>
            <div class="item hidden" id="">
                <div class="item-header">
                    <p class="item-title pull-left"><strong>题目：</strong></p>
                    <p class="item-author pull-right"><strong>发布者：</strong></p>
                </div>
                <div class="item-body">
                    <p class="item-news">
                    </p>
                </div>
                <div class="item-footer">
                    <span class="label label-primary pull-right"></span>
                </div>
            </div>
            <div class="item hidden" id="">
                <div class="item-header">
                    <p class="item-title pull-left"><strong>题目：</strong></p>
                    <p class="item-author pull-right"><strong>发布者：</strong></p>
                </div>
                <div class="item-body">
                    <p class="item-news">
                    </p>
                </div>
                <div class="item-footer">
                    <span class="label label-primary pull-right"></span>
                </div>
            </div>
        </div>
        <ul class="text-center pager">
            <li class="btn btn-default btn-lg" onclick="previous()">上一页</li>
            <li class="btn btn-default btn-lg" onclick="next()">下一页</li>
        </ul>
    </div>
    <!--右侧内容结束-->
    <script src="/js/communicate.js"></script>
    <script src="/js/nav.js"></script>
</body>

</html>