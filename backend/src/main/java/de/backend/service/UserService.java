package de.backend.service;

import de.backend.model.User;
import de.backend.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public List<User> list(){return userRepo.findAll();}

    public List<User> search(String s) {
        List <User> searchResultList = new ArrayList<>();
        for (User user: list()) {
            if (user.getName().contains(s)){
                searchResultList.add(user);
            }
        }

        return searchResultList;
    }
}
