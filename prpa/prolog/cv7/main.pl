cislice(1).
cislice(2).
cislice(3).
cislice(4).
cislice(5).
cislice(6).

muz("Hektor").
muz("Jiri").
muz("Josef").
muz("Petr").
muz("Tomas").
muz("Jan").
muz("Karel").
muz("Franta").

zena("Romana").
zena("Sylva").
zena("Sarka").
zena("Vera").
zena("Petra").
zena("Julie").
zena("Iveta").
zena("Michala").
zena("Jana").
zena("Anna").

rodice("Karel", "Jana", "Jan").
rodice("Karel", "Jana", "Michala").
rodice("Jan", "Sarka", "Franta").
rodice("Jan", "Sarka", "Tomas").
rodice("Josef", "Michala", "Iveta").
rodice("Josef", "Michala", "Anna").
rodice("Franta", "Sylva", "Romana").
rodice("Tomas", "Petra", "Vera").
rodice("Petr", "Iveta", "Julie").
rodice("Jiri", "Anna", "Hektor").

% otec(Otec, Potomek).
otec(Otec, Potomek) :- rodice(Otec, _, Potomek).

% matka(Matka, Potomek).
matka(Matka, Potomek) :- rodice(_, Matka, Potomek).

%rodic(Rodic, Potomek).
rodic(Rodic, Potomek) :- rodice(Rodic, _, Potomek).
rodic(Rodic, Potomek) :- rodice(_, Rodic, Potomek).

% syn(Syn, Rodic).
syn(Syn, Rodic) :- rodic(Rodic, Syn),muz(Syn).

% dcera(Dcera, Rodic).
dcera(Dcera, Rodic) :- rodic(Rodic, Dcera), zena(Dcera).

%sourozenec(S1, S2).
sourozenec(S1, S2) :-
    rodice(Otec, Matka, S1),
    rodice(Otec, Matka, S2),
    S1 \= S2.

%predek(Predek, Osoba).
predek(Predek, Osoba) :-
    rodic(Predek, Osoba).
predek(Predek, Osoba) :-
    rodic(Rodic, Osoba),
    predek(Predek, Rodic).

%potomek(Potomek, Predek).
potomek(Potomek, Predek) :- predek(Predek, Potomek).

%osoba(Osoba).
osoba(Osoba) :- muz(Osoba).
osoba(Osoba) :- zena(Osoba).

vypis_predky :- read(O), predek(P, O), write(P), nl, fail.
vypis_predky.

vypis_muze :- muz(M), write(M), nl, fail.
vypis_muze.

arit_prumer :- 
    read(A),
    read(B),
    C is A+B,
    D is C/2,
    write(D).

fac(A, 1) :- A < 1.
fac(In, Out) :-
    In > 0,
    In_1 is In - 1,
    fac(In_1, Out_1),
    Out is In * Out_1.

% Trojuhelnik.

trojuhelnik(A,B,C,D,E,F) :-
    cislice(A),
    cislice(B),
    cislice(C),
    cislice(D),
    cislice(E),
    cislice(F),
    T1 is A + B + C,
    T2 is A + F + E,
    T3 is C + D + E,
    T1 == T2,
    T1 == T3,
    A \= B,
    A \= C,
    A \= D,
    A \= E,
    A \= F,
    B \= A,
    B \= C,
    B \= D,
    B \= E,
    B \= F,
    C \= A,
    C \= B,
    C \= D,
    C \= E,
    C \= F,
    D \= A,
    D \= B,
    D \= C,
    D \= E,
    D \= F,
    E \= A,
    E \= B,
    E \= C,
    E \= D,
    E \= F,
    F \= A,
    F \= B,
    F \= C,
    F \= D,
    F \= E.

vypis_trojuhelnik([Hlava|Telo]) :-
    write(Hlava),
    nl,
    write(Telo).

prvni(Hlava, [Hlava|_]).

druhy(Druhy, [_,Druhy|_]).

%posledni(Posledni, Seznam).

posledni(Jediny, [Jediny]).
posledni(Posledni, [_|Telo]):- 
    posledni(Posledni, Telo).
    
predposledni(Predposledni, [Predposledni,_]).
predposledni(Predposledni, [_|Telo]):- 
    predposledni(Predposledni, Telo).

prvek(P, [P|_]).
prvek(P, [_|S]):-
    prvek(P, S).

vypis(S):- write(S).
    

vypisPozpatku([P]):-write(P),nl.
vypisPozpatku([H|B]):-
    vypisPozpatku(B),
    write(H),
    nl.

nty([H|_], 1, H).
nty([_|B], N, P):-
    N > 1,
    K is N-1,
    nty(B,K,P).
