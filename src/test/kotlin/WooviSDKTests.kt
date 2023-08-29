package com.openpix.sdk

import org.junit.jupiter.api.Test

class WooviSDKTests {
  @Test
  fun `test woovi sdk app id`() {
    val appId = "id"
    val client = WooviSDK(appId)

    assert(client.appId == appId)
  }
}
