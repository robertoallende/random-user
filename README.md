# Random User Client for Android
An Android Client that fetches data from randomuser.me

## Architecture

The App has been implemented using Kotlin, Dependency injection with Koin and following MVVM
and has offline support by using Room and JetPaq's Pagination library.

Following Android Documentation, the implemented flow is described below.

The DataSource.Factory (implemented by Room) creates the DataSource. Then, LivePagedListBuilder builds
the LiveData<PagedList>, using the passed-in DataSource.Factory, BoundaryCallback, and PagedList configuration.
This LivePagedListBuilder object is responsible for creating PagedList objects. When a PagedList is created,
two things happen at the same time:

- The LiveData emits the new PagedList to the ViewModel, which in turn passes it to the UI. The UI observes the changed PagedList and uses its PagedListAdapter to update the RecyclerView that presents the PagedList data. (The PagedList is represented in the following animation by an empty square).

- The PagedList tries to get the first chunk of data from the DataSource. When the DataSource is empty, for example when the app is started for the first time and the database is empty, it calls BoundaryCallback.onZeroItemsLoaded(). In this method, the BoundaryCallback requests more data from the network and inserts the response data in the database.

![](https://codelabs.developers.google.com/codelabs/android-paging/img/a4f392ad4ae49042.gif)

After the data is inserted in the DataSource, a new PagedList object is created (represented in the following animation by a filled-in square). This new data object is then passed to the ViewModel and UI using LiveData and displayed with the help of the PagedListAdapter.

![](https://codelabs.developers.google.com/codelabs/android-paging/img/e6a52e528d1c22db.gif)

When the user scrolls, the PagedList requests that the DataSource load more data, querying the database for the next chunk of data. When the PagedList paged all the available data from the DataSource, BoundaryCallback.onItemAtEndLoaded() is called. The BoundaryCallback requests data from the network and inserts the response data in the database. The UI then gets re-populated based on the newly-loaded data.

![](https://codelabs.developers.google.com/codelabs/android-paging/img/576f0df1cc74cb0a.gif)

## Features Implemented

- User list screen

- User detail screen

- Pagination

- Offline support with Room

- API Fetch


## Pending Tasks

- Exception handling: if the API raises an exception the app will crash because exeptions are not handled at the moment.

- User Search: the query has been implemented but not exposed to the API

- API Mocking: I would use MockWebServer to mock API responses.

- Add IdlingResources for testing

- Unit testing and UI test with Espresso.

- Enable code test coverage with JaCoCo

