# CafeNext
Naver Cafe Simple Clone

## Framework
* config - Spring Boot
* entity - JPA
* repository - Spring Data JPA
* test - spock with spring
* web view - Velocity, FreeMarker
* javascript - jQuery

## Structure
* cafe-core
 * Cafe Commone Component
 * Entity, Repository, Service
* cafe-cafeweb
 * Individual Cafe
 * WebMVC
* cafe-sectionweb
 * Cafe Section
 * WebMVC
* cafe-api
 * internal API
 * Rest API

## Run Application
* cafe-cafeweb(port:8081), cafe-sectionweb(port:8080), cafe-api(port:8083)
 * gradle bootRun -Dspring.profiles.active=local

## Feature
### Section
* cafe list by category
* cafe create (to be)
### Individual Cafe
* cafe all articles
* cafe board
* article read
* artciel write (to be)
* article update (to be)
* cafe member join (to be)
