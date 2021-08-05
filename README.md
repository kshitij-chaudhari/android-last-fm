# Android Last FM App
This application uses Last FM Api to demonstrate android best practices.

**Note:** This application is developed and tested on Android Studio Arctic Fox | 2020.3.1

## Getting LAST FM API Key
To obtain a LAST FM API key, refer - https://www.last.fm/api/account/create
Once you have the key, add it inside your local or global gradle.properties -> `LAST_FM_API_KEY=<your-api-key>`

## Libraries Used
This application is **developed and tested on Android Studio Arctic Fox | 2020.3.1** and may not work on earlier versions of Android Studio.

* **Spotless with KtLint** - For code formatting which could be extended to create a pre-commit hook so everyone in the team follow the same formatting.
  Run `./gradlew spotlessApply` to format code. 
* **Compose** - For creating UI.

