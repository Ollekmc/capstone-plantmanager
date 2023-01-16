import useUsers from "../hooks/useUsers";
import AddUser from "./AddUser";
import UserGallery from "./UserGallery";

export default function UserApp(){

    const {users, addUser,deleteUser} = useUsers()

    return (
        <div>
            <h2>UserApp</h2>
            <AddUser addUser={addUser}/>
            <UserGallery users={users} deleteUser={deleteUser}/>
        </div>
    )
}
