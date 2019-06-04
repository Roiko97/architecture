<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>测试用例</title>
    <link rel="shortcut icon" href="/src/favicon.ico">
    <link href="/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">

    <link href="/css/nav.css" rel="stylesheet">
    <link href="/css/testUnit.css" rel="stylesheet">
    <script src="/js/jquery-3.3.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/modula.js"></script>
</head>

<body>
    <!--右侧内容开始-->
    <div class="main" id="main">
        <div class="flex-banner">
            <div class="btn-group">
                <button class="btn btn-default" onclick="javascript:location.href='/jump/toDocument'"><span
                        class="glyphicon glyphicon-arrow-up"></span></button>
                <button class="btn btn-default" onclick="javascript:location.href='/jump/toFileExport'"><span
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
                    <button class="btn btn-info  btn-lg pull-right" data-toggle="modal"
                        data-target="#createProject">创建测试用例</button>
                    <strong class="h2">测试用例</strong>
                    <p><small>创建测试用例有助于提高软件的迭代</small></p>
                </div>
                <div class="list-project">
                    <div class="item hidden">
                        <div class="tip">&nbsp;</div>
                        <div class="top-part">
                            <div class="top-info">
                                <p class="num"><strong>测试次数：</strong>6<strong>次</strong></p>
                                <p class="title"> 111</p>
                                <p class="time"> 2019年3月10日 22时22分</p>
                            </div>
                            <div class="middle-info">
                                <p class="name"><strong>负责人：</strong></p>
                                <p class="content">
                                    111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111
                                </p>
                            </div>
                        </div>
                        <div class="bottom-part">
                            <div class="btn-group btn-group-justified">
                                <div class="btn-group">
                                    <button class="btn btn-default" onclick="openAndClose(this,true)">全部展开<span
                                            class="glyphicon glyphicon-triangle-bottom"></span></button>
                                </div>
                                <div class="btn-group">
                                    <button class="btn btn-default" onclick="openAndClose(this,false)">全部收回<span
                                            class="glyphicon glyphicon-triangle-top"></span></button>
                                </div>
                                <div class="btn-group">
                                    <button class="btn btn-default" type="button" data-toggle="collapse"
                                        data-target="#collapse-hope-0" aria-expanded="false" aria-controls="collapse">
                                        预期结果
                                    </button>
                                </div>
                                <div class="btn-group">
                                    <button class="btn btn-default" type="button" data-toggle="collapse"
                                        data-target="#collapse-process-0" aria-expanded="false"
                                        aria-controls="collapse">
                                        测试过程
                                    </button>
                                </div>
                                <div class="btn-group">
                                    <button class="btn btn-default" type="button" data-toggle="collapse"
                                        data-target="#collapse-result-0" aria-expanded="false" aria-controls="collapse">
                                        测试结果
                                    </button>
                                </div>
                                <div class="btn-group">
                                    <button class="btn btn-default" type="button" data-toggle="collapse"
                                        data-target="#collapse-conclusion-0" aria-expanded="false"
                                        aria-controls="collapse">
                                        测试结论
                                    </button>
                                </div>
                                <div class="btn-group">
                                    <button class="btn btn-default" type="button" data-toggle="collapse"
                                        data-target="#collapse-remarks-0" aria-expanded="false"
                                        aria-controls="collapse">
                                        备注
                                    </button>
                                </div>
                            </div>
                        </div>
                        <div class="collapse" id="collapse-hope-0">
                            <div class="well p"><strong>预期结果</strong>123</div>
                        </div>
                        <div class="collapse" id="collapse-process-0">
                            <div class="well p"><strong>测试过程</strong>123</div>
                        </div>
                        <div class="collapse" id="collapse-result-0">
                            <div class="well p"><strong>测试结果</strong>123</div>
                        </div>
                        <div class="collapse" id="collapse-conclusion-0">
                            <div class="well p"><strong>测试结论</strong>123</div>
                        </div>
                        <div class="collapse" id="collapse-remarks-0">
                            <div class="well p"><strong>备注</strong>123</div>
                        </div>
                    </div>
                    <div class="item hidden" id="">
                        <div class="tip">&nbsp;</div>
                        <div class="top-part">
                            <div class="top-info">
                                <p class="num"><strong>测试次数：</strong>6<strong>次</strong></p>
                                <p class="title"> 111</p>
                                <p class="time"> 2019年3月10日 22时22分</p>
                            </div>
                            <div class="middle-info">
                                <p class="name"><strong>负责人：</strong></p>
                                <p class="content"> </p>
                            </div>
                        </div>
                        <div class="bottom-part">
                            <div class="btn-group btn-group-justified">
                                <div class="btn-group">
                                    <button class="btn btn-default" onclick="openAndClose(this,true)">全部展开<span
                                            class="glyphicon glyphicon-triangle-bottom"></span></button>
                                </div>
                                <div class="btn-group">
                                    <button class="btn btn-default" onclick="openAndClose(this,false)">全部收回<span
                                            class="glyphicon glyphicon-triangle-top"></span></button>
                                </div>
                                <div class="btn-group">
                                    <button class="btn btn-default" type="button" data-toggle="collapse"
                                        data-target="#collapse-hope-1" aria-expanded="false" aria-controls="collapse">
                                        预期结果
                                    </button>
                                </div>
                                <div class="btn-group">
                                    <button class="btn btn-default" type="button" data-toggle="collapse"
                                        data-target="#collapse-process-1" aria-expanded="false"
                                        aria-controls="collapse">
                                        测试过程
                                    </button>
                                </div>
                                <div class="btn-group">
                                    <button class="btn btn-default" type="button" data-toggle="collapse"
                                        data-target="#collapse-result-1" aria-expanded="false" aria-controls="collapse">
                                        测试结果
                                    </button>
                                </div>
                                <div class="btn-group">
                                    <button class="btn btn-default" type="button" data-toggle="collapse"
                                        data-target="#collapse-conclusion-1" aria-expanded="false"
                                        aria-controls="collapse">
                                        测试结论
                                    </button>
                                </div>
                                <div class="btn-group">
                                    <button class="btn btn-default" type="button" data-toggle="collapse"
                                        data-target="#collapse-remarks-1" aria-expanded="false"
                                        aria-controls="collapse">
                                        备注
                                    </button>
                                </div>
                            </div>
                        </div>
                        <div class="collapse" id="collapse-hope-1">
                            <div class="well p"><strong>预期结果</strong>123</div>
                        </div>
                        <div class="collapse" id="collapse-process-1">
                            <div class="well p"><strong>测试过程</strong>123</div>
                        </div>
                        <div class="collapse" id="collapse-result-1">
                            <div class="well p"><strong>测试结果</strong>123</div>
                        </div>
                        <div class="collapse" id="collapse-conclusion-1">
                            <div class="well p"><strong>测试结论</strong>123</div>
                        </div>
                        <div class="collapse" id="collapse-remarks-1">
                            <div class="well p"><strong>备注</strong>123</div>
                        </div>
                    </div>
                    <div class="item hidden" id="">
                        <div class="tip">&nbsp;</div>
                        <div class="top-part">
                            <div class="top-info">
                                <p class="num"><strong>测试次数：</strong>6<strong>次</strong></p>
                                <p class="title"> 111</p>
                                <p class="time"> 2019年3月10日 22时22分</p>
                            </div>
                            <div class="middle-info">
                                <p class="name"><strong>负责人：</strong></p>
                                <p class="content"> </p>
                            </div>
                        </div>
                        <div class="bottom-part">
                            <div class="btn-group btn-group-justified">
                                <div class="btn-group">
                                    <button class="btn btn-default" onclick="openAndClose(this,true)">全部展开<span
                                            class="glyphicon glyphicon-triangle-bottom"></span></button>
                                </div>
                                <div class="btn-group">
                                    <button class="btn btn-default" onclick="openAndClose(this,false)">全部收回<span
                                            class="glyphicon glyphicon-triangle-top"></span></button>
                                </div>
                                <div class="btn-group">
                                    <button class="btn btn-default" type="button" data-toggle="collapse"
                                        data-target="#collapse-hope-2" aria-expanded="false" aria-controls="collapse">
                                        预期结果
                                    </button>
                                </div>
                                <div class="btn-group">
                                    <button class="btn btn-default" type="button" data-toggle="collapse"
                                        data-target="#collapse-process-2" aria-expanded="false"
                                        aria-controls="collapse">
                                        测试过程
                                    </button>
                                </div>
                                <div class="btn-group">
                                    <button class="btn btn-default" type="button" data-toggle="collapse"
                                        data-target="#collapse-result-2" aria-expanded="false" aria-controls="collapse">
                                        测试结果
                                    </button>
                                </div>
                                <div class="btn-group">
                                    <button class="btn btn-default" type="button" data-toggle="collapse"
                                        data-target="#collapse-conclusion-2" aria-expanded="false"
                                        aria-controls="collapse">
                                        测试结论
                                    </button>
                                </div>
                                <div class="btn-group">
                                    <button class="btn btn-default" type="button" data-toggle="collapse"
                                        data-target="#collapse-remarks-2" aria-expanded="false"
                                        aria-controls="collapse">
                                        备注
                                    </button>
                                </div>
                            </div>
                        </div>
                        <div class="collapse" id="collapse-hope-2">
                            <div class="well p"><strong>预期结果</strong>123</div>
                        </div>
                        <div class="collapse" id="collapse-process-2">
                            <div class="well p"><strong>测试过程</strong>123</div>
                        </div>
                        <div class="collapse" id="collapse-result-2">
                            <div class="well p"><strong>测试结果</strong>123</div>
                        </div>
                        <div class="collapse" id="collapse-conclusion-2">
                            <div class="well p"><strong>测试结论</strong>123</div>
                        </div>
                        <div class="collapse" id="collapse-remarks-2">
                            <div class="well p"><strong>备注</strong>123</div>
                        </div>
                    </div>
                    <div class="item hidden" id="">
                        <div class="tip">&nbsp;</div>
                        <div class="top-part">
                            <div class="top-info">
                                <p class="num"><strong>测试次数：</strong>6<strong>次</strong></p>
                                <p class="title"> 111</p>
                                <p class="time"> 2019年3月10日 22时22分</p>
                            </div>
                            <div class="middle-info">
                                <p class="name"><strong>负责人：</strong></p>
                                <p class="content"> </p>
                            </div>
                        </div>
                        <div class="bottom-part">
                            <div class="btn-group btn-group-justified">
                                <div class="btn-group">
                                    <button class="btn btn-default" onclick="openAndClose(this,true)">全部展开<span
                                            class="glyphicon glyphicon-triangle-bottom"></span></button>
                                </div>
                                <div class="btn-group">
                                    <button class="btn btn-default" onclick="openAndClose(this,false)">全部收回<span
                                            class="glyphicon glyphicon-triangle-top"></span></button>
                                </div>
                                <div class="btn-group">
                                    <button class="btn btn-default" type="button" data-toggle="collapse"
                                        data-target="#collapse-hope-3" aria-expanded="false" aria-controls="collapse">
                                        预期结果
                                    </button>
                                </div>
                                <div class="btn-group">
                                    <button class="btn btn-default" type="button" data-toggle="collapse"
                                        data-target="#collapse-process-3" aria-expanded="false"
                                        aria-controls="collapse">
                                        测试过程
                                    </button>
                                </div>
                                <div class="btn-group">
                                    <button class="btn btn-default" type="button" data-toggle="collapse"
                                        data-target="#collapse-result-3" aria-expanded="false" aria-controls="collapse">
                                        测试结果
                                    </button>
                                </div>
                                <div class="btn-group">
                                    <button class="btn btn-default" type="button" data-toggle="collapse"
                                        data-target="#collapse-conclusion-3" aria-expanded="false"
                                        aria-controls="collapse">
                                        测试结论
                                    </button>
                                </div>
                                <div class="btn-group">
                                    <button class="btn btn-default" type="button" data-toggle="collapse"
                                        data-target="#collapse-remarks-3" aria-expanded="false"
                                        aria-controls="collapse">
                                        备注
                                    </button>
                                </div>
                            </div>
                        </div>
                        <div class="collapse" id="collapse-hope-3">
                            <div class="well p"><strong>预期结果</strong>123</div>
                        </div>
                        <div class="collapse" id="collapse-process-3">
                            <div class="well p"><strong>测试过程</strong>123</div>
                        </div>
                        <div class="collapse" id="collapse-result-3">
                            <div class="well p"><strong>测试结果</strong>123</div>
                        </div>
                        <div class="collapse" id="collapse-conclusion-3">
                            <div class="well p"><strong>测试结论</strong>123</div>
                        </div>
                        <div class="collapse" id="collapse-remarks-3">
                            <div class="well p"><strong>备注</strong>123</div>
                        </div>
                    </div>
                    <div class="item hidden" id="">
                        <div class="tip">&nbsp;</div>
                        <div class="top-part">
                            <div class="top-info">
                                <p class="num"><strong>测试次数：</strong>6<strong>次</strong></p>
                                <p class="title"> 111</p>
                                <p class="time"> 2019年3月10日 22时22分</p>
                            </div>
                            <div class="middle-info">
                                <p class="name"><strong>负责人：</strong></p>
                                <p class="content"> </p>
                            </div>
                        </div>
                        <div class="bottom-part">
                            <div class="btn-group btn-group-justified">
                                <div class="btn-group">
                                    <button class="btn btn-default" onclick="openAndClose(this,true)">全部展开<span
                                            class="glyphicon glyphicon-triangle-bottom"></span></button>
                                </div>
                                <div class="btn-group">
                                    <button class="btn btn-default" onclick="openAndClose(this,false)">全部收回<span
                                            class="glyphicon glyphicon-triangle-top"></span></button>
                                </div>
                                <div class="btn-group">
                                    <button class="btn btn-default" type="button" data-toggle="collapse"
                                        data-target="#collapse-hope-4" aria-expanded="false" aria-controls="collapse">
                                        预期结果
                                    </button>
                                </div>
                                <div class="btn-group">
                                    <button class="btn btn-default" type="button" data-toggle="collapse"
                                        data-target="#collapse-process-4" aria-expanded="false"
                                        aria-controls="collapse">
                                        测试过程
                                    </button>
                                </div>
                                <div class="btn-group">
                                    <button class="btn btn-default" type="button" data-toggle="collapse"
                                        data-target="#collapse-result-4" aria-expanded="false" aria-controls="collapse">
                                        测试结果
                                    </button>
                                </div>
                                <div class="btn-group">
                                    <button class="btn btn-default" type="button" data-toggle="collapse"
                                        data-target="#collapse-conclusion-4" aria-expanded="false"
                                        aria-controls="collapse">
                                        测试结论
                                    </button>
                                </div>
                                <div class="btn-group">
                                    <button class="btn btn-default" type="button" data-toggle="collapse"
                                        data-target="#collapse-remarks-4" aria-expanded="false"
                                        aria-controls="collapse">
                                        备注
                                    </button>
                                </div>
                            </div>
                        </div>
                        <div class="collapse" id="collapse-hope-4">
                            <div class="well p"><strong>预期结果</strong>123</div>
                        </div>
                        <div class="collapse" id="collapse-process-4">
                            <div class="well p"><strong>测试过程</strong>123</div>
                        </div>
                        <div class="collapse" id="collapse-result-4">
                            <div class="well p"><strong>测试结果</strong>123</div>
                        </div>
                        <div class="collapse" id="collapse-conclusion-4">
                            <div class="well p"><strong>测试结论</strong>123</div>
                        </div>
                        <div class="collapse" id="collapse-remarks-4">
                            <div class="well p"><strong>备注</strong>123</div>
                        </div>
                    </div>
                    <ul class="text-center pager">
                        <li class="btn btn-default btn-lg" onclick="previous()">上一页</li>
                        <li class="btn btn-default btn-lg" onclick="next()">下一页</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- 创建小组模态框（Modal） -->
    <div class="modal fade" id="createProject" tabindex="-1" role="dialog" aria-labelledby="myModalLabel-1"
        aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header bg-primary">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel-1">创建测试用例</h4>
                </div>
                <form class="form-group" onsubmit="return false">
                    <div class="row modal-form-group">
                        <div class="col-md-10 col-md-offset-1">
                            <div class="input-group">
                                <span class="input-group-addon"><label for="title"
                                        class="control-label">题目</label></span>
                                <input class="form-control" type="text" id="title" name="title" placeholder="请输入题目"
                                    maxlength="50" required="required">
                            </div>
                        </div>
                        <div class="col-md-6 col-md-offset-1">
                            <div class="input-group">
                                <span class="input-group-addon"><label for="name"
                                        class="control-label">姓名</label></span>
                                <input class="form-control" type="text" id="name" name="name" placeholder="请输入姓名"
                                    maxlength="50" required="required">
                            </div>
                        </div>
                        <div class="col-md-3 col-md-offset-1">
                            <div class="input-group">
                                <span class="input-group-addon"><label for="number"
                                        class="control-label">次数</label></span>
                                <input class="form-control" type="text" id="number" name="number" max="1000" min="0"
                                    required="required">
                            </div>
                        </div>
                        <div class="col-md-10 col-md-offset-1">
                            <div class="input-group">
                                <span class="input-group-addon"><label for="content"
                                        class="control-label">内容</label></span>
                                <textarea class="form-control" id="content" name="content" placeholder="请输入测试内容"
                                    maxlength="1000" required="required"></textarea>
                            </div>
                        </div>
                        <div class="col-md-10 col-md-offset-1">
                            <div class="form-group">
                                <label for="hope" class="col-md-12 text-center test-label control-label">预期结果</label>
                                <textarea class="form-control test-input" id="hope" name="hope" placeholder="请输入预期结果"
                                    maxlength="1000" required="required"></textarea>
                            </div>
                        </div>
                        <div class="col-md-10 col-md-offset-1">
                            <div class="form-group">
                                <label for="process" class="col-md-12 text-center test-label control-label">测试过程</label>
                                <textarea class="form-control test-input" id="process" name="process"
                                    placeholder="请输入测试过程" maxlength="1000" required="required"></textarea>
                            </div>
                        </div>
                        <div class="col-md-10 col-md-offset-1">
                            <div class="form-group">
                                <label for="result" class="col-md-12 text-center test-label control-label">测试结果</label>
                                <textarea class="form-control test-input" id="result" name="result"
                                    placeholder="请输入测试结果" maxlength="1000" required="required"></textarea>
                            </div>
                        </div>
                        <div class="col-md-10 col-md-offset-1">
                            <div class="form-group">
                                <label for="conclusion"
                                    class="col-md-12 text-center test-label control-label">测试结论</label>
                                <textarea class="form-control test-input" id="conclusion" name="conclusion"
                                    placeholder="请输入测试结论" maxlength="1000" required="required"></textarea>
                            </div>
                        </div>
                        <div class="col-md-10 col-md-offset-1">
                            <div class="input-group">
                                <span class="input-group-addon"><label for="remarks"
                                        class="control-label">备注</label></span>
                                <textarea class="form-control" id="remarks" name="remarks" placeholder="请输入备注"
                                    maxlength="1000" required="required"></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default btn-lg" data-dismiss="modal">关闭</button>
                        <button type="submit" class="btn btn-success btn-lg" data-loading-text="发送中..."
                            onclick="sendTest(this)">提交</button>
                    </div>
                </form>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
    <!--右侧内容结束-->
    <script src="/js/testunit.js"></script>
    <script src="/js/nav.js"></script>
</body>

</html>