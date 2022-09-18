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

    abstract operator fun invoke(scope: DependencyHandlerScope)

    protected fun DependencyHandlerScope.implementation(dependencyNotation: String) {
        "implementation"(dependencyNotation)
    }
}
