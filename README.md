# Android Last FM App
This application uses Last FM Api to demonstrate android best practices.

## Getting LAST FM API Key
To obtain a LAST FM API key, refer - https://www.last.fm/api/account/create.
Once you have the key, add it inside your gradle.properties -> `LASTFM_API_KEY=<your-api-key>`

## Libraries Used
This application is **developed and tested on Android Studio Arctic Fox | 2020.3.1** and may not work on earlier versions of Android Studio.

* **Spotless with KtLint** - For code formatting which could be extended to create a pre-commit hook so everyone in the team follow the same formatting.
  Run `./gradlew spotlessApply` to format code. 
* **Hilt & Compose Hilt** - For dependency injection.
* **Compose** - For creating UI.
* **Compose Navigation** - For navigation between consumables.
* **ViewModel** - For UI logic.
* **Paging-3** - For pagination support.
* **Coroutines & Flow** - For all async operations and fetching stream of data.
* **Retrofit & OKHttp** - For networking.
* **Mockk & Truth** -For mocking and assertion. 
