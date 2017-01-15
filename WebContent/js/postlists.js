 var counter;
$(document).ready(function(){
	
    $.ajax({
        "url":"http://localhost:8080/carpolling/posts.json",
        "type":"GET",
        "success":lispost,
        "error":fail
	});
//    $("#comment-submit0").on('click',function(){
//		var comt=$("#comment-box0").val();
//		$("<p>").text(comt).appendTo("#post0");
//	});
    
});

function lispost(data){
    console.log(data.length);
    
    for(var i=0;i<data.length;i++)
    {
    	console.log(data[i].post);
    
        var postdiv = "<h4><strong>"+data[i].post+"</strong></h4>"
        $("<div>").attr("id","post"+i).addClass('well').html(postdiv).appendTo('#allposts');
        //$('#post'+i).append('<input type = "text" id = "comment-box'+i+'" placeholder="Comment here..." /><button class="btn btn-primary" id="comment-submit"'+i+'>Comment</button>');
        $("<input>").attr("id","comment-box"+i).addClass("comment-box").attr("placeholder","Comment here...").attr("type","text").appendTo("#post"+i);
        $("<button>").attr("id","comment-submit"+i).attr("class","btn").addClass("btn-primary").text("Comment").appendTo("#post"+i)
        
         $("<button>").attr("id","comment-like"+i).attr("class","btn2").addClass("btn-like").html("like<br>").appendTo("#post"+i)
//  //        $("#comment-submit"+i).click(function(){
////            $.post( "/CommentController", 
////            {"userId":0,"comment":$('#comment-box'+i).text(),"postId":data[i].postId,"dateCreated":"Dec 19, 2016","dateUpdate":"Dec 19, 2016"},
////            function(  ) {      
////                console.log( data );
////            });
//    		var comt=$(".comment-box").val();
//    		$("<p>").text(comt).appendTo("#post"+i);
////            alert($('#comment-box'+i).text());
//         });
    }
   
    $(".btn-primary").click(function(){
    	var comt=$(this).prev(".comment-box").val();
		$("<p>").text(comt).appendTo($(this).parent());
    });
    /*$("#comment-submit"+i).on('click',function(){
        $.post( "/CommentController", 
        {"userId":0,"comment":$('#comment-box'+i).text(),"postId":data[i].postId,"dateCreated":"Dec 19, 2016","dateUpdate":"Dec 19, 2016"},
        function(  ) {      
            console.log( data );
        });
        alert($('#comment-box'+i).text());
    });*/
}
function fail(){
    console.log("fail");
}
// //offering form load
 $("#offering").on('click',function(even){
    $("#posdiv").load("offeringpost.html");
   
    })
    $("#offering").on('click',function(even){
    $("#posdiv").load("#logupate.jsp");
   
    })
    
//post button click
    $("#postb").on('click',function(even){
    $.ajax({
        "url":"http://localhost:8080/carpolling/PostController",
        "type":"GET",
        "data":{"postpostoffereing":$("#post").val(),"type":$("#ridetype").val()},
        "success":posdisp,
        "error":faila

});
})
//udatebutton click
  $("#update").on('click',function(even){
    $.ajax({
        "url":"http://localhost:8080/carpolling/PostController",
        "type":"Post",
        "data":{"name":$("#name").val(),"type":$("#gender").val(),"state":$("#state").val(),"city":$("#city"),
                "street":$("#street").val(),"zipcode":$("#zipcode").val(),"birth":$("#birth").val(),"email":$("#email").val(),
                "password":$("#password").val()},
        "success":posdisp,
        "error":faila

});
});

function posdisp(){

}
function faila(){
	
}

