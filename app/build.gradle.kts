plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.kapt")
}

android {
    namespace = "com.example.mandiri_news_apps"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mandiri_news_apps"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        val newsApiKey = project.properties["NEWS_API_KEY"] as String

        buildConfigField(
            "String",
            "NEWS_API_KEY",
            "\"$newsApiKey\""
        )

    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }

    kotlinOptions {
        jvmTarget = "18"
    }
}

dependencies {


    implementation ("androidx.appcompat:appcompat:1.7.0")
    implementation ("com.google.android.material:material:1.12.0")

    // Lifecycle ViewModel & LiveData
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.6")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.8.6")

    // Lifecycle runtime
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.8.6")


    // coroutine
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    // okhttp
    implementation ("com.squareup.okhttp3:okhttp:4.12.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.12.0")

    implementation ("androidx.cardview:cardview:1.0.0")
    implementation("com.github.bumptech.glide:glide:4.16.0")
    kapt("com.github.bumptech.glide:compiler:4.16.0")


}

