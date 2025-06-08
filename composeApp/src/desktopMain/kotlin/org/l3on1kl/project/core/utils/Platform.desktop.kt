package org.l3on1kl.project.core.utils

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class Platform actual constructor() {
    actual val isIos: Boolean = false
    actual val isAndroid: Boolean = false
    actual val isDesktop: Boolean = true
}

actual fun restartRootViewController() { }
