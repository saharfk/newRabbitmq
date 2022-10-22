package com.example.newrabbit;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuOrder implements Serializable {
    private static final long serialVersionUID = -1138446817700416884L;
    @JsonProperty
    private String orderIdentifier;

    @Override
    public String toString() {
        return "MenuOrder{" +
                "orderIdentifier='" + orderIdentifier + '\'' +
                '}';
    }
}