package ru.pianotest.stackexchangeApiClient.entities;

/**
 * Порядок вывода на экран
 */
public enum Order {

    ASC("asc"), DESC("desc");

    public static final Order[] ALL = {ASC, DESC};

    private final String name;

    private Order(final String name) {
        this.name = name;
    }


    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return getName();
    }

}
