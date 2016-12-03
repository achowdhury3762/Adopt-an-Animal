package nyc.c4q.ashiquechowdhury.adoptme.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ashiquechowdhury on 11/30/16.
 */
public class Photos {
    private List<Photo> photo = new ArrayList<Photo>();

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    public List<Photo> getPhoto() {
        return photo;
    }

    public void setPhoto(List<Photo> photo) {
        this.photo = photo;
    }

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
