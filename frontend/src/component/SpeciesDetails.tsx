import useSpecies from "../hooks/useSpecies";
import {useParams} from "react-router-dom";

export default function SpeciesDetails(){

    const parameters = useParams()

    const id:string | undefined = parameters.id

    const {species} = useSpecies(id);

    if (!species) {
        return (
            <p>Loading species...</p>
        )
    }

    return (
        <div>
            <p>Details for species</p>
            {!species && <p>Loading Species inner brackets...</p>}
            {<div>
                <p>{species.name}</p>
                <p>{species.id}</p>
                <p>{species.waterDemand}</p>
                <p>{species.fertilizerDemand}</p>
                <p>{species.habitat}</p>
                <p>{species.soil}</p>
                <button>Edit</button>
            </div>}
        </div>
    )
}