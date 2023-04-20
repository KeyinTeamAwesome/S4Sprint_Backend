<h1>
  Semester 4 | Final Sprint
</h1>

### **Entity Information**

| Entity Name  | Fields                                                  | Sample JSON                                                                    |
| :----------: |:--------------------------------------------------------| :----------------------------------------------------------------------------- | 
|    movie     | title(*String*)<br/>genre(*String*)<br/>year(*int*)<br/>review(*int*)|{<br/>&emsp;"id": 1,<br/>&emsp;"title": "Search for the Beast",<br/>&emsp;"genre": "Horror",<br/>&emsp;"year": 2008,<br/>&emsp;"review": 4<br/>}                                             

<!--  
Unformatted Data:
-----------------

Entity Name:    movie	

Fields:         title(String)
                genre(String)
                year(int) 	

Sample JSON:    {
                    "id":1,
                    "title":"Search for the Beast",
                    "genre":"Horror",
                    "year":2008
                }
-->

____________________________________________________________________________________________________________________


### **Endpoints**

| Method      | Argument                       | URI                                                | Query Parameter                                   |
|:-----------:|:------------------------------:|:---------------------------------------------------|:--------------------------------------------------|
|   **GET**   | All                            | localhost:8080/movie                               |                                                   |
|   **GET**   | By ID                          | localhost:8080/movie/{id}                          |                                                   |
|   **GET**   | Find by All (Partial Match)    | localhost:8080/movie/search/findByAllContaining    | ?searchTerm=\<*String/int*>                       |
|   **GET**   | Find by Title (Partial Match)  | localhost:8080/movie/search/findByTitleContaining  | ?title=\<*String*>                                |
|   **GET**   | Find by Genre (Partial Match)  | localhost:8080/movie/search/findByGenreContaining  | ?genre=\<*String*>                                |
|   **GET**   | Find by Year (Partial Match)   | localhost:8080/movie/search/findByYearContaining   | ?year=\<*int*>                                    |
|   **GET**   | Find by Title (Full Match)     | localhost:8080/movie/search/findByTitle            | ?title=\<*String*>                                |
|   **GET**   | Find by Genre (Full Match)     | localhost:8080/movie/search/findByGenre            | ?genre=\<*String*>                                |
|   **GET**   | Find by Year (Full Match)      | localhost:8080/movie/search/findByYear             | ?year=\<*int*>                                    |
|   **GET**   | Find by Review (Full Match)    | localhost:8080/movie/search/findByReview           | ?review=\<*int*>                                  |
|   **POST**  |                                | localhost:8080/movie                               |                                                   |
|   **PUT**   |                                | localhost:8080/movie/{id}                          |                                                   |
|  **PATCH**  |                                | localhost:8080/movie/{id}                          |                                                   |
|  **DELETE** |                                | localhost:8080/movie/{id}                          |                                                   |
 
