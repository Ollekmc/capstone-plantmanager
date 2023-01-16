package de.backend.service;

import de.backend.model.*;
import de.backend.repo.UserRepo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserServiceTest {

    private final IdService idService = mock(IdService.class);
    private final UserRepo userRepo =mock(UserRepo.class);
    List<Plant> plantList = new ArrayList<>();


    @Test
    void shouldAddUser() {
        //GIVEN
        User userToAdd = new User("1","TestName",plantList);
        when(userRepo.save(userToAdd)).thenReturn(userToAdd);
        UserService userService = new UserService(userRepo,idService);
        //WHEN
        User result = userService.addUser(userToAdd);
        //THEN
        assertEquals(result, userToAdd);
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
    @Test
    void should_Return_User_By_Id() {
        //GIVEN
        User user = new User("1","TestName",plantList);
        when(userRepo.findById("1")).thenReturn(Optional.of(user));
        UserService userService = new UserService(userRepo,idService);


        //WHEN
        User result = userService.findById("1");

        //THEN
        assertThat(result, is(user));
    }
    @Test
    void should_Delete_User_By_Id() {
        //GIVEN
        User user = new User("1","TestName", plantList);
        when(userRepo.findById("1")).thenReturn(Optional.of(user));
        UserService userService = new UserService(userRepo,idService);
        //WHEN
        userService.delete("1");
        //THEN
        verify(userRepo).delete(user);
    }
}