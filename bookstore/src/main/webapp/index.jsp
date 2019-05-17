<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>bookstore</title>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/common.css">
    <script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="../js/bootstrap.js"></script>
    <script type="text/javascript" src="../js/bookType.js"></script>
    <script type="text/javascript" src="../js/bookInfo.js"></script>
    <script>
        selectAllBookType();
        selectAllBookInfo();
        selectNewBookInfo();
    </script>
</head>
<body style="background-color: #F5F5D5">
<div class="navbar navbar-default" style="text-align: center;background-color: #F8D29D">
    <div class="container">
        <div class="navbar-header">
            <div class="navbar-brand">明天小书屋</div>
        </div>
        <ul class="nav navbar-nav" style="display:inline-block;float:none;font-size:16px">
            <li class="active"><a href="#allBook" data-toggle="tab">所有图书</a></li>
            <li><a href="#newBook" data-toggle="tab">新书速递</a></li>
            <%--<li><a href="#sellRank" data-toggle="tab">销售排行榜</a></li>--%>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#" data-toggle="modal" data-target="#register">注册</a></li>
            <li><a href="#" data-toggle="modal" data-target="#userLogin"><span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>&nbsp;&nbsp;会员登录</a></li>
            <li><a href="#" data-toggle="modal" data-target="#adminLogin"><span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>&nbsp;&nbsp;管理员登录</a></li>
        </ul>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="tab-content">
            <%--新书速递--%>
            <div id="newBook" class="tab-pane container">
                <div class="row"></div>
            </div>
            <%--所有图书--%>
            <div id="allBook" class="tab-pane active">
                <ul class="nav navbar-nav type">
                    <li class="active"><a href="#allBookType" data-toggle="tab" onclick="selectAllBookInfo()">全部种类</a></li>
                    <li id="selectBookName" style="float:right;margin-top:2px">
                        <form style="display:inline;">
                            <input id="bookName" type="text" placeholder="书名">
                            <button type="button" class="btn-small btn-info" onclick="selectBookByName()">
                                <span class="glyphicon glyphicon-search"></span>查询
                            </button>
                        </form>
                    </li>
                </ul>
                <div id="allBookContent" class="tab-content">
                    <div id="allBookType" class="tab-pane active container">
                        <div class="row"></div>
                    </div>
                </div>
            </div>
            <%--销售排行榜--%>
            <%--<div id="sellRank" class="tab-pane">销售排行榜</div>--%>
        </div>
   </div>
    <%--模态框--%>
    <div class="modal fade" id="userLogin" tabindex="-1" role="dialog" aria-labelledby="loginLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-hidden="true">×
                    </button>
                    <h4 class="modal-title" id="loginLabel">
                        会员登录
                    </h4>
                </div>
                <form class="form-horizontal" role="form">
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="shoppingName" class="col-xs-3 control-label">Shopping号：</label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" id="shoppingName" placeholder="Shopping号">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-xs-3 control-label">密码：</label>
                            <div class="col-xs-9">
                                <input type="password" class="form-control" id="password" placeholder="密码">
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default"
                                data-dismiss="modal">返回
                        </button>
                        <button type="button" class="btn btn-primary" onclick="log()">
                            登录
                        </button>
                    </div>
                </form>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
    <div class="modal fade" id="register" tabindex="-1" role="dialog" aria-labelledby="registerLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-hidden="true">×
                    </button>
                    <h4 class="modal-title" id="registerLabel">
                        会员注册
                    </h4>
                </div>
                <form class="form-horizontal" role="form">
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="photo" class="col-xs-3 control-label">添加图片：</label>
                            <div class="col-xs-5">
                                <input type="file" class="form-control" id="photo" onchange="showPreview(this)">
                            </div>
                            <img id="portrait" class="col-xs-4" src="" style="display:none;width: 100px;height:100px;margin-left: 50px" /><br/><br/>
                        </div>
                        <div class="form-group">
                            <label for="shoppingNameAdd" class="col-xs-3 control-label">Shopping号：</label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" id="shoppingNameAdd" placeholder="Shopping号">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="passwordAdd" class="col-xs-3 control-label">密码：</label>
                            <div class="col-xs-9">
                                <input type="password" class="form-control" id="passwordAdd" placeholder="密码">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="passwordAddAgain" class="col-xs-3 control-label">确认密码：</label>
                            <div class="col-xs-9">
                                <input type="password" class="form-control" id="passwordAddAgain" placeholder="确认密码">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="phoneNumber" class="col-xs-3 control-label">联系方式：</label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" id="phoneNumber" placeholder="联系方式">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="birthday" class="col-xs-3 control-label">出生日期：</label>
                            <div class="col-xs-3">
                                <input type="date" class="form-control" id="birthday">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="postcode" class="col-xs-3 control-label">邮编 ：</label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" id="postcode" placeholder="邮编">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="address" class="col-xs-3 control-label">收货地址：</label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" id="address" placeholder="收货地址">
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default"
                                data-dismiss="modal">返回
                        </button>
                        <button type="button" class="btn btn-primary" onclick="log()">
                            注册
                        </button>
                    </div>
                </form>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
</div>
<script>
    function log(){
        alert("登录成功")
    }
    function showPreview(source) {
        var file = source.files[0];
        if(window.FileReader) {
            var fr = new FileReader();
            console.log(fr);
            var portrait = document.getElementById('portrait');
            fr.onloadend = function(e) {
                portrait.src = e.target.result;
            };
            fr.readAsDataURL(file);
            portrait.style.display = 'block';
        }
    }
</script>
</body>
</html>
