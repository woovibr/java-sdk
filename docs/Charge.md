

# Charge


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**value** | **BigDecimal** |  |  [optional] |
|**customer** | **Customer** |  |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | Charge type is used to determine whether a charge will have a deadline, fines and interests |  [optional] |
|**comment** | **String** |  |  [optional] |
|**brCode** | **String** | EMV BRCode to be rendered as a QRCode |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) |  |  [optional] |
|**correlationID** | **String** | Your correlation ID to keep track of this charge |  [optional] |
|**paymentLinkID** | **String** | Payment Link ID, used on payment link and to retrieve qrcode image |  [optional] |
|**paymentLinkUrl** | **Object** | Payment Link URL to be shared with customers |  [optional] |
|**globalID** | **Object** | External ID of this charge |  [optional] |
|**transactionID** | **Object** | unique uuid used as the txid from Pix into the provider from your openpix account. This field link the charge with the transaction when paid. |  [optional] |
|**identifier** | **String** | Custom identifier for EMV |  [optional] |
|**qrCodeImage** | **Object** | QRCode image link URL |  [optional] |
|**additionalInfo** | [**List&lt;ChargeAdditionalInfoInner&gt;**](ChargeAdditionalInfoInner.md) | Additional info of the charge |  [optional] |
|**pixKey** | **String** |  |  [optional] |
|**createdAt** | **String** |  |  [optional] |
|**updatedAt** | **String** |  |  [optional] |
|**expiresIn** | **String** |  |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| DYNAMIC | &quot;DYNAMIC&quot; |
| OVERDUE | &quot;OVERDUE&quot; |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| ACTIVE | &quot;ACTIVE&quot; |
| COMPLETED | &quot;COMPLETED&quot; |
| EXPIRED | &quot;EXPIRED&quot; |



