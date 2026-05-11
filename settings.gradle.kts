import org.gradle.api.internal.DynamicObjectAware
import org.gradle.api.internal.project.DynamicLookupRoutine
import org.gradle.kotlin.dsl.support.serviceOf

// TODO: Change the name of your project here
rootProject.name = "Compose-beyond-UI"

pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        mavenCentral()
        google()
    }
}

fun findProperty(propertyName: String) = serviceOf<DynamicLookupRoutine>().findProperty((settings as DynamicObjectAware).asDynamicObject, propertyName)?.toString()

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositories {
        mavenLocal()
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/kodeinkoders/kodein-themes")
            content {
                includeGroup("net.kodein.themes")
            }
            credentials {
                username = findProperty("gpr.user") ?: System.getenv("GITHUB_ACTOR")
                password = findProperty("gpr.key") ?: System.getenv("GITHUB_TOKEN")

                if (username == null || password == null) {
                    logger.warn("WARNING: No GitHub credentials defined.")
                    logger.warn("WARNING: Please add the gpr.user and gpr.key properties in your \$HOME/.gradle/gradle.properties.")
                    logger.warn("WARNING: Do NOT add these properties into the project gradle.properties file (it should go in your HOME gradle.properties).")
                    logger.warn("WARNING: The gpr.user and gpr.key properties must correspond to a Github Classic Personal Access Token.")
                    logger.warn("WARNING: see https://docs.github.com/en/packages/learn-github-packages/about-permissions-for-github-packages#about-scopes-and-permissions-for-package-registries.")
                }
            }
        }
        mavenCentral()
        google()
    }
}
