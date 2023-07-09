

# ChargeRefund


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**value** | **BigDecimal** | Value in cents of this refund |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) |  |  [optional] |
|**correlationID** | **String** | Your correlation ID to keep track of this refund |  [optional] |
|**endToEndId** | **String** | The endToEndId of this refund |  [optional] |
|**time** | **String** | Time of this refund |  [optional] |
|**comment** | **String** | Comment of this refund |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| IN_PROCESSING | &quot;IN_PROCESSING&quot; |
| CONFIRMED | &quot;CONFIRMED&quot; |
| REJECTED | &quot;REJECTED&quot; |



