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
    <script type="text/javascript" src="../js/holder.js"></script>
</head>
<body>
<div class="navbar navbar-default" style="text-align: center">
    <div class="container">
        <div class="navbar-header">
            <div class="navbar-brand">明天小书屋</div>
        </div>
        <ul class="nav navbar-nav" style="display:inline-block;float:none">
            <li class="active"><a href="#newBook" data-toggle="tab">新书速递</a></li>
            <li><a href="#allBook" data-toggle="tab">所有图书</a></li>
            <li><a href="#sellRank" data-toggle="tab">销售排行榜</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp;&nbsp;登录</a></li>
        </ul>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="tab-content">
            <div id="newBook" class="tab-pane active">
                <ul class="nav navbar-nav type">
                    <li class="active"><a href="#allType" data-toggle="tab">全部种类</a></li>
                    <li><a href="#type1" data-toggle="tab">type1</a></li>
                    <li><a href="#type2" data-toggle="tab">type2</a></li>
                </ul>
                <div class="tab-content">
                    <div id="allType" class="tab-pane active container">
                        <div class="row">
                            <div class="col-sm-3">
                                <div class="thumbnail"><img src="holder.js/171px180" alt="..."></div>
                            </div>
                            <div class="col-sm-3">
                                <div class="thumbnail"><img src="holder.js/171px180" alt="..."></div>
                            </div>
                            <div class="col-sm-3">
                                <div class="thumbnail"><img src="holder.js/171px180" alt="..."></div>
                            </div>
                            <div class="col-sm-3">
                                <div class="thumbnail"><img src="holder.js/171px180" alt="..."></div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-3">
                                <div class="thumbnail"><img src="holder.js/171px180" alt="..."></div>
                            </div>
                            <div class="col-sm-3">
                                <div class="thumbnail"><img src="holder.js/171px180" alt="..."></div>
                            </div>
                            <div class="col-sm-3">
                                <div class="thumbnail"><img src="holder.js/171px180" alt="..."></div>
                            </div>
                            <div class="col-sm-3">
                                <div class="thumbnail"><img src="holder.js/171px180" alt="..."></div>
                            </div>
                        </div>
                    </div>
                    <div id="type1" class="tab-pane">type1</div>
                    <div id="type2" class="tab-pane">type2</div>
                </div>
            </div>
            <div id="allBook" class="tab-pane">所有图书</div>
            <div id="sellRank" class="tab-pane">销售排行榜</div>
        </div>
   </div>
</div>
</body>
</html>
