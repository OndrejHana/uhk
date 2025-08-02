import { dbGetActor } from "@/db-handler/db-actors";
import { dbGetCastingsForActor } from "@/db-handler/db-casting";
import { EventCard } from "../../event-list";
import Image from "next/image";

export const dynamic = "force-dynamic"

export default async function Page({ params }: { params: { slug: string } }) {
    const actor = await dbGetActor(parseInt(params.slug));

    if (!actor) {
        return (
            <h1 className="text-center text-4xl font-bold text-primary">
                Herec nebyl nalezen
            </h1>
        );
    }

    const actorsCastings = await dbGetCastingsForActor(actor.id);

    return (
        <div className="flex h-full w-full flex-col">
            <div className="flex w-full">
                <div className="h-96 w-full bg-muted relative max-w-96">
                    {actor.actorImage && (
                        <Image
                            src={actor.actorImage}
                            width={512}
                            height={384}
                            className="object-cover object-center w-full h-full"
                            alt="Actor image"
                        />
                    )}
                </div>
                <div className="flex flex-col gap-4 p-4">
                    <h1 className="text-4xl font-bold text-primary">
                        {actor.person.firstName} {actor.person.lastName}
                    </h1>
                    <p>{actor.description}</p>
                </div>
            </div>
            <div className="flex w-full flex-col gap-8 bg-secondary p-8">
                <h2 className="text-2xl font-bold text-primary-foreground">
                    V čem právě hraje
                </h2>
                <div className="flex gap-8 overflow-x-auto">
                    {actorsCastings.map((casting) => (
                        <EventCard
                            key={casting.event.id}
                            event={casting.event}
                        />
                    ))}
                </div>
            </div>
        </div>
    );
}
