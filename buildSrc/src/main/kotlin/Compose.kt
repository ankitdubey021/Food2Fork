object Compose {
    const val composeVersion = "1.0.0-rc01"
    const val runtime = "androidx.compose.runtime:runtime:${composeVersion}"
    const val runtimeLiveData = "androidx.compose.runtime:runtime-livedata:${composeVersion}"
    const val ui = "androidx.compose.ui:ui:${composeVersion}"
    const val material = "androidx.compose.material:material:${composeVersion}"
    const val uiTooling = "androidx.compose.ui:ui-tooling:${composeVersion}"
    const val foundation = "androidx.compose.foundation:foundation:${composeVersion}"
    const val compiler = "androidx.compose.compiler:compiler:${composeVersion}"

    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07"
    const val hiltNavigation = "androidx.hilt:hilt-navigation-compose:1.0.0-alpha02"

    private const val constraintLayoutComposeVersion = "1.0.0-alpha08"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout-compose:${constraintLayoutComposeVersion}"

    private const val composeActivitiesVersion = "1.3.0-rc01"
    const val activity = "androidx.activity:activity-compose:${composeActivitiesVersion}"

    private const val composeNavigationVerson = "2.4.0-alpha04"
    const val navigation = "androidx.navigation:navigation-compose:${composeNavigationVerson}"
}