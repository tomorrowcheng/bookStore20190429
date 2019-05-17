var shoppingURL="http://localhost:8080/shopping/";
function selectShopping(){
    var myData=JSON.stringify({"userID":1});
    $.ajax({
        type:"POST",
        url:shoppingURL+"selectShopping",
        contentType:"application/json",
        crossDomain:true,
        data:myData,
        success:function(data){
            for(var i in data.data){
                var picture=data.data[i].bookInfo.picture;
                var bookName=data.data[i].bookInfo.bookName;
                var authorName=data.data[i].authors.authorName;
                var number=data.data[i].number;
                var price=data.data[i].bookInfo.price;
                var totalPrice=price*number;
                var img='<img src="'+picture+'" alt="'+bookName+'" style="width:120px;height:135px">';
                var title='<h5 style="margin-top:5px;margin-bottom:5px;font-weight:bold">'+bookName+'</h5>';
                var author='<p style="margin:0">'+'<span>'+"作者:"+'</span>'+authorName+'</p>';
                //var priceSpan='<p style="margin:0;color:#b22222">'+'<span>'+"价格："+'</span>'+price+"￥"+'</p>';
                var info='<td>'+img+'<div style="display:inline;float:right;margin-top:50px">'+title+author+'</div>'+'</td>'
                var tr='<tr>'+info+'<td>'+price+'</td>'+'<td>'+number+'</td>'+'<td>'+totalPrice+'</td>'+'<td>'+'<a href="#">'+"删除"+'</a>'+'</td>'+'</tr>'
                $("#cartInfo").append(tr);
            }
        }
    });
}