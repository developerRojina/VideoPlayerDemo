plugins {
    alias(libs.plugins.androidApplication)
    id("com.google.dagger.hilt.android")
  //  id(libs.plugins.hiltPlugin)

}

android {
    namespace = "com.demoapp.videoplayer"
    compileSdk = 34
    android.buildFeatures.viewBinding =true
    defaultConfig {
        applicationId = "com.demoapp.videoplayer"
        minSdk = 26
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
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    
    implementation(libs.hilt)
    annotationProcessor(libs.hiltCompiler)

    implementation(libs.retrofit)
    implementation(libs.retrofitAdapter)
    implementation(libs.gson)
    implementation(libs.loggingInterceptor)

    implementation(libs.timber)

    implementation(libs.pagingRuntime)
    implementation(libs.pagingRxJava)
    implementation(libs.glide)

    implementation(libs.exoplayer)
    implementation(libs.exoplayerDash)
    implementation(libs.exoplayerMedia)


    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}