<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head lang="zh">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="shortcut icon" href="/src/favicon.ico">
    <link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="/css/bootstrap.css" rel="stylesheet" type="text/css" />
    <link href="/css/on.css" rel="stylesheet" type="text/css" />

    <title>面向大学生基于软件工程思维协同开发系统</title>
</head>

<body class="ms-windows">
    <div class="Goods-home">
        <div class="Goods-content">
            <div class="Goods-content-cell-whiteBlock">
                <div class="Goods-content-cell-whiteBlockcontent">
                    <div class="whiteBlockcontent-Header">
                        <img class="imgLogo" src="/src/LOGO1.gif" />
                    </div>
                    <h1 class="whiteBlockcontent-Title">软件开发协同系统</h1>
                    <div class="whiteBlockcontentform">
                        <div class="row">
                            <div class="col-md-16">
                                <div class="form-top">
                                    <div class="form-top-left">
                                        <h3 class="text-center" id="login-title">用户登录</h3>
                                    </div>
                                </div>
                                <div class="form-bottom">
                                    <form role="form" method="post"  class="login-form" id="login">
                                        <div class="form-group">
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="glyphicon glyphicon-user"
                                                        aria-hidden="true"></span></span>
                                                <input type="text" id="userName" name="student_id" class="form-control"
                                                    placeholder="账号" autocomplete="on" required="required" aria-describedby="basic-addon1" maxlength="13" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="input-group">
                                                <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-lock"
                                                        aria-hidden="true"></span></span>
                                                <input  type="password" name="password" id="userPaw" class="form-control"
                                                    placeholder="密码" required="required" aria-describedby="basic-addon2"  maxlength="13"/>
                                            </div>
                                        </div>
                                    </form>
                                    <button class="btn btn-success btn-lg center-block" id="btn-submit" onclick="login(this)">登录</button>
                                </div>
                                <p>（大三）账号：2016030403104&nbsp;&nbsp;&nbsp;&nbsp;密码:hj5201314</p>
                                <p>（大二）账号：2016030403117&nbsp;&nbsp;&nbsp;&nbsp;密码:a123456</p>
                                <p>（大一）账号：2016030403118&nbsp;&nbsp;&nbsp;&nbsp;密码:a123456</p>
                            </div>
                        </div>
                    </div>


                </div>
            </div>
            <div class="Goods-content-cell-blueBlock">
                <div class="Goods-content-cell-blueBlockcontent">
                    <div class="Goods-content-cell-blueBlockcontent-item">
                        <span class="Icon fa fa-search">
                        </span>解决团队协作的沟通问题。
                    </div>
                    <div class="Goods-content-cell-blueBlockcontent-item">
                        <span class="Icon fa fa-comment-o">
                        </span>体验高效的开发环境。
                    </div>
                    <div class="Goods-content-cell-blueBlockcontent-item">
                        <span class="Icon fa fa-home">
                        </span>从程序员到项目经理的培养。
                    </div>
                </div>
            </div>
        </div>
        <div class="Goods-footer Goods-footer-fixed">
            <ul class="Goods-footer-list">
                <li class="Goods-footer-item">
                    <a class="a-style" href="#" rel="noopener">关于</a>
                </li>
                <li class="Goods-footer-item">
                    <a class="a-style" href="#" rel="noopener">帮助中心</a>
                </li>
                <li class="Goods-footer-item">
                    <a class="a-style" href="#" rel="noopener">广告</a>
                </li>
                <li class="Goods-footer-item">
                    <a class="a-style" href="#" rel="noopener">开发者</a>
                </li>
                <li class="Goods-footer-item Goods-footer-coryright">© 2018 Goods Team </li>
            </ul>
        </div>
    </div>
    <script src="/js/jquery-3.3.1.min.js" type="text/javascript"></script>
    <script src="/js/bootstrap.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="/js/on.js"></script>
</body>
</html>