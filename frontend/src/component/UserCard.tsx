import {User} from "../model/User";
import './UserCard.css'
import {useNavigate} from "react-router-dom";

type UserCardProps = {
    user: User
    deleteUser: (id:string) => void
}

export default function UserCard(props: UserCardProps) {

    const navigate = useNavigate();

    function handleDetailsClick() {
        navigate("/users/"+props.user.id)
    }
    function handleDelete(){
        props.deleteUser(props.user.id)
    }

    return (
        <div className={"user-card"}>
            <p className={"user-card__name"}>{props.user.name}</p><br/>
            <div className={"user-card__buttons"}><br/>
                <button className={"unused-button"}>Edit</button>
                <button className={"used-button"} onClick={handleDelete}>Delete</button>
                <button className={"used-button"} onClick={handleDetailsClick}>Details</button>
            </div>
        </div>
    )
}
