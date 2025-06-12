package org.l3on1kl.project.core.db

import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import java.io.File

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class DatabaseFactory {
    actual fun createDatabase(): ChronosDatabase {
        val dbPath = "chronos.db"
        val dbFile = File(dbPath)
        val isNewDatabase = !dbFile.exists()

        val driver = JdbcSqliteDriver("jdbc:sqlite:$dbPath")
        if (isNewDatabase) {
            ChronosDatabase.Schema.create(driver)
        }

        return ChronosDatabase(driver)
    }
}
