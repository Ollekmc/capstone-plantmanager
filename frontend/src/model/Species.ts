export enum Habitat {
    Sunny,
    Shaded,
    Semishaded
}


export type Species = {
    id: string;
    name: string;
    waterDemand: number;
    fertilizerDemand: number;
    habitat: Habitat;
    soil: number
}

export type NewSpecies = {
    name: string;
    waterDemand: number;
    fertilizerDemand: number;
    habitat: Habitat;
    soil: number;

}