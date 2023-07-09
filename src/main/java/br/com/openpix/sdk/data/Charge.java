package br.com.openpix.sdk.data;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public final class Charge {
    private final @NotNull Status status;
    private final @NotNull Costumer costumer;
    private final @NotNull String comment;
    private final @NotNull String correlationID;
    private final @NotNull String paymentLinkID;
    private final @NotNull String paymentLinkUrl;
    private final @NotNull String globalID;
    private final @NotNull String qrCodeImage;
    private final @NotNull String brCode;
    private final @NotNull List<AdditionalInfo> additionalInfo;
    private final @NotNull LocalDateTime expiresDate;
    private final @NotNull LocalDateTime createdAt;
    private final @NotNull LocalDateTime updatedAt;
    private final long expiresIn;
    private final int value;

    public Charge(@NotNull Status status, @NotNull Costumer costumer, @NotNull String comment, @NotNull String correlationID, @NotNull String paymentLinkID, @NotNull String paymentLinkUrl, @NotNull String globalID, @NotNull String qrCodeImage, @NotNull String brCode, @NotNull List<AdditionalInfo> additionalInfo, @NotNull LocalDateTime expiresDate, @NotNull LocalDateTime createdAt, @NotNull LocalDateTime updatedAt, long expiresIn, int value) {
        this.status = status;
        this.costumer = costumer;
        this.comment = comment;
        this.correlationID = correlationID;
        this.paymentLinkID = paymentLinkID;
        this.paymentLinkUrl = paymentLinkUrl;
        this.globalID = globalID;
        this.qrCodeImage = qrCodeImage;
        this.brCode = brCode;
        this.additionalInfo = additionalInfo;
        this.expiresDate = expiresDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.expiresIn = expiresIn;
        this.value = value;
    }

    @Contract(pure = true)
    @NotNull
    public Status getStatus() {
        return status;
    }

    @Contract(pure = true)
    @NotNull
    public Costumer getCostumer() {
        return costumer;
    }

    @Contract(pure = true)
    @NotNull
    public String getComment() {
        return comment;
    }

    @Contract(pure = true)
    @NotNull
    public String getCorrelationID() {
        return correlationID;
    }

    @Contract(pure = true)
    @NotNull
    public String getPaymentLinkID() {
        return paymentLinkID;
    }

    @Contract(pure = true)
    @NotNull
    public String getPaymentLinkUrl() {
        return paymentLinkUrl;
    }

    @Contract(pure = true)
    @NotNull
    public String getGlobalID() {
        return globalID;
    }

    @Contract(pure = true)
    @NotNull
    public String getQrCodeImage() {
        return qrCodeImage;
    }

    @Contract(pure = true)
    @NotNull
    public String getBrCode() {
        return brCode;
    }

    @Contract(pure = true)
    @NotNull
    public List<AdditionalInfo> getAdditionalInfo() {
        return additionalInfo;
    }

    @Contract(pure = true)
    public int getValue() {
        return value;
    }

    @Contract(pure = true)
    @NotNull
    public LocalDateTime getExpiresDate() {
        return expiresDate;
    }

    @Contract(pure = true)
    @NotNull
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Contract(pure = true)
    @NotNull
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Contract(pure = true)
    public long getExpiresIn() {
        return expiresIn;
    }

    @Contract(value = "null -> false", pure = true)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Charge charge = (Charge) o;
        return expiresIn == charge.expiresIn && value == charge.value && status == charge.status && Objects.equals(costumer, charge.costumer) && Objects.equals(comment, charge.comment) && Objects.equals(correlationID, charge.correlationID) && Objects.equals(paymentLinkID, charge.paymentLinkID) && Objects.equals(paymentLinkUrl, charge.paymentLinkUrl) && Objects.equals(globalID, charge.globalID) && Objects.equals(qrCodeImage, charge.qrCodeImage) && Objects.equals(brCode, charge.brCode) && Objects.equals(additionalInfo, charge.additionalInfo) && Objects.equals(expiresDate, charge.expiresDate) && Objects.equals(createdAt, charge.createdAt) && Objects.equals(updatedAt, charge.updatedAt);
    }

    @NotNull
    @Contract(pure = true)
    @Override
    public String toString() {
        return "Charge{" +
            "status=" + status +
            ", costumer=" + costumer +
            ", comment='" + comment + '\'' +
            ", correlationID='" + correlationID + '\'' +
            ", paymentLinkID='" + paymentLinkID + '\'' +
            ", paymentLinkUrl='" + paymentLinkUrl + '\'' +
            ", globalID='" + globalID + '\'' +
            ", qrCodeImage='" + qrCodeImage + '\'' +
            ", brCode='" + brCode + '\'' +
            ", additionalInfo=" + additionalInfo +
            ", expiresDate=" + expiresDate +
            ", createdAt=" + createdAt +
            ", updatedAt=" + updatedAt +
            ", expiresIn=" + expiresIn +
            ", value=" + value +
            '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, costumer, comment, correlationID, paymentLinkID, paymentLinkUrl, globalID, qrCodeImage, brCode, additionalInfo, expiresDate, createdAt, updatedAt, expiresIn, value);
    }
}
