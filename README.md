[README.md](https://github.com/user-attachments/files/34867046/README.md)
# BoundaryLive TV — Broadcast Edition

An Android TV score-board app designed for a 16:9 television screen. It ships with an attractive demo match and can optionally retrieve live match data from CricketData.org.

## Build on GitHub from a phone

1. Create an empty GitHub repository (for example `boundarylive-tv`).
2. Extract this ZIP and upload the **contents** of the `BoundaryLiveAndroidTV_Broadcast` folder to the repository root. Keep the hidden `.github` folder.
3. Open the repository **Actions** tab, choose **Build BoundaryLive Android TV APK**, and run the workflow.
4. When it completes, download the **BoundaryLive-TV-Broadcast-APK** artifact. The installable file is `app-debug.apk`.

The workflow uses a clean GitHub-hosted Ubuntu runner, JDK 17 and Android SDK API 35. It does not require Android Studio, a computer, signing key, or a Gradle wrapper.

## App controls

* D-pad center / Enter: toggle Demo and Live modes.
* In Live mode, an API key can be supplied by creating `local.properties` with `CRICKETDATA_API_KEY=your_key`, or via the `CRICKETDATA_API_KEY` GitHub Actions secret. Without a key, the app clearly displays the demo data.
* The app is intentionally a TV-only launcher activity (`LEANBACK_LAUNCHER`).

## Notes

The debug APK produced by this project is suitable for personal sideloading. It is not Play Store signed. Live scoring depends on the availability and limits of your CricketData.org account.
