var orderInfoURL="http://localhost:8080/orderInfo/";
var tbody='<tbody>'+'</tbody>';
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg); //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}
function orderInfoErgodic(data){
    $("#orderInfo>tbody").remove();
    $("#orderInfo").append(tbody);
    for(var i in data.data) {
        var orderID = data.data[i].orderID;
       // var userName = data.data[i].user.userName;
        var bookName = data.data[i].bookInfo.bookName;
        var price=data.data[i].bookInfo.price;
        var picture=data.data[i].bookInfo.picture;
        var authorName=data.data[i].authors.authorName;
        var status = data.data[i].status;
        var number = data.data[i].orderNumber;
        var expNum = data.data[i].expNum;
        var linkman = data.data[i].recInfo.linkman;
        var tel = data.data[i].recInfo.tel;
        var address = data.data[i].recInfo.address;
        var bookPicture='<img src="'+picture+'" alt="'+bookName+'" style="width:100px;height:105px">';
        var bookNameDiv='<div style="display:inline;float:right;margin-top:50px">'+'<h5 style="margin-top:5px;margin-bottom:5px;font-weight:bold">'+bookName+'</h5>'+'<p style="margin:0">'+'<span>'+"作者:"+'</span>'+authorName+'</p>'+'</div>';
        var operation1='<p style="font-size:16px;color:#777">'+"未发货"+'</p>'+'<a href="#">'+"催单"+'</a>'+'<a href="#" style="color:#b22222;margin-left: 5px" onclick="updateOrderInfoByStatus2('+orderID+',\''+number+'\',\''+expNum+'\')">'+"取消订单"+'</a>';
        var recInfo='<p>'+address+'</p>'+'<p>'+linkman+'</p>'+'<tel>'+tel+'</tel>';
        var operation2='<p style="font-size:16px;color:#777">'+"已发货"+'</p>'+'<a href="#" onclick="updateOrderInfoByStatus('+orderID+',\''+number+'\',\''+expNum+'\')">'+"签收"+'</a>';
        var operation3='<p style="font-size:16px;color:#777">'+"已签收"+'</p>';
        if(status==0){
            var order0='<td>'+bookPicture+bookNameDiv+'</td>'+'<td>'+number+'</td>'+'<td style="color:#b22222;font-size: 16px">'+price*number+"￥"+'</td>'+'<td>'+recInfo+'</td>'+'<td>'+expNum+'</td>'+'<td>'+operation1+'</td>';
            $("#orderInfo>tbody").append('<tr>'+order0+'</tr>');
        }else if(status==1){
            var order1='<td>'+bookPicture+bookNameDiv+'</td>'+'<td>'+number+'</td>'+'<td style="color:#b22222;font-size: 16px">'+price*number+"￥"+'</td>'+'<td>'+recInfo+'</td>'+'<td>'+expNum+'</td>'+'<td>'+operation2+'</td>';
            $("#orderInfo>tbody").append('<tr>'+order1+'</tr>');
        }else if(status==2){
            var order2='<td>'+bookPicture+bookNameDiv+'</td>'+'<td>'+number+'</td>'+'<td style="color:#b22222;font-size: 16px">'+price*number+"￥"+'</td>'+'<td>'+recInfo+'</td>'+'<td>'+expNum+'</td>'+'<td>'+operation3+'</td>';
            $("#orderInfo>tbody").append('<tr>'+order2+'</tr>');
        }
    }
}
function selectOrderInfo(){
    var userID=getUrlParam("user");
    var myData=JSON.stringify({"userID":userID});
    $.ajax({
        type:"POST",
        url:orderInfoURL+"selectOrderInfo",
        contentType:"application/json",
        crossDomain:true,
        data:myData,
        success:function(data){
            orderInfoErgodic(data);
        }
    })
}
function updateOrderInfoByStatus(orderID,number,expNum){
    var myData=JSON.stringify({"orderID":orderID,"orderNumber":number,"expNum":expNum,"status":2});
    $.ajax({
        type:"POST",
        url:orderInfoURL+"updateOrderInfo",
        data:myData,
        contentType:"application/json",
        crossDomain:true,
        success:function(data){
            orderInfoErgodic(data);
            alert("已签收");
        },
        error: function () {
            alert("签收失败");
        }
    });
}
function updateOrderInfoByStatus2(orderID,number,expNum){
    var myData=JSON.stringify({"orderID":orderID,"orderNumber":number,"expNum":expNum,"status":3});
    $.ajax({
        type:"POST",
        url:orderInfoURL+"updateOrderInfo",
        data:myData,
        contentType:"application/json",
        crossDomain:true,
        success:function(data){
            orderInfoErgodic(data);
            alert("已取消");
        },
        error: function () {
            alert("取消失败");
        }
    });
}