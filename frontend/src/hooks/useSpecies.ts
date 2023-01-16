import {useEffect, useState} from "react";
import {Species} from "../model/Species";
import axios from "axios";

function  useSpecies(id: string | undefined) {
    const [species, setSpecies] = useState<Species>()

    useEffect(() => {
        if (id) {
            getSpeciesById(id)
        }
        //eslint-disable-next-line
    },[])

    function getSpeciesById(id: string) {
        axios.get("/api/plants/"+id)
            .then(response => response.data)
            .then(data => {
                setSpecies(data)
            })
            .catch(console.error)
    }
    return {species}
}
export default useSpecies;