/**function init(){
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
}**/

function init() {
    // Ajoute un gestionnaire d'événements pour le changement du type
    document.getElementById('type').addEventListener('change', function () {
        const selectedType = this.value; // Récupère la valeur sélectionnée (film ou actor)
        const nameLabel = document.getElementById('nameLabel');

        // Change le libellé en fonction du type sélectionné
        if (selectedType === 'film') {
            nameLabel.textContent = 'Film:';
        } else {
            nameLabel.textContent = 'Acteur/rice:';
        }
    });

    // Ajoute un gestionnaire d'événements pour la soumission du formulaire
    document.getElementById('xForm').addEventListener('submit', function (e) {
        e.preventDefault(); // Empêche le rechargement de la page

        const type = document.getElementById('type').value; // Type (film ou actor)
        const name = document.getElementById('name').value; // Nom saisi

        if (!name) {
            alert('Veuillez saisir un nom pour votre recherche.');
            return;
        }
        if (type === "film") {
            searchFilm(name);
        } else if (type === "actor") {
            searchActor(name);
        }
        /**
        // Construire l'URL de l'API
        let url = '';
        if (type === 'film') {
            url = `/movies/findByName?name=${encodeURIComponent(name)}`;
        } else {
            url = `/actors/findByName?name=${encodeURIComponent(name)}`;
        }

        // Faire une requête avec Axios
        axios.get(url)
            .then(response => {
                const results = document.getElementById('results');
                results.textContent = JSON.stringify(response.data, null, 2); // Afficher les résultats formatés
            })
            .catch(error => {
                console.error(error);
                alert('Une erreur est survenue lors de la recherche.');
            });**/
    });
 }

function searchFilm(name) {
    // Requête pour rechercher des films
    fetch('http://localhost:8082/movies/findByKeyword?name=' + encodeURIComponent(name))
        .then(response => {
            if (!response.ok) {
                throw new Error("Erreur lors de la récupération des données.");
            }
            return response.json();
        })
        .then(data => {
            if (data.length === 0) {
                document.getElementById("results").textContent = "Aucun film trouvé.";
            } else {
                // Construire le HTML pour afficher les films
                const results = data.map(movie => `
                    <div>
                        <h3>${movie.name}</h3>
                        <p>ID: ${movie.id}</p>
                        <p>Date: ${movie.date}</p>
                        <p>Tagline: ${movie.tagline}</p>
                        <p>Description: ${movie.description}</p>
                        <p>Durée: ${movie.minute} minutes</p>
                        <p>Note: ${movie.rating}</p>
                    </div>
                `).join("");
                document.getElementById("results").innerHTML = results;
            }
        })
        .catch(error => {
            console.error("Erreur :", error);
            document.getElementById("results").textContent = "Erreur lors de la récupération des données.";
        });
}

function searchActor(name) {
    // Requête pour rechercher des acteurs
    fetch('http://localhost:8082/actors/findByKeyword?name=' + encodeURIComponent(name))
        .then(response => {
            if (!response.ok) {
                throw new Error("Erreur lors de la récupération des données.");
            }
            return response.json();
        })
        .then(data => {
            if (data.length === 0) {
                document.getElementById("results").textContent = "Aucun acteur/rice trouvé.";
            } else {
                // Construire le HTML pour afficher les acteurs
                const results = data.map(actor => `
                    <div>
                        <h3>${actor.name}</h3>
                        <p>ID: ${actor.id}</p>
                        <p>Rôle: ${actor.role}</p>
                    </div>
                `).join("");
                document.getElementById("results").innerHTML = results;
            }
        })
        .catch(error => {
            console.error("Erreur :", error);
            document.getElementById("results").textContent = "Erreur lors de la récupération des données.";
        });
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
            document.getElementById('' +
                '').style.display = 'block';
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