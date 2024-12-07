function init(){
    try {
        const button = document.getElementById('submit');
        button.onclick = onSubmit;
    } catch (e){};
    try {
        const buttonQuery = document.getElementById('submit_q');
        buttonQuery.onclick = onSubmitQuery;
    } catch (e){};

    document.getElementById('results').style.display='none';
    document.getElementById('xForm').style.display='block';
}
/**
 * It sends an Ajax query using Axios
 * @param {string} url - The URL to send the request to
 * @param {Object} data - The data to send as query parameters
 */
function sendAxiosQuery(url, data) {
    const params = new URLSearchParams(data).toString();

    axios.get(`${url}?${params}`)
        .then(function (dataR) {
            const results = dataR.data;
            let output = "Movies found: <br>";
            results.forEach(movie => {
                output += `
                    ID: ${movie.id}<br>
                    Name: ${movie.name}<br>
                    Date: ${movie.date}<br>
                    Tagline: ${movie.tagline}<br>
                    Description: ${movie.description}<br>
                    Minute: ${movie.minute}<br>
                    Rating: ${movie.rating}<br>
                    <br>
                `;
            });
            document.getElementById('results').innerHTML = output;
            document.getElementById('results').style.display = 'block';
            document.getElementById('xForm').style.display = 'block';
        })
        .catch(function (error) {
            if (error.response && error.response.status === 404) {
                alert("No movies found.");
            } else {
                alert("An error occurred: " + error.message);
            }
        });
}



/**
 * Called when the submit button is pressed
 * @param {Event} event - The submission event
 */
function onSubmit(event) {
    onSubmitAux(event, '/movies/findByKeyword'); // Envoie les données pour chercher un film
}

/**
 * Called when another query is triggered (do not modify this function)
 * @param {Event} event - The submission event
 */
function onSubmitQuery(event) {
    onSubmitAux(event, '/query'); // Envoie les données pour une autre action
}

/**
 * Helper function to process form data and send an AJAX query
 * @param {Event} event - The form submission event
 * @param {string} url - The URL to send the request to
 */
function onSubmitAux(event, url) {
    // Sérialise les données du formulaire en un objet JavaScript
    const formArray = $("#xForm").serializeArray(); // Récupère les données du formulaire spécifique
    const data = {};
    formArray.forEach(field => {
        data[field.name] = field.value; // Convertit les données du formulaire en objet clé-valeur
    });

    sendAxiosQuery(url, data); // Envoi de la requête via Axios

    event.preventDefault(); // Empêche le rechargement de la page
}