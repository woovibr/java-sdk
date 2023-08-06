package br.com.openpix.sdk

import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.*
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class WooviSDKTests {
  @Test
  fun `test woovi sdk app id`() {
    val appId = "id"
    val client = WooviSDK(appId)

    assert(client.appId == appId)
  }

}
