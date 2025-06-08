package org.l3on1kl.project.core.utils

import org.l3on1kl.project.MainViewController
import platform.UIKit.UIApplication
import platform.UIKit.UIWindow
import platform.UIKit.UIWindowScene

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class Platform actual constructor() {
    actual val isIos: Boolean = true
    actual val isAndroid: Boolean = false
    actual val isDesktop: Boolean = false
}

actual fun restartRootViewController() {
    val windowScene = UIApplication.sharedApplication
        .connectedScenes
        .firstOrNull() as? UIWindowScene

    val window = windowScene?.windows?.firstOrNull() as? UIWindow

    window?.rootViewController = MainViewController()
    window?.makeKeyAndVisible()
}
