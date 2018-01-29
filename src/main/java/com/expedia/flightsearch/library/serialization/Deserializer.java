package com.expedia.flightsearch.library.serialization;

public interface Deserializer<S, T> {

    T deserialize(
        S source
    );
}
