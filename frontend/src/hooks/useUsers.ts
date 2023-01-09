import {NewUser, User} from "../model/User";
import axios from "axios";
import {useState} from "react";

export default function useUsers() {

    const [users, setUser] = useState<User[]>([])

    function addUser(newUser: NewUser) {
        console.log(newUser)
        return axios.post("/api/users", newUser)
            .then(response => response.data)
            .then((savedUser) => setUser(prevState => [...prevState, savedUser]))
            .catch(console.error);
    }
    return {users, addUser}
}