import {useEffect, useState} from "react";
import {User} from "../model/User";
import axios from "axios";

function  useUser(id: string | undefined) {
    const [user, setUser] = useState<User>()

    useEffect(() => {
        if (id) {
            getUserById(id)
        }
        //eslint-disable-next-line
    },[])

    function getUserById(id: string) {
        axios.get("/api/users/"+id)
            .then(response => response.data)
            .then(data => {
                setUser(data)
            })
            .catch(console.error)
    }
    return {user}
}
export default useUser;