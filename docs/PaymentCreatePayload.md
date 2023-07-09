

# PaymentCreatePayload


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**value** | **BigDecimal** | value of the requested payment in cents |  [optional] |
|**destinationAlias** | **String** | the pix key the payment should be sent to |  [optional] |
|**correlationID** | **String** | an unique identifier for your payment |  [optional] |
|**comment** | **String** | the comment that will be send alongisde your payment |  [optional] |
|**sourceAccountId** | **String** | an optional id for the source account of the payment, if not informed will assume the default account |  [optional] |



