<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <form  method="post" id="commentform" action="PostController">
  
  <h3>Offering ride</h3>
    <textarea name="postoffereing" id="post"  required="required"></textarea>
    <input name="type" value="1" type="hidden"  id="ridetype"/>
	<input type="submit" value="post" />
	</form>
</body>
</html>