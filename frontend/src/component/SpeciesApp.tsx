import useSpecies from "../hooks/useSpecies";
import AddSpecies from "./AddSpecies";

export default function SpeciesApp(){
    const {addSpecies} = useSpecies()

    return (
        <div>
            <AddSpecies addSpecies={addSpecies}/>
        </div>
    )
}