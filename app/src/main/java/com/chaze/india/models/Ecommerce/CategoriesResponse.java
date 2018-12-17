
package com.chaze.india.models.Ecommerce;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class CategoriesResponse {

    @Expose
    private List<Child> results;
    @Expose
    private Boolean succes;

    public List<Child> getResults() {
        return results;
    }

    public void setResults(List<Child> results) {
        this.results = results;
    }

    public Boolean getSucces() {
        return succes;
    }

    public void setSucces(Boolean succes) {
        this.succes = succes;
    }

}
