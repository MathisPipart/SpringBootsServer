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
            case 'movieWithPosters':
                nameLabel.textContent = 'Movie with posters';
                break;
            case 'movieWithStudios':
                nameLabel.textContent = 'Movie with studios';
                break;
            case 'movieWithCountries':
                nameLabel.textContent = 'Movie with countries';
                break;
            case 'movieWithCrew':
                nameLabel.textContent = 'Movie with crew';
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
            case "movieWithPosters":
                searchMovieWithPosters(name);
                break;
            case "movieWithStudios":
                searchMovieWithStudios(name);
                break;
            case "movieWithCountries":
                searchMovieWithCountries(name);
                break;
            case 'movieWithCrew':
                searchMovieWithCrew(name);
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

            // Grouper les résultats par film (par movie_id)
            const movies = {};
            data.forEach(row => {
                const movieId = row[0]; // movie_id
                if (!movies[movieId]) {
                    movies[movieId] = {
                        id: movieId,
                        name: row[1],
                        date: row[2],
                        description: row[3],
                        duration: row[4],
                        rating: row[5],
                        tagline: row[6],
                        actors: [],
                    };
                }
                if (row[7]) {
                    // Ajouter l'acteur à la liste des acteurs pour ce film
                    movies[movieId].actors.push({
                        name: row[7],
                        role: row[8],
                    });
                }
            });

            // Construire le HTML pour afficher les films et leurs posters
            const resultsHTML = Object.values(movies)
                .map(movie => {
                    const actorList = movie.actors
                        .map(actor => `<li>${actor.name} as ${actor.role}</li>`)
                        .join("");

                    return `
                        <div>
                            <h3>${movie.name} (${movie.date})</h3>
                            <p><strong>Tagline:</strong> ${movie.tagline}</p>
                            <p><strong>Description:</strong> ${movie.description}</p>
                            <p><strong>Duration:</strong> ${movie.duration} minutes</p>
                            <p><strong>Rating:</strong> ${movie.rating}</p>
                            <h4>Actors:</h4>
                            <ul>
                                ${actorList || "<li>No actors found.</li>"}
                            </ul>
                        </div>
                    `;
                })
                .join("");

            document.getElementById("results").innerHTML = resultsHTML;
        })
        .catch(error => {
            console.error("Erreur :", error);
            document.getElementById("results").textContent = "Erreur lors de la recherche du film.";
        });
}

function searchMovieWithPosters(name) {
    fetch('/movies/findPostersofMovies?name=' + encodeURIComponent(name))
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

            // Grouper les résultats par film (par movie_id)
            const movies = {};
            data.forEach(row => {
                const movieId = row[0]; // movie_id
                if (!movies[movieId]) {
                    movies[movieId] = {
                        id: movieId,
                        name: row[1],
                        date: row[2],
                        description: row[3],
                        duration: row[4],
                        rating: row[5],
                        tagline: row[6],
                        posterLink: row[8], // Lien du poster
                    };
                }
            });

            // Construire le HTML pour afficher les films et leurs posters
            const resultsHTML = Object.values(movies)
                .map(movie => {
                    return `
                        <div>
                            <h3>${movie.name} (${movie.date})</h3>
                            <p>Tagline: ${movie.tagline}</p>
                            <p>Description: ${movie.description}</p>
                            <p>Duration: ${movie.duration} minutes</p>
                            <p>Rating: ${movie.rating}</p>
                            <h4>Poster:</h4>
                            <img src="${movie.posterLink}" alt="Poster of ${movie.name}" style="max-width: 200px; max-height: 300px;">
                        </div>
                    `;
                })
                .join("");

            document.getElementById("results").innerHTML = resultsHTML;
        })
        .catch(error => {
            console.error("Erreur :", error);
            document.getElementById("results").textContent = "Erreur lors de la recherche du film.";
        });
}

function searchMovieWithStudios(name) {
    fetch('/movies/findStudiosofMovies?name=' + encodeURIComponent(name))
        .then(response => {
            if (!response.ok) {
                throw new Error("Studio non trouvé ou erreur lors de la récupération.");
            }
            return response.json();
        })
        .then(data => {
            if (data.length === 0) {
                document.getElementById("results").textContent = "Aucun studio trouvé.";
                return;
            }

            // Grouper les résultats par film (par movie_id)
            const movies = {};
            data.forEach(row => {
                const movieId = row[0]; // movie_id
                if (!movies[movieId]) {
                    movies[movieId] = {
                        id: movieId,
                        name: row[1],
                        date: row[2],
                        description: row[3],
                        duration: row[4],
                        rating: row[5],
                        tagline: row[6],
                        studios: [],
                    };
                }
                if (row[8]) {
                    // Ajouter le studio à la liste des acteurs pour ce film
                    movies[movieId].studios.push({
                        studio: row[8]
                    });
                }
            });

            // Construire le HTML pour afficher les films et leurs studios
            const resultsHTML = Object.values(movies)
                .map(movie => {
                    const studioList = movie.studios
                        .map(studio => `<li>${studio.studio}</li>`)
                        .join("");
                    return `
                        <div>
                            <h3>${movie.name} (${movie.date})</h3>
                            <p>Tagline: ${movie.tagline}</p>
                            <p>Description: ${movie.description}</p>
                            <p>Duration: ${movie.duration} minutes</p>
                            <p>Rating: ${movie.rating}</p>
                            <h4>Studios:</h4>
                            <ul>
                                ${studioList || "<li>No studios found.</li>"}
                            </ul>
                        </div>
                    `;
                })
                .join("");

            document.getElementById("results").innerHTML = resultsHTML;
        })
        .catch(error => {
            console.error("Erreur :", error);
            document.getElementById("results").textContent = "Erreur lors de la recherche du studio.";
        });
}

