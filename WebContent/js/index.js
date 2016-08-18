var categoryNode1;
var categoryNode2;
var categoryNode3;
var categoryNode4;
var categoryNode5;
var categoryNode6;
var as;
var flagin=0;

$(document).ready(function(){
	
	categoryNode1=$("#category1").width("300px").height("75px")
	.css("position","absolute").css("z-index","99").css("background-color","#F2F2F2");
	
	categoryNode2=$("#category2").width("300px").height("75px")
	.css("position","absolute").css("z-index","99").css("background-color","#F2F2F2");
	
	categoryNode3=$("#category3").width("300px").height("75px")
	.css("position","absolute").css("z-index","99").css("background-color","#F2F2F2");
	
	categoryNode4=$("#category4").width("300px").height("75px")
	.css("position","absolute").css("z-index","99").css("background-color","#F2F2F2");
	
	categoryNode5=$("#category5").width("300px").height("75px")
	.css("position","absolute").css("z-index","99").css("background-color","#F2F2F2");
	
	categoryNode6=$("#category6").width("300px").height("75px")
	.css("position","absolute").css("z-index","99").css("background-color","#F2F2F2");
	
	categoryNode1.hide();
	categoryNode2.hide();
	categoryNode3.hide();
	categoryNode4.hide();
	categoryNode5.hide();
	categoryNode6.hide();
	
	as=$(".good_item");
	
	

	as.click(function(){
		var aNode=$(this);
		var offset=aNode.offset();
		var i=aNode.attr("id");
		
		if(i==1){
			categoryNode1.css("left","240px").css("top",offset.top+"px");
			categoryNode1.toggle("slow");
			
		}else if(i==2){
			categoryNode2.css("left","240px").css("top",offset.top+"px");
			categoryNode2.toggle("slow");
		}else if(i==3){
			categoryNode3.css("left","240px").css("top",offset.top+"px");
			categoryNode3.toggle("slow");
		}else if(i==4){
			categoryNode4.css("left","240px").css("top",offset.top+"px");
			categoryNode4.toggle("slow");
		}else if(i==5){
			categoryNode5.css("left","240px").css("top",offset.top+"px");
			categoryNode5.toggle("slow");
		}else if(i==6){
			categoryNode6.css("left","240px").css("top",offset.top+"px");
			categoryNode6.toggle("slow");
		}
		
		
		

	});
	
	
});

function showcate(){

	
	
	var aNode=$(this);
	var offset=aNode.offset();
	var i=aNode.attr("id");
	
	if(i==1){
		categoryNode1.css("left","240px").css("top",offset.top+"px");
		categoryNode1.show();
		
	}else if(i==2){
		categoryNode2.css("left","240px").css("top",offset.top+"px");
		categoryNode2.show();
	}else if(i==3){
		categoryNode3.css("left","240px").css("top",offset.top+"px");
		categoryNode3.show();
	}else if(i==4){
		categoryNode4.css("left","240px").css("top",offset.top+"px");
		categoryNode4.show();
	}else if(i==5){
		categoryNode5.css("left","240px").css("top",offset.top+"px");
		categoryNode5.show();
	}else if(i==6){
		categoryNode6.css("left","240px").css("top",offset.top+"px");
		categoryNode6.show();
	}
	
	

}

function searchbook(){
	var bookname=$("#txtSearch").val();
	location.href="/BookMallProject/servlet/IndexBookSearchServlet?bookname="+bookname+"&method=searchbyname";
	
}




function go(pageIndex,searchstyle){
   
	location.href="/BookMallProject/servlet/IndexBookSearchServlet?pageindex="+pageIndex+"&method=searchbyindex&searchstyle="+searchstyle;

}