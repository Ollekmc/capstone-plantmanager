package de.backend.service;

import de.backend.model.User;
import de.backend.repo.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;

    private final IdService idService;

    public UserService(UserRepo userRepo, IdService idService) {
        this.userRepo = userRepo;
        this.idService = idService;
    }
    public User addUser(User user) {
        user.setId(idService.generateId());
        return userRepo.save(user);
    }
}
