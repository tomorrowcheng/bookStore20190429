var bookInfoURL="http://localhost:8080/bookInfo/";
var divsm2='<div class="col-sm-2">'+'<div class="thumbnail">';
var divsm3='<div class="col-sm-3">'+'<div class="thumbnail">';
var divend='</div>'+'</div>';
var row='<div class="row">'+'</div>';
var shopCart='<a style="float:right" href="#">'+'<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>'+"&nbsp;&nbsp;购物车"+'</a>';
function selectAllBookInfo(){
    $("#selectBookName").show();
    $.ajax({
        type:"POST",
        url:bookInfoURL+"selectAllBookInfo",
        contentType:"application/json",
        crossDomain:true,
        success:function(data){
            for(var i in data.data){
                var picture=data.data[i].picture;
                var price=data.data[i].price;
                var bookName=data.data[i].bookName;
                //var authorName=data.data[i].authors.authorName;
                // var img='<img src="'+picture+'" alt="'+bookName+'" style="width:195px;height:210px">';
                // var title='<h4 style="margin-top:5px;margin-bottom:5px;font-weight:bold">'+bookName+'</h4>';
                // var author='<p style="margin:0">'+'<span>'+"作者:"+'</span>'+authorName+'</p>';
                // var priceSpan='<p style="margin:0;color:#b22222">'+'<span>'+"价格："+'</span>'+price+"￥"+shopCart+'</p>';
                // var content=divsm+img+'<div style="margin-right:25px;margin-left:25px">'+title+author+priceSpan+'</div>'+divend;

                var img='<img src="'+picture+'" alt="'+bookName+'" style="width:130px;height:170px">';
                var title='<h5 style="margin-top:5px;margin-bottom:5px;font-weight:bold">'+bookName+'</h5>';
                var priceSpan='<p style="margin:0;color:#b22222">'+'<span>'+"价格："+'</span>'+price+"￥"+shopCart+'</p>';
                var content=divsm2+img+'<div style="margin-left:5px">'+title+priceSpan+'</div>'+divend;
                $("#allBookType>div.row").append(content);
            }
        }
    })
}
function selectBookInfoByTypeID(typeID){
    var myData=JSON.stringify({"typeID":typeID});
    $.ajax({
        type:"POST",
        url:bookInfoURL+"selectBookInfo",
        contentType:"application/json",
        crossDomain:true,
        data:myData,
        success:function(data){
            $("#selectBookName").hide();
            $("#type"+typeID).children('div.row').remove();
            $("#type"+typeID).append(row);
            for(var i in data.data){
                var picture=data.data[i].picture;
                var price=data.data[i].price;
                var bookName=data.data[i].bookName;
                var img='<img src="'+picture+'" alt="'+bookName+'" style="width:130px;height:170px">';
                var title='<h5 style="margin-top:5px;margin-bottom:5px;font-weight:bold">'+bookName+'</h5>';
                var priceSpan='<p style="margin:0;color:#b22222">'+'<span>'+"价格："+'</span>'+price+"￥"+shopCart+'</p>';
                var content=divsm2+img+'<div style="margin-left:5px">'+title+priceSpan+'</div>'+divend;
                $("#type"+typeID).children(".row").append(content);
            }
        }
    })
}
function selectNewBookInfo(){
    $.ajax({
        type: "POST",
        url: bookInfoURL + "selectAllBookInfo",
        contentType: "application/json",
        crossDomain:true,
        success: function (data) {
            var len=data.data.length;
            for (var i=len-1;i>len-9;i--) {
                var picture = data.data[i].picture;
                var price = data.data[i].price;
                var bookName = data.data[i].bookName;
                var authorName=data.data[i].authors.authorName;
                var img='<img src="'+picture+'" alt="'+bookName+'" style="width:195px;height:205px">';
                var title='<h4 style="margin-top:5px;margin-bottom:5px;font-weight:bold">'+bookName+'</h4>';
                var author='<p style="margin:0">'+'<span>'+"作者:"+'</span>'+authorName+'</p>';
                var priceSpan='<p style="margin:0;color:#b22222">'+'<span>'+"价格："+'</span>'+price+"￥"+shopCart+'</p>';
                var content=divsm3+img+'<div style="margin-right:25px;margin-left:25px">'+title+author+priceSpan+'</div>'+divend;
                $("#newBook>div.row").append(content);
            }
        }
    })
}
function selectBookByName(){
    var bookName=$("#bookName").val();
    var myData=JSON.stringify({"bookName":bookName});
    $.ajax({
        type:"POST",
        url:bookInfoURL+"selectBookInfo",
        contentType:"application/json",
        crossDomain:true,
        dataType:"json",
        data:myData,
        success:function(data){
            $("#allBookType").children('div.row').remove();
            $("#allBookType").append(row);
            for(var i in data.data){
                var picture=data.data[i].picture;
                var price=data.data[i].price;
                var bookName=data.data[i].bookName;
                var img='<img src="'+picture+'" alt="'+bookName+'" style="width:130px;height:160px">';
                var title='<h5 style="margin-top:5px;margin-bottom:5px;font-weight:bold">'+bookName+'</h5>';
                var priceSpan='<p style="margin:0;color:#b22222">'+'<span>'+"价格："+'</span>'+price+"￥"+shopCart+'</p>';
                var content=divsm2+img+'<div style="margin-left:5px">'+title+priceSpan+'</div>'+divend;
                $("#allBookType").children(".row").append(content);
            }
        }
    })
}