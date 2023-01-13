import {useParams} from "react-router-dom";
import useUser from "../hooks/useUser";

export default function UserDetails(){

    const parameters = useParams()

    const id:string | undefined = parameters.id

    const {user} = useUser(id);

    if (!user) {
        return (
            <p>Loading user...</p>
        )
    }

    return (
        <div>
            <p>Details for user</p>
            {!user && <p>Loading Species inner brackets...</p>}
            {<div>
                <p>{user.name}</p>
                <p>{user.id}</p>
                <p>{user.plants.length} plants are owned by this user</p>
            </div>}
        </div>
    )
}