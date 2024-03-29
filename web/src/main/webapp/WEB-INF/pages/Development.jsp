<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>开发模式</title>
    <link rel="shortcut icon" href="/src/favicon.ico">
    <link href="/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">

    <link href="/css/nav.css" rel="stylesheet">
    <link href="/css/development.css" rel="stylesheet">
    <script src="/js/jquery-3.3.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/modula.js"></script>
</head>

<body>
    <!--右侧内容开始-->
    <div class="main" id="main">
        <div class="flex-banner">
            <div class="btn-group">
                <button class="btn btn-default" onclick="javascript:location.href='/jump/toSummarize'"><span
                        class="glyphicon glyphicon-arrow-up"></span></button>
                <button class="btn btn-default" onclick="javascript:location.href='/jump/toDemand'"><span
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
            <div class="content" onmouseover="Pause()" onmouseout="Start()">
                <div id="infoCarousel" class="carousel slide">
                    <!-- 轮播（Carousel）指标 -->
                    <ol class="carousel-indicators">
                        <li data-target="#infoCarousel" data-slide-to="0" class="active"></li>
                        <li data-target="#infoCarousel" data-slide-to="1"></li>
                        <li data-target="#infoCarousel" data-slide-to="2"></li>
                    </ol>

                    <!-- 轮播（Carousel）项目 -->
                    <div class="carousel-inner">
                        <div class="item active">
                            <div class="item-info">
                                <h3 class="text-center item-title">——外科手术队伍模式——</h3>
                                <div class="item-body">
                                    <p><strong>外科医生：</strong>亲自定义功能和性能技术说明书，设计程序，编制源代码，测试以及书写技术文档</p>
                                    <p><strong>副手：</strong>作为设计的思考者、讨论者和评估人员.可能编写代码,但对代码的任何部分,不承担具体的开发职责</p>
                                    <p><strong>程序职员：</strong>负责维护编程产品库中所有团队的技术记录,有时也进行相应开发和模块测试.</p>
                                    <p><strong>工具维护人员：</strong>开发一些实用的程序,编制具有目录的函数库以及宏库</p>
                                    <p><strong>测试人员：</strong>负责测试用例的编写,计划测试的步骤和为单元测试搭建测试平台</p>
                                </div>
                            </div>
                        </div>
                        <div class="item">
                            <div class="item-info">
                                <h3 class="text-center item-title">——现代开发模式——</h3>
                                <div class="item-body">
                                    <p><strong>项目经理：</strong>相当于该项目的组长,负责把控项目的整体进度,需求的分析,有时也负责代码的编写</p>
                                    <p><strong>UI设计师：</strong>负责界面的美化和设计,常常需要和前端工程师打交道,需要有美术功底.</p>
                                    <p><strong>开发人员：</strong>负责代码的编写,具体可分为前端工程师,后端工程师等,每个开发人员,都需要自行自己所编写的模块，确保准确无误</p>
                                    <p><strong>测试人员：</strong>负责测试用例的编写,计划测试的步骤和为单元测试搭建测试平台,在现代开发模式中,测试人员的数目往往是最多的.</p>
                                </div>
                            </div>
                        </div>
                        <div class="item">
                            <div class="item-info">
                                <h3 class="text-center item-title">——校内开发模式——</h3>
                                <div class="item-body">
                                    <p><strong>组长：</strong>负责设计该项目的整体框架,采用技术,数据库设计,人员分配,和项目进度. </p>
                                    <p><strong>编码开发人员：</strong>按照组长划分职责进行分工开发.建议：涉及算法方面,将全权交付一人独自完成.强烈建议不要将算法分工.</p>
                                    <p><strong>测试人员及界面设计人员：</strong>任务往往非核心代码,主要方向是解决用户交互方面的问题.不仅如此,还需要完成整个程序的测试.</p>
                                    <p>注*
                                        ：在编者的软件工程实训项目组,采用了外科手术队伍模式结合校内开发的模式进行.设置了前端主代码手一名,后端主代码手一名,并且各配一名副手.最后还有一人完成文档撰写和测试.
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- 轮播（Carousel）导航 -->
                    <a class="left carousel-control" href="#infoCarousel" role="button" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="right carousel-control" href="#infoCarousel" role="button" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
                <p class="tap"> 在一个开发小组中,每个人都有不同的职责,随着实训项目的难度增大,一个高效、良好的团队不可避免的需要详细的分工<br>
                    为此,我们参考了"人月神话"一书,结合我们个人的经验,介绍下述常用的项目配置模式。</p>
            </div>
            <div class="content-content" id="bottom">
                <h3 class="group-title"><img src="/src/member.png" alt="成员">组员管理</h3>
                <p class="group-info">邀请同学加入小组\分配每个人的工作职责.</p>
                <div class="group-main">
                    <div class="form-list">
                        <div class="create-form form-inline" id="create-form" role="form">
                            <div class="form-group">
                                <label class="sr-only" for="endT">开发时限</label>
                                <input class="form-control" id="endT" name="endT" type="number" placeholder="天数"
                                    max="9999" min="1" title="项目开展的天数" required="required">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="heading">组名</label>
                                <input class="form-control" id="heading" name="heading" type="text"
                                    placeholder="请输入小组题目" maxlength="50" title="请输入小组题目" required="required">
                                <button type="button" id="create" disavled="disavled" class="btn btn-success"
                                    onclick="createGroup()" title="创建小组">创建小组</button>
                                <button type="button" id="leave" class="btn btn-danger" onclick="leaveGroup()"
                                    title="离开小组">离开小组</button>
                            </div>
                        </div>
                        <div class="inset-form">
                            <div class="input-group">
                                <input class="form-control" id="receiveid" name="receiveid" type="text"
                                    placeholder="请输入学号" maxlength="13" required="required" title="组员的学号">
                                <span class="input-group-btn">
                                    <button class="btn btn-success" type="button" onclick="addMember()">添加成员</button>
                                </span>
                            </div>
                        </div>
                    </div>
                    <ul class="list-group">
                        <table class="table table-responsive">
                            <thead>
                                <tr class="active">
                                    <td>学号</td>
                                    <td>姓名</td>
                                    <td>职责</td>
                                </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                    </ul>
                    <p id="day-number"></p>
                </div>
            </div>
        </div>

    </div>
    <!--右侧内容结束-->
    <script src="/js/nav.js"></script>
    <script src="/js/development.js"></script>
</body>

</html>