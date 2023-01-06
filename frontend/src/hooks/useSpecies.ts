import {NewSpecies, Species} from "../model/Species";
import axios from "axios";
import {useState} from "react";

export default  function useSpecies() {

    const [species, setSpecies] = useState<Species[]>([])

    function addSpecies(newSpecies: NewSpecies) {
        console.log(newSpecies)
        return axios.post("/api/plants", newSpecies)
            .then(response => response.data)
            .then((savedSpecies) => setSpecies(prevState => [...prevState, savedSpecies]))
            .catch(console.error);

    }
    return {addSpecies}
}