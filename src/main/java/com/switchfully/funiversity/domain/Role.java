package com.switchfully.funiversity.domain;

import com.switchfully.funiversity.domain.Feature;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static com.switchfully.funiversity.domain.Feature.*;

public enum Role {
    PRESIDENT(newArrayList(
            GET_ALL_PROFESSORS,
            UPDATE_PROFESSOR,
            DELETE_A_PROFESSOR,
            GET_A_PROFESSOR
    )),
    DIRECTOR(newArrayList(
            GET_ALL_PROFESSORS
    )),
    PROFESSOR(newArrayList(
            GET_ALL_PROFESSORS,
            UPDATE_PROFESSOR,
            DELETE_A_PROFESSOR,
            GET_A_PROFESSOR
    ));
    private final List<Feature> featureList;

    Role(List<Feature> featureList) {
        this.featureList = featureList;
    }
    public boolean canAccess(Feature feature){
        return featureList.contains(feature);
    }
}
