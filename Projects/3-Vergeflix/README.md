# Vergeflix

Vergeflix is a project developed for the Advanced Object Oriented Programming course. The purpose of the project is to teach advanced OPP concepts such as polymorphism, inheritance, interfaces, enumerations, comparators, and comparables. It is a catalog management system where users can create movies and TV series, modify their details, add seasons and episodes to the series, and vote for their favorite content.

## Functionality

-   Create, read, update and delete movies and TV series
-   Add seasons and episodes to the TV series
-   List the best movies and TV series based on votes
-   List the best movies by actor or director
-   Vote for movies and TV series

## Project Structure

The Vergeflix repository contains a PDF file that explains how to create the necessary classes with their respective attributes and methods to build the project. The project is divided into the following classes:

-   `Main`: The entry point of the application that controls the flow of the program.
- `Media`: An abstract class which implements comparable, assessable. From her they inherit film and series
-   `Movie`: A class representing a movie with its attributes such as title, director, actors, and rating, etc.
-   `Serie`: A class representing a TV series with its attributes such as  seasons and release date.
-   `Season`: A class representing a season of a TV series with its attributes such as title and episodes.
-   `Episode`: A class representing an episode of a TV series with its attributes such as title and rating.
-   `VergeflixComparator`: A comparator class used to compare movies and TV series based on their rating.
-   `Theme`: An enumeration class representing the possible movie categories

## Conclusion

Vergeflix is a comprehensive project that teaches advanced OPP concepts and provides an opportunity to practice them. With its functionalities such as creating and managing movies and TV series, adding seasons and episodes, and voting for favorite content, it provides an excellent learning opportunity for aspiring programmers.
