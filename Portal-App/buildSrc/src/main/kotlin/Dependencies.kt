import org.gradle.kotlin.dsl.DependencyHandlerScope

@Suppress("MemberVisibilityCanBePrivate")
sealed class Dependencies {

    object Ktor : Dependencies() {
        const val version = "2.1.1"

        const val ktorClientCore = "io.ktor:ktor-client-core:$version"
        const val ktorClientAndroid = "io.ktor:ktor-client-android:$version"
        const val ktorClientContentNegotiation = "io.ktor:ktor-client-content-negotiation:$version"
        const val ktorSerializationJson = "io.ktor:ktor-serialization-kotlinx-json:$version"

        override fun invoke(scope: DependencyHandlerScope) {
            scope {
                implementation(ktorClientCore)
                implementation(ktorClientAndroid)
                implementation(ktorClientContentNegotiation)
                implementation(ktorSerializationJson)
            }
        }
    }

    object AndroidxCore : Dependencies() {
        const val version = "1.9.0"

        const val coreKtx = "androidx.core:core-ktx:$version"

        override fun invoke(scope: DependencyHandlerScope) {
            scope {
                implementation(coreKtx)
            }
        }
    }

    object Compose : Dependencies() {
        const val version = "1.2.1"

        const val activity = "androidx.activity:activity-compose:1.5.1"
        const val navigation = "androidx.navigation:navigation-compose:2.6.0-alpha01"
        const val material = "androidx.compose.material:material:$version"
        const val ui = "androidx.compose.ui:ui:$version"
        const val uiTooling = "androidx.compose.ui:ui-tooling-preview:$version"
        const val matIcons = "androidx.compose.material:material-icons-extended:$version"

        override fun invoke(scope: DependencyHandlerScope) {
            scope {
                implementation(activity)
                implementation(navigation)
                implementation(material)
                implementation(ui)
                implementation(uiTooling)
                implementation(matIcons)
            }
        }
    }

    abstract operator fun invoke(scope: DependencyHandlerScope)

    protected fun DependencyHandlerScope.implementation(dependencyNotation: String) {
        "implementation"(dependencyNotation)
    }
}
