package com.app.clientsApp.services;

import com.app.clientsApp.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Map<String, Long> getCountByStatus() {
        List<Object[]> results = clientRepository.countClientsByStatus();
        Map<String, Long> countByStatus = new HashMap<>();
        for (Object[] result : results) {
            String status = (String) result[0];
            Long count = (Long) result[1];
            countByStatus.put(status, count);
        }
        return countByStatus;
    }
}