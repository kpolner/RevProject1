# Cookbook Web API

# Project Description
WEB API designed to keep track of recipes and chef information to help you cook in your spare time

# Technologies Used

* Servlets
* Spring Framework
* Spring Boot
* Spring ORM
* Spring AOP
* Spring Data
* Hibernate
* Azure SQL Databases
* Java programming language

# Features
List of features ready and TO-DOs for future development
* Posting new recipe and chef information
* Queries made through JPQL, HQL, and native SQL
* Updates to entries made erroniously 
* Deletion of entries no longer wanted

To-do list:
* Change patch mappings into a putmapping so you can update all of the entry at once

# Getting Started

1. Clone the repository using "git clone https://github.com/kpolner/RevProject1"
2. Run the program on a java runtime environment such as IntelliJ or a virtual machine with a JRE installed
3. Make sure you are entering through port 9000
4. Visit postman.com for help with mappings or conduct the mappings yourself within the JRE
5. Conduct the proper mapping for whichever CRUD operation you want 

# Usage

* Query recipes by: get mappings
   * All recipes - {IP/localhost}:9000/recipe
   
   * Food type - {IP/localhost}:9000/recipe/foodType/{food type - asian, mexican, etc}
   
   * Cook time - {IP/localhost}:9000/recipe/cookTime/{cook time in minutes}
   
   * Chef - {IP/localhost}:9000/recipe/chef/{chef name}
   
   * Top 3 rated for a food type - {IP/localhost}:9000/recipe/top3/{food type}
   
   * Fastest cook time for a food type - {IP/localhost}:9000/recipe/fastest/{food type}
   
   * Id - {IP/localhost}:9000/recipe/id/{id, shown when getting recipes}

* Query chefs by: get mappings
   * All chefs - {IP/localhost}:9000/chef
   
   * Name - {IP/localhost}:9000/chef/chefName/{chef's name}
   
   * Specialty - {IP/localhost}:9000/chef/specialty/{specialty - southern, soul food, savory, etc}
   
   * Tag - {IP/localhost}:9000/chef/tag/{tag - LGBTQ, POC, etc}

* Update recipes by: patch mappings
   * Name - {IP/localhost}:9000/recipe/updateName/{id of the recipe you need}/{new name}
   
   * Food type - {IP/localhost}:9000/recipe/updateFoodType/{id of the recipe you need}/{new food type}
   
   * Difficulty - {IP/localhost}:9000/recipe/updateDifficulty/{id of the recipe you need}/{new difficulty}
   
   * Rating - {IP/localhost}:9000/recipe/updateRating/{id of the recipe you need}/{new rating}

* Update chefs by: patch mappings
   * Name - {IP/localhost}:9000/chef/updateName/{id of the chef you need}/{new name}
   
   * Specialty - {IP/localhost}:9000/chef/updateSpecialty/{id of the chef you need}/{new specialty}
   
   * Tag - {IP/localhost}:9000/chef/updateTag/{id of the chef you need}/{new tag}

* Delete recipes and chefs: delete mappings
   * Recipe - {IP/localhost}:9000/recipe/delete/{id of the recipe you need}
   
   * Chef - {IP/localhost}:9000/chef/delete/{id of the chef you need}
