import { supabase } from "@/lib/supabase";
import { Actor, DbAddActorObject, UpdateActorFormObject } from "@/types/actor";
import { File } from "buffer";

export async function dbGetActors(): Promise<Actor[]> {
    const { data, error } = await supabase.from("actor").select(`
        id,
        description,
        actor_image,
        person(id, first_name, last_name)`);

    if (error !== null) {
        console.error(error);
        throw new Error(error.message);
    }
    if (data === null || data === undefined) {
        throw new Error("Error getting actors");
    }

    const actors: Actor[] = data?.map((actor: any) => {
        const Actor: Actor = {
            id: actor.id,
            description: actor.description,
            actorImage: actor.actor_image,
            person: {
                id: actor.person.id,
                firstName: actor.person.first_name,
                lastName: actor.person.last_name,
            },
        };
        return Actor;
    });
    return actors;
}

export async function dbGetActor(id: number): Promise<Actor | undefined> {
    const { data, error } = await supabase
        .from("actor")
        .select(
            `
            id, 
            description,
            actor_image,
            person(id, first_name, last_name)
        `,
        )
        .eq("id", id)
        .limit(1);

    if (error !== null) {
        console.error(error);
        throw new Error(error.message);
    }
    if (data === undefined) {
        return undefined;
    }
    if (data === null || data.length != 1) {
        return undefined;
    }

    const actor: any = data[0];
    const Actor: Actor = {
        id: actor.id,
        actorImage: actor.actor_image,
        description: actor.description,
        person: {
            id: actor.person.id,
            firstName: actor.person.first_name,
            lastName: actor.person.last_name,
        },
    };

    return Actor;
}

export async function dbAddActor(
    addActorData: DbAddActorObject,
): Promise<Actor> {
    const { data: personData, error: personError } = await supabase
        .from("person")
        .insert([
            {
                first_name: addActorData.firstName,
                last_name: addActorData.lastName,
            },
        ])
        .select();

    if (personError !== null) {
        console.error(personError);
        throw new Error(personError.message);
    }

    if (personData === null || personData.length === 0) {
        throw new Error("Person not added");
    }

    const person = personData[0];

    const { data, error } = await supabase
        .from("actor")
        .insert([
            {
                id: person.id,
                description: addActorData.description,
                actor_image: addActorData.actorImage,
            },
        ])
        .select();

    if (error !== null) {
        console.error(error);
        throw new Error(error.message);
    }

    if (data === null || data.length === 0) {
        throw new Error("Actor not added");
    }

    const actor = data[0];

    return {
        id: actor.id,
        description: actor.description,
        actorImage: actor.actor_image,
        person: {
            id: person.id,
            firstName: person.first_name,
            lastName: person.last_name,
        },
    };
}

export async function dbUpdateActor(
    updateFormData: UpdateActorFormObject,
): Promise<Actor> {
    const { data: personData, error: personError } = await supabase
        .from("person")
        .update({
            first_name: updateFormData.firstName,
            last_name: updateFormData.lastName,
        })
        .eq("id", updateFormData.id)
        .select();

    if (personError !== null || personData === null) {
        throw new Error(personError.message);
    }

    const person = personData[0];

    const { data, error } = await supabase
        .from("actor")
        .update({
            description: updateFormData.description,
            actor_image: updateFormData.actorImage,
        })
        .eq("id", updateFormData.id)
        .select();

    if (error !== null) {
        console.error(error);
        throw new Error(error.message);
    }

    if (data === null || data.length === 0) {
        throw new Error("Actor not updated");
    }

    const actor = data[0];

    return {
        id: actor.id,
        description: actor.description,
        actorImage: actor.actor_image,
        person: {
            id: person.id,
            firstName: person.first_name,
            lastName: person.last_name,
        },
    };
}

export async function dbDeleteActor(
    id: number,
): Promise<void> {
    const { data, error } = await supabase
        .from("actor")
        .delete()
        .eq("id", id)
        .select();
    if (error !== null) {
        throw new Error(error.message);
    }

    const actor = data[0];

    const { data: personData, error: personError } = await supabase
        .from("person")
        .delete()
        .eq("id", actor.id)
        .select();

    if (personError !== null || personData === null) {
        throw new Error(personError.message);
    }
}

export async function uploadActorImage(
    imageName: string,
    image: File,
): Promise<string> {
    const { data: imageData, error: imageError } = await supabase.storage
        .from("theatre-images")
        .upload(`public/actors/${imageName}`, image as any, { upsert: true });

    if (imageError) {
        throw new Error(imageError.message);
    }

    const { data } = supabase.storage
        .from("theatre-images")
        .getPublicUrl(imageData.path);

    return data.publicUrl;
}
