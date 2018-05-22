package com.avvarga.events.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.avvarga.events.models.User;
import com.avvarga.events.repositories.UserRepository;

@Component
public class UserValidator implements Validator {
    
	private final UserRepository userRepo;
	public UserValidator(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
    //    1
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
    
    // 2
    @Override
    public void validate(Object object, Errors errors) {
        User user = (User) object;
        
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            // 3
            errors.rejectValue("passwordConfirmation", "Match");
        }
        User user2 = userRepo.findByEmail(user.getEmail());
        if (user2 != null) {
        	errors.rejectValue("email", "Unique");
        }
    }
}
