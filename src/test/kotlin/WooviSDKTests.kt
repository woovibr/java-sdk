package br.com.openpix.sdk

import io.mockk.mockk
import org.junit.jupiter.api.Test

class WooviSDKTests {
  @Test
  fun `test woovi sdk app id`() {
    val appId = mockk<String>()
    val client = WooviSDK(appId)

    assert(client.appId == appId)
  }
}
