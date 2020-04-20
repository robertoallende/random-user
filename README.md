# Random User Client for Android
[![codecov.io](https://codecov.io/gh/robertoallende/random-user/commit/21ba8bf472896b06b6c7b9fc280b50c82384dd2a/graphs/badge.svg?branch=develop)](
https://codecov.io/gh/robertoallende/random-user/commit/21ba8bf472896b06b6c7b9fc280b50c82384dd2a?branch=develop)

An Android Client that fetches and displays data from randomuser.me.

## Demo Video

![](https://media.giphy.com/media/ibjX8LHiS9Qr48xEXk/giphy.gif)

## Features Implemented

- User list screen

- User detail screen

- Pagination

- Offline support with Room

- API Fetch

- Empty cases and Error Exceptions

- Add IdlingResources for testing

- Unit Tests setup and initial 10% code coverage

- Enable code test coverage with JaCoCo, CodeCov

- MockWebServer setup for integrated tests

- CircleCi Integration

## Further Improvements

- User Search: the query has been implemented but not exposed to the UI

- Add Swipe to Refresh or make UserListViewModel aware of connection status to automatically update user lists, in particular for the empty result case.

- Improve network errors to make them more user friendly.

- Improve code coverage with Unit Tests

- Add Instrumented Tests with Espresso.

## Architecture

The App has been implemented using Kotlin, Dependency injection with Koin and following MVVM
and has offline support by using Room and JetPaq's Pagination library.

![](https://developer.android.com/topic/libraries/architecture/images/final-architecture.png)

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


