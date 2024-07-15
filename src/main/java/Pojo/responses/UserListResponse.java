package Pojo.responses;

import Pojo.RestResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@lombok.Data
public class UserListResponse implements RestResponse {

    private int page;
    @JsonProperty("per_page")
    private int perPage;
    private int total;
    private int total_pages;

    private List<Data> data;

    private Support support;

}
