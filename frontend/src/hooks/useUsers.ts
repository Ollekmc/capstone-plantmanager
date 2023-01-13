import {NewUser, User} from "../model/User";
import axios from "axios";
import {useEffect, useState} from "react";

export default function useUsers() {

    const [users, setUsers] = useState<User[]>([])

    useEffect(() => {
        getUsers()
    },[])

    function getUsers(){
    axios.get("api/users")
        .then(response => {
            setUsers(response.data)
        })
        .catch(console.error)
    }

    function addUser(newUser: NewUser) {
        console.log(newUser)
        return axios.post("/api/users", newUser)
            .then(response => response.data)
            .then((savedUser) => setUsers(prevState => [...prevState, savedUser]))
            .catch(console.error);
    }
    function removeUser(id: string) {
        axios.delete(`/api/users/${id}`)
            .then(() => {
                setUsers(prevState => {
                    return prevState.filter((user) => user.id !==id
                    )
                })
            })
    }
    return {users, addUser, removeUser}
}