package br.com.openpix.sdk

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class ValidateTests {
  companion object {
    @Suppress("MaxLineLength", "ktlint")
    const val PAYLOAD: String =
      """{ "pixQrCode": null, "charge": { "status": "COMPLETED", "customer": { "name": "Antonio Victor", "taxID": { "taxID": "12345678976", "type": "BR:CPF" }, "email": "antoniocliente@example.com", "correlationID": "4979ceba-2132-4292-bd90-bee7fb2125e4" }, "value": 1000, "comment": "Pagamento OpenPix", "transactionID": "ea83401ed4834b3ea6f1f283b389af29", "correlationID": "417bae21-3d08-4cdb-9c2d-fee63c89e9e4", "paymentLinkID": "34697ed2-3790-4b60-8512-e7465b142d84", "createdAt": "2021-03-12T12:43:54.528Z", "updatedAt": "2021-03-12T12:44:09.360Z", "brCode": "https://api.openpix.com.br/openpix/openpix/testing?transactionID=ea83401ed4834b3ea6f1f283b389af29" }, "pix": { "charge": { "status": "COMPLETED", "customer": { "name": "Antonio Victor", "taxID": { "taxID": "12345678976", "type": "BR:CPF" }, "email": "antoniocliente@example.com", "correlationID": "4979ceba-2132-4292-bd90-bee7fb2125e4" }, "value": 1000, "comment": "Pagamento OpenPix", "transactionID": "ea83401ed4834b3ea6f1f283b389af29", "correlationID": "417bae21-3d08-4cdb-9c2d-fee63c89e9e4", "paymentLinkID": "34697ed2-3790-4b60-8512-e7465b142d84", "createdAt": "2021-03-12T12:43:54.528Z", "updatedAt": "2021-03-12T12:44:09.360Z" }, "customer": { "correlationID": "9134e286-6f71-427a-bf00-241681624586", "email": "email1@example.com", "name": "Loma", "phone": "+5511999999999", "taxID": { "taxID": "47043622050", "type": "BR:CPF" } }, "payer": { "correlationID": "9134e286-6f71-427a-bf00-241681624586", "email": "email1@example.com", "name": "Loma", "phone": "+5511999999999", "taxID": { "taxID": "47043622050", "type": "BR:CPF" } }, "time": "2021-03-12T12:44:09.269Z", "value": 1, "transactionID": "ea83401ed4834b3ea6f1f283b389af29", "infoPagador": "OpenPix testing" }, "company": { "id": "624f46f9e93f9f521c8308d7", "name": "Pizzaria do José", "taxID": "4722767300014" }, "account": { "clientId": "ZOJ64B9B-ZM1W-89MI-4UCI-OP2LVIU6NY75" } }""" // ktlint-disable

    @Suppress("MaxLineLength", "ktlint")
    const val SIGNATURE: String =
      "lL2nnXgmLFGgxJ8+jCDguqouU4ucrIxYJcU5SPrJFaNcJajTJHYVldqc/z4YFIjAjtPEALe699WosgPY08W7CLpidvtm06Qwa4YMB0l/DcTS93O91NdSH/adjugEKiOb76Zj/0jB8mqOmWCFYbweOBa17bssuEkd5Lw7Q5L314Y=" // ktlint-disable
  }

  @Test
  fun `verify true`() {
    assertThat(verify(PAYLOAD, SIGNATURE)).isTrue()
  }

  @Test
  fun `verify false with payload`() {
    assertThat(verify("{ \"payload\": \"invalid\" }", SIGNATURE)).isFalse()
  }

  @Test
  fun `verify false with signature`() {
    assertThat(verify(PAYLOAD, "no")).isFalse()
  }
}
