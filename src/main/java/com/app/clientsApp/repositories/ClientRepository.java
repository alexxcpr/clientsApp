package com.app.clientsApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.app.clientsApp.models.Client;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    Client findByEmail(String email);

    @Query("SELECT c.status, COUNT(c) FROM Client c GROUP BY c.status")
    List<Object[]> countClientsByStatus();
}