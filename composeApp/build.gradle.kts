import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.detekt)
    alias(libs.plugins.ktlint)
    id("dev.icerock.mobile.multiplatform-resources")
}

kotlin {
    sourceSets.configureEach {
        languageSettings.optIn("kotlinx.coroutines.ExperimentalCoroutinesApi")
        languageSettings.optIn("androidx.compose.material3.ExperimentalMaterial3Api")
        languageSettings.optIn("androidx.compose.animation.ExperimentalAnimationApi")
        languageSettings.optIn("kotlin.time.ExperimentalTime")
    }

    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
            freeCompilerArgs += "-Xbinary=bundleId=org.l3on1kl.project.ComposeApp"

            export(libs.moko.resources)
        }
    }

    jvm("desktop")

    sourceSets {
        val desktopMain by getting

        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)
            implementation(libs.kotlinx.datetime)
            implementation(libs.voyager.tab.navigator)
            implementation(libs.voyager.navigator)
            implementation(libs.voyager.screenmodel)
            implementation(libs.material.icons.extended)
            implementation(libs.composables.core)
            api(libs.moko.resources)
            api(libs.moko.resources.compose)
            implementation(libs.multiplatform.settings.no.arg)
        }
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutines.swing)
        }
    }
}

tasks.register("assembleXCFramework") {
    dependsOn(
        "linkDebugFrameworkIosSimulatorArm64",
        "linkDebugFrameworkIosX64",
        "linkDebugFrameworkIosArm64",
    )
}

tasks.register("syncFramework") {
    dependsOn("assembleXCFramework")

    doLast {
        val outputDir = layout.buildDirectory.get().asFile.resolve("xcode-frameworks/Debug")
        val srcDirs =
            listOf(
                layout.buildDirectory.get().asFile.resolve("bin/iosArm64/debugFramework"),
                layout.buildDirectory.get().asFile.resolve("bin/iosSimulatorArm64/debugFramework"),
                layout.buildDirectory.get().asFile.resolve("bin/iosX64/debugFramework"),
            )

        outputDir.mkdirs()

        srcDirs.forEach { src ->
            val framework = src.resolve("ComposeApp.framework")
            if (framework.exists()) {
                framework.copyRecursively(outputDir.resolve(framework.name), overwrite = true)
            }
        }
    }
}

android {
    namespace = "org.l3on1kl.project"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "org.l3on1kl.project"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
    testImplementation(project(":test:shared"))
}

compose.desktop {
    application {
        mainClass = "org.l3on1kl.project.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "org.l3on1kl.project"
            packageVersion = "1.0.0"
        }
    }
}

detekt {
    config.from("$rootDir/detekt.yml")
    buildUponDefaultConfig = true
}

ktlint {
    android.set(true)
    filter {
        exclude { element ->
            element.file.path.contains("build/generated/compose/resourceGenerator")
        }
    }
}

tasks.register("ciCheck") {
    dependsOn("build", "allTests", "detekt", "ktlintCheck")
}

multiplatformResources {
    resourcesPackage.set("org.l3on1kl.project")
}
