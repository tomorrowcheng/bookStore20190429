var orderInfoURL="http://localhost:8080/orderInfo/";
var tbody='<tbody>'+'</tbody>';
function orderInfoErgodic(data){
    $("#orderInfoManageTable>tbody").remove();
    $("#orderInfoManageTable").append(tbody);
    for(var i in data.data){
        var orderID=data.data[i].orderID;
        var userName=data.data[i].user.userName;
        var bookName=data.data[i].bookInfo.bookName;
    }
}