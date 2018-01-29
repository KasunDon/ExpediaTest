package com.expedia.flightsearch.infrastructure.gson;

import com.expedia.flightsearch.domain.entity.Flight;
import com.expedia.flightsearch.domain.parser.StringToLocalTimeParser;
import com.expedia.flightsearch.library.serialization.Deserializer;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import net.dongliu.gson.GsonJava8TypeAdapterFactory;

import java.lang.reflect.Type;
import java.time.LocalTime;
import java.util.List;

public class FlightDataDeserializer implements Deserializer<String, List<Flight>> {

    private static final Gson GSON =
        new GsonBuilder()
            .registerTypeAdapterFactory(new GsonJava8TypeAdapterFactory())
            .setFieldNamingStrategy(field -> {

                    if (field.getName().equals("carrier")) {
                        return "flight";
                    }

                    return
                        FieldNamingPolicy
                            .LOWER_CASE_WITH_UNDERSCORES
                            .translateName(field);
                }
            )
            .registerTypeAdapter(
                LocalTime.class,
                (JsonDeserializer<LocalTime>) (e, t, c) ->
                    new StringToLocalTimeParser()
                        .parse(e.getAsString())
            )
            .create();

    public List<Flight> deserialize(String source) {

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject) jsonParser.parse(source);

        Type flightType = new TypeToken<List<Flight>>() {
        }.getType();

        return GSON.fromJson(jsonObject.get("flights"), flightType);
    }
}
