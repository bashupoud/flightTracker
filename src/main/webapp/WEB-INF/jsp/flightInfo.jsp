<!DOCTYPE html>
<html>
  <head>
    <style>
#map {
        width: 100%;
        height: 800px;
     }
    </style>
  </head>
  <body>
	<h1>Flight Info for ${model.flight.name}</h1>
	
	<p>The last report for this Flight was at ${model.position.timestamp}</p>
	
	<p>It was at lat long ${model.position.lat}, ${model.position.longitude}</p>

    <div id="map"></div>
    <script>
      function initMap() {
        var myLatLng = {lat: ${model.position.lat}, lng: ${model.position.longitude}};
      
        var mapDiv = document.getElementById('map');
        var map = new google.maps.Map(mapDiv, {
            center: myLatLng,
            zoom: 15
        });
        
          var marker = new google.maps.Marker({
    		position: myLatLng,
    		map: map,
    		title: '${model.position.timestamp}'
  		  });               
      }
      
   //AIzaSyD_zSusNtdm05ME_XlDnGBkoo-qp2sjV5o
    </script>
    <script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD_zSusNtdm05ME_XlDnGBkoo-qp2sjV5o&callback=initMap">
    </script>
  </body>
</html>