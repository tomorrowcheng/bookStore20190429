var bookInfoManageURL="http://localhost:8080/bookInfo/";
var tbody='<tbody>'+'</tbody>';
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg); //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}
function adminHide(){
    var mark=getUrlParam("admin");
    if(mark==="2"){
        $("#user").hide();
        $("#admin").hide();
    }
}
function adminLogout(){
    var href="http://localhost:8080";
    if(confirm("确认退出后台管理平台吗？")){
        window.location.href=href;
    }
}
function bookInfoManageErgodic(data){
    $("#bookInfoTable>tbody").remove();
    $("#bookInfoTable").append(tbody);
    for(var i in data.data){
        var bookID=data.data[i].bookID;
        var picture=data.data[i].picture;
        var bookName=data.data[i].bookName;
        var price=data.data[i].price;
        var authorID=data.data[i].authorID;
        var typeID=data.data[i].typeID;
        var isdn=data.data[i].isdn;
        var bookSize=data.data[i].bookSize;
        var publishing=data.data[i].publishing;
        var page=data.data[i].page;
        var contentIntro=data.data[i].contentIntro;
        var stockQty=data.data[i].stockQty;
        var img='<img src="'+picture+'" alt="'+bookName+'" style="width:90px;height:100px">';
        var operation='<a href="#" style="margin-right:20px" data-toggle="modal" data-target="#updateBookInfoManage" onclick="updateBookInfoManage('+bookID+',\''+picture+'\',\''+bookName+'\',\''+price+'\',\''+authorID+'\',\''+typeID+'\',\''+isdn+'\',\''+bookSize+'\',\''+publishing+'\',\''+page+'\',\''+contentIntro+'\',\''+stockQty+'\')">'+"查看详情"+'</a>'+'<a href="#" style="color:#b22222" onclick="deleteBookInfo('+bookID+')">'+"删除"+'</a>';
        var bookInfo='<td>'+bookID+'</td>'+'<td>'+img+'</td>'+'<td>'+bookName+'</td>'+'<td>'+price+'</td>'+'<td>'+operation+'</td>';
        $("#bookInfoTable>tbody").append('<tr>'+bookInfo+'</tr>');
    }
}
function selectAllBookInfoManage(){
    $.ajax({
        type:"POST",
        url:bookInfoManageURL+"selectAllBookInfo",
        contentType:"application/json",
        crossDomain:true,
        success:function(data){
            bookInfoManageErgodic(data);
        }
    });
    authorSelect();
    typeSelect();
}
function authorSelect(){
    $.ajax({
        type:"POST",
        url:"http://localhost:8080/authors/selectAllAuthors",
        contentType:"application/json",
        crossDomain:true,
        success:function(data){
            $("#authorUpdate>option").remove();
            $("#authorInsert>option").remove();
            for(var i in data.data){
                var authorID=data.data[i].authorID;
                var authorName=data.data[i].authorName;
                var option='<option value="'+authorID+'">'+authorName+'</option>';
                $("#authorUpdate").append(option);
                $("#authorInsert").append(option);
            }
        }
    })
}
function typeSelect(){
    $.ajax({
        type:"POST",
        url:"http://localhost:8080/bookType/selectAllType",
        contentType:"application/json",
        crossDomain:true,
        success:function(data){
            $("#bookTypeUpdate>option").remove();
            $("#bookTypeInsert>option").remove();
            $("#selectType>option").remove();
            $("#selectType").append('<option value="">'+"全部种类"+'</option>');
            for(var i in data.data){
                var typeID=data.data[i].typeID;
                var typeName=data.data[i].typeName;
                var option='<option value="'+typeID+'">'+typeName+'</option>';
                $("#bookTypeUpdate").append(option);
                $("#bookTypeInsert").append(option);
                $("#selectType").append(option);
            }
        }
    })
}
function updateBookInfoManage(bookID,picture,bookName,price,authorID,typeID,isdn,bookSize,publishing,page,contentIntro,stockQty){
    $("#bookIDUpdate").val(bookID);
    var img='<img src="'+picture+'" alt="'+bookName+'" style="width:90px;height:100px">';
    $("#bookImgUpdate").append(img);
    $("#bookNameUpdate").val(bookName);
    $("#priceUpdate").val(price);
    $("#authorUpdate").val(authorID);
    $("#bookTypeUpdate").val(typeID);
    $("#isbnUpdate").val(isdn);
    $("#bookSizeUpdate").val(bookSize);
    $("#publishingUpdate").val(publishing);
    $("#bookPageUpdate").val(page);
    $("#contentIntroUpdate").val(contentIntro);
    $("#stockQtyUpdate").val(stockQty);
}
function updateBookInfoManageReal(){
    var bookID=$("#bookIDUpdate").val();
    var bookName=$("#bookNameUpdate").val();
    var price=$("#priceUpdate").val();
    var authorID=$("#authorUpdate").val();
    var typeID=$("#bookTypeUpdate").val();
    var isdn=$("#isbnUpdate").val();
    var bookSize=$("#bookSizeUpdate").val();
    var publishing=$("#publishingUpdate").val();
    var page=$("#bookPageUpdate").val();
    var contentIntro=$("#contentIntroUpdate").val();
    var stockQty=$("#stockQtyUpdate").val();
    var myData=JSON.stringify({
        "bookID":bookID,
        "bookName":bookName,
        "price":price,
        "authorID":authorID,
        "typeID":typeID,
        "isdn":isdn,
        "bookSize":bookSize,
        "publishing":publishing,
        "page":page,
        "contentIntro":contentIntro,
        "stockQty":stockQty
    });
    $.ajax({
        type:"POST",
        url:"http://localhost:8080/bookInfo/updateBookInfo",
        data:myData,
        contentType:"application/json",
        crossDomain:true,
        success:function(data){
            bookInfoManageErgodic(data);
            alert("修改成功");
        },
        error: function () {
            alert("修改失败");
        }
    });
    $("#updateBookInfoManage").modal("hide");
}
function selectBookTypeManage(){
    var typeID=$("#selectType").val();
    var myData=JSON.stringify({"typeID":typeID});
    $.ajax({
        type:"POST",
        url:bookInfoManageURL+"selectBookInfo",
        contentType:"application/json",
        data:myData,
        crossDomain:true,
        success:function(data){
            bookInfoManageErgodic(data);
        }
    });
}
function selectBookNameManage(){
    var bookName=$("#selectBookName").val();
    var myData=JSON.stringify({"bookName":bookName});
    $.ajax({
        type:"POST",
        url:bookInfoManageURL+"selectBookInfo",
        contentType:"application/json",
        data:myData,
        crossDomain:true,
        success:function(data){
            bookInfoManageErgodic(data);
        }
    });
}
function showPreview(source) {
    var file = source.files[0];
    if(window.FileReader) {
        var fr = new FileReader();
        console.log(fr);
        var portrait = document.getElementById('portrait');
        fr.onloadend = function(e) {
            portrait.src = e.target.result;
        };
        fr.readAsDataURL(file);
        portrait.style.display = 'block';
    }
}
function insertBookInfo(){
    var formData=new FormData();
    var file=document.getElementById("bookImgInsert").files[0];
    formData.append("file",file);
    var bookName=$("#bookNameInsert").val();
    var stockQty=$("#stockQtyInsert").val();
    var authorID=$("#authorInsert").val();
    var typeID=$("#bookTypeInsert").val();
    var price=$("#priceInsert").val();
    var isdn=$("#isbnInsert").val();
    var publishing=$("#publishingInsert").val();
    var bookSize=$("#bookSizeInsert").val();
    var page=$("#bookPageInsert").val();
    var contentIntro=$("#contentIntroInsert").val();
    var myData=JSON.stringify({
        "authorID":authorID,
        "typeID":typeID,
        "bookName":bookName,
        "picture":"",
        "price":price,
        "isdn":isdn,
        "bookSize":bookSize,
        "publishing":publishing,
        "pubTime":"",
        "page":page,
        "contentIntro":contentIntro,
        "stockQty":stockQty
    });
    formData.append("bookInfo",new Blob([myData],{type:"application/json"}));
    $.ajax({
        type:"POST",
        url:"http://localhost:8080/bookInfo/insertBookInfo",
        dataType:"json",
        contentType:false,
        crossDomain:true,
        processData:false,
        data:formData,
        success:function(data){
            bookInfoManageErgodic(data);
            console.log(data);
        },
        error:function(){
            alert("添加图书失败")
        }
    });
    $("#insertBookInfoManage").modal("hide");
}
function deleteBookInfo(bookID){
    var myData=JSON.stringify({"bookID":bookID});
    $.ajax({
        type:"POST",
        url:bookInfoManageURL+"deleteBookInfo",
        data:myData,
        contentType:"application/json",
        crossDomain:true,
        success:function(data){
            bookInfoManageErgodic(data);
            alert("删除成功");
        },
        error: function () {
            alert("删除失败");
        }
    })
}
