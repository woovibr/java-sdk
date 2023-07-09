package br.com.openpix.sdk.data;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class TaxType {
    private final @NotNull String rawTaxType;

    public TaxType(@NotNull String rawTaxType) {
        this.rawTaxType = rawTaxType;
    }

    @Contract(pure = true)
    @NotNull
    public String getRawTaxType() {
        return rawTaxType;
    }

    @Contract(value = "null -> false", pure = true)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxType taxType = (TaxType) o;
        return Objects.equals(rawTaxType, taxType.rawTaxType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rawTaxType);
    }

    @Contract(pure = true)
    @Override
    @NotNull
    public String toString() {
        return "TaxType{" +
            "rawTaxType='" + rawTaxType + '\'' +
            '}';
    }
}
