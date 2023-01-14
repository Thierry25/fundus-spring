package com.thierry.fundus.services;

import com.thierry.fundus.models.Request;
import com.thierry.fundus.models.User;
import org.springframework.stereotype.Service;

@Service
public class RequestService {

    private final RequestDao requestDao;

    public RequestService(RequestDao requestDao){
        this.requestDao = requestDao;
    }

    public Request createNewRequest(User user, Request request){
        request.setUser(user);
        return requestDao.save(request);
    }
}
