# android-sniped

## Introduction

SNIPED (Screens Navigators Interactors Presenters Entities with Dependency injection, etc...) is a **clean architecture** approach to Android application development.

It is an evolution of the popular MVP (Model View Presenter) pattern  with influences from the VIPER (View Interactor Presenter Entity Router) architecture on iOS.

### Why
The objective of the project is to empower Android software engineers by providing them with a framework built around best practices proven to work for building readable and highly maintainable applications.

Similar to what the Angular framework brought into the web development worlds with its set of standards for application building blocks, SNIPED plans to improve the coding quality in the Android space by introducing a common understanding for structuring an application and modeling its components.

The end goal is to maximize the maintainability and testability, therefore the quality of the software product.

### How
It emphasizes the idea of building software with testable pieces that are easily identifiable, serve a specific and obvious purpose, and fit together with each other in a logical manner.

SNPIED describes well defined sets of building blocks that are common to complex, maintainable and testable applications and promotes clean coding where entire features can be quickly added by simply replicating these parts and implementing them with the necessary logic.

It does this by defining 6 main building blocks common to every application:

- **Screens** (Views)
Contain UI logic and are the part usually responsible for calling Android SDK code.
They display what the Presenter decides, delegate user actions back to the Presenter and inform it about their state.
→ Views should be plain, simple and contain no business logic.

- **Navigators**
Small, single purpose components defining the navigation between Screens together with the data passed in between.
→ While still using the Android SDK, these classes have the purpose of extracting the navigation logic from the view and enabling Presenters to handle it.

- **Interactors**
A class for every particular use case, these are responsible for fetching or modifying data and abstracting away the data sources.
Presenters request data from Interactors and delegate operations on data as a result of user actions.
Multiple Interactors can be operated by higher level Interactors, E.g.: when performing authentication, which could involve multiple back-end calls, data caching and additional processing.
→ Contain only business logic and have no knowledge of the View, or the View about them.

- **Presenters**:
The main bridge between the user (interface and interaction) and the application logic.
Presenters ask interactors for content and process it before passing it to the view.
On the other hand, when user interaction is involved, presenters will be in charge of acting upon the events and delegating the business logic, usually to the Interactors.
→ Contain business and view logic, connecting the two worlds, yet without any references to the Android framework.

- **Entities**
Models which are managed by Interactors usually through repositories.
→ Primarily contain data or simple getters and setters.

- **Dependency injection**
Everything is tied up together with a smart and well defined dependency injection approach which enables rich testability.

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
- [x] Add short intro and explain the meaning behind the S.N.I.P.E.D. name
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
