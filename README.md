# android-sniped

## Introduction
SNIPED (Screens Navigators Interactors Presenters Entities with Dependency injection, etc...) is an approach to android application architecture 
inspired from the VIPER (View Interactor Presenter Entity Router) architecture on iOS yet mainly evolved from the popular MVP (Model View Presenter) 
approach.

It describes well defined sets of building blocks that are common to complex, maintainable and testable applications and strives to streamline the 
process by enabling clean coding where entire features can be quickly added by simply replicating these parts and implementing them with the 
necessary logic.

The objective of the project is to empower engineers less experienced in android development by providing them with a framework built around best 
practices proven to work for building readable and highly maintainable applications.  
Similar to what the Angular framework brought into the web development space with its set of standards for creating application building blocks, we 
hope to improve the coding quality by introducing a common understanding for structuring an application and defining its components to maximize the 
maintainability and testability of the software project.

SNIPED is not intended to define every type of component that could be useful when building complex applications, rather it emphasizes the 
idea of building software with testable pieces that are easily identifiable, serve a specific and obvious purpose, and fit together with each 
other in a logical manner.
It does this by defining 6 examples of blocks that could be common in every application:

- **Screens**: aka the Views, contain UI logic and are the part usually responsible for calling Android SDK code. 
They display what the Presenter decides, delegate user actions back to the Presenter and inform it about their state.  
Views should be plain, simple and contain no business logic.

- **Navigators**: Small, single purpose classes defining the navigation between views together with the set of data that can be passed in between.  
While still using the Android SDK, these classes have the purpose of extracting the navigation logic from the view and enabling 
presenters to handle it.

- **Interactors**: A class for every particular use case, these are usually responsible for fetching or modifying data and abstracting away 
the data sources, usually called by Presenters in need of filling the view with data or delegating user actions that should have a persisting 
effect.  
Interactors can be grouped and used by a high level interactor, for example when performing the login, which could involve backend communication, 
caching and further data processing.  
Contain only business logic and have no knowledge of the view, neither the view about them.

- **Presenters**: The main bridge between the user (interface and interaction) and the application logic.  
Presenters ask interactors for content and process it before passing it to the view. On the other hand, when user interaction is involved, 
presenters will be in charge of acting upon the events and delegating business logic, usually to the interactors.  
Contain business and view logic, connecting the two worlds, yet without any references to the Android framework.
Presenters should never have a reference to the context!

- **Entities**: Models which are managed by interactors usually through repositories.  
Primarily contain data or simple getters and setters.

- **Dependency injection**: Everything is tied up together with a smart and well defined dependency injection approach which enables rich testability.

## Getting Started
TODO: Guide users through getting your code up and running on their own system. In this section you can talk about:
1.  Installation process
1.  Customizing
1.  Software dependencies
1.  API references
1.  Project Structure
1.  Architecture
1.  Coding Style

## Build and Test
TODO: Describe and show how to build your code and run the tests. 

## To Do
- [x] Add short intro and explain the meaning behind the S.N.I.P.E.D. name.
- [ ] Completely integrate Flipper
- [ ] Fill in base documentation
- [ ] Document project structure and idea
- [ ] Document adding a new feature
- [ ] Add examples (As git branches ?)
- [ ] Migrate to AndroidX
- [ ] Replace Gson with Moshi
- [ ] Use Android Architecture components
- [ ] Add example with KOIN instead of Dagger2
- [ ] Add CLI/Templates (?)
- [ ] Add medium post & media resources (youtube video?)
- [ ] Add example with Kotlin Coroutines instead of RxJava2 for Retrofit2

## Changelog
TODO: Add link to changelog file

## Contribute
TODO: Add link to CONTRIBUTING.md
