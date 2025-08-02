import { dbGetActors } from "@/db-handler/db-actors";
import { Actor } from "@/types/actor";
import Link from "next/link";
import Image from "next/image";

function Card({ actor }: { actor: Actor }) {
    return (
        <div className="relative h-64 min-w-48">
            {actor.actorImage ? (
                <Image
                    src={actor.actorImage}
                    width={192}
                    height={256}
                    className="object-cover object-center w-full h-full"
                    alt="actor"
                />
            ) : (
                <div className="h-full w-full bg-muted" />
            )}
            <div className="absolute left-0 top-0 flex h-full w-full flex-col items-center justify-end">
                <div className="flex w-full flex-col px-12 py-4 text-2xl font-bold text-primary bg-white bg-opacity-40 backdrop-blur">
                    <p className="text-left">{actor.person.firstName}</p>
                    <p className="text-right">{actor.person.lastName}</p>
                </div>
            </div>
        </div>
    );
}

export default async function MainPageActorList() {
    const actors = await dbGetActors();

    return (
        <div className="flex h-full w-full flex-col gap-8 bg-secondary px-2 py-8 text-secondary-foreground lg:px-16">
            <h2 className="text-2xl font-bold ">Naši herci</h2>
            <div className="flex gap-4 overflow-x-auto">
                {actors.map((actor) => (
                    <Link href={`/actors/${actor.id}`} key={actor.id} passHref>
                        <Card actor={actor} />
                    </Link>
                ))}
            </div>
        </div>
    );
}
