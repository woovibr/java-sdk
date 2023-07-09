

# Refund


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**value** | **BigDecimal** |  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) |  |  [optional] |
|**correlationID** | **String** | Your correlation ID to keep track of this refund |  [optional] |
|**refundId** | **String** | Unique refund ID for this pix refund |  [optional] |
|**time** | **String** | Time of this refund |  [optional] |
|**comment** | **String** | Comment of this refund |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| IN_PROCESSING | &quot;IN_PROCESSING&quot; |
| REFUNDED | &quot;REFUNDED&quot; |
| NOT_ACCOMPLISHED | &quot;NOT_ACCOMPLISHED&quot; |



