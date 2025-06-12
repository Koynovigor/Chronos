package org.l3on1kl.project.core.db

import android.content.Context
import app.cash.sqldelight.driver.android.AndroidSqliteDriver

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class DatabaseFactory(private val context: Context) {
    actual fun createDatabase(): ChronosDatabase {
        val driver = AndroidSqliteDriver(ChronosDatabase.Schema, context, "chronos.db")
        return ChronosDatabase(driver)
    }
}
