import {NewUser} from "../model/User";
import {ChangeEvent, useState} from "react";

type AddUserProps = {
    addUser: (newUser: NewUser) => Promise<any>
}

export default function AddUser(props: AddUserProps){

    const [username, setUsername] = useState<string>("");

    function onUsernameChange(event: ChangeEvent<HTMLInputElement>) {
        setUsername(event.target.value)
    }
    function onClickSave(){
        props.addUser({name: username,plants:[]})
            .then(() => {
                setUsername("");
            })
        console.log(props.addUser)
    }

    return (
        <div>
            <input type={"text"} placeholder={"Username"} value={username} onChange={onUsernameChange}/>
            <button onClick={onClickSave}>Save new User</button>
        </div>
    )
}