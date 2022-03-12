package io.sudoku.sudoku.utils

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class LoggerDelegate : ReadOnlyProperty<Any?, Logger> {

    private var logger: Logger? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): Logger {
        if (logger == null) {
            logger = createLogger(thisRef!!.javaClass)
        }

        return logger!!
    }

    companion object {
        private fun <T> createLogger(clazz: Class<T>) : Logger {
            return LoggerFactory.getLogger(clazz);
        }
    }
}