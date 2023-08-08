@file:JvmName("OpenSSL")

package br.com.openpix.sdk

import io.ktor.util.*
import java.security.KeyFactory
import java.security.PublicKey
import java.security.Signature
import java.security.spec.X509EncodedKeySpec

/**
 * The public key used to verify the signature of the webhook.
 *
 * @see verify
 */
@Suppress("MaxLineLength")
public const val PUBLIC_KEY: String =
  "LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUlHZk1BMEdDU3FHU0liM0RRRUJBUVVBQTRHTkFEQ0JpUUtCZ1FDLytOdElranpldnZxRCtJM01NdjNiTFhEdApwdnhCalk0QnNSclNkY2EzcnRBd01jUllZdnhTbmQ3amFnVkxwY3RNaU94UU84aWVVQ0tMU1dIcHNNQWpPL3paCldNS2Jxb0c4TU5waS91M2ZwNnp6MG1jSENPU3FZc1BVVUcxOWJ1VzhiaXM1WloySVpnQk9iV1NwVHZKMGNuajYKSEtCQUE4MkpsbitsR3dTMU13SURBUUFCCi0tLS0tRU5EIFBVQkxJQyBLRVktLS0tLQo="

/**
 * The certificate used to verify the signature of the webhook.
 *
 * @see verify
 */
private val publicKey: PublicKey = run {
  val base64 = PUBLIC_KEY.decodeBase64String()
    .replace("-----BEGIN PUBLIC KEY-----", "")
    .replace("\\n", "")
    .replace("\n", "")
    .replace("-----END PUBLIC KEY-----","")
    .decodeBase64Bytes()

  KeyFactory
    .getInstance("RSA")
    .generatePublic(X509EncodedKeySpec(base64))
}

/**
 * Verifies the signature of the webhook.
 *
 * ```java
 * String payload;
 * String signature;
 *
 * OpenSSL.verify(payload, signature);
 * ```
 *
 * @param payload The payload of the webhook.
 * @param signature The signature of the webhook.
 * @return `true` if the signature is valid, `false` otherwise.
 */
public fun verify(payload: String, signature: String): Boolean {
  runCatching {
    return Signature.getInstance("SHA256withRSA").run {
      initVerify(publicKey)
      update(payload.toByteArray())

      verify(signature.decodeBase64Bytes())
    }
  }.getOrElse {
    return false
  }
}
