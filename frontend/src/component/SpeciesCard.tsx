import {Species} from "../model/Species";
import {useNavigate} from "react-router-dom";

type SpeciesCardProps = {
    species: Species
    removeSpecies: (id:string) => void
}

export default function SpeciesCard (props: SpeciesCardProps) {

    const navigate = useNavigate();

    function onDetailsClick() {
        navigate("/plants/"+props.species.id)
    }
    function handleDelete(){
        props.removeSpecies(props.species.id)
    }

    return (
        <div className={"species-card"}>
            <p className={"species-card__name"}>{props.species.name}</p>
            <p><button onClick={handleDelete}>Delete</button></p>
            <p><button onClick={onDetailsClick}>Details</button></p>
        </div>
    )
}