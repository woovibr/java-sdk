

# Payment


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**value** | **BigDecimal** | value of the requested payment in cents |  [optional] |
|**destinationAlias** | **String** | the pix key the payment should be sent to |  [optional] |
|**correlationID** | **String** | Your correlation ID to keep track of this payment |  [optional] |
|**comment** | **String** | the comment that will be send alongisde your payment |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | payment status |  [optional] |
|**sourceAccountId** | **String** | the id of the payment source account |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| CREATED | &quot;CREATED&quot; |
| FAILED | &quot;FAILED&quot; |
| CONFIRMED | &quot;CONFIRMED&quot; |
| DENIED | &quot;DENIED&quot; |



