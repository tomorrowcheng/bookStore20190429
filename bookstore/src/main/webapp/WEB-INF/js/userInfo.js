var recInfoURL="http://localhost:8080/recInfo/";
var tbody='<tbody>'+'</tbody>';
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg); //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}
function userSelectFun(){
    var userID=getUrlParam("user");
    var myData=JSON.stringify({"userID":userID});
    $.ajax({
        type:"POST",
        url:"http://localhost:8080/user/selectUserOnly",
        contentType:"application/json",
        data:myData,
        crossDomain:true,
        success:function(data){
            var userName=data.data[0].userName;
            var photo=data.data[0].userPhoto;
            // var tel=data.data.recInfo.tel;
            $("#userPhotoSelect").attr("src",photo);
            $("#userPhotoSelect").attr("alt",userName);
            $("#userNameSelect").html(userName);
            // $("#phoneNumberSelect").val(tel);
        }
    })
}
function recInfoErgodic(data){
    $("#recInfoTable>tbody").remove();
    $("#recInfoTable").append(tbody);
    $("#insertRecInfoCart>option").remove();
    for(var i in data.data){
        var recID=data.data[i].recID;
        var address=data.data[i].address;
        var postcode=data.data[i].postcode;
        var linkman=data.data[i].linkman;
        var tel=data.data[i].tel;
        var operation='<a href="#" style="margin-right:20px" data-toggle="modal" data-target="#updateRecInfo" onclick="updateRecInfo('+recID+',\''+address+'\',\''+postcode+'\',\''+linkman+'\',\''+tel+'\')">'+"修改"+'</a>'+'<a href="#" style="color:#b22222" onclick="deleteRecInfoFun('+recID+')">'+"删除"+'</a>';
        var recInfo='<td>'+address+'</td>'+'<td>'+postcode+'</td>'+'<td>'+linkman+'</td>'+'<td>'+tel+'</td>'+'<td>'+operation+'</td>';
        $("#recInfoTable>tbody").append('<tr>'+recInfo+'</tr>');
        var option='<option value="'+recID+'">'+address+"&nbsp;&nbsp;"+linkman+'</option>';
        $("#insertRecInfoCart").append(option);
    }
    var td='<td colspan="5">'+'<a href="#" data-toggle="modal" data-target="#insertRecInfo"">'+"添加收货信息?"+'</a>'+'</td>';
    $("#recInfoTable>tbody").append('<tr>'+td+'</tr>');
}
function recInfoSelectFun(){
    var userID=getUrlParam("user");
    var myData=JSON.stringify({"userID":userID});
    $.ajax({
        type:"POST",
        url:recInfoURL+"selectRecInfo",
        data:myData,
        contentType:"application/json",
        crossDomain:true,
        success:function(data){
            recInfoErgodic(data);
            var photoNumber=data.data[0].tel;
            $("#phoneNumberSelect").html(photoNumber);
        }
    })
}
function insertRecInfoFun(){
    var userID=getUrlParam("user");
    var address=$("#insertAddress").val();
    var postcode=$("#insertPostcode").val();
    var linkman=$("#insertLinkman").val();
    var tel=$("#insertTel").val();
    var myData=JSON.stringify({
        "userID":userID,
        "address":address,
        "postcode":postcode,
        "linkman":linkman,
        "tel":tel
    });
    $.ajax({
        type:"POST",
        url:recInfoURL+"insertRecInfo",
        data:myData,
        contentType:"application/json",
        crossDomain:true,
        success:function(data){
            recInfoErgodic(data);
        }
    });
    $("#insertRecInfo").modal("hide");
}
function updateRecInfo(recID,address,postcode,linkman,tel){
    $("#updateRecID").val(recID);
    $("#updateAddress").val(address);
    $("#updatePostcode").val(postcode);
    $("#updateLinkman").val(linkman);
    $("#updateTel").val(tel);
}
function updateRecInfoFun(){
    var recID=$("#updateRecID").val();
    var address=$("#updateAddress").val();
    var postcode=$("#updatePostcode").val();
    var linkman=$("#updateLinkman").val();
    var tel=$("#updateTel").val();
    var myData=JSON.stringify({
        "recID":recID,
        "address":address,
        "postcode":postcode,
        "linkman":linkman,
        "tel":tel
    });
    $.ajax({
        type:"POST",
        url:recInfoURL+"updateRecInfo",
        data:myData,
        contentType:"application/json",
        crossDomain:true,
        success:function(data){
            recInfoErgodic(data);
        }
    });
    $("#updateRecInfo").modal("hide");
}
function deleteRecInfoFun(recID){
    var myData=JSON.stringify({"recID":recID});
    $.ajax({
        type:"POST",
        url:recInfoURL+"deleteRecInfo",
        data:myData,
        contentType:"application/json",
        crossDomain:true,
        success:function(data){
            recInfoErgodic(data);
            alert("删除成功，请刷新！");
        }
    })
}
function userLogout(){
    var href="http://localhost:8080";
    if(confirm("确认退出图书在线销售系统吗？")){
        window.location.href=href;
    }
}