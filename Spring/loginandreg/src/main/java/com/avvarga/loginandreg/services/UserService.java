package com.avvarga.loginandreg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.avvarga.loginandreg.models.Role;
import com.avvarga.loginandreg.models.User;
import com.avvarga.loginandreg.repositories.RoleRepository;
import com.avvarga.loginandreg.repositories.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder)     {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    
    // 1
    public void saveWithUserRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_USER"));
        userRepository.save(user);
    }
     
     // 2 
    public void saveUserWithAdminRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
        userRepository.save(user);
    }   
    
    public void setAdmin(User user) {
    	user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
    	userRepository.save(user);
    }    
    
    // 3
    public User findByUsername(String email) {
        return userRepository.findByEmail(email);
    }


	public List<User> findAll() {
		return userRepository.findAll();
	}


	public List<Role> findRoleByName(String string) {
		return roleRepository.findByName(string);
	}

	public List <User> findUserByRole (String string){
		return userRepository.findByRole(string);
	}

	public void updateLastLogin(User user) {
		userRepository.save(user);
	}


	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}


	public User findById(Long id) {
		Optional <User> o = userRepository.findById(id);
		userRepository.save(o.get());
		return o.get();
	}
}
