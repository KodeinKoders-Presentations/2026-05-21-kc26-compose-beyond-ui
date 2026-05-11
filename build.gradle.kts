plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.plugin.compose)
    alias(libs.plugins.compose)
    alias(libs.plugins.cup)
}

cup {
    targetDesktop()
    targetWeb()
}

kotlin {
    jvmToolchain(21)

    sourceSets.commonMain {
        dependencies {
            implementation(libs.bundles.compose)
            implementation(libs.bundles.cup)

            implementation(libs.kodein.theme)
            implementation(libs.emoji.compose)
            implementation(libs.qrose)
        }
    }

    compilerOptions {
        freeCompilerArgs.add("-Xcontext-parameters")
    }
}
