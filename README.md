# Android Last FM App
This application uses Last FM Api to demonstrate android best practices.

Clean-architecture concept is used along with MVVM and the application is mainly divided into 3 modules ->
- **lastfm-app** module -> Responsible to render UI.
- **lastfm-domain** module -> Contains the Models and Use-case classes.
- **lastfm-data** module -> Responsible to render data. Contains remote DTOs & services, DB Entities & DAOs.

Data Layer uses **Jetpack Room**, **Paging3** and **Retrofit** to fetch data from database and from remote api.
**RemoteMediator** is used to fetch paginated data from layered DataSource (DB + Remote).
Application uses three different set of classes - DTOs, Entities & Models for remote, Database and UI communication respectively, to ensure a change in one will not break the other layer.
UI layer is written with **Compose** using the latest Compose practices -> **Hilt-Compose, Navigation-Compose, Accompanist**.

This application is **developed and tested on Android Studio Arctic Fox | 2020.3.1**.

## Libraries Used
- **Spotless with KtLint** - Used for code formatting and copyright injection via command-line. Run `./gradlew spotlessApply` to format code.
- **Hilt & Compose Hilt** - Used for dependency injection.
- **Compose** - For creating UI.
- **Compose Navigation** - For navigation between consumables.
- **ViewModel** - For UI logic.
- **Paging-3** - For pagination support.
- **Coroutines & Flow** - For all async operations and fetching stream of data.
- **Room** - For temporary storage of albums needed for pagination.
- **Retrofit & OKHttp** - For networking.
- **Mockk & Truth** -For mocking and assertion.

## Getting LAST FM API Key
To obtain a LAST FM API key, refer - https://www.last.fm/api/account/create.
Once you have the key, add it inside your gradle.properties -> `LASTFM_API_KEY=<your-api-key>`
