import useUsers from "../hooks/useUsers";
import AddUser from "./AddUser";

export default function UserApp(){

    const {addUser} = useUsers()

    return (
        <div>
            <h2>UserApp</h2>
            <AddUser addUser={addUser}/>
        </div>
    )
}