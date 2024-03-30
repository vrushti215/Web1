plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.assignment_1"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.assignment_1"
        minSdk = 34
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = 1.8.toString()
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.core:core-ktx:1.12.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    // Retrofit for networking
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Gson for JSON parsing with Retrofit
    implementation("com.google.code.gson:gson:2.10")

    // OkHttp logging interceptor (optional, for logging network requests)
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.0")

    // Volley for networking (alternative to Retrofit)
    implementation("com.android.volley:volley:1.2.1")

    // Room for local database
    implementation("androidx.room:room-runtime:2.6.1")
    annotationProcessor("androidx.room:room-compiler:2.6.1")


    // Coroutines for Kotlin projects
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")

    // Material Design components for UI enhancements
    implementation("com.google.android.material:material:1.11.0")

    // Other dependencies like appcompat, etc., if not already included
    implementation("androidx.appcompat:appcompat:1.6.1")

    implementation("androidx.lifecycle:lifecycle-viewmodel:2.7.0")
    // For Kotlin projects
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")

    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")


    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

// Kotlin Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")

// Optional - Logging Interceptor for Retrofit
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.0")

    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")

        // Retrofit and Gson for network operations
        implementation ("com.squareup.retrofit2:retrofit:2.9.0")
        implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
        // Kotlin Coroutines
        implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")
        implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")


}