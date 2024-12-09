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
    });
 }

function searchFilm(name) {
    // Requête pour rechercher des films
    fetch('/movies/findByKeyword?name=' + encodeURIComponent(name))
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
    fetch('/actors/findByKeyword?name=' + encodeURIComponent(name))
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