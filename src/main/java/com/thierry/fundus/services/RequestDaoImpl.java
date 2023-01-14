package com.thierry.fundus.services;

import com.thierry.fundus.models.Request;
import com.thierry.fundus.repositories.RequestRepository;
import org.springframework.stereotype.Component;

@Component
public class RequestDaoImpl implements RequestDao {

    private final RequestRepository requestRepo;

    public RequestDaoImpl(RequestRepository requestRepo){
        this.requestRepo = requestRepo;
    }

    @Override
    public Request save(Request request) {
        return requestRepo.save(request);
    }
}
