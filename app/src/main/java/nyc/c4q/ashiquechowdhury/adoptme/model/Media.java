package nyc.c4q.ashiquechowdhury.adoptme.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ashiquechowdhury on 11/30/16.
 */
public class Media {
    private Photos photos;

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;

    }

    public Photos getPhotos() {
        return photos;
    }

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
