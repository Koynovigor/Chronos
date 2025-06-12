package org.l3on1kl.project.core.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual val DatabaseDispatcher: CoroutineDispatcher = Dispatchers.IO
