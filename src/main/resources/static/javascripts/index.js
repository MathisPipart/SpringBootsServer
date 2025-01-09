/**
 * Initializes the application interface and event handlers for user interactions.
 */
function init() {
    /**
     * Adds an event listener for changes in the type selection dropdown.
     * Updates the label text based on the selected type.
     */
    document.getElementById('type').addEventListener('change', function () {
        const selectedType = this.value;
        const nameLabel = document.getElementById('nameLabel');

        // Update the label text based on the selected type
        switch (selectedType) {
            case 'movieDetails':
                nameLabel.textContent = 'Movie Details:';
                break;
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
            case 'movieWithGenre':
                nameLabel.textContent = 'Movie with genre';
                break;
            case 'movieWithLanguage':
                nameLabel.textContent = 'Movie with language';
                break;
            case 'movieWithTheme':
                nameLabel.textContent = 'Movie with theme';
                break;
            case 'movieByGenre':
                nameLabel.textContent = 'Movie by genre';
                break;
            case 'movieByDate':
                nameLabel.textContent = 'Movie by date';
                break;
            case 'movieByGenreAndDate':
                nameLabel.textContent = 'Movie by genre and date';
                break;
            default:
                nameLabel.textContent = 'Type inconnu';
                break;
        }

    });

    /**
     * Adds an event listener for the form submission.
     * Prevents page reload and performs a search based on the selected type and input name.
     */
    document.getElementById('xForm').addEventListener('submit', function (e) {
        e.preventDefault(); // Prevent reloading of the page

        const type = document.getElementById('type').value;
        const name = document.getElementById('name').value;

        if (!name) {
            alert('Veuillez saisir un nom pour votre recherche.');
            return;
        }
        switch (type) {
            case "movieDetails":
                searchMovieDetails(name);
                break;
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
            case 'movieWithGenre':
                searchMovieWithGenre(name);
                break;
            case 'movieWithLanguage':
                searchMovieWithLanguage(name);
                break;
            case 'movieWithTheme':
                searchMovieWithTheme(name);
                break;
            case 'movieByGenre':
                searchMoviesByGenre(name);
                break;
            case 'movieByDate':
                searchMoviesByDate(name);
                break;
            case 'movieByGenreAndDate':
                searchMoviesByGenreAndDate();
                break;
            default:
                alert("Unknown search type.");
                break;
        }

    });
 }

/**
 * Fetches the details of a movie by its ID from the API and displays the results.
 *
 * @param {string} id - The ID of the movie to fetch.
 */
function searchMovieDetails(id) {
    const url = `http://localhost:8082/detailsMovies/findById/${id}`;

    fetch(url)
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error(`Movie with id ${id} not found (status: ${response.status})`);
            }
        })
        .then(data => {
            console.log("Movie details :", data);
            displayMovieDetails(data);
        })
        .catch(error => {
            console.error("Error while loading the details of the movie :", error);
        });
}

/**
 * Displays the details of a movie in the "results" container.
 *
 * @param {Object} movie - The movie object containing details such as name, date, rating, etc.
 */
function displayMovieDetails(movie) {
    const container = document.getElementById('results');

    if (!container) {
        console.error("Container with the ID 'results' not found in the DOM.");
        return;
    }

    const content = `
        <h2>${movie.name} (${movie.date})</h2>
        <img src="${movie.link}" alt="${movie.name}" style="max-width: 100%; height: auto;" />
        <p><strong>Tagline:</strong> ${movie.tagline}</p>
        <p><strong>Description:</strong> ${movie.description}</p>
        <p><strong>Duration:</strong> ${movie.minute} minutes</p>
        <p><strong>Rating:</strong> ${movie.rating}</p>
        <p><strong>Genres:</strong> ${movie.genres}</p>
        <p><strong>Actors:</strong> ${movie.actors}</p>
        <p><strong>Countries:</strong> ${movie.countries}</p>
        <p><strong>Languages:</strong> ${movie.languages}</p>
        <p><strong>Releases:</strong> ${movie.releases}</p>
        <p><strong>Studios:</strong> ${movie.studios}</p>
        <p><strong>Themes:</strong> ${movie.themes}</p>
        <p><strong>Crew:</strong> ${movie.crew}</p>
    `;

    container.innerHTML = content;
}

/**
 * Searches for movies by keyword and displays the results.
 *
 * @param {string} name - The keyword to search for in movie names.
 */
function searchFilm(name) {
    fetch('/movies/findByKeyword?name=' + encodeURIComponent(name))
        .then(response => {
            if (!response.ok) {
                throw new Error("Error while retrieving the data.");
            }
            return response.json();
        })
        .then(data => {
            if (data.length === 0) {
                document.getElementById("results").textContent = "No movie found.";
            } else {
                const results = data.map(movie => `
                    <div>
                        <h3>${movie.name}</h3>
                        <p>ID: ${movie.id}</p>
                        <p>Date: ${movie.date}</p>
                        <p>Tagline: ${movie.tagline}</p>
                        <p>Description: ${movie.description}</p>
                        <p>Durée: ${movie.minute} minutes</p>
                        <p>Note: ${movie.rating}</p>
                        <p><img src="${movie.link}" alt="Poster Film" style="max-width:200px;"/></p>
                    </div>
                `).join("");
                document.getElementById("results").innerHTML = results;
            }
        })
        .catch(error => {
            console.error("Erreur :", error);
            document.getElementById("results").textContent = "Error while retrieving the data.";
        });
}

/**
 * Searches for actors by keyword and displays the results.
 *
 * @param {string} name - The keyword to search for in actor names.
 */
function searchActor(name) {
    fetch('/actors/findByKeyword?name=' + encodeURIComponent(name))
        .then(response => {
            if (!response.ok) {
                throw new Error("Error while retrieving the data.");
            }
            return response.json();
        })
        .then(data => {
            if (data.length === 0) {
                document.getElementById("results").textContent = "No actors found.";
            } else {
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
            document.getElementById("results").textContent = "Error while retrieving the data.";
        });
}

/**
 * Searches for countries by keyword and displays the results.
 *
 * @param {string} name - The keyword to search for in country names.
 */
function searchCountry(name) {
    fetch('/countries/findByKeyword?name=' + encodeURIComponent(name))
        .then(response => {
            if (!response.ok) {
                throw new Error("Error while retrieving the data.");
            }
            return response.json();
        })
        .then(data => {
            if (data.length === 0) {
                document.getElementById("results").textContent = "No countries found.";
            } else {
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
            document.getElementById("results").textContent = "Error while retrieving the data.";
        });
}

/**
 * Searches for crew members by keyword and displays the results.
 *
 * @param {string} name - The keyword to search for in crew member names.
 */
function searchCrew(name) {
    fetch('/crews/findByKeyword?name=' + encodeURIComponent(name))
        .then(response => {
            if (!response.ok) {
                throw new Error("Error while retrieving the data.");
            }
            return response.json();
        })
        .then(data => {
            if (data.length === 0) {
                document.getElementById("results").textContent = "No crew found.";
            } else {
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
            document.getElementById("results").textContent = "Error while retrieving the data.";
        });
}

/**
 * Searches for genres by keyword and displays the results.
 *
 * @param {string} name - The keyword to search for in genre names.
 */
function searchGenre(name) {
    fetch('/genres/findByKeyword?name=' + encodeURIComponent(name))
        .then(response => {
            if (!response.ok) {
                throw new Error("Error while retrieving the data.");
            }
            return response.json();
        })
        .then(data => {
            if (data.length === 0) {
                document.getElementById("results").textContent = "No country found.";
            } else {
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
            document.getElementById("results").textContent = "Error while retrieving the data.";
        });
}

/**
 * Searches for languages by keyword and displays the results.
 *
 * @param {string} name - The keyword to search for in language names.
 */
function searchLanguage(name) {
    fetch('/languages/findByKeyword?name=' + encodeURIComponent(name))
        .then(response => {
            if (!response.ok) {
                throw new Error("Error while retrieving the data.");
            }
            return response.json();
        })
        .then(data => {
            if (data.length === 0) {
                document.getElementById("results").textContent = "No language found.";
            } else {
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
            document.getElementById("results").textContent = "Error while retrieving the data.";
        });
}

/**
 * Searches for posters by keyword and displays the results.
 *
 * @param {string} name - The keyword to search for in poster links.
 */
function searchPoster(name) {
    fetch('/posters/findByKeyword?name=' + encodeURIComponent(name))
        .then(response => {
            if (!response.ok) {
                throw new Error("Error while retrieving the data.");
            }
            return response.json();
        })
        .then(data => {
            if (data.length === 0) {
                document.getElementById("results").textContent = "No link found";
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
            document.getElementById("results").textContent = "Error while retrieving the data.";
        });
}

/**
 * Searches for releases by keyword and displays the results.
 *
 * @param {string} name - The keyword to search for in release information.
 */
function searchRelease(name) {
    fetch('/releases/findByKeyword?name=' + encodeURIComponent(name))
        .then(response => {
            if (!response.ok) {
                throw new Error("Error while retrieving the data.");
            }
            return response.json();
        })
        .then(data => {
            if (data.length === 0) {
                document.getElementById("results").textContent = "No releases found.";
            } else {
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
            document.getElementById("results").textContent = "Error while retrieving the data.";
        });
}

/**
 * Searches for studios by keyword and displays the results.
 *
 * @param {string} name - The keyword to search for in studio names.
 */
function searchStudio(name) {
    fetch('/studios/findByKeyword?name=' + encodeURIComponent(name))
        .then(response => {
            if (!response.ok) {
                throw new Error("Error while retrieving the data.");
            }
            return response.json();
        })
        .then(data => {
            if (data.length === 0) {
                document.getElementById("results").textContent = "No studios found.";
            } else {
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
            document.getElementById("results").textContent = "Error while retrieving the data.";
        });
}

/**
 * Searches for themes by keyword and displays the results.
 *
 * @param {string} name - The keyword to search for in theme names.
 */
function searchTheme(name) {
    fetch('/themes/findByKeyword?name=' + encodeURIComponent(name))
        .then(response => {
            if (!response.ok) {
                throw new Error("Error while retrieving the data.");
            }
            return response.json();
        })
        .then(data => {
            if (data.length === 0) {
                document.getElementById("results").textContent = "No themes found.";
            } else {
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
            document.getElementById("results").textContent = "Error while retrieving the data.";
        });
}

/**
 * Fetches the 50 top-rated movies from the API and displays the results.
 *
 * @param {string} name - The keyword to search for in movie names.
 */
function searchTopRatedMovies(name) {
    fetch('/movies/topRated?name=' + encodeURIComponent(name))
        .then(response => {
            if (!response.ok) {
                throw new Error("Error fetching top-rated movies.");
            }
            return response.json();
        })
        .then(data => {
            if (data.length === 0) {
                document.getElementById("results").textContent = "No top-rated movies found.";
                return;
            }

            // Construct the HTML to display the movies
            const resultsHTML = data.map(movie => `
                <div>
                    <h3>${movie.name} (${movie.date})</h3>
                    <p><img src="${movie.link}" alt="Movie Poster" style="max-width:200px;"/></p>
                    <p><strong>Tagline:</strong> ${movie.tagline}</p>
                    <p><strong>Description:</strong> ${movie.description}</p>
                    <p><strong>Duration:</strong> ${movie.minute} minutes</p>
                    <p><strong>Rating:</strong> ${movie.rating}</p>
                </div>
            `).join("");

            // Update the results section with the generated HTML
            document.getElementById("results").innerHTML = resultsHTML;
        })
        .catch(error => {
            console.error("Error:", error);
            document.getElementById("results").textContent = "Failed to fetch top-rated movies.";
        });
}

/**
 * Searches for a movie by name and retrieves its associated actors.
 *
 * @param {string} name - The name of the movie to search for.
 */
function searchMovieWithActors(name) {
    fetch('/movies/findByNameMovieAndActors?name=' + encodeURIComponent(name))
        .then(response => {
            if (!response.ok) {
                throw new Error("Movie not found or error retrieving it");
            }
            return response.json();
        })
        .then(data => {
            if (data.length === 0) {
                document.getElementById("results").textContent = "No movie found.";
                return;
            }

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
                    movies[movieId].actors.push({
                        name: row[7],
                        role: row[8],
                    });
                }
            });

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
            document.getElementById("results").textContent = "Error while retrieving the data.";
        });
}


/**
 * Searches for a movie by name and retrieves its associated posters.
 *
 * @param {string} name - The name of the movie to search for.
 */
function searchMovieWithPosters(name) {
    fetch('/movies/findPostersofMovies?name=' + encodeURIComponent(name))
        .then(response => {
            if (!response.ok) {
                throw new Error("Movie not found or error retrieving it");
            }
            return response.json();
        })
        .then(data => {
            if (data.length === 0) {
                document.getElementById("results").textContent = "No movies found.";
                return;
            }

            const movies = {};
            data.forEach(row => {
                const movieId = row[0];
                if (!movies[movieId]) {
                    movies[movieId] = {
                        id: movieId,
                        name: row[1],
                        date: row[2],
                        description: row[3],
                        duration: row[4],
                        rating: row[5],
                        tagline: row[6],
                        posterLink: row[8],
                    };
                }
            });

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
            document.getElementById("results").textContent = "Error while searching the movie.";
        });
}

/**
 * Searches for a movie by name and retrieves its associated studios.
 *
 * @param {string} name - The name of the movie to search for.
 */
function searchMovieWithStudios(name) {
    fetch('/movies/findStudiosofMovies?name=' + encodeURIComponent(name))
        .then(response => {
            if (!response.ok) {
                throw new Error("Studio not found or error while retrieving it.");
            }
            return response.json();
        })
        .then(data => {
            if (data.length === 0) {
                document.getElementById("results").textContent = "No movies found.";
                return;
            }

            const movies = {};
            data.forEach(row => {
                const movieId = row[0];
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
                    movies[movieId].studios.push({
                        studio: row[8]
                    });
                }
            });

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
            document.getElementById("results").textContent = "Error while searching for the studio";
        });
}

/**
 * Searches for movies with their associated countries by name.
 *
 * @param {string} name - The name of the movie to search for.
 */
function searchMovieWithCountries(name) {
    fetch('/movies/findCountriesofMovies?name=' + encodeURIComponent(name))
        .then(response => {
            if (!response.ok) {
                throw new Error("Country not found or error during retrieval.");
            }
            return response.json();
        })
        .then(data => {
            if (data.length === 0) {
                document.getElementById("results").textContent = "No countries found.";
                return;
            }

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
                    movies[movieId].countries.push({
                        country: row[8]
                    });
                }
            });

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
            document.getElementById("results").textContent = "Error during country search.";
        });
}

/**
 * Searches for movies with their associated crew members by name.
 *
 * @param {string} name - The name of the movie to search for.
 */
function searchMovieWithCrew(name) {
    fetch('/movies/findCrewofMovies?name=' + encodeURIComponent(name))
        .then(response => {
            if (!response.ok) {
                throw new Error("Crew not found or error during retrieval.");
            }
            return response.json();
        })
        .then(data => {
            if (data.length === 0) {
                document.getElementById("results").textContent = "No crew members found.";
                return;
            }

            const movies = {};
            data.forEach(row => {
                const movieId = row[0];
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
                    movies[movieId].crew.push(`${row[9]} as ${row[8]}`);
                }
            });

            const resultsHTML = Object.values(movies)
                .map(movie => {
                    const crewList = movie.crew.join(', <span style="margin-left: 2em;"></span>');
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
            document.getElementById("results").textContent = "Error during crew search.";
        });
}

/**
 * Searches for movies with their associated genres by name.
 *
 * @param {string} name - The name of the movie to search for.
 */
function searchMovieWithGenre(name) {
    fetch('/movies/findGenreofMovies?name=' + encodeURIComponent(name))
        .then(response => {
            if (!response.ok) {
                throw new Error("Genre not found or error during retrieval.");
            }
            return response.json();
        })
        .then(data => {
            if (data.length === 0) {
                document.getElementById("results").textContent = "No genres found.";
                return;
            }

            const movies = {};
            data.forEach(row => {
                const movieId = row[0];
                if (!movies[movieId]) {
                    movies[movieId] = {
                        id: movieId,
                        name: row[1],
                        date: row[2],
                        description: row[3],
                        duration: row[4],
                        rating: row[5],
                        tagline: row[6],
                        genres: [],
                    };
                }
                if (row[8]) {
                    movies[movieId].genres.push({
                        genre: row[8]
                    });
                }
            });

            const resultsHTML = Object.values(movies)
                .map(movie => {
                    const genreList = movie.genres
                        .map(genre => `<li>${genre.genre}</li>`)
                        .join("");
                    return `
                        <div>
                            <h3>${movie.name} (${movie.date})</h3>
                            <p>Tagline: ${movie.tagline}</p>
                            <p>Description: ${movie.description}</p>
                            <p>Duration: ${movie.duration} minutes</p>
                            <p>Rating: ${movie.rating}</p>
                            <h4>Genres:</h4>
                            <ul>
                                ${genreList || "<li>No genres found.</li>"}
                            </ul>
                        </div>
                    `;
                })
                .join("");

            document.getElementById("results").innerHTML = resultsHTML;
        })
        .catch(error => {
            console.error("Erreur :", error);
            document.getElementById("results").textContent = "Error during genre search.";
        });
}

/**
 * Fetches and displays movies along with their associated languages by the provided movie name.
 *
 * @param {string} name - The name of the movie to search for.
 */
function searchMovieWithLanguage(name) {
    fetch('/movies/findLanguageofMovies?name=' + encodeURIComponent(name))
        .then(response => {
            if (!response.ok) {
                throw new Error("Language not found or error during retrieval.");
            }
            return response.json();
        })
        .then(data => {
            if (data.length === 0) {
                document.getElementById("results").textContent = "No languages found.";
                return;
            }

            const movies = {};
            data.forEach(row => {
                const movieId = row[0];
                if (!movies[movieId]) {
                    movies[movieId] = {
                        id: movieId,
                        name: row[1],
                        date: row[2],
                        description: row[3],
                        duration: row[4],
                        rating: row[5],
                        tagline: row[6],
                        languages: [],
                    };
                }
                if (row[8] && row[9]) {
                    movies[movieId].languages.push({
                        type: row[8],
                        language: row[9],
                    });
                }
            });

            const resultsHTML = Object.values(movies)
                .map(movie => {
                    const languageList = movie.languages
                        .map(language => `<li>${language.type} is ${language.language}</li>`)
                        .join("");
                    return `
                        <div>
                            <h3>${movie.name} (${movie.date})</h3>
                            <p>Tagline: ${movie.tagline}</p>
                            <p>Description: ${movie.description}</p>
                            <p>Duration: ${movie.duration} minutes</p>
                            <p>Rating: ${movie.rating}</p>
                            <h4>Languages:</h4>
                            <ul>
                                ${languageList || "<li>No languages found.</li>"}
                            </ul>
                        </div>
                    `;
                })
                .join("");

            document.getElementById("results").innerHTML = resultsHTML;
        })
        .catch(error => {
            console.error("Erreur :", error);
            document.getElementById("results").textContent = "Error during language search.";
        });
}

/**
 * Fetches and displays movies along with their associated themes by the provided movie name.
 *
 * @param {string} name - The name of the movie to search for.
 */
function searchMovieWithTheme(name) {
    fetch('/movies/findThemeofMovies?name=' + encodeURIComponent(name))
        .then(response => {
            if (!response.ok) {
                throw new Error("Theme not found or error during retrieval.");
            }
            return response.json();
        })
        .then(data => {
            if (data.length === 0) {
                document.getElementById("results").textContent = "No themes found.";
                return;
            }

            const movies = {};
            data.forEach(row => {
                const movieId = row[0];
                if (!movies[movieId]) {
                    movies[movieId] = {
                        id: movieId,
                        name: row[1],
                        date: row[2],
                        description: row[3],
                        duration: row[4],
                        rating: row[5],
                        tagline: row[6],
                        themes: [],
                    };
                }
                if (row[8]) {
                    movies[movieId].themes.push(`${row[8]}`);
                }
            });

            const resultsHTML = Object.values(movies)
                .map(movie => {
                    const themeList = movie.themes.join(', <span style="margin-left: 2em;"></span>');
                    return `
                        <div>
                            <h3>${movie.name} (${movie.date})</h3>
                            <p>Tagline: ${movie.tagline}</p>
                            <p>Description: ${movie.description}</p>
                            <p>Duration: ${movie.duration} minutes</p>
                            <p>Rating: ${movie.rating}</p>
                            <h4>The movie's themes are :</h4>
                                ${themeList || "<p>No themes found.</p>"}
                        </div>
                    `;
                })
                .join("");

            document.getElementById("results").innerHTML = resultsHTML;
        })
        .catch(error => {
            console.error("Erreur :", error);
            document.getElementById("results").textContent = "Error during theme search.";
        });
}

/**
 * Fetches and displays movies by the provided genre.
 *
 * @param {string} genre - The genre to search for movies.
 */
function searchMoviesByGenre(genre) {
    fetch('/movies/findByGenre?genre=' + encodeURIComponent(genre))
        .then(response => {
            if (!response.ok) {
                throw new Error("No movies found for this genre.");
            }
            return response.json();
        })
        .then(data => {
            if (data.length === 0) {
                document.getElementById("results").textContent = "No movies found.";
                return;
            }

            const resultsHTML = data.map(movie => `
                <div>
                    <h3>Nom du Film: ${movie.name}</h3>
                    <p><strong>Date:</strong> ${movie.date}</p>
                    <p><strong>Tagline:</strong> ${movie.tagline}</p>
                    <p><strong>Description:</strong> ${movie.description}</p>
                    <p><strong>Durée (minutes):</strong> ${movie.minute}</p>
                    <p><strong>Note:</strong> ${movie.rating}</p>
                    <p><strong>Genres:</strong> ${movie.genres}</p>
                    <img src="${movie.link}" alt="Poster Film" style="max-width: 200px;">
                </div>
            `).join("");

            document.getElementById("results").innerHTML = resultsHTML;
        })
        .catch(error => {
            console.error("Erreur :", error);
            document.getElementById("results").textContent = "Error during movie retrieval.";
        });
}

/**
 * Fetches and displays movies by the provided release date.
 *
 * @param {string} date - The release date in the format YYYY to search for movies.
 */
function searchMoviesByDate(date) {
    if (!/^\d{4}$/.test(date)) {
        document.getElementById("results").textContent = "Invalid date format. Expected format: YYYY.";
        return;
    }

    fetch('/movies/findByDate?date=' + encodeURIComponent(date))
        .then(response => {
            if (!response.ok) {
                throw new Error("No movies found for this date.");
            }
            return response.json();
        })
        .then(data => {
            if (data.length === 0) {
                document.getElementById("results").textContent = "No movies found.";
                return;
            }

            const resultsHTML = data.map(movie => `
                <div>
                    <h3>Nom du Film: ${movie.name}</h3>
                    <p><strong>Date:</strong> ${movie.date}</p>
                    <p><strong>Tagline:</strong> ${movie.tagline}</p>
                    <p><strong>Description:</strong> ${movie.description}</p>
                    <p><strong>Durée (minutes):</strong> ${movie.minute}</p>
                    <p><strong>Note:</strong> ${movie.rating}</p>
                    <p><strong>Genres:</strong> ${movie.genres}</p>
                    <img src="${movie.link}" alt="Poster Film" style="max-width: 200px;">
                </div>
            `).join("");

            document.getElementById("results").innerHTML = resultsHTML;
        })
        .catch(error => {
            console.error("Erreur :", error);
            document.getElementById("results").textContent = "Error retrieving movies.";
        });
}

/**
 * Fetches and displays movies filtered by both genre and release date.
 *
 * @param {string} genre - The genre to search for movies.
 * @param {string} date - The release date in the format YYYY to search for movies.
 */
function searchMoviesByGenreAndDate() {
    const genre = 'Comedy';
    const date = '2023';

    fetch(`/movies/findByGenreAndDate?genre=${encodeURIComponent(genre)}&date=${encodeURIComponent(date)}`)
        .then(response => {
            if (!response.ok) {
                throw new Error("No movies found for the given criteria.");
            }
            return response.json();
        })
        .then(data => {
            if (data.length === 0) {
                document.getElementById("results").textContent = "No movies found.";
                return;
            }

            const resultsHTML = data.map(movie => `
                <div>
                    <h1>Film recherché par genre : ${genre} et date : ${date} </h1>
                    <h3>Nom du Film: ${movie.name}</h3>
                    <p><strong>Date:</strong> ${movie.date}</p>
                    <p><strong>Tagline:</strong> ${movie.tagline}</p>
                    <p><strong>Description:</strong> ${movie.description}</p>
                    <p><strong>Durée (minutes):</strong> ${movie.minute}</p>
                    <p><strong>Note:</strong> ${movie.rating}</p>
                    <p><strong>Genres:</strong> ${movie.genres}</p>
                    <img src="${movie.link}" alt="Poster Film" style="max-width: 200px;">
                </div>
            `).join("");

            document.getElementById("results").innerHTML = resultsHTML;
        })
        .catch(error => {
            console.error("Erreur :", error);
            document.getElementById("results").textContent = "Error retrieving movies.";
        });
}

/**
 * Initializes the language and type selection for filtering movies.
 * Automatically populates the dropdowns with available languages and types from the API.
 */
document.addEventListener("DOMContentLoaded", () => {
    const typeSelect = document.getElementById("type-select");
    const selectedTypeDisplay = document.getElementById("selected-type");
    const languageSelect = document.getElementById("language-select");
    const selectedLanguageDisplay = document.getElementById("selected-language");
    const form = document.getElementById("language-form");

    async function fetchLanguages() {
        try {
            const response = await fetch("/languages/distinctLanguages");
            if (!response.ok) {
                throw new Error("Error retrieving languages.");
            }
            const languages = await response.json();
            populateLanguageSelect(languages);
        } catch (error) {
            console.error("Error :", error);
            languageSelect.innerHTML = '<option value="">Loading error</option>';
        }

        try {
            const response = await fetch("/languages/distinctTypes");
            if (!response.ok) {
                throw new Error("Error retrieving types.");
            }
            const types = await response.json();
            populateTypeSelect(types);
        } catch (error) {
            console.error("Error :", error);
            typeSelect.innerHTML = '<option value="">Loading error</option>';
        }
    }

    function populateLanguageSelect(languages) {
        languages.forEach(language => {
            const option = document.createElement("option");
            option.value = language;
            option.textContent = language;
            languageSelect.appendChild(option);
        });
    }

    function populateTypeSelect(types) {
        types.forEach(type => {
            const option = document.createElement("option");
            option.value = type;
            option.textContent = type;
            typeSelect.appendChild(option);
        });
    }

    form.addEventListener("submit", (event) => {
        event.preventDefault();
        const selectedLanguage = languageSelect.value;
        const selectedType = typeSelect.value;
        selectedLanguageDisplay.textContent = selectedLanguage
            ? `Selected language : ${selectedLanguage}`
            : "Selected language : none";

        selectedTypeDisplay.textContent = selectedType
            ? `Selected type : ${selectedType}`
            : "Selected type : none";

        searchMovies(selectedLanguage, selectedType);
    });

    fetchLanguages();
});

/**
 * Fetches and displays movies filtered by selected language and type.
 *
 * @param {string} selectedLanguage - The language filter for movies.
 * @param {string} selectedType - The type filter for movies.
 */
function searchMovies(selectedLanguage, selectedType) {
    fetch(`/movies/findMoviesByLanguageAndType?selectedLanguage=${encodeURIComponent(selectedLanguage)}&selectedType=${encodeURIComponent(selectedType)}`)
        .then(response => {
            if (!response.ok) {
                throw new Error("No movies found or error retrieving data.");
            }
            return response.json();
        })
        .then(data => {
            if (data.length === 0) {
                document.getElementById("results").textContent = "No movies found.";
                return;
            }

            const movies = {};
            data.forEach(row => {
                const movieId = row[0];
                if (!movies[movieId]) {
                    movies[movieId] = {
                        id: movieId,
                        name: row[1],
                        date: row[2],
                        description: row[3],
                        duration: row[4],
                        rating: row[5],
                        tagline: row[6],
                        posterLink: row[10],
                        languages: [],
                    };
                }
                if (row[8] && row[9]) {
                    movies[movieId].languages.push({
                        type: row[8],
                        language: row[9],
                    });
                }
            });

            const resultsHTML = Object.values(movies)
                .map(movie => {
                    const languageList = movie.languages
                        .map(language => `<li>${language.type} : ${language.language}</li>`)
                        .join("");
                    return `
                        <div>
                            <h3>${movie.name} (${movie.date})</h3>
                            <p><img src="${movie.posterLink}" alt="Poster Film" style="max-width:200px;"/></p>
                            <p>Tagline: ${movie.tagline}</p>
                            <p>Description: ${movie.description}</p>
                            <p>Duration: ${movie.duration} minutes</p>
                            <p>Rating: ${movie.rating}</p>
                            <h4>Languages:</h4>
                            <ul>
                                ${languageList || "<li>No language found.</li>"}
                            </ul>
                        </div>
                    `;
                })
                .join("");

            document.getElementById("results").innerHTML = resultsHTML;
        })
        .catch(error => {
            console.error("Erreur :", error);
            document.getElementById("results").textContent = "Error while searching for movies.";
        });
}

