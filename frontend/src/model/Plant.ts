import {Species} from "./Species";

export type Plant ={
    id: string,
    name: string,
    species: Species,
    date: Date,
    height: number
}

export type NewPlant = {
    name: string,
    species: Species,
    date: Date,
    height: number
}