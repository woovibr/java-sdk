

# Transaction


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**charge** | **Charge** |  |  [optional] |
|**value** | **BigDecimal** |  |  [optional] |
|**time** | **String** |  |  [optional] |
|**endToEndID** | **String** |  |  [optional] |
|**transactionID** | **String** |  |  [optional] |
|**infoPagador** | **String** |  |  [optional] |
|**endToEndId** | **String** |  |  [optional] |
|**customer** | **Customer** |  |  [optional] |
|**withdraw** | **PixWithdrawTransaction** |  |  [optional] |
|**payer** | **Customer** |  |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | Pix Transaction type |  [optional] |
|**globalID** | **Object** | External ID of this transaction |  [optional] |
|**pixQrCode** | **PixQrCode** |  |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| PAYMENT | &quot;PAYMENT&quot; |
| WITHDRAW | &quot;WITHDRAW&quot; |
| REFUND | &quot;REFUND&quot; |
| FEE | &quot;FEE&quot; |



