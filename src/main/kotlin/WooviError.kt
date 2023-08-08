package br.com.openpix.sdk

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * [WooviError] is the error response from the Woovi API that can be thrown as an [Throwable].
 *
 * @property message The error message.
 */
@Serializable
public class WooviError(@SerialName("error") override val message: String? = null) : RuntimeException()
