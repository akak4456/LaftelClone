pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "LaftelClone"
include(":app")

// https://hyosikchoi.tistory.com/entry/build-logic-rebuild-project-%EC%8B%9C-%EC%97%90%EB%9F%AC-%EA%B4%80%EB%A0%A8
// 이를 이유로 아래의 코드 추가함
gradle.startParameter.excludedTaskNames.addAll(listOf(":build-logic:convention:testClasses"))

include(":feature:home")
include(":core:database")
include(":feature:splash")
include(":core:designsystem")
