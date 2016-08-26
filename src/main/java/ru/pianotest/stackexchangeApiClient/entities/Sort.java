package ru.pianotest.stackexchangeApiClient.entities;

/**
 * Тип сортировки
 */
public enum Sort {

    ACTIVITY("activity"), VOTES("votes"), CREATION("creation"), RELEVANCE("relevance");

    public static final Sort[] ALL = {ACTIVITY, VOTES, CREATION, RELEVANCE};

    private final String name;

    private Sort(final String name) {
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
