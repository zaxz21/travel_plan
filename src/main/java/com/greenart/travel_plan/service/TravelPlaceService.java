package com.greenart.travel_plan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.greenart.travel_plan.entity.TravelPlaceEntity;
import com.greenart.travel_plan.repository.TravelPlaceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelPlaceService {
    private final TravelPlaceRepository travelPlaceRepository;
    public List<TravelPlaceEntity> getTravlePlace (Integer tptype) {
        List<TravelPlaceEntity> list = new ArrayList<TravelPlaceEntity>();
        if(tptype == null) {
            list = travelPlaceRepository.findAll();
        }
        else{
            list = travelPlaceRepository.findByTpType(tptype);
        }
        return list;
    }
    
}
