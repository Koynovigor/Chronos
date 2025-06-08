package org.l3on1kl.project.core.utils

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class Platform() {
    val isIos: Boolean
    val isAndroid: Boolean
    val isDesktop: Boolean
}

expect fun restartRootViewController()
