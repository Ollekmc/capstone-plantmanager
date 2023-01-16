import {NavLink} from "react-router-dom";


export default function NavBar() {

    return (
        <div>
            <NavLink to={"/"} >Startseite</NavLink>
            <NavLink to={"/plants"} >SpeciesGallery</NavLink>
            <NavLink to={"/users"} >Users</NavLink>
        </div>
    )
}
