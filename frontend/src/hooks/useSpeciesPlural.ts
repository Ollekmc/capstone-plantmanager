import {NewSpecies, Species} from "../model/Species";
import axios from "axios";
import {useEffect, useState} from "react";

export default  function useSpeciesPlural() {

    const [speciesPlural, setSpeciesPlural] = useState<Species[]>([])

    useEffect(() => {
        getSpeciesPlural()
    },[])

    function getSpeciesPlural(){
        axios.get("api/plants")
            .then(response => {
                setSpeciesPlural(response.data)
            })
            .catch(console.error)
    }

    function addSpecies(newSpecies: NewSpecies) {
        console.log(newSpecies)
        return axios.post("/api/plants", newSpecies)
            .then(response => response.data)
            .then((savedSpecies) => setSpeciesPlural(prevState => [...prevState, savedSpecies]))
            .catch(console.error);

    }
    function removeSpecies(id: string) {
        axios.delete(`/api/plants/${id}`)
            .then(() => {
                setSpeciesPlural(prevState => {
                    return prevState.filter((species) => species.id !==id
                    )
                })
            })
    }
    return {speciesPlural , addSpecies, removeSpecies}
}