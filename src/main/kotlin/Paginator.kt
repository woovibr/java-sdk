package com.openpix.sdk

import io.ktor.client.call.*
import io.ktor.client.request.*
import java.util.concurrent.Future
import kotlinx.coroutines.future.future

/**
 * Paginator for the API. Used to paginate through the API. It's used by the SDK to paginate through the API.
 *
 * @property sdk The SDK instance. Used to make requests.
 */
public class Paginator<T> @PublishedApi internal constructor(
  /**
   * The SDK instance. Used to make requests.
   */
  private val sdk: WooviSDK,
  private var skipping: Int,
  private val pageSize: Int,
  private val initialQueries: Map<String, String>,
  private val request: suspend WooviSDK.(queries: Map<String, String>) -> PageInstance<T>,
) {
  private var page: PageInstance<T>? = null

  /**
   * The current page of the paginator. Starts at 1.
   *
   * @return The current page of the paginator.
   */
  public suspend fun items(): List<T> {
    if (page == null) {
      page = request(sdk, initialQueries + mapOf("skip" to skipping.toString()))
    }

    return page!!.items
  }

  /**
   * The current page of the paginator. Starts at 1.
   *
   * @return The current page of the paginator.
   */
  public fun itemsAsync(): Future<List<T>> = sdk.future {
    items()
  }

  /**
   * Advances to the next page.
   */
  public fun next() {
    this.skipping += pageSize
    this.page = null // Invalidates the current page cache
  }

  /**
   * Goes back to the previous page.
   */
  public fun previous() {
    this.skipping -= pageSize
    this.page = null // Invalidates the current page cache
  }

  /**
   * The current page information.
   */
  public suspend fun pageInfo(): PageInfo {
    if (page == null) {
      page = request(sdk, initialQueries + mapOf("skip" to skipping.toString()))
    }

    return page!!.pageInfo
  }

  /**
   * The current page information.
   */
  public fun pageInfoAsync(): Future<PageInfo> = sdk.future {
    pageInfo()
  }

  public companion object {
    /**
     * Creates a paginator for the API. Used to paginate through the API.
     *
     * It's used by the SDK to paginate through the API.
     */
    public inline fun <reified R : PageInstance<T>, T> createPaginator(
      sdk: WooviSDK,
      endpoint: String,
      pageSize: Int,
      initialQueries: Map<String, String?>,
    ): Paginator<T> {
      val queriesNotNullable = initialQueries.filterValues { it != null }.mapValues { it.value!! }

      return Paginator(sdk, 0, pageSize, queriesNotNullable) { queries ->
        sdk.client
          .get(endpoint) {
            queries.forEach { (key, value) ->
              parameter(key, value)
            }
          }
          .body<R>()
      }
    }
  }
}

public class PaginationQueries : HashMap<String, String>() {
  public var start: String?
    get(): String? = this["start"]
    set(value) {
      if (value != null) {
        this["start"] = value
      }
    }

  public var end: String?
    get(): String? = this["end"]
    set(value) {
      if (value != null) {
        this["end"] = value
      }
    }
}

public interface PageInstance<T> {
  public var items: List<T>
  public var pageInfo: PageInfo
}
