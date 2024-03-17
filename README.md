# BluePillow
This repo presents the implementation of MVVM with clean architecture.  

The project adds worlds name and shows them below in the same screen.

Functionalities:
* add worlds 
* print their details.



App Module
UI Layer
* Activity
* ViewModel

Data Module: Provides repository to app module.
* Database calls
* Network calls

Database Module: Provides local database

Network Module: Provides network support

Skipped Domain layer, but might add it in future

Architecture Component
* DataBinding 
  - Viewmodel data in layout
  - Custom attributes with @BindingAdapter

Whats currently cooking
* Dependency Injection using HILT
* Utilities - upload image
* Network Module - fetch images from server
* Test module
