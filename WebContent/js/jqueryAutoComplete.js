//current high light item index
var highLightIndex = -1;
var timeoutId;
$(document).ready(function(){
	var wordInput = $("#word");
	var wordInputOffset = wordInput.offset();
	
	//hide the div when page is loaded at the beginning
	$("#auto").hide().css("border","1px black solid")
			.css("position","absolute")
			.css("top",wordInputOffset.top + wordInput.height() + 5 + "px")
			.css("left",wordInputOffset.left + "px")
			.width(wordInput.width() + 2);
	
	//event for the input textbox
	wordInput.keyup(function(event) {
		var myEvent = event || window.event;
		var keyCode = myEvent.keyCode;
		
		//only valid string input will send an ajax request to servlet
		//backspace: 8
		//delete: 46
		if (keyCode >=65 && keyCode<=90 || keyCode == 8 || keyCode == 46) {
			//input text
			var wordText = $("#word").val();
			if (wordText != "") {
				//clear the previous timeoutId if it still not run
				clearTimeout(timeoutId);
				
				//set a timeout id
				timeoutId = setTimeout(function(){
					$.post("AutoCompleteServlet",{word:wordText},function(data){
//					$.post("AutoCompleteJSTLServlet",{word:wordText},function(data){
						//convert dom object to JQuery object
						var jqueryObj = $(data);
						
						//find all word nodes
						var wordNodes = jqueryObj.find("word");
						var autoNode = $("#auto");
						
						//clear contents
						autoNode.html("");
						
						//loop all word nodes, and get the content
						wordNodes.each(function(i){
							var wordNode = $(this);
							
							var newDivNode = $("<div>").attr("id",i);
							newDivNode.html(wordNode.text()).appendTo(autoNode);
							
							//mouse event
							newDivNode.mouseover(function(){
								//cancel the previous highlighted item and set the current item as high lighted
								if (highLightIndex != -1) {
									$("#auto").children("div").eq(highLightIndex).css("background-color","white");
								}
								highLightIndex = $(this).attr("id");
								$(this).css("background-color","red");
							});
							
							newDivNode.mouseout(function(){
								$(this).css("background-color","white");
							});
							
							newDivNode.click(function(){
								var comText = $(this).text();
								$("#auto").hide();
								highLightIndex = -1;
								$("#word").val(comText);
							});
						});
						
						//when there are data returned, show the div
						if (wordNodes.length >0) {
							$("#auto").show();
						} else {
							$("#auto").hide();
							highLightIndex = -1;	//reset the index
						}
					},"xml");
				},500);
			} else {
				//when no text in the input textbox
				$("#auto").hide();
				highLightIndex = -1;	//reset the index
			}
		} else if (keyCode == 38 || keyCode == 40){
			//up: 38   down:40
			//set the backgroud color 
			if (keyCode == 38) {
				//all items in the popup div
				var autoNodes = $("#auto").children("div");
				if (highLightIndex != -1) {
					//when it is a high light item, reset this one with white white in background
					autoNodes.eq(highLightIndex).css("background-color","white");
					highLightIndex--;
				} else {
					highLightIndex = autoNodes.length - 1;
				}
				
				if (highLightIndex == -1) {
					//when it is the first one, then reset it to the last one
					highLightIndex = autoNodes.length - 1;
				}
				
				//set the high light to red
				autoNodes.eq(highLightIndex).css("background-color","red");
			}
			
			if (keyCode == 40) {
				//all items in the popup div
				var autoNodes = $("#auto").children("div");
				if (highLightIndex != -1) {
					//when it is a high light item, reset this one with white white in background
					autoNodes.eq(highLightIndex).css("background-color","white");
				}
				highLightIndex++;
				if (highLightIndex == autoNodes.length) {
					//when it is the first one, then reset it to the last one
					highLightIndex = 01;
				}
				
				//set the high light to red
				autoNodes.eq(highLightIndex).css("background-color","red");
			}
		} else if (keyCode == 13) {
			//when there is a high light item in the popup div
			if (highLightIndex != -1) {
				//text of the high light item
				var comText = $("#auto").hide().children("div").eq(highLightIndex).text();
				highLightIndex = -1;
				
				//set the input textbox with the high lighted content
				$("#word").val(comText);
			} else {
				alert("no high lighted data");
				$("#auto").hide();
				
				//let the textbox lost the focus
				$("#word").get(0).blur();
			}
		} 

	});
	
	//event for submit button
	$("input[type='button']").click(function(){
	});
});