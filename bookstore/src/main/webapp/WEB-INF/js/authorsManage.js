var authorsURL="http://localhost:8080/authors/";
var tbody='<tbody>'+'</tbody>';
function authorsErgodic(data){
    $("#authorsManageTable>tbody").remove();
    $("#authorsManageTable").append(tbody);
    for(var i in data.data){
        var authorID=data.data[i].authorID;
        var authorName=data.data[i].authorName;
        var description=data.data[i].description;
        var operation='<a href="#" style="margin-right:20px" data-toggle="modal" data-target="#updateAuthors" onclick="updateAuthors('+authorID+',\''+authorName+'\',\''+description+'\')">'+"修改"+'</a>'+'<a href="#" style="color:#b22222" onclick="deleteAuthor('+authorID+')">'+"删除"+'</a>';
        var author='<td>'+authorID+'</td>'+'<td>'+authorName+'</td>'+'<td>'+description+'</td>'+'<td>'+operation+'</td>';
        $("#authorsManageTable>tbody").append('<tr>'+author+'</tr>')
    }
}
function selectAllAuthors(){
    $.ajax({
        type:"POST",
        url:authorsURL+"selectAllAuthors",
        contentType:"application/json",
        crossDomain:true,
        success:function(data){
            authorsErgodic(data);
        }
    })
}
function insertAuthors(){
    var insertAuthorName=$("#insertAuthorName").val();
    var insertDescription=$("#insertDescription").val();
    var myData=JSON.stringify({"authorName":insertAuthorName,"description":insertDescription});
    $.ajax({
        type:"POST",
        url:authorsURL+"insertAuthor",
        data:myData,
        contentType:"application/json",
        crossDomain:true,
        success:function(data){
            authorsErgodic(data);
            alert("添加成功");
        },
        error: function () {
            alert("添加失败");
        }
    });
    $("#insertAuthors").modal("hide");
}
function updateAuthors(authorID,authorName,description){
    $("#updateAuthorID").val(authorID);
    $("#updateAuthorName").val(authorName);
    $("#updateDescription").val(description);
}
function updateAuthorsReal(){
    var authorID=$("#updateAuthorID").val();
    var authorName=$("#updateAuthorName").val();
    var description=$("#updateDescription").val();
    var myData=JSON.stringify({"authorID":authorID,"authorName":authorName,"description":description});
    $.ajax({
        type:"POST",
        url:authorsURL+"updateAuthor",
        data:myData,
        contentType:"application/json",
        crossDomain:true,
        success:function(data){
            authorsErgodic(data);
            alert("修改成功");
        },
        error: function () {
            alert("修改失败");
        }
    });
    $("#updateAuthors").modal("hide");
}
function deleteAuthor(authorID){
    var myData=JSON.stringify({"authorID":authorID});
    $.ajax({
        type:"POST",
        url:authorsURL+"deleteAuthor",
        data:myData,
        contentType:"application/json",
        crossDomain:true,
        success:function(data){
            authorsErgodic(data);
            alert("删除成功");
        },
        error: function () {
            alert("删除失败");
        }
    })
}
function selectAuthors(){
    var authorName=$("#selectAuthor").val();
    var myData=JSON.stringify({"authorName":authorName});
    $.ajax({
        type:"POST",
        url:authorsURL+"selectAuthors",
        contentType:"application/json",
        crossDomain:true,
        data:myData,
        success:function(data){
            authorsErgodic(data);
        }
    })
}
