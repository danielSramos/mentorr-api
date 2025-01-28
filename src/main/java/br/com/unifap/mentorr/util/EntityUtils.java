package br.com.unifap.mentorr.util;

import java.util.Collection;
import java.util.Objects;
import java.util.function.Supplier;

public class EntityUtils {

    /**
     * Garante que uma coleção seja inicializada.
     * Se a coleção for null, ela será inicializada como uma nova instância.
     *
     * @param collection A coleção que precisa ser inicializada.
     * @param <T> O tipo da coleção.
     * @return A coleção inicializada (ou a coleção original, se já estiver inicializada).
     */
    public static <T extends Collection<?>> T initializeCollection(T collection, Supplier<T> collectionSupplier) {
        return Objects.requireNonNullElseGet(collection, collectionSupplier);
    }
}
