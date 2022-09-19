plugins {
    id("com.android.application")
    id("kotlin-android")
    kotlin("plugin.serialization") version "1.7.10"
}

val compose_version = "1.2.0"

android {
    compileSdk = 33

    defaultConfig {
        applicationId = "dev.alyxia.portal_app"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        buildConfigField("String", "BASE_URL", "\"https://gdos-api.alyxia.dev\"")

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
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
        freeCompilerArgs = freeCompilerArgs + "-opt-in=kotlin.RequiresOptIn"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = compose_version
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    Dependencies.AndroidxCore(this)
    Dependencies.Compose(this)
    Dependencies.Ktor(this)

    // NOTE: Old deps, not needed?
    // implementation("androidx.appcompat:appcompat:1.5.1")
    // implementation("com.google.android.material:material:1.6.1")
    // implementation("com.google.accompanist:accompanist-systemuicontroller:0.25.1")
    // implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")

    debugImplementation("androidx.compose.ui:ui-tooling:$compose_version")
}