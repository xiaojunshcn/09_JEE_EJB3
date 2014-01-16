//data from servlet
var obj;
var sid;

//when page is loading, retrieve data from server side, and display stock price info
$(document).ready(
	function() {
		//hide the popup div
		var stockNode = $("#stock").css("border","1px solid black")
				.width("200px")
				.css("position","absolute")
				.css("z-index","10")
				.css("background-color","blue")
				.css("color","yellow");
		stockNode.hide();
		
		//find all <a> links
		var as = $("a");
		as.mouseover(function(event) {
			//a node which the mouse is over
			var aNode = $(this);
			var divNode = aNode.parent();
			sid = divNode.attr("id");
			
			updatePopupDiv();
			
//			//reset position of the popup div: set it under current link
//			//1. find the current link position
//			var offset = aNode.offset();
//			//2. set the popup div position
//			stockNode.css("left",offset.left + "px").css("top", offset.top + aNode.height() + "px");
			
			//popup div in the right bottom of the mouse
			var myEvent = event || window.event;
			stockNode.css("left",myEvent.clientX + 5 + "px").css("top", myEvent.clientY + 5 + "px");
			
			stockNode.show();
		});
		as.mouseout(function(){
			stockNode.hide();
		});
		
		getStockInfo();
		setInterval(getStockInfo, 1000);
	}
);

function updatePopupDiv() {
	//find the proper stock obj
	var stockObj = obj[sid];
	for (var proName in stockObj) {
		//name is not used in the popup div
		if (proName != "name") {
			//find correct div by id, and find the span node, fill data
			$("#" + proName).children("span").html(stockObj[proName]);
		}
	}
}

function getStockInfo() {
	//1. send request to server, "data" in function is the response from servlet
	$.get("StockServlet",null,function(data){
		//alert(data);
		
		//2. parse data
		obj = eval(data);
		
		//when add the 4th param for .get() with the value: json.
		//here, it can be dirctly set obj with data:
		//obj = data;
		
		//2.1 get the 2 stock current info
		var szzs = obj["300001"];
		var pfyh = obj["000001"];
		
		//2.2 get the proper node in page, fill data into it
		var span3 = $("#300001").children("span");
		span3.html(szzs.now);
		if (szzs.now > szzs.yes) {
			//current price > yesterday end price, show in red
			span3.css("color","red");
		} else {
			span3.css("color","green");
		}
		
		var span1 = $("#000001").children("span");
		span1.html(pfyh.now);
		if (pfyh.now > pfyh.yes) {
			//current price > yesterday end price, show in red
			span1.css("color","red");
		} else {
			span1.css("color","green");
		}
		
		updatePopupDiv();
	});
}