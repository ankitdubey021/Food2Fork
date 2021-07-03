plugins {
    id(Plugins.androidApplication)
    kotlin(KotlinPlugins.android)
    kotlin(KotlinPlugins.kapt)
    id(Plugins.hilt)
    kotlin(KotlinPlugins.serialization) version Kotlin.version
}

dependencies {
    implementation(project(":shared"))
    implementation(Google.material)
    implementation(AndroidX.appCompat)
    implementation(Kotlinx.datetime)

    implementation("androidx.compose.runtime:runtime:1.0.0-rc01")
    implementation("androidx.compose.runtime:runtime-livedata:1.0.0-rc01")
    implementation("androidx.compose.ui:ui:1.0.0-rc01")
    implementation("androidx.compose.material:material:1.0.0-rc01")
    implementation("androidx.compose.ui:ui-tooling:1.0.0-rc01")
    implementation("androidx.compose.foundation:foundation:1.0.0-rc01")
    implementation("androidx.compose.compiler:compiler:1.0.0-rc01")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.0-alpha08")
    implementation("androidx.activity:activity-compose:1.3.0-rc01")
    implementation("androidx.navigation:navigation-compose:2.4.0-alpha04")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0-alpha03")

    implementation("com.google.dagger:hilt-android:2.35")
    kapt("com.google.dagger:hilt-compiler:2.35")
    implementation("androidx.hilt:hilt-navigation-fragment:1.0.0")


    debugImplementation(SquareUp.leakCanary)
}

android {
    compileSdkVersion(Application.compileSdk)
    defaultConfig {
        applicationId = Application.appId
        minSdkVersion(Application.minSdk)
        targetSdkVersion(Application.targetSdk)
        versionCode = Application.versionCode
        versionName = Application.versionName
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    buildFeatures {
        // Enables Jetpack Compose for this module
        compose = true
    }

    // Set both the Java and Kotlin compilers to target Java 8.

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }

    composeOptions {
        kotlinCompilerVersion = Kotlin.version
        kotlinCompilerExtensionVersion = Kotlin.compilerExtVersion
    }

}