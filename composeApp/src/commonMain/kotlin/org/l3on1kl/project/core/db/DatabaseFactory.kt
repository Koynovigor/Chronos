package org.l3on1kl.project.core.db

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class DatabaseFactory {
    fun createDatabase(): ChronosDatabase
}
