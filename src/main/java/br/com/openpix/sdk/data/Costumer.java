package br.com.openpix.sdk.data;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class Costumer {
    private final @NotNull String name;
    private final @NotNull String email;
    private final @NotNull String phone;
    private final @NotNull TaxID taxID;

    public Costumer(@NotNull final String name, @NotNull final String email, @NotNull final String phone, @NotNull final TaxID taxID) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.taxID = taxID;
    }

    @NotNull
    @Contract(pure = true)
    public String getName() {
        return name;
    }

    @NotNull
    @Contract(pure = true)
    public String getEmail() {
        return email;
    }

    @NotNull
    @Contract(pure = true)
    public String getPhone() {
        return phone;
    }

    @NotNull
    @Contract(pure = true)
    public TaxID getTaxID() {
        return taxID;
    }

    @Contract(value = "null -> false", pure = true)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Costumer costumer = (Costumer) o;
        return Objects.equals(name, costumer.name) && Objects.equals(email, costumer.email) && Objects.equals(phone, costumer.phone) && Objects.equals(taxID, costumer.taxID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, phone, taxID);
    }
}
