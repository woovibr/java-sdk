@file:JvmName("PageInfos")

package br.com.openpix.sdk

import kotlinx.serialization.Serializable

@Serializable
public data class PageInfo @JvmOverloads public constructor(
  public val errors: List<PageInfoError> = emptyList(),
  public val skip: Int,
  public val limit: Int,
  public val totalCount: Int,
  public val hasPreviousPage: Boolean,
  public val hasNextPage: Boolean,
)

@Serializable
public data class PageInfoError(
  public val message: String,
  public val data: PageInfoErrorData,
)

@Serializable
public data class PageInfoErrorData(
  public val skip: Int,
  public val limit: Int,
)
