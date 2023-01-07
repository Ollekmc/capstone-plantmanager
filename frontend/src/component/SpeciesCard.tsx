import {Species} from "../model/Species";

type SpeciesCardProps = {
    species: Species
}

export default function SpeciesCard (props: SpeciesCardProps) {
    return (
        <div>
            <p className={"species-card__name"}>{props.species.name}</p>
            <p><button>Details</button><button>Delete</button></p>
        </div>
    )
}