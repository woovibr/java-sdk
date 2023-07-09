

# ChargePayload


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**correlationID** | **String** | Your correlation ID to keep track of this charge |  |
|**value** | **BigDecimal** | Value in cents of this charge |  |
|**type** | [**TypeEnum**](#TypeEnum) | Charge type is used to determine whether a charge will have a deadline, fines and interests |  [optional] |
|**comment** | **String** | Comment to be added in infoPagador |  [optional] |
|**identifier** | **String** | Custom identifier for EMV |  [optional] |
|**expiresIn** | **BigDecimal** | Expires the charge in seconds (minimum is 15 minutes) |  [optional] |
|**customer** | **CustomerPayload** |  |  [optional] |
|**daysForDueDate** | **BigDecimal** | Time in days until the charge hits the deadline so fines and interests start applying. This property is only considered for charges of type OVERDUE |  [optional] |
|**daysAfterDueDate** | **BigDecimal** | Time in days that a charge is still payable after the deadline. This property is only considered for charges of type OVERDUE |  [optional] |
|**interests** | [**ChargePayloadInterests**](ChargePayloadInterests.md) |  |  [optional] |
|**fines** | [**ChargePayloadFines**](ChargePayloadFines.md) |  |  [optional] |
|**additionalInfo** | [**List&lt;ChargeAdditionalInfoInner&gt;**](ChargeAdditionalInfoInner.md) | Additional info of the charge |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| DYNAMIC | &quot;DYNAMIC&quot; |
| OVERDUE | &quot;OVERDUE&quot; |



