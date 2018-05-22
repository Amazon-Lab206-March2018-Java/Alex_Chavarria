package com.avvarga.finalproject.services;

import org.springframework.stereotype.Service;

import com.avvarga.finalproject.repositories.RoleRepository;

@Service
public class RoleService {

	@SuppressWarnings("unused")
	private RoleRepository rRepo;
	public RoleService (RoleRepository rRepo) {
		this.rRepo = rRepo;
	}
}
