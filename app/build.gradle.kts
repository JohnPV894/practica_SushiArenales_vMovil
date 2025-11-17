plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.act2_movil"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.act2_movil"
        minSdk = 24
        targetSdk = 36
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    implementation(libs.recyclerview)
    implementation(libs.firebase.crashlytics.buildtools)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // PARA LA CONEXIÓN A LA API (Retrofit y Gson)

    // Librería de Retrofit
    implementation("com.squareup.retrofit2:retrofit:3.0.0")

    // Conversor de JSON a objetos Java (usando Gson)
    implementation("com.squareup.retrofit2:converter-gson:3.0.0")

    implementation ("com.github.bumptech.glide:glide:4.16.0")
}