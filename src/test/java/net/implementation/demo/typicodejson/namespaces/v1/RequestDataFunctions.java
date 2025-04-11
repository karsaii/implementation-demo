package net.implementation.demo.typicodejson.namespaces.v1;

import com.neathorium.thorium.java.extensions.namespaces.predicates.NullablePredicates;
import net.implementation.demo.typicodejson.records.RequestData;

public interface RequestDataFunctions {
    static String getUri(RequestData data) {
        return NullablePredicates.isNotNull(data) ? data.URL() + data.ENDPOINT() : "";
    }
}
