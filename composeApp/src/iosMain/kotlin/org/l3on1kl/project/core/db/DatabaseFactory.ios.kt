package org.l3on1kl.project.core.db

import app.cash.sqldelight.driver.native.NativeSqliteDriver

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class DatabaseFactory {
    actual fun createDatabase(): ChronosDatabase {
        val driver = NativeSqliteDriver(ChronosDatabase.Schema, "chronos.db")
        return ChronosDatabase(driver)
    }
}
