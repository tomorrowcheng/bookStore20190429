var orderInfoURL="http://localhost:8080/orderInfo/";
var tbody='<tbody>'+'</tbody>';
function orderInfoErgodic(data){
    $("#orderInfoManageTable>tbody").remove();
    $("#orderInfoManageTable").append(tbody);
    for(var i in data.data){
        var orderID=data.data[i].orderID;
        var userName=data.data[i].user.userName;
        var bookName=data.data[i].bookInfo.bookName;
        var status=data.data[i].status;
        var number=data.data[i].orderNumber;
        var expNum=data.data[i].expNum;
        var linkman=data.data[i].recInfo.linkman;
        var tel=data.data[i].recInfo.tel;
        var address=data.data[i].recInfo.address;
        var operation='<a href="#" style="margin-right:20px" data-toggle="modal" data-target="#updateOrderInfo" onclick="updateOrderInfo('+orderID+',\''+userName+'\',\''+bookName+'\',\''+number+'\',\''+linkman+'\',\''+tel+'\',\''+expNum+'\',\''+address+'\',\''+status+'\')">'+"查看详情"+'</a>'+'<a href="#" style="color:#b22222" onclick="deleteOrderInfo('+orderID+')">'+"删除"+'</a>';
        if(status==0){
            var order0='<td>'+orderID+'</td>'+'<td>'+userName+'</td>'+'<td>'+bookName+'</td>'+'<td>'+"未发货"+'</td>'+'<td>'+operation+'</td>';
            $("#orderInfoManageTable>tbody").append('<tr>'+order0+'</tr>');
        }else if(status==1){
            var order1='<td>'+orderID+'</td>'+'<td>'+userName+'</td>'+'<td>'+bookName+'</td>'+'<td>'+"已发货"+'</td>'+'<td>'+operation+'</td>';
            $("#orderInfoManageTable>tbody").append('<tr>'+order1+'</tr>');
        }else if(status==2){
            var order2='<td>'+orderID+'</td>'+'<td>'+userName+'</td>'+'<td>'+bookName+'</td>'+'<td>'+"已签收"+'</td>'+'<td>'+operation+'</td>';
            $("#orderInfoManageTable>tbody").append('<tr>'+order2+'</tr>');
        }else{
            var order3='<td>'+orderID+'</td>'+'<td>'+userName+'</td>'+'<td>'+bookName+'</td>'+'<td>'+"已取消"+'</td>'+'<td>'+operation+'</td>';
            $("#orderInfoManageTable>tbody").append('<tr>'+order3+'</tr>');
        }
    }
}
function selectAllOrderInfo(){
    $.ajax({
        type:"POST",
        url:orderInfoURL+"selectAllOrderInfo",
        contentType:"application/json",
        crossDomain:true,
        success:function(data){
            orderInfoErgodic(data);
        }
    })
}
function updateOrderInfo(orderID,userName,bookName,number,linkman,tel,expNum,address,status){
    $("#updateOrderInfoID").val(orderID);
    $("#userName_order").val(userName);
    $("#bookName_order").val(bookName);
    $("#number_order").val(number);
    $("#linkman_order").val(linkman);
    $("#tel_order").val(tel);
    $("#expNum_order").val(expNum);
    $("#address_order").val(address)
    $("#status_order").val(status);
}
function updateOrderInfoReal(){
    var orderID=$("#updateOrderInfoID").val();
    var number=$("#number_order").val();
    var expNum=$("#expNum_order").val();
    var status=$("#status_order").val();
    var myData=JSON.stringify({"orderID":orderID,"orderNumber":number,"expNum":expNum,"status":status});
    $.ajax({
        type:"POST",
        url:orderInfoURL+"updateOrderInfo",
        data:myData,
        contentType:"application/json",
        crossDomain:true,
        success:function(data){
            orderInfoErgodic(data);
            alert("修改成功");
        },
        error: function () {
            alert("修改失败");
        }
    });
    $("#updateOrderInfo").modal("hide");
}
function deleteOrderInfo(orderID){
    var myData=JSON.stringify({"orderID":orderID});
    $.ajax({
        type:"POST",
        url:orderInfoURL+"deleteOrderInfo",
        data:myData,
        contentType:"application/json",
        crossDomain:true,
        success:function(data){
            orderInfoErgodic(data);
            alert("删除成功");
        },
        error: function () {
            alert("删除失败");
        }
    })
}
function selectOrderInfo(){
    var status=$("#selectStatus").val();
    var myData=JSON.stringify({"status":status});
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