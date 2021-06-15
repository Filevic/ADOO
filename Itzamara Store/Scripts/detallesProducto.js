
const detallesProducto = async () => {
    const res = await fetch(product_api_url)
    const data = await res.json()//Esto convierte en JS lo que se trae de la API
    console.log(res)
    console.log(data)

    const result = data
        .map((informacion) => generarTarjeta(informacion))//con cada personaje que se lea le pedimos con map que se cree una tarjeta 
        .join(' ')

    contenedor.innerHTML = result
}

const generarTarjeta = ({image_link, name,price,product_api_url}) => {
    return    `   
    <section class="tarjeta">
        <div class="top-tarjeta">
            <a href="${product_api_url}">
                <img src="${image_link}" alt="${name}">
            </a>    
        </div>
        <div class="bottom-tarjeta">
            <h3>${name}</h3>
            <p>$${price}</p>
        </div>
    </section>
    `
}