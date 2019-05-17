var bookTypeURL="http://localhost:8080/bookType/";
var tbody='<tbody>'+'</tbody>';
function bookTypeErgodic(data){
    $("#bookTypeManageTable>tbody").remove();
    $("#bookTypeManageTable").append(tbody);
    for(var i in data.data){
        var typeID=data.data[i].typeID;
        var typeName=data.data[i].typeName;
        var operation='<a href="#" style="margin-right:20px" data-toggle="modal" data-target="#updateBookType" onclick="updateBookType('+typeID+',\''+typeName+'\')">'+"修改"+'</a>'+'<a href="#" style="color:#b22222" onclick="deleteBookType('+typeID+')">'+"删除"+'</a>';
        var bookType='<td>'+typeID+'</td>'+'<td>'+typeName+'</td>'+'<td>'+operation+'</td>';
        $("#bookTypeManageTable>tbody").append('<tr>'+bookType+'</tr>');
    }
}
function selectBookTypeAll(){
    $.ajax({
        type:"POST",
        url:bookTypeURL+"selectAllType",
        contentType:"application/json",
        crossDomain:true,
        success:function(data){
            bookTypeErgodic(data);
        }
    })
}
function insertBookType(){
    var insertBookTypeName=$("#insertBookTypeName").val();
    var myData=JSON.stringify({"typeName":insertBookTypeName});
    $.ajax({
        type:"POST",
        url:bookTypeURL+"insertBookType",
        data:myData,
        contentType:"application/json",
        crossDomain:true,
        success:function(data){
            bookTypeErgodic(data);
            alert("添加成功");
        },
        error: function () {
            alert("添加失败");
        }
    });
    $("#insertBookType").modal("hide");
}
function deleteBookType(typeID){
    var myData=JSON.stringify({"typeID":typeID});
    $.ajax({
        type:"POST",
        url:bookTypeURL+"deleteBookType",
        data:myData,
        contentType:"application/json",
        crossDomain:true,
        success:function(data){
            bookTypeErgodic(data);
            alert("删除成功");
        },
        error: function () {
            alert("删除失败");
        }
    })
}
function updateBookType(typeID,typeName){
    $("#updateBookTypeID").val(typeID);
    $("#updateBookTypeName").val(typeName);
}
function updateBookTypeReal(){
    var updateBookTypeID=$("#updateBookTypeID").val();
    var updateBookTypeName=$("#updateBookTypeName").val();
    var myData=JSON.stringify({"typeID":updateBookTypeID,"typeName":updateBookTypeName});
    $.ajax({
        type:"POST",
        url:bookTypeURL+"updateBookType",
        data:myData,
        contentType:"application/json",
        crossDomain:true,
        success:function(data){
            bookTypeErgodic(data);
            alert("修改成功");
        },
        error: function () {
            alert("修改失败");
        }
    });
    $("#updateBookType").modal("hide");
}
