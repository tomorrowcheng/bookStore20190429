var userURL="http://localhost:8080/user/";
var tbody='<tbody>'+'</tbody>';
function userErgodic(data){
    $("#userInfoManageTable>tbody").remove();
    $("#userInfoManageTable").append(tbody);
    for(var i in data.data){
        var userID=data.data[i].userID;
        var userName=data.data[i].userName;
        var userPassword=data.data[i].userPassword;
        //var birthday=data.data[i].birthday;
        var operation='<a href="#" style="margin-right:20px" data-toggle="modal" data-target="#updateUser" onclick="updateUser('+userID+',\''+userName+'\',\''+userPassword+'\')">'+"修改"+'</a>'+'<a href="#" style="color:#b22222" onclick="deleteUser('+userID+')">'+"删除"+'</a>';
        var user='<td>'+userID+'</td>'+'<td>'+userName+'</td>'+'<td>'+userPassword+'</td>'+'<td>'+operation+'</td>';
        $("#userInfoManageTable>tbody").append('<tr>'+user+'</tr>');
    }
}
function selectAllUser(){
    $.ajax({
        type:"POST",
        url:userURL+"selectAllUser",
        contentType:"application/json",
        crossDomain:true,
        success:function(data){
            userErgodic(data);
        }
    })
}
function updateUser(userID,userName,userPassword){
    $("#updateUserID").val(userID);
    $("#updateUserName").val(userName);
    $("#updateUserPassword").val(userPassword);
}
function updateUserReal(){
    var updateUserID=$("#updateUserID").val();
    var updateUserName=$("#updateUserName").val();
    var updateUserPassword=$("#updateUserPassword").val();
    var myData=JSON.stringify({"userID":updateUserID,"userName":updateUserName,"userPassword":updateUserPassword});
    $.ajax({
        type:"POST",
        url:userURL+"updateUser",
        data:myData,
        contentType:"application/json",
        crossDomain:true,
        success:function(data){
            userErgodic(data);
            alert("修改成功");
        },
        error: function () {
            alert("修改失败");
        }
    });
    $("#updateUser").modal("hide");
}
function deleteUser(userID){
    var myData=JSON.stringify({"userID":userID});
    $.ajax({
        type:"POST",
        url:userURL+"deleteUser",
        data:myData,
        contentType:"application/json",
        crossDomain:true,
        success:function(data){
            userErgodic(data);
            alert("删除成功");
        },
        error: function () {
            alert("删除失败");
        }
    })
}