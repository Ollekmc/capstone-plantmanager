import {User} from "../model/User";
import {ChangeEvent, useState} from "react";
import UserCard from "./UserCard";

type UserGalleryProps = {
    users: User[]
    removeUser: (id:string) => void
}

export default function UserGallery(props: UserGalleryProps){
    const [searchText, setSearchText] = useState<string>("")

    const filteredUsers: User[] = props.users.filter(user => user.name.toLowerCase().includes(searchText.toLowerCase()))

    function onSearchChange(event: ChangeEvent<HTMLInputElement>) {
        setSearchText(event.target.value)
    }
    return (
        <div>
            <input className={"user-gallery__search"} placeholder={"Search"} value={searchText} onChange={onSearchChange}/>

            <div className={"user-gallery"}>
                {filteredUsers.map(user => <UserCard user={user} key={user.id} removeUser={props.removeUser}/>)}

            </div>
        </div>
    )

}