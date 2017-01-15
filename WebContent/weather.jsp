<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
<script type="text/javascript" src="carpool.js"></script> 
 <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/poststyle.css" rel="stylesheet">
 <link href="carpool.css" type="text/css" rel="stylesheet"/>
<title>Weather</title>
</head>
<body>
<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
  
      <form class="navbar-form navbar-right">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
     
        <ul class="nav navbar-nav navbar-left">
         <li><a href="#" id="profileup">Update Profile Information</a></li>
        <li><a href="home1.jsp">Home</a></li>
        <li><a href="weather.jsp">Weather Service</a></li>
        <li class="dropdown">
          <a href="http://localhost:8080/carpolling/home.jsp" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Select Ride <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#" id="asking">Asking For a Ride</a></li>
            <li><a href="#" id="offering">Offering Ride</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
          </ul>
        </li>
    </div><!-- /.navbar-collapse -->
		<div id="logo"></div>
	<input id="searchBox" class="controls" type="text" placeholder="Search Box">
	<div id="weather">
	
		
		<div id="currentWeather">
		
		</div>
			
		<div id="forecastWeather">
			
		</div>
		<h3>Current Weather Map</h3>
		<div id="map">
		
		</div>
	</div>
	
</body>

 <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAhUmLtEMCQ9Ke1u4BxEXLLpVNagExaJT4&l&libraries=places&callback=initAutocomplete">

 </script>
</html>