var bookTypeURL="http://localhost:8080/bookType/";
function selectAllBookType() {
    $.ajax({
        type:"POST",
        url:bookTypeURL+"selectAllType",
        contentType:"application/json",
        crossDomain:true,
        success:function(data){
            for(var i in data.data){
                var typeID=data.data[i].typeID;
                var typeName=data.data[i].typeName;
                var type='<a href="#type'+typeID+'" data-toggle="tab" onclick="selectBookInfoByTypeID('+typeID+')">'+typeName+'</a>';
                var allBookContent='<div id="type'+typeID+'" class="tab-pane container">'+'</div>';
                $("#allBook>ul").prepend('<li>'+type+'</li>');
                $("#allBookContent").append(allBookContent);
            }
        }
    })
}