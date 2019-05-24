var bookInfoURL="http://localhost:8080/bookInfo/";
function bookDetailByBookID(bookID){
    $("#bookInfoDetail").siblings("div").removeClass("active");
    $("#bookInfoDetail").addClass("active");
    $("#navTop>ul>li.active").removeClass("active");
    var myData=JSON.stringify({"bookID":bookID});
    $.ajax({
        type:"POST",
        url:bookInfoURL+"selectBookInfo",
        contentType:"application/json",
        crossDomain:true,
        dataType:"json",
        data:myData,
        success:function(data){
            var picture=data.data[0].picture;
            var bookName=data.data[0].bookName;
            var bookID=data.data[0].bookID;
            var authorName=data.data[0].authors.authorName;
            var price=data.data[0].price+"￥";
            var isdn=data.data[0].isdn;
            var publishing=data.data[0].publishing;
            var bookSize=data.data[0].bookSize;
            var page=data.data[0].page;
            var contentIntro=data.data[0].contentIntro;
            $("#bookIDDetailSelect").val(bookID);
            $("#bookDetailSelect").attr("src",picture);
            $("#bookDetailSelect").attr("alt",bookName);
            $("#bookNameSelect").html(bookName);
            $("#authorNameSelect").html(authorName);
            $("#priceSelect").html(price);
            $("#isdnSelect").html(isdn);
            $("#publishingSelect").html(publishing);
            $("#bookSizeSelect").html(bookSize);
            $("#pageSelect").html(page);
            $("#contentIntroSelect").html(contentIntro);
        }
    })
}
function bookDetailOut(){
    $("#bookInfoDetail").removeClass("active");
    $("#allBook").addClass("active");
    $("#allBookLi").addClass("active");
}