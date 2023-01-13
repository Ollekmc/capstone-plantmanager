import useUsers from "../hooks/useUsers";
import AddUser from "./AddUser";
import UserGallery from "./UserGallery";

export default function UserApp(){

    const {users, addUser,removeUser} = useUsers()

    return (
        <div>
            <h2>UserApp</h2>
            <AddUser addUser={addUser}/>
            <UserGallery users={users} removeUser={removeUser}/>
        </div>
    )
}