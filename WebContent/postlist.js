//accessing the posts
$(function() {
	$.ajax({
		"url" : "http://localhost:8080/carpolling/posts.json",
		"type" : "GET",
		"success" : lispost,
		"error" : fail

	});

	function lispost(data) {
		console.log(data.length);

		for (var i = 0; i < data.length; i++) {
			console.log(data[i].post);
			$("<div>").text(data[i].post).appendTo("body");
			$("<button>").attr("id", "comment" + data[i].postId).attr("class",
					"comment").text("comment").appendTo("body");
		}
		$(".comment").on('click', function() {

			$("<textarea>").appendTo("body");
		})
	}
	function fail() {
		console.log("fail");
	}
	//offering form load
	$("#offering").on('click', function(even) {
		$("#posdiv").load("offeringpost.html");
		var html = '<a href="link">' + field + "</a><br/>";
		$("<div>").append(html);
		return false;

	});

	//asking post
	$("#asking").on('click', function(even) {
		$("#posdiv1").load("askingpost.html");
		return false;

	});

	//profile update 
	$("#profileup").on('click', function(even) {
		$("#updatediv").load("logupupdate.html");

	})

	//post button click
	$("#post1").on('click', function(even) {
		var input = $("#post").val();
		alert("hhuhu");
		$.ajax({
			"url" : "http://localhost:8080/carpolling/PostController",
			"type" : "Post",
			"data" : {
				"postpostoffereing" : input,
				"type" : $("#ridetype").val()
			},
			"success" : posdisp,
			"error" : faila

		});
		return false;
	})
	//udatebutton click
//	$("#update").on('click', function(even) {
//		$.ajax({
//			"url" : "http://localhost:8080/carpolling/ProfileUpdate",
//			"type" : "Post",
//			"data" : {
//				"name" : $("#name").val(),
//				"type" : $("#gender").val(),
//				"state" : $("#state").val(),
//				"city" : $("#city"),
//				"street" : $("#street").val(),
//				"zipcode" : $("#zipcode").val(),
//				"birth" : $("#birth").val(),
//				"email" : $("#email").val(),
//				"password" : $("#password").val()
//			},
//			"success" : posdisp,
//			"error" : faila
//
//		});
//	})
$("#formUpdate").submit( function(even) {
		$.ajax({
			"url" : "http://localhost:8080/carpolling/ProfileUpdate",
			"type" : "Post",
			"data" : {
				"name" : $("#name").val(),
				"type" : $("#gender").val(),
				"state" : $("#state").val(),
				"city" : $("#city"),
				"street" : $("#street").val(),
				"zipcode" : $("#zipcode").val(),
				"birth" : $("#birth").val(),
				"email" : $("#email").val(),
				"password" : $("#password").val()
			},
			"success" : posdisp,
			"error" : faila

		});
		even.preventDefault();
	});
	
})
function posdisp() {

	}
	function faila() {
		console.log("errror");
	}