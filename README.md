<h1 align="center">🧙‍♀️ BluePillow </h1>

<p align="center">
  <a href="https://android-arsenal.com/api?level=24"><img alt="API" src="https://img.shields.io/badge/API-24%2B-brightgreen.svg?style=flat"/></a>
    <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://github.com/skydoves/Pokedex/actions"><img alt="Build Status" src = "https://github.com/yvek/BluePillow/workflows/Android%20CI/badge.svg"/></a> 

  </p>
Blue Pillow is an Android app that demonstrates use of Activities, Viewmodel, Data binding, LiveData, Flow, Coroutines & Room. It is built over MVVM architecture. 
  </br>
  </br>
  
  ## What does it do?
    - Takes a world name.
    - Stores it in local database.
    - Display list of worlds stored on Device.
    - The list refreshes on adding new worlds.
    - Loads a cute image from the internet.
  </br>
  
<img src="/Docs/gifs/BluePillow.gif" width="250" />


## Concepts implemented
* `MVVM` architecture pattern
* `Data Binding` with custom attributes such as ```xml app:imageUrl```
* `Room` library
* `HILT` *Dependency Injection* for loading objects such as Retrofit client, Database, Repositories, Viewmodels etc
* `Retrofit` client that maps response to methods using `LiveData/Flow`


 
## Explaination
The project started with simple Hello world. You can type the world name. You will see a list of worlds that are in DB.

The list is displayed using *RecyclerView* that is built with *LiveData*. Hence the list is always containing the latest data.


## UI Layer
* Activity 
  - *ImageView* that loads an image from the internet using custom attribute 
  ```
  app:imageUrl = "url"
  app:placeholder = "@{@drawable/...}
  app:error = "@{@drawable/..." 
  ``` 
  - *EditText* & a *Button* to save new world name in database 
  - *RecyclerView* displays list of worlds.
  
* ViewModel
  - Exposes *Immutable* data to Activity layout.
  - Performs api calls while providing callbacks for each stage of an api call, that is: `onStart`, `onCompleted` and `onFinish`.

## Data Layer
* Database Room with LiveData.
* Data models for Room and network request/response.
* Repositories to handle api/Room data and passes data back to viewmodels using `kotlin flows`.

## Network Layer
* Using Retrofit for network calls.
* Using [Sandwich by Skydoves](https://github.com/skydoves/sandwich) to further enhance api calls with much better error handling.
* ErrorResponseMapper to centeralise error handling.

## Dependency Injection using HILT

## Architecture Component
* DataBinding 
  - Viewmodel data in layout
  - Custom attributes with `@BindingAdapter`

## Whats currently cooking
* BaseActivity, BaseViewmodel & BaseRepository.
* Utilities - CommonTheme, Image load, Dialogs.
* Test module.
