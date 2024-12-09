function init() {
    // Ajoute un gestionnaire d'événements pour le changement du type
    document.getElementById('type').addEventListener('change', function () {
        const selectedType = this.value; // Récupère la valeur sélectionnée (film ou actor)
        const nameLabel = document.getElementById('nameLabel');

        // Change le libellé en fonction du type sélectionné
        switch (selectedType) {
            case 'film':
                nameLabel.textContent = 'Film:';
                break;
            case 'actor':
                nameLabel.textContent = 'Acteur/rice:';
                break;
            case 'country':
                nameLabel.textContent = 'Country:';
                break;
            case 'crew':
                nameLabel.textContent = 'Crew:';
                break;
            case 'genre':
                nameLabel.textContent = 'Genre:';
                break;
            case 'language':
                nameLabel.textContent = 'Language:';
                break;
            case 'poster':
                nameLabel.textContent = 'Poster:';
                break;
            case 'release':
                nameLabel.textContent = 'Release:';
                break;
            case 'studio':
                nameLabel.textContent = 'Studio:';
                break;
            case 'theme':
                nameLabel.textContent = 'Theme:';
                break;
            case 'movieWithActors':
                nameLabel.textContent = 'Movie with actors';
                break;
            default:
                nameLabel.textContent = 'Type inconnu';
                break;
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
        switch (type) {
            case "film":
                searchFilm(name);
                break;
            case "actor":
                searchActor(name);
                break;
            case "country":
                searchCountry(name);
                break;
            case "crew":
                searchCrew(name);
                break;
            case "genre":
                searchGenre(name);
                break;
            case "language":
                searchLanguage(name);
                break;
            case "poster":
                searchPoster(name);
                break;
            case "release":
                searchRelease(name);
                break;
            case "studio":
                searchStudio(name);
                break;
            case "theme":
                searchTheme(name);
                break;
            case "movieWithActors":
                searchMovieWithActors(name);
                break;
            default:
                alert("Type de recherche inconnu.");
                break;
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

function searchCountry(name) {
    // Requête pour rechercher des pays par mot-clé
    fetch('/countries/findByKeyword?name=' + encodeURIComponent(name))
        .then(response => {
            if (!response.ok) {
                throw new Error("Erreur lors de la récupération des données.");
            }
            return response.json();
        })
        .then(data => {
            if (data.length === 0) {
                document.getElementById("results").textContent = "Aucun pays trouvé.";
            } else {
                // Construire le HTML pour afficher les pays avec leur ID
                const results = data.map(country => `
                    <div>
                        <h3>Pays: ${country.country}</h3>
                        <p>ID: ${country.id}</p>
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

function searchCrew(name) {
    // Requête pour rechercher des pays par mot-clé
    fetch('/crews/findByKeyword?name=' + encodeURIComponent(name))
        .then(response => {
            if (!response.ok) {
                throw new Error("Erreur lors de la récupération des données.");
            }
            return response.json();
        })
        .then(data => {
            if (data.length === 0) {
                document.getElementById("results").textContent = "Aucun crew trouvé.";
            } else {
                // Construire le HTML pour afficher les pays avec leur ID
                const results = data.map(crew => `
                    <div>
                        <h3>Name: ${crew.name}</h3>
                        <p>ID: ${crew.id}</p>
                        <p>Role : ${crew.role}</p>
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

function searchGenre(name) {
    // Requête pour rechercher des pays par mot-clé
    fetch('/genres/findByKeyword?name=' + encodeURIComponent(name))
        .then(response => {
            if (!response.ok) {
                throw new Error("Erreur lors de la récupération des données.");
            }
            return response.json();
        })
        .then(data => {
            if (data.length === 0) {
                document.getElementById("results").textContent = "Aucun pays trouvé.";
            } else {
                // Construire le HTML pour afficher les pays avec leur ID
                const results = data.map(genre => `
                    <div>
                        <h3>Genre: ${genre.genre}</h3>
                        <p>ID: ${genre.id}</p>
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

function searchLanguage(name) {
    // Requête pour rechercher des pays par mot-clé
    fetch('/languages/findByKeyword?name=' + encodeURIComponent(name))
        .then(response => {
            if (!response.ok) {
                throw new Error("Erreur lors de la récupération des données.");
            }
            return response.json();
        })
        .then(data => {
            if (data.length === 0) {
                document.getElementById("results").textContent = "Aucun pays trouvé.";
            } else {
                // Construire le HTML pour afficher les pays avec leur ID
                const results = data.map(language => `
                    <div>
                        <h3>Language: ${language.language}</h3>
                        <p>ID: ${language.id}</p>
                        <p>Type: ${language.type}</p>
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

function searchPoster(name) {
    // Requête pour rechercher des pays par mot-clé
    fetch('/posters/findByKeyword?name=' + encodeURIComponent(name))
        .then(response => {
            if (!response.ok) {
                throw new Error("Erreur lors de la récupération des données.");
            }
            return response.json();
        })
        .then(data => {
            if (data.length === 0) {
                document.getElementById("results").textContent = "Aucun lien trouvé.";
            } else {
                // Construire le HTML pour afficher les pays avec leur ID
                const results = data.map(poster => `
                    <div>
                        <h3>ID: ${poster.id}</h3>
                        <p>Link: ${poster.link}</p>
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

function searchRelease(name) {
    // Requête pour rechercher des pays par mot-clé
    fetch('/releases/findByKeyword?name=' + encodeURIComponent(name))
        .then(response => {
            if (!response.ok) {
                throw new Error("Erreur lors de la récupération des données.");
            }
            return response.json();
        })
        .then(data => {
            if (data.length === 0) {
                document.getElementById("results").textContent = "Aucun lien trouvé.";
            } else {
                // Construire le HTML pour afficher les pays avec leur ID
                const results = data.map(release => `
                    <div>
                        <h3>ID: ${release.id}</h3>
                        <p>Country: ${release.country}</p>
                        <p>Date: ${release.date}</p>
                        <p>Type: ${release.type}</p>
                        <p>Rating: ${release.rating}</p>
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

function searchStudio(name) {
    // Requête pour rechercher des pays par mot-clé
    fetch('/studios/findByKeyword?name=' + encodeURIComponent(name))
        .then(response => {
            if (!response.ok) {
                throw new Error("Erreur lors de la récupération des données.");
            }
            return response.json();
        })
        .then(data => {
            if (data.length === 0) {
                document.getElementById("results").textContent = "Aucun studio trouvé.";
            } else {
                // Construire le HTML pour afficher les pays avec leur ID
                const results = data.map(studio => `
                    <div>
                        <h3>Studio: ${studio.studio}</h3>
                        <p>ID: ${studio.id}</p>
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

function searchTheme(name) {
    // Requête pour rechercher des pays par mot-clé
    fetch('/themes/findByKeyword?name=' + encodeURIComponent(name))
        .then(response => {
            if (!response.ok) {
                throw new Error("Erreur lors de la récupération des données.");
            }
            return response.json();
        })
        .then(data => {
            if (data.length === 0) {
                document.getElementById("results").textContent = "Aucun studio trouvé.";
            } else {
                // Construire le HTML pour afficher les pays avec leur ID
                const results = data.map(theme => `
                    <div>
                        <h3>Theme: ${theme.theme}</h3>
                        <p>ID: ${theme.id}</p>
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

function searchMovieWithActors(name) {
    fetch('/movies/findByNameMovieAndActors?name=' + encodeURIComponent(name))
        .then(response => {
            if (!response.ok) {
                throw new Error("Film non trouvé ou erreur lors de la récupération.");
            }
            return response.json();
        })
        .then(data => {
            if (data.length === 0) {
                document.getElementById("results").textContent = "Aucun film trouvé.";
                return;
            }

            // Extraire les informations du film depuis la première ligne
            const movieInfo = `
                <h3>${data[0][1]} (${data[0][2]})</h3>
                <p><strong>Tagline:</strong> ${data[0][6]}</p>
                <p><strong>Description:</strong> ${data[0][3]}</p>
                <p><strong>Duration:</strong> ${data[0][4]} minutes</p>
                <p><strong>Rating:</strong> ${data[0][5]}</p>
            `;

            // Lister les acteurs
            const actorList = data
                .filter(row => row[7] !== null) // Exclure les lignes sans acteur
                .map(row => `<li>${row[7]} as ${row[8]}</li>`)
                .join("");

            const fullInfo = `
                ${movieInfo}
                <h4>Actors:</h4>
                <ul>
                    ${actorList || "<li>No actors found.</li>"}
                </ul>
            `;

            document.getElementById("results").innerHTML = fullInfo;
        })
        .catch(error => {
            console.error("Erreur :", error);
            document.getElementById("results").textContent = "Erreur lors de la recherche du film.";
        });
}


