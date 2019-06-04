<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>文档选择</title>
    <link rel="shortcut icon" href="/src/favicon.ico">
    <link href="/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">

    <link href="/css/nav.css" rel="stylesheet">
    <link href="/css/demand.css" rel="stylesheet">
    <script src="/js/jquery-3.3.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
</head>

<body>
    <!--右侧内容开始-->
    <div id="main">
        <div class="flex-banner">
            <div class="btn-group">
                <button class="btn btn-default" onclick="javascript:location.href='/jump/toDevelopment'"><span
                        class="glyphicon glyphicon-arrow-up"></span></button>
                <button class="btn btn-default" onclick="javascript:location.href='/jump/toCommunicate'"><span
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
            <div class="item1">
                <div class="title h3">
                    初级
                    <small>适用于刚刚接触计算机领域，尚未建立工程思维</small>
                </div>
                <p>请选择下面的模板，用于文档填写。<span class="text-danger">(只有队伍创建人可以选择模板，选择模板后，会覆盖原来的模板!）</span></p>
                <div class="process">
                    <div class="thumbnail" onclick="selectModual(1,1)">
                        <img src="/src/1-1.png" alt="模板一">
                        <div class="caption">
                            <strong>实训程序自评表</strong>
                            <p>自我评分，开始认知团队协作的重要性。</p>
                        </div>
                    </div>
                </div>
                <div class="refresh-lock"><img class="img-responsive" src="/src/refresh-lock.png" alt="锁"></div>
            </div>
            <div class="item2">
                <div class="title h3">
                    中级
                    <small>适用于有工程思维，但是还未接触大型项目开发</small>
                </div>
                <p>请选择下面的模板，用于文档填写。<span class="text-danger">(只有队伍创建人可以选择模板，选择模板后，会覆盖原来的模板!）</span></p>
                <div class="process">
                    <div class="thumbnail" onclick="selectModual(2,2)">
                        <img src="/src/2-1.png" alt="模板二">
                        <div class="caption">
                            <strong>课程设计说明书-1</strong>
                            <p>较为简单的开发文档，学会如何编写开发文档。</p>
                        </div>
                    </div>
                    <div class="thumbnail" onclick="selectModual(2,3)">
                        <img src="/src/2-2.png" alt="模板三">
                        <div class="caption">
                            <strong>课程设计说明书-2</strong>
                            <p>内容更多的开发文档，开始自己根据具体内容编写开发文档。</p>
                        </div>
                    </div>
                    <div class="thumbnail" onclick="selectModual(2,4)">
                        <img src="/src/2-3.png" alt="模板四">
                        <div class="caption">
                            <strong>课程设计说明书-3</strong>
                            <p>较为完善的开发文档，能够独立自主的完成一份完善的开发文档。</p>
                        </div>
                    </div>
                </div>
                <div class="lock"><img class="img-responsive" src="/src/lock.png" alt="锁"></div>
            </div>
            <div class="item3">
                <div class="title h3">
                    高级
                    <small>适用于有工程思维，接触过比较大型项目开发，有一定编写文档能力</small>
                </div>
                <p>请选择下面的模板，用于文档填写。<span class="text-danger">(只有队伍创建人可以选择模板，选择模板后，会覆盖原来的模板!）</span></p>
                <div class="process">
                    <div class="thumbnail" onclick="selectModual(3,5)">
                        <img src="/src/3-1.png" alt="模板五">
                        <div class="caption">
                            <strong>《软件工程》</strong>
                            <p>完整的软件开发文档</p>
                        </div>
                    </div>
                </div>
                <div class="lock"><img class="img-responsive" src="/src/lock.png" alt="锁"></div>

            </div>
        </div>
    </div>
    <!--右侧内容结束-->
    <script src="/js/nav.js"></script>
    <script src="/js/demand.js"></script>
</body>

</html>