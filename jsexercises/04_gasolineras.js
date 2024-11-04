let markers = L.markerClusterGroup();
let cargarDatos = function() {
    let loading = document.createElement('div')
    loading.id = "loading"
    document.body.appendChild(loading)
    fetch('https://sedeaplicaciones.minetur.gob.es/ServiciosRESTCarburantes/PreciosCarburantes/EstacionesTerrestres/', {
        dataType: "json"
    }).then(response => response.json()).then(data => {
        data.ListaEESSPrecio.forEach(estacion => {
            if (estacion["Longitud (WGS84)"] == null || estacion["Latitud"] == null)
                return;

            var marker = L.marker([parseFloat(estacion["Latitud"].replace(",", ".")), parseFloat(estacion["Longitud (WGS84)"].replace(",", "."))])
            markers.addLayer(marker)

            var texto = "<div class='info'><h1>" + estacion["Rótulo"] + "</h1>"
            texto += "<p>Precios</p><dl>";
            texto += Object.keys(estacion).filter(k => k.startsWith("Precio") & estacion[k].length > 0).map(k => `<dt>${k}</dt><dd>${estacion[k]}</dd>`).join("")
            texto += "</dl></div>"
            marker.bindPopup(texto);
        })
        document.body.removeChild(loading)
    });
}

let map = L.map('map').setView([40.416775, -3.703790], 6);
L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {maxZoom: 19}).addTo(map);
map.addLayer(markers);
cargarDatos();

if (navigator.geolocation)
    navigator.geolocation.getCurrentPosition(pos => map.setView(new L.LatLng(pos.coords.latitude, pos.coords.longitude), 13));