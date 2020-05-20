# Android MVVM Architecture app

The following is a sample android project on how to use the Model View ViewModel [(MVVM)](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel) architecture  with [Retrofit](https://square.github.io/retrofit/) which is a type-safe HTTP client for Android and Java and  [JSONPlaceholder](https://jsonplaceholder.typicode.com/) which is a fake online REST API for testing and prototyping. 

The MVVM architecture is the [recommended](https://developer.android.com/jetpack/docs/guide) architecture for developing android application. MVVM provides the following benefits:
1. Separation of concerns which enables developers to write maintainable code.
2. Survive configuration changes (such as screen rotations) which improves user experience



The network request returns a list of users which is displayed in a RecyclerView as illustrate in the demo bellow. 


##  Concepts used in this Application
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
* [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
* [view-binding](https://developer.android.com/topic/libraries/view-binding)
* [Retrofit](https://square.github.io/retrofit/)
* [JSONPlaceholder](https://jsonplaceholder.typicode.com/)
* [RecyclerView](https://developer.android.com/guide/topics/ui/layout/recyclerview)
* [CardView](https://developer.android.com/reference/androidx/cardview/widget/CardView)
* [Monitor connectivity status](https://developer.android.com/training/monitoring-device-state/connectivity-status-type#java)
* [Lombok](https://projectlombok.org/) added for getters and setter inside user model class 


##  Application Demo:

<img src="https://user-images.githubusercontent.com/60129144/72930554-d7840980-3d64-11ea-87f0-905ded61f806.jpg" width=400 alt="Demo screen">