function searchMovieWithCountries(name) {
    fetch('/movies/findCountriesofMovies?name=' + encodeURIComponent(name))
        .then(response => {
            if (!response.ok) {
                throw new Error("Pays non trouvé ou erreur lors de la récupération.");
            }
            return response.json();
        })
        .then(data => {
            if (data.length === 0) {
                document.getElementById("results").textContent = "Aucun pays trouvé.";
                return;
            }

            // Grouper les résultats par film (par movie_id)
            const movies = {};
            data.forEach(row => {
                const movieId = row[0]; // movie_id
                if (!movies[movieId]) {
                    movies[movieId] = {
                        id: movieId,
                        name: row[1],
                        date: row[2],
                        description: row[3],
                        duration: row[4],
                        rating: row[5],
                        tagline: row[6],
                        countries: [],
                    };
                }
                if (row[8]) {
                    // Ajouter le pays à la liste des acteurs pour ce film
                    movies[movieId].countries.push({
                        country: row[8]
                    });
                }
            });

            // Construire le HTML pour afficher les films et leurs pays
            const resultsHTML = Object.values(movies)
                .map(movie => {
                    const countryList = movie.countries
                        .map(country => `<li>${country.country}</li>`)
                        .join("");
                    return `
                        <div>
                            <h3>${movie.name} (${movie.date})</h3>
                            <p>Tagline: ${movie.tagline}</p>
                            <p>Description: ${movie.description}</p>
                            <p>Duration: ${movie.duration} minutes</p>
                            <p>Rating: ${movie.rating}</p>
                            <h4>Countries:</h4>
                            <ul>
                                ${countryList || "<li>No countries found.</li>"}
                            </ul>
                        </div>
                    `;
                })
                .join("");

            document.getElementById("results").innerHTML = resultsHTML;
        })
        .catch(error => {
            console.error("Erreur :", error);
            document.getElementById("results").textContent = "Erreur lors de la recherche du studio.";
        });
}

function searchMovieWithCrew(name) {
    fetch('/movies/findCrewofMovies?name=' + encodeURIComponent(name))
        .then(response => {
            if (!response.ok) {
                throw new Error("Personnel non trouvé ou erreur lors de la récupération.");
            }
            return response.json();
        })
        .then(data => {
            if (data.length === 0) {
                document.getElementById("results").textContent = "Aucun personnel trouvé.";
                return;
            }

            // Grouper les résultats par film (par movie_id)
            const movies = {};
            data.forEach(row => {
                const movieId = row[0]; // movie_id
                if (!movies[movieId]) {
                    movies[movieId] = {
                        id: movieId,
                        name: row[1],
                        date: row[2],
                        description: row[3],
                        duration: row[4],
                        rating: row[5],
                        tagline: row[6],
                        crew: [],
                    };
                }
                if (row[8] && row[9]) {
                    // Ajouter le membre de l'équipe à la liste
                    movies[movieId].crew.push(`${row[9]} as ${row[8]}`); // Nom + rôle
                }
            });

            // Construire le HTML pour afficher les films et leur personnel
            const resultsHTML = Object.values(movies)
                .map(movie => {
                    const crewList = movie.crew.join(", "); // Séparer les membres par une virgule
                    return `
                        <div>
                            <h3>${movie.name} (${movie.date})</h3>
                            <p>Tagline: ${movie.tagline}</p>
                            <p>Description: ${movie.description}</p>
                            <p>Duration: ${movie.duration} minutes</p>
                            <p>Rating: ${movie.rating}</p>
                            <h4>Crew:</h4>
                                ${crewList || "<p>No crew found.</p>"}
                        </div>
                    `;
                })
                .join("");

            document.getElementById("results").innerHTML = resultsHTML;
        })
        .catch(error => {
            console.error("Erreur :", error);
            document.getElementById("results").textContent = "Erreur lors de la recherche du studio.";
        });
}



