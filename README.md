# BluePillow
This repo presents the implementation of MVVM with clean architecture.

The project is simple, it adds a world name and updates the list below within the same screen.

Functionalities:
* add worlds 
* print its name.

App Module consists of a:
* Activity
* ViewModel

Data Module, provides world repository to the app module:
* Database calls
* Network calls

Database Module: Provides local database

Network Module: Provides network calls and their responses.

Skipped Domain layer, but if required will add it in future.

Architecture Component
* DataBinding 
  - Viewmodel data in layout
  - Custom attributes with @BindingAdapter

Whats currently cooking
* Utilities - upload image
* Network Module - fetch images from server
* Test module
