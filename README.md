<h1>
  Semester 4 | Final Sprint
</h1>

[description goes here]
____________________________________________________________________________________________________________________


### **Entity Information**

| Entity Name  | Fields                                                  | Sample JSON                                                                    |
| :----------: |:--------------------------------------------------------| :----------------------------------------------------------------------------- | 
|    movie     | title(*String*) <br/> genre(*String*) <br/> year(*int*) |{<br/>&emsp;"id":1,<br/>&emsp;"title":"Search for the Beast",<br/>&emsp;"genre":"Horror",<br/>&emsp;"year":2008<br/>}                                            |

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

|         Method          | URI                                     | Query Parameter    |
|:-----------------------:|:----------------------------------------|:-------------------|
|      **GET** (All)      | localhost:8080/movie                    |                    |
|     **GET** (By ID)     | localhost:8080/movie/{id}               |                    |
| **GET** (Find by Title) | localhost:8080/movie/search/findByTitle | ?title=\<*String*> |
| **GET** (Find by Genre) | localhost:8080/movie/search/findByGenre | ?genre=\<*String*> |
| **GET** (Find by Year)  | localhost:8080/movie/search/findByYear  | ?year=\<*int*>     |
|        **POST**         | localhost:8080/movie                    |                    |
|         **PUT**         | localhost:8080/movie/{id}               |                    |
|        **PATCH**        | localhost:8080/movie/{id}               |                    |
|       **DELETE**        | localhost:8080/movie/{id}               |                    |

