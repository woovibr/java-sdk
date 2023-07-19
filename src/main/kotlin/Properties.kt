package br.com.openpix.sdk

import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

internal object Properties {
  internal fun <T> required(): ReadWriteProperty<Any?, T & Any> = object : ReadWriteProperty<Any?, T & Any> {
    var value: T? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): T & Any {
      return value ?: run {
        val className = if (thisRef != null) thisRef::class.simpleName else null

        throw IllegalArgumentException("The property $className.${property.name} must be not null")
      }
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T & Any) {
      this.value = value
    }
  }

  internal fun <T> nullable(): ReadWriteProperty<Any?, T?> = object : ReadWriteProperty<Any?, T?> {
    var value: T? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): T? {
      return value
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T?) {
      this.value = value
    }
  }
}
