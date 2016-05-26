function redireccionar () {
	// body...
	var documento= document.getElementById('documento').value;
	

	if (documento == 111) {

		document.getElementById('login').action= "Gerente.html";




	}if (documento == 222) {

		document.getElementById('login').action= "secretaria.html";




	}if (documento == 333) {

		document.getElementById('login').action= "Asamblea.html";




	}if (documento == 444) {

		document.getElementById('login').action= "juntadirectiva.html";




	};
}
