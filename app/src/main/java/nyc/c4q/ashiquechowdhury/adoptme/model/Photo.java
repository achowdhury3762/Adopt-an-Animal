package nyc.c4q.ashiquechowdhury.adoptme.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ashiquechowdhury on 11/30/16.
 */
public class Photo {
    private String size;
    private String $t;
    private String id;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String get$t() {
        return $t;
    }

    public void set$t(String $t) {
        this.$t = $t;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}

