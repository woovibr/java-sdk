package br.com.openpix.sdk

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class WooviError(
  @SerialName("error")
  override val message: String? = null,
) : Throwable()
