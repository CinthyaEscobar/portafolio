var sel1 = document.querySelector('#sel1');
var sel2 = document.querySelector('#sel2');
var sel3 = document.querySelector('#sel3');

var options2 = sel2.querySelectorAll('option');
var options3 = sel3.querySelectorAll('option');

function cargarDos(selValue) {      
    sel2.innerHTML = '';
    for(var i = 0; i < options2.length; i++)
    {		
        if(options2[i].dataset.option == selValue)
        {
            sel2.appendChild(options2[i]);
        }
    }
	cargarTres(sel2.value);    
}

function cargarTres(selValue) {
    sel3.innerHTML = '';
    for(var i = 0; i < options3.length; i++)
    {
        if(options3[i].dataset.option == selValue)
        {
            sel3.appendChild(options3[i]);
        }
    }    
}

var imgInp = document.querySelector('#customFileLang');
imgInp.onchange = evt => {
  const [file] = imgInp.files
  if (file) {
    blah.src = URL.createObjectURL(file)
  }
}


cargarDos(sel1.value);
cargarTres(sel2.value);