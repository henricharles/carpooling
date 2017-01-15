/**
 * This javascript file manages getting weather information from
 * 
 * open weather site.
 */
var latitude;
var longtiude;
var api = "a1d85a58712a58e8f408a0fe2249f197";
var temp;
$(document).ready(function() {
	// autocomplete feature

	$.get("http://api.openweathermap.org/data/2.5/weather", {
		"zip" : 52557,
		"APPID" : api
	}).done(ajaxSucess).fail(ajaxFailure);
	setInterval(function() {
		$("#currentWeather").empty();
		$.get("http://api.openweathermap.org/data/2.5/weather", {
			"zip" : 52557,
			"APPID" : api
		}).done(ajaxSucess);
	}, 600000);
	$.get("http://api.openweathermap.org/data/2.5/forecast", {
		"zip" : 52557,
		"APPID" : api
	}).done(forecast);
	// runs every 10 mts to update the weather
	setInterval(function() {
		$("#forecastWeather").empty();
		$.get("http://api.openweathermap.org/data/2.5/forecast", {
			"zip" : 52557,
			"APPID" : api
		}).done(forecast);
	}, 600000);
	// search button eventcolor:licolor:lightbluecolor:lightblueghtblue
	$("#searchBtn").click(searchCityWeather);

});
function ajaxSucess(data) {
	$("<span>").html(data.name + "," + data.sys.country + "<br>").appendTo(
			"#currentWeather");
	$("<img>").attr(
			{
				"src" : "http://openweathermap.org/img/w/"
						+ data.weather[0].icon + ".png",
				alt : "icon"
			}).appendTo("#currentWeather");
	var k = parseFloat(data.main.temp);
	var f = 9 / 5 * (k - 273) + 32;
	var time = new Date();
	temp=f.toFixed(2);
	var currentHour = time.getHours() + ":" + time.getMinutes();
	$("<span>").html(
			f.toFixed(2) + " F <br>" + data.weather[0].description
					+ "<br>last updated:" + currentHour).appendTo(
			"#currentWeather");
	$("<p>").html(
			"Wind " + data.wind.speed + " mph  " + "Humidity "
					+ data.main.humidity + " %").appendTo("#currentWeather");

}
function ajaxFailure(xhr, exception) {

}
function forecast(data) {

	var weekly = [ "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" ];
	$("<p>").text("Daily forecast").appendTo("#forecastWeather");
	// $.each(data.list, function(index,forecast){
	var forecast = data.list;

	for (var i = 5; i < forecast.length; i += 8) {
		var k = parseFloat(forecast[i].main.temp);
		var f = 9 / 5 * (k - 273) + 32;
		var icon = forecast[i].weather[0].icon;
		var description = forecast[i].weather[0].description;
		var date = new Date(forecast[i].dt_txt);
		var days = weekly[date.getDay()];
		$("<div>").append($("<img>").attr({
			"src" : "http://openweathermap.org/img/w/" + icon + ".png",
			alt : "icon"
		})).appendTo("#forecastWeather").addClass("daily").attr({
			"id" : "d" + i
		});
		$("<span>").html(
				days + " " + date.getDate() + "<br>" + f.toFixed(2) + " F<br>"
						+ description + "<br>").appendTo("#d" + i)
	}
	// });
}

function handleLocationError(browserHasGeolocation, infoWindow, pos) {
	infoWindow.setPosition(pos);
	infoWindow
			.setContent(browserHasGeolocation ? 'Error: The Geolocation service failed.'
					: 'Error: Your browser doesn\'t support geolocation.');
}

/*
 * Google auto complete feature for search using Place API
 */
function initAutocomplete() {

	var map = new google.maps.Map(document.getElementById('map'), {
		zoom : 13,
		mapTypeId : 'roadmap'
	});
	// Load user locations
	var infoWindow = new google.maps.InfoWindow({
		
	});

	if (navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(function(position) {
			var pos = {
				lat : position.coords.latitude,
				lng : position.coords.longitude
			};
			var info="<div>Temp:"+temp+"</div>";
			infoWindow.setContent(info);
			var marker = new google.maps.Marker({
				position : pos,
				map : map,
				title : "Weather"
			});

			map.setCenter(pos);
			marker.addListener('click', function() {
				infoWindow.open(map, marker);

			});
		}, function() {
			handleLocationError(true, infoWindow, map.getCenter());
		});
	} else {
		var recenter = {
				lat : 56,
				lng : -90
			};
		var marker = new google.maps.Marker({
			position : pos,
			map : map,
			title : "Weather"
		});
		map.setCenter(recenter);
//		// Browser doesn't support Geolocation
//		handleLocationError(false, infoWindow, map.getCenter());
	}

	// Create the search box and link it to the UI element.
	var input = document.getElementById('searchBox');
	var searchBox = new google.maps.places.SearchBox(input);
	map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);
	// get forecast weather information

	// Bias the SearchBox results towards current map's viewport.
	map.addListener('bounds_changed', function() {
		searchBox.setBounds(map.getBounds());

	});

	var markers = [];
	// Listen for the event fired when the user selects a prediction and
	// retrieve
	// more details for that place.
	searchBox
			.addListener(
					'places_changed',
					function() {
						var places = searchBox.getPlaces();

						if (places.length == 0) {
							return;
						}

						// get current weather
						infoWindow.close();
						// Clear out the old markers.
						markers.forEach(function(marker) {
							marker.setMap(null);
						});
						markers = [];
						var q;
						var address = '';
						// For each place, get the icon, name and location.
						var bounds = new google.maps.LatLngBounds();
						places
								.forEach(function(place) {
									q = place.name;

									if (!place.geometry) {
										console
												.log("Returned place contains no geometry");
										return;
									}
									var icon = {
										url : place.icon,
										size : new google.maps.Size(71, 71),
										origin : new google.maps.Point(0, 0),
										anchor : new google.maps.Point(17, 34),
										scaledSize : new google.maps.Size(25,
												25)
									};

									if (place.address_components) {
										address = [
												(place.address_components[0]
														&& place.address_components[0].short_name || ''),
												(place.address_components[1]
														&& place.address_components[1].short_name || ''),
												(place.address_components[2]
														&& place.address_components[2].short_name || '') ]
												.join(' ');
									}

									// Create a marker for each place.
									markers.push(new google.maps.Marker({
										map : map,
										icon : icon,
										title : place.name,
										position : place.geometry.location
									}));
									// create marker event handler

									if (place.geometry.viewport) {
										// Only geocodes have viewport.
										bounds.union(place.geometry.viewport);
									} else {
										bounds.extend(place.geometry.location);
									}
								});
						map.fitBounds(bounds);
						// make ajax request to get destination weather
						// condition
						$.get("http://api.openweathermap.org/data/2.5/weather",
								{
									"q" : address,
									"APPID" : api
								}).done(
								function(data) {
									$("#currentWeather").empty();
									ajaxSucess(data);
									var temperature = "<div>Temp"
											+ data.main.temp + " F</div>"
								});
						$
								.get(
										"http://api.openweathermap.org/data/2.5/forecast",
										{
											"q" : address,
											"APPID" : api
										}).done(function(data) {
									$("#forecastWeather").empty();
									forecast(data);
								});
					});
}
