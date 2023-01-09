import {Plant} from "./Plant";

export type User = {
    id: string,
    name: string,
    plants: Plant[]
}

export type NewUser = {
    name: string,
    plants: Plant[]
}