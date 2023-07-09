package br.com.openpix.sdk.data;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public final class AdditionalInfo {
    private final @NotNull String key;
    private final @Nullable Object value;

    public AdditionalInfo(@NotNull String key, @Nullable Object value) {
        this.key = key;
        this.value = value;
    }

    @Contract(pure = true)
    @NotNull
    public String getKey() {
        return key;
    }

    @Contract(pure = true)
    @Nullable
    public Object getValue() {
        return value;
    }

    @Contract(value = "null -> false", pure = true)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdditionalInfo that = (AdditionalInfo) o;
        return Objects.equals(key, that.key) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Contract(pure = true)
    @Override
    @NotNull
    public String toString() {
        return "AdditionalInfo{" +
            "key='" + key + '\'' +
            ", value=" + value +
            '}';
    }
}
