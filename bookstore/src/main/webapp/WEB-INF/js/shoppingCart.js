var shoppingURL="http://localhost:8080/shopping/";
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg); //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}

function shoppingCartErgodic(data){
    $("#cartInfo>tbody").remove();
    $("#cartInfo").append(tbody);
    for(var i in data.data){
        var shoppingID=data.data[i].shoppingID;
        var picture=data.data[i].bookInfo.picture;
        var bookID=data.data[i].bookInfo.bookID;
        var bookName=data.data[i].bookInfo.bookName;
        var authorName=data.data[i].authors.authorName;
        var number=data.data[i].number;
        var price=data.data[i].bookInfo.price;
        var totalPrice=price*number;
        var img='<img src="'+picture+'" alt="'+bookName+'" style="width:120px;height:135px">';
        var title='<h5 style="margin-top:5px;margin-bottom:5px;font-weight:bold">'+bookName+'</h5>';
        var author='<p style="margin:0">'+'<span>'+"作者:"+'</span>'+authorName+'</p>';
        var numberInput='<input id="shoppingID'+shoppingID+'" type="number" value="'+number+'" style="width:40px;border-width:0;" onchange="updateShopping('+shoppingID+')">';
        //var priceSpan='<p style="margin:0;color:#b22222">'+'<span>'+"价格："+'</span>'+price+"￥"+'</p>';
        var info='<td>'+img+'<div style="display:inline;float:right;margin-top:50px">'+title+author+'</div>'+'</td>';
        var tr='<tr>'+info+'<td style="color:#b22222;font-size: 18px">'+price+"￥"+'</td>'+'<td>'+numberInput+'</td>'+'<td style="color:#b22222;font-size: 18px">'+totalPrice+"￥"+'</td>'+'<td>'+'<a href="#" data-toggle="modal" data-target="#insertOrder" onclick="insertOrder('+bookID+',\''+bookName+'\',\''+number+'\')">'+"结算"+'</a>'+'<a href="#" style="color:#b22222;margin-left:10px" onclick="deleteShopping('+shoppingID+')">'+"删除"+'</a>'+'</td>'+'</tr>'
        $("#cartInfo>tbody").append(tr);
    }
}

function updateShopping(shoppingID){
    var number=$("#shoppingID"+shoppingID).val();
    var myData=JSON.stringify({"shoppingID":shoppingID,"number":number});
    $.ajax({
        type:"POST",
        url:shoppingURL+"updateShopping",
        contentType:"application/json",
        crossDomain:true,
        data:myData,
        success:function(data){
            shoppingCartErgodic(data);
        }
    });
}

function selectShopping(){
    var userID=getUrlParam("user");
    var myData=JSON.stringify({"userID":userID});
    $.ajax({
        type:"POST",
        url:shoppingURL+"selectShopping",
        contentType:"application/json",
        crossDomain:true,
        data:myData,
        success:function(data){
            shoppingCartErgodic(data);
        }
    });
}

function insertShopping(bookID){
    var userID=getUrlParam("user");
    var myData=JSON.stringify({"userID":userID,"bookID":bookID,"number":1});
    $.ajax({
        type:"POST",
        url:shoppingURL+"insertShopping",
        contentType:"application/json",
        crossDomain:true,
        data:myData,
        success:function(data){
            shoppingCartErgodic(data);
            alert("添加购物车成功");
        }
    });
}

function insertShopping2(){
    var userID=getUrlParam("user");
    var bookID=$("#bookIDDetailSelect").val();
    var myData=JSON.stringify({"userID":userID,"bookID":bookID,"number":1});
    $.ajax({
        type:"POST",
        url:shoppingURL+"insertShopping",
        contentType:"application/json",
        crossDomain:true,
        data:myData,
        success:function(data){
            shoppingCartErgodic(data);
            alert("添加购物车成功");
        }
    });
}

function deleteShopping(shoppingID){
    var myData=JSON.stringify({"shoppingID":shoppingID});
    $.ajax({
        type:"POST",
        url:shoppingURL+"deleteShopping",
        contentType:"application/json",
        crossDomain:true,
        data:myData,
        success:function(){
            // shoppingCartErgodic(data);
            alert("删除成功");
        }
    });
}

function insertOrder(bookID,bookName,number){
    $("#insertBookIDCart").val(bookID);
    $("#insertBookNumberCart").val(number);
    $("#insertBookNameCart").val(bookName);
}

function insertOrderReal(){
    var userID=getUrlParam("user");
    var bookID=$("#insertBookIDCart").val();
    var orderNumber=$("#insertBookNumberCart").val();
    var recID=$("#insertRecInfoCart").val();
    var myData=JSON.stringify({
        "userID":userID,
        "bookID":bookID,
        "recID":recID,
        "orderNumber":orderNumber,
        "expNum":"无",
        "status":"0"
    });
    $.ajax({
        type:"POST",
        url:"http://localhost:8080/orderInfo/insertOrderInfo",
        contentType:"application/json",
        crossDomain:true,
        data:myData,
        success:function(){
            alert("添加订单成功");
        }
    })
}