import {Species} from "../model/Species";

type SpeciesCardProps = {
    species: Species
}

export default function SpeciesCard (props: SpeciesCardProps) {
    return (
        <div>
            <p className={"species-card__name"}>{props.species.name}</p>
            <p><button>Edit</button></p>
        </div>
    )
}