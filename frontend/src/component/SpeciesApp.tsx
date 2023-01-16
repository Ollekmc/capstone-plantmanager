import useSpeciesPlural from "../hooks/useSpeciesPlural";
import AddSpecies from "./AddSpecies";
import SpeciesGallery from "./SpeciesGallery";

export default function SpeciesApp(){
    const {speciesPlural, addSpecies, removeSpecies} = useSpeciesPlural()

    return (
        <div>
            <h2>SpeciesApp</h2>
            <AddSpecies addSpecies={addSpecies}/>
            <SpeciesGallery speciesPlural={speciesPlural} removeSpecies={removeSpecies}/>
        </div>
    )
}