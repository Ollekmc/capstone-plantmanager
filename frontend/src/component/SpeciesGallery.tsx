import {Species} from "../model/Species";
import {ChangeEvent, useState} from "react";
import SpeciesCard from "./SpeciesCard";

type SpeciesGalleryProps = {
    speciesPlural: Species[]
    removeSpecies: (id:string) => void
}

export default function SpeciesGallery(props: SpeciesGalleryProps){

    const [searchText, setSearchText] = useState<string>("")

    const filteredSpeciesPlural: Species[] = props.speciesPlural.filter(species => species.name.toLowerCase().includes(searchText.toLowerCase()))

    function onSearchChange(event: ChangeEvent<HTMLInputElement>) {
        setSearchText(event.target.value)
    }

    return (
        <div>
            <input className={"species-gallery__search"} placeholder={"Search"} value={searchText} onChange={onSearchChange}/>

            <div className={"species-gallery"}>
                {filteredSpeciesPlural.map(species => <SpeciesCard species={species} key={species.id} removeSpecies={props.removeSpecies}/>)}

            </div>
        </div>
    )
}