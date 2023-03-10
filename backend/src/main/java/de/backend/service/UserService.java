package de.backend.service;

import de.backend.model.User;
import de.backend.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final IdService idService;

    @Autowired
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

    public User findById(String id) {
        Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        throw new IllegalArgumentException("Id not found!");
    }

    public void delete(String id) {
        User user = findById(id);
        userRepo.delete(user);
    }
}
