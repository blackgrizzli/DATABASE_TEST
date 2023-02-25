package org.example.JdbcTypeCode_JSON;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Map;

@Entity
public class UserMapJson {
    @jakarta.persistence.Id

    private int Id;
    private String nameMap;
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String,Integer> map;

    public UserMapJson(String nameMap, Map<String, Integer> map) {
        this.nameMap = nameMap;
        this.map = map;
    }

    public UserMapJson() {

    }
}
