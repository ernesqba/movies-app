package uah.es.securityapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import uah.es.securityapi.model.Role;

public interface IRolesJPA extends JpaRepository<Role, Integer> {
}