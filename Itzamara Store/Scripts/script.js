// let contador = 1;
// setInterval(function(){
//     document.getElementById('radio' + contador).checked = true;
//     contador++;
//     if(contador > 4){
//         contador = 1;
//     }
// }, 5000 );

const carrito = document.querySelector('#carrito');
const contenedorCarrito = document.querySelector('#lista-carrito tbody');
const vaciarCarrito = document.querySelector('#vaciar-carrito');
const listaProductos = document.querySelector('#lista-producto');
let articulosCarrito = [];

cargarEventListeners();

function cargarEventListeners(){
    listaProductos.addEventListener('click', agregarCurso);

    //Elimina productos del carrito
    carrito.addEventListener('click', eliminarProducto);

    //Vaciar el carrito
    vaciarCarrito.addEventListener('click', () =>{
        articulosCarrito = []; //reseteamos arreglo
        limpiarHTML(); //Eliminamos todo el HTML
    })

}

//Funciones
function agregarCurso(e){
    e.preventDefault();

    if(e.target.classList.contains('agregar-carrito') ){
        const productoSeleccioando = e.target.parentElement;
        leerDatos(productoSeleccioando);
    }
}

function eliminarProducto(e){
    console.log(e.target.classList);
    if(e.target.classList.contains('borrar-curso')){
        const productoId = e.target.getAttribute('data-id');

        //elimina del arrglo articulosCarrito por el data-id
        articulosCarrito = articulosCarrito.filter( p => p.id !== productoId );
        
        carritoHTML(); //iterar sobre el carrito y mostrar su HTML
    }
}

//Lee contenido HTML
function leerDatos(p){
    //   console.log(p);

    const infP = {
        imagen: p.querySelector('img').src,
        titulo: p.querySelector('h4').textContent,
        precio: p.querySelector('.precio').textContent,
        id: p.querySelector('a').getAttribute('data-id'),
        cantidad: 1
    }

    //Revisa si un elemento existe en el carrito
    const existe = articulosCarrito.some( p => p.id === infP.id );
    if(existe){
        //Actualizar cantidad
        const pdts = articulosCarrito.map( p =>{
            if(p.id === infP.id){
                p.cantidad++;
                return p; //retorna objeto actualizado
            }else{
                return p; //retorna objetos no duplicados
            }
        });
        articulosCarrito = [...pdts];
    }else{
        //Agrega elementos al carrito
        articulosCarrito = [...articulosCarrito, infP];
    }
     console.log(articulosCarrito);
    carritoHTML();
    
}

//Muestra Carrito en HTML
function carritoHTML() {

    //Limpiar HTML
    limpiarHTML();

    //Recorre el carrito y genera el HTML
    articulosCarrito.forEach( p =>{
        const { imagen, titulo, precio, cantidad, id } = p;
        const row = document.createElement('tr');
        row.innerHTML  = `

        <td><img src="${imagen}" width="100"></td>
        <td>${titulo}</td>
        <td>${precio}</td>
        <td>${cantidad}</td>
        <td>
        <a href="#" class="borrar-curso" data-id="${id}"> X </a>
        </td>
        `;

        //Agrega HTML en el tbody
        contenedorCarrito.appendChild(row);
    })

}

//Limpiar HTML
function limpiarHTML(){
    // contenedorCarrito.innerHTML = '';
    while(contenedorCarrito.firstChild){
        contenedorCarrito.removeChild(contenedorCarrito.firstChild)
    }
}