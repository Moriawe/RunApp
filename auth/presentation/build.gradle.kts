plugins {
    alias(libs.plugins.runique.android.feature.ui)
}

android {
    namespace = "com.moriawe.auth.presentation"
}

dependencies {
    // Using the gradle settings Typesafe project accessors to get the dependencies.
    // If you don't do that you have to use this syntax
//    implementation(project(":core:domain"))
//    implementation(project(":auth:domain"))
    implementation(projects.core.domain)
    implementation(projects.auth.domain)
}