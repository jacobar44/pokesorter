This spring application has a webclient call to pokeapi.co (RESTful API that returns the name of a Pokemon and a url that links to a page with further information on the Pokemon).
These Pokemon objects are returned in the order of the object's Pokemon id number by the https://pokeapi.co/api/v2/pokemon/?limit=1200 endpoint
When the getAll endpoint is called in the sorter application, the application will instead return the objects sorted by the Pokemon's name instead of its Pokemon id number.
