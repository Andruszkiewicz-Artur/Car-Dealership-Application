plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.daggerHilt)
    alias(libs.plugins.kspCompose)
}

android {
    namespace = "com.andruszkiewicz.cardealershipapplication"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.andruszkiewicz.cardealershipapplication"
        minSdk = 26
        targetSdk = 35
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
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //Retrofit
    implementation(libs.bundles.retrofit)

    //OkHttp
    implementation(libs.bundles.okhttp)

    //Hilt
    implementation(libs.hilt)
    ksp(libs.hilt.compiler)

    //Glide
    implementation(libs.glide)

    //Lifecycle
    implementation(libs.lifecycle.viewModel)

    //Fragment
    implementation(libs.androidx.fragment)
}