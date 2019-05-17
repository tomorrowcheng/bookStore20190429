<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Access-Control-Allow-Origin" content="*" />
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>bookstore</title>
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/common.css">
    <script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="../js/bootstrap.js"></script>
    <script type="text/javascript" src="../js/bookType.js"></script>
    <script type="text/javascript" src="../js/bookInfo.js"></script>
    <%--<script type="text/javascript" src="../js/shoppingCart.js"></script>--%>
    <script type="text/javascript" src="../js/initTableCheckbox.js"></script>
    <script>
        selectAllBookType();
        selectAllBookInfo();
        selectNewBookInfo();
        // selectShopping();
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
            <!--<li><a href="#sellRank" data-toggle="tab">销售排行榜</a></li>-->
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#cart" data-toggle="tab"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>&nbsp;&nbsp;购物车</a></li>
            <li><a href="#order" data-toggle="tab"><span class="glyphicon glyphicon-heart" aria-hidden="true"></span>&nbsp;&nbsp;我的订单</a></li>
            <li><a href="#userInfo" data-toggle="tab"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp;&nbsp;个人信息</a></li>
            <li><a href="#out" data-toggle="tab"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>&nbsp;&nbsp;退出</a></li>
        </ul>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="tab-content">
            <!--新书速递-->
            <div id="newBook" class="tab-pane container">
                <div class="row"></div>
            </div>
            <!--所有图书-->
            <div id="allBook" class="tab-pane active">
                <ul class="nav navbar-nav type">
                    <li class="active"><a href="#allBookType" data-toggle="tab" onclick="">全部种类</a></li>
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
            <!--销售排行榜-->
            <!--<div id="sellRank" class="tab-pane">销售排行榜</div>-->
            <div id="cart" class="tab-pane container">
                <p class="title">我的购物车</p>
                <table id="cartInfo" class="table table-bordered table-hover" style="table-layout: fixed">
                    <thead>
                        <tr class="success">
                            <th style="width: 270px">商品信息</th>
                            <th>单价</th>
                            <th>数量</th>
                            <th>金额</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <img src="/upload/b45d192e-000a-4bcd-9270-8eaf0c82c18atimg.jpg" alt="天才在左，疯子在右" style="width:100px;height:105px">
                                <div style="display:inline;float:right;margin-top:50px"><h5 style="margin-top:5px;margin-bottom:5px;font-weight:bold">天才在左，疯子在右</h5><p style="margin:0"><span>作者:</span>程程</p></div>
                            </td>
                            <td style="color:#b22222;">23.2￥</td>
                            <td>2</td>
                            <td style="color:#b22222;font-size: 16px">46.4￥</td>
                            <td><a href="#">删除</a></td>
                        </tr>
                        <tr>
                            <td>
                                <img src="/upload/f4743ad8-07d7-4c51-8ee6-05a0352b0611panda.jpg" alt="熊猫" style="width:100px;height:105px">
                                <div style="display:inline;float:right;margin-top:50px"><h5 style="margin-top:5px;margin-bottom:5px;font-weight:bold">小熊猫</h5><p style="margin:0"><span>作者:</span>明天</p></div>
                            </td>
                            <td style="color:#b22222;">30.0￥</td>
                            <td>2</td>
                            <td style="color:#b22222;font-size: 16px">60.0￥</td>
                            <td><a href="#">删除</a></td>
                        </tr>
                        <tr>
                            <td>
                                <img src="/upload/b45d192e-000a-4bcd-9270-8eaf0c82c18atimg.jpg" alt="天才在左" style="width:100px;height:120px">
                                <div style="display:inline;float:right;margin-top:50px"><h5 style="margin-top:5px;margin-bottom:5px;font-weight:bold">天才在左</h5><p style="margin:0"><span>作者:</span>程程</p></div>
                            </td>
                            <td style="color:#b22222;">23.2￥</td>
                            <td>1</td>
                            <td style="color:#b22222;font-size: 16px">23.2￥</td>
                            <td><a href="#">删除</a></td>
                        </tr>
                        <tr>
                            <td colspan="5">
                                <span>已选中&nbsp;&nbsp;<span style="color:#4DC7EC">2</span>&nbsp;&nbsp;件商品</span>
                                <a href="#" style="padding-left:20px">删除选中商品</a>
                                <div style="display: inline;float:right">
                                    <span style="color:#777;font-size: 18px;margin-right:8px">应付金额:</span>
                                    <span style="color:#b22222;font-size: 22px;margin-right:10px">83.2￥</span>
                                    <button class="btn-danger btn-lg">结算</button>
                                </div>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div id="order" class="tab-pane container">
                <p class="title">我的订单</p>
                <table id="orderInfo" class="table table-bordered table-hover" style="table-layout: fixed">
                    <thead>
                    <tr class="success">
                        <th style="width: 270px">商品信息</th>
                        <th>数量</th>
                        <th>金额</th>
                        <th>收货信息</th>
                        <th>快递编号</th>
                        <th>订单状态</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>
                            <img src="/upload/f4743ad8-07d7-4c51-8ee6-05a0352b0611panda.jpg" alt="熊猫" style="width:100px;height:105px">
                            <div style="display:inline;float:right;margin-top:50px"><h5 style="margin-top:5px;margin-bottom:5px;font-weight:bold">小熊猫</h5><p style="margin:0"><span>作者:</span>明天</p></div>
                        </td>
                        <td>2</td>
                        <td style="color:#b22222;font-size: 16px">60.0￥</td>
                        <td>
                            <p>南昌大学前湖校区天健园27栋</p>
                            <p>小妮子</p>
                            <p>17689652345</p>
                        </td>
                        <td>无</td>
                        <td>
                            <p style="font-size:16px;color:#777">未发货</p>
                            <a href="#">催单</a>
                            <a href="#" style="color:#b22222">取消订单</a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <img src="/upload/b45d192e-000a-4bcd-9270-8eaf0c82c18atimg.jpg" alt="天才在左" style="width:100px;height:120px">
                            <div style="display:inline;float:right;margin-top:50px"><h5 style="margin-top:5px;margin-bottom:5px;font-weight:bold">天才在左</h5><p style="margin:0"><span>作者:</span>程程</p></div>
                        </td>
                        <td>1</td>
                        <td style="color:#b22222;font-size: 16px">23.2￥</td>
                        <td>
                            <p>南昌大学前湖校区天健园27栋</p>
                            <p>小妮子</p>
                            <p>17689652345</p>
                        </td>
                        <td>4423565735463</td>
                        <td>
                            <p style="font-size:16px;color:#777">已发货</p>
                            <a href="#">签收</a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <img src="/upload/b45d192e-000a-4bcd-9270-8eaf0c82c18atimg.jpg" alt="天才在左，疯子在右" style="width:100px;height:120px">
                            <div style="display:inline;float:right;margin-top:50px"><h5 style="margin-top:5px;margin-bottom:5px;font-weight:bold">天才在左，疯子在右</h5><p style="margin:0"><span>作者:</span>程程</p></div>
                        </td>
                        <td>1</td>
                        <td style="color:#b22222;font-size: 16px">23.2￥</td>
                        <td>
                            <p>南昌大学前湖校区天健园27栋</p>
                            <p>小妮子</p>
                            <p>17689652345</p>
                        </td>
                        <td>4423565735555</td>
                        <td>
                            <p style="font-size:16px;color:#777">已签收</p>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div id="userInfo" class="tab-pane container">
                <div style="display:inline-block;float:left">
                    <img style="display:block;width:200px;height:250px;margin: 0 0 20px 20px;" src="/upload/cdacf04b-ba05-43e1-97ff-7bc3e8ca03311.jpg" alt="熊猫">
                    <div>
                        <p>
                            <span style="font-size: 16px;margin-right:5px">Shopping号:</span>
                            <span>小妮子</span>
                        </p>
                        <p>
                            <span style="font-size: 16px;margin-right:5px">出生日期：</span>
                            <span>2001-01-01</span>
                        </p>
                        <p>
                            <span style="font-size: 16px;margin-right:5px">联系方式</span>
                            <span>17367973828</span>
                        </p>
                    </div>
                </div>
                <div style="display:inline-block;float:right">
                    <p style="font-size: 16px;font-weight: bold;color:#777">我的订单</p>
                    <table class="table table-bordered table-hover">
                        <thead>
                        <tr class="success">
                            <th style="width:250px">收货地址</th>
                            <th style="width:150px">邮编</th>
                            <th style="width:150px">联系人</th>
                            <th style="width:150px">联系方式</th>
                            <th style="width:150px">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>南昌大学前湖校区天健园27栋</td>
                            <td>330031</td>
                            <td>小妮子</td>
                            <td>17367973828</td>
                            <td>
                                <a href="#">修改</a>
                                <a href="#" style="color:#b22222">删除</a>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="5"><a href="#">添加收货信息?</a></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div id="out" class="tab-pane container">
                <p class="title">图书详情</p>
                <div style="width:85%;height:85%;border-color: #000;">
                    <img style="display:inline-block;width:350px;height:400px;margin: 0 20px 20px 20px;float:left;" src="/upload/da9610aa-feaa-4b7b-83c4-540bc12a63c0JS.jpg" alt="JS高级程序设计教程">
                    <div style="display:inline-block;float:right;width:500px">
                        <p>
                            <span style="font-size: 24px;font-weight:bold;">JS高级程序设计教程</span>
                            <a href="#" style="margin-left:40px;font-size:20px;color:#4dc7ec"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>加入购物车</a>
                        </p>
                        <p>
                            <span style="font-size: 16px;margin-right:5px">作者:</span>
                            <span>程程</span>
                        </p>
                        <p>
                            <span style="font-size: 16px;margin-right:5px">价格：</span>
                            <span style="color:#b22222;font-size: 20px;margin-right:10px">59.9￥</span>
                        </p>
                        <p>
                            <span style="font-size: 16px;margin-right:5px">ISBN：</span>
                            <span>9787118027082</span>
                        </p>
                        <p>
                            <span style="font-size: 16px;margin-right:5px">出版社：</span>
                            <span>电子工业出版社</span>
                        </p>
                        <p>
                            <span style="font-size: 16px;margin-right:5px">开本：</span>
                            <span>16开</span>
                        </p>
                        <p>
                            <span style="font-size: 16px;margin-right:5px">总页数：</span>
                            <span>500</span>
                        </p>
                        <p>
                            &nbsp;&nbsp;本书从最早期Netscape浏览器中的JavaScript开始讲起，
                            直到当前它对XML和Web服务的具体支持，内容主要涉及JavaScript的语
                            言特点、JavaScript与浏览器的交互、更高级的JavaScript技巧，以及
                            与在Web应用程序中部署JavaScript解决方案有关的问题，如错误处理、
                            调试、安全性、优化/混淆化、XML和Web服务，最后介绍应用所有这些知
                            识来创建动态用户界面。
                        </p>
                        <button style="float:right" class="btn-info btn">返回</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
