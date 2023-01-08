import useSpecies from "../hooks/useSpecies";
import AddSpecies from "./AddSpecies";
import SpeciesGallery from "./SpeciesGallery";

export default function SpeciesApp(){
    const {speciesPlural, addSpecies} = useSpecies()

    return (
        <div>
            <AddSpecies addSpecies={addSpecies}/>
            <SpeciesGallery speciesPlural={speciesPlural}/>
        </div>
    )
}