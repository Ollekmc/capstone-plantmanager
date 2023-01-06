import {Habitat, NewSpecies} from "../model/Species";
import {ChangeEvent, useState} from "react";

type AddSpeciesProps = {
    addSpecies: (newSpecies: NewSpecies) => Promise<any>;
}

export default function AddSpecies(props: AddSpeciesProps) {

    const [name, setName] = useState<string>("");
    const [waterDemand, setWaterDemand] = useState<number>(5);
    const [fertilizerDemand, setFertilizerDemand] = useState<number>(5);
    const [habitat, setHabitat] = useState<number>(1);
    const [soil, setSoil] = useState<number>(1);

    function onNameChange(event: ChangeEvent<HTMLInputElement>) {
        setName(event.target.value)
    }
    function onWaterDemandChange(event: ChangeEvent<HTMLInputElement>){
        setWaterDemand(parseInt(event.target.value))
    }
    function onFertilizerDemandChange(event: ChangeEvent<HTMLInputElement>){
        setFertilizerDemand(parseInt(event.target.value))
    }
    function onHabitatChange(event: ChangeEvent<HTMLSelectElement>){
        setHabitat(parseInt(event.target.value))
    }
    function onSoilChange(event: ChangeEvent<HTMLSelectElement>){
        setSoil(parseInt(event.target.value))
    }
    function onClickSave(){
        props.addSpecies({name: name,waterDemand: waterDemand,fertilizerDemand: fertilizerDemand,habitat: Habitat.Semishaded,soil:soil})
            .then(() => {
                setName("");
                setWaterDemand(5);
                setFertilizerDemand(5);
                setHabitat(0);
                setSoil(0)
            })
        console.log(props.addSpecies)
    }

    return (
        <div>
            <input type={"text"} placeholder={"Name"} value={name} onChange={onNameChange}/><p/>
            <label htmlFor={"waterDemand"}>Water demand</label>
            <input id={"waterDemand"} type={"range"} min={0} max={10} step={1} defaultValue={5} onChange={onWaterDemandChange}/><p/>
            <label htmlFor={"fertilizerDemand"}>Fertilizer demand</label>
            <input id={"fertilizerDemand"} type={"range"} min={0} max={10} step={1} defaultValue={5} onChange={onFertilizerDemandChange}/><p/>
                <label htmlFor="habitat_type">Habitat Type:</label>
                <select id="habitat_type" name="habitat_type" value={habitat} onChange={onHabitatChange}>
                        <option placeholder={"SUNNY"} value={0} >Sunny</option>
                        <option placeholder={"SHADED"} value={1} >Shaded</option>
                        <option placeholder={"SEMISHADED"} value={2} >Semishaded</option>
                </select><p/>
                <label htmlFor="soil_type">Soil Type:</label>
                <select id="soil_type" name="soil_type" value={soil} onChange={onSoilChange}>
                    <option placeholder={"SANDY"} value={0} >Sandy</option>
                    <option placeholder={"HUMIC"} value={1} >Humic</option>
                    <option placeholder={"CLAYEY"} value={2} >Clayey</option>
                    <option placeholder={"SILTY"} value={2} >Silty</option>
                </select><p/>
                <button onClick={onClickSave}>Save new species</button>
        </div>
    )
}

// TODO Reset Range to default after Submit