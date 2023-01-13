import {User} from "../model/User";

type UserCardProps = {
    user: User
}

export default function UserCard(props: UserCardProps) {
    return (
        <div>
            <p className={"user-card__name"}>{props.user.name}</p>
        </div>
    )
}