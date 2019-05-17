var adminURL="http://localhost:8080/admin/";
var tbody='<tbody>'+'</tbody>';
function adminErgodic(data){
    $("#adminInfoManageTable>tbody").remove();
    $("#adminInfoManageTable").append(tbody);
    for(var i in data.data){
        var adminID=data.data[i].adminID;
        var adminName=data.data[i].adminName;
        var adminPassword=data.data[i].adminPassword;
        var rank=data.data[i].rank;
        var operation='<a href="#" style="margin-right:20px" data-toggle="modal" data-target="#updateAdmin" onclick="updateAdmin('+adminID+',\''+adminName+'\',\''+adminPassword+'\')">'+"修改"+'</a>'+'<a href="#" style="color:#b22222" onclick="deleteAdmin('+adminID+')">'+"删除"+'</a>';
        if (rank==1){
            var adminInfo='<td>'+adminID+'</td>'+'<td>'+adminName+'</td>'+'<td>'+adminPassword+'</td>'+'<td>'+'高级'+'</td>'+'<td>'+'<a href="#"  data-toggle="modal" data-target="#updateAdmin" onclick="updateAdmin('+adminID+',\''+adminName+'\',\''+adminPassword+'\')">'+"修改"+'</a>'+'</td>';
            $("#adminInfoManageTable>tbody").append('<tr>'+adminInfo+'</tr>')
        }else{
            var admin='<td>'+adminID+'</td>'+'<td>'+adminName+'</td>'+'<td>'+adminPassword+'</td>'+'<td>'+'普通'+'</td>'+'<td>'+operation+'</td>';
            $("#adminInfoManageTable>tbody").append('<tr>'+admin+'</tr>')
        }
    }
}
function selectAllAdmin(){
    $.ajax({
        type:"POST",
        url:adminURL+"selectAllAdmin",
        contentType:"application/json",
        crossDomain:true,
        success:function(data){
            adminErgodic(data);
        }
    })
}
function insertAdmin(){
    var insertAdminName=$("#insertAdminName").val();
    var insertAdminPassword=$("#insertAdminPassword").val();
    var myData=JSON.stringify({"adminName":insertAdminName,"adminPassword":insertAdminPassword,"rank":2});
    $.ajax({
        type:"POST",
        url:adminURL+"insertAdmin",
        data:myData,
        contentType:"application/json",
        crossDomain:true,
        success:function(data){
            adminErgodic(data);
            alert("添加成功");
        },
        error: function () {
            alert("添加失败");
        }
    });
    $("#insertAdmin").modal("hide");
}
function deleteAdmin(adminID){
    var myData=JSON.stringify({"adminID":adminID});
    $.ajax({
        type:"POST",
        url:adminURL+"deleteAdmin",
        data:myData,
        contentType:"application/json",
        crossDomain:true,
        success:function(data){
            adminErgodic(data);
            alert("删除成功");
        },
        error: function () {
            alert("删除失败");
        }
    })
}
function updateAdmin(adminID,adminName,adminPassword){
    $("#updateAdminID").val(adminID);
    $("#updateAdminName").val(adminName);
    $("#updateAdminPassword").val(adminPassword);
}
function updateAdminReal(){
    var updateAdminID=$("#updateAdminID").val();
    var updateAdminName=$("#updateAdminName").val();
    var updateAdminPassword=$("#updateAdminPassword").val();
    var myData=JSON.stringify({"adminID":updateAdminID,"adminName":updateAdminName,"adminPassword":updateAdminPassword});
    $.ajax({
        type:"POST",
        url:adminURL+"updateAdmin",
        data:myData,
        contentType:"application/json",
        crossDomain:true,
        success:function(data){
            adminErgodic(data);
            alert("修改成功");
        },
        error: function () {
            alert("修改失败");
        }
    });
    $("#updateAdmin").modal("hide");
}