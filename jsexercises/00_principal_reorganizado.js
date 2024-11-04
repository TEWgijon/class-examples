let pedirNombre = function() {
    var nombre = prompt("Dime tu nombre")
    document.getElementById("nombre").innerText = nombre;
}

let mostrarDatos = function() {
    var main = document.getElementsByTagName("main")[0]

    main.removeChild(main.getElementsByTagName("input")[0])

    var contenedor = document.createElement("section")
    main.appendChild(contenedor)
    contenedor.innerHTML = "<h2>Datos del navegador</h2>"
    contenedor.innerHTML += `<p>Plataforma=${navigator.platform}</p>`
    contenedor.innerHTML += `<p>User Agent=${navigator.userAgent}</p>`
    contenedor.innerHTML += `<p>Idioma=${navigator.language}</p>`
    contenedor.innerHTML += `<p>Fabricante=${navigator.vendor}</p>`
    contenedor.innerHTML += `<p>Driver=${navigator.product}</p>`
}