package de.backend.service;

import de.backend.model.Plant;
import de.backend.model.User;
import de.backend.repo.UserRepo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.mockito.Mockito.*;

class UserServiceTest {

    private final IdService idService = mock(IdService.class);
    private final UserRepo userRepo =mock(UserRepo.class);
    List<Plant> plantList = new ArrayList<>();

    @Test
    void should_Add_With_Random_Id() {
        //GIVEN
        User userToAdd = new User(null, "Morten",plantList);
        User addedUser = new User("k0Lj4", "Skinny",plantList);

        when(idService.generateId()).thenReturn("k0lj4");
        when(userRepo.save(addedUser)).thenReturn(addedUser);
        //UserService userService = new UserService(userRepo, idService);
        //WHEN
        //User result = userService.addUser(userToAdd);
        //THEN TODO redo test
        // assertThat(result, is(userToAdd));  TODO assert why not running w assertThat...
        verify(userRepo).save(userToAdd);
    }

    @Test
    void should_Return_User_List () {
        //GIVEN
        User user1 = new User("1", "Justus", plantList);
        User user2 = new User("2", "Peter", plantList);
        User user3 = new User("3", "Bob",plantList );
        when(userRepo.findAll()).thenReturn(
                List.of(
                        user1,
                        user2,
                        user3
                )
        );
        UserService userService = new UserService(userRepo, idService);
        //WHEN
        List<User> actual = userService.list();
        //THEN
        assertThat(actual, containsInAnyOrder(
                user1,
                user2,
                user3
        ));
    }

    @Test
    void search_Should_Return_User() {
        //GIVEN
        User user;
        when(userRepo.findAll()).thenReturn(
                List.of(
                        user = new User("1", "Justus",plantList),
                        new User("2", "Peter", plantList),
                        new User("3", "Bob",plantList )
                )
        );
        UserService userService = new UserService(userRepo, idService);
        //WHEN
        List<User> actual = userService.search("Just");
        //THEN
        assertThat(actual, containsInAnyOrder(
                user
        ));
    }
}