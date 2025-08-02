CREATE DATABASE ProfiTaxi;

CREATE TABLE Adresy (
    adresaId INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    ulice VARCHAR(64) NOT NULL,
    mesto VARCHAR(64) NOT NULL,
    psc VARCHAR(5) NOT NULL,
);

CREATE TABLE Firmy (
    firmaId INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    adresaId INT NOT NULL FOREIGN KEY REFERENCES Adresy(adresaId),
    nazev VARCHAR(64) NOT NULL,
);

CREATE TABLE Osoby (
    osobaId INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    jmeno VARCHAR(64) NOT NULL,
    prijmeni VARCHAR(64) NOT NULL,
);

CREATE TABLE Zakaznici(
    zakaznikId INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    datumRegistrace DATE NOT NULL,
    osobaId INT NOT NULL FOREIGN KEY REFERENCES Zakaznici(zakaznikId),
);

CREATE TABLE Kontrakty (
    kontraktId INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    firmaId INT NOT NULl FOREIGN KEY REFERENCES Firmy(firmaId),
    zakaznikId INT NOT NULL FOREIGN KEY REFERENCES Zakaznici(zakaznikId),
    cisloKontraktu INT NOT NULL,
    pocetJizd INT NOT NULL,
    cenaZaKm INT NOT NULL,
    aktivni BOOLEAN NOT NULL,
    datumUzavreni DATE NOT NULL,
);

CREATE TABLE TelefonickeObjednavky (
    telefonickeObjednavkyId INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    zakazkaId INT FOREIGN KEY REFERENCES Zakazky(zakazkaId),
    adresaId INT NOT NULL FOREIGN KEY REFERENCES Adresy(adresaId),
    tel VARCHAR(9) NOT NULL,
    predpokladanyZacatek DATETIME NOT NULL,
);

CREATE TABLE Sms (
    smsId INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    zakazkaId INT NOT NULL FOREIGN KEY REFERENCES Zakazky(zakazkaId),
    zamestnanecId INT NOT NULL FOREIGN KEY REFERENCES Zamestnanci(zamestnanecId),
    zakaznikId INT NOT NULL FOREIGN KEY REFERENCES Zakaznici(zakaznikId),
    tel VARCHAR(9),
    obsah VARCHAR(255),
);

CREATE TABLE Pozice (
    poziceId INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    nazev VARCHAR(64),
);

CREATE TABLE Zamestnanci (
    zamestnanecId INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    pobockaId INT NOT NULL,
    poziceId INT NOT NULL FOREIGN KEY REFERENCES Pozice(poziceId),
    majitelOsoba INT NOT NULL FOREIGN KEY REFERENCES Osoby(osobaId),
    plat INT NOT NULL,
);

CREATE TABLE Pobocky (
    pobockaId INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    adresaId INT NOT NULL FOREIGN KEY REFERENCES Adresy(adresaId),
    manazerZamestnanecId INT NOT NULL REFERENCES Zamestnanci(zamestnanecId),
    nazev VARCHAR(64),
);

ALTER TABLE Zamestnanci
ADD FOREIGN KEY (pobockaId) REFERENCES Pobocky(pobockaId);

CREATE TABLE Vozidla (
    vozidloId INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    majitelOsobaId INT NOT NULL FOREIGN KEY REFERENCES Osoby(osobaId),
    znacka VARCHAR(64) NOT NULL,
    model VARCHAR(64) NOT NULL,
    rokVyroby INT NOT NULL,
    najetoKm INT NOT NULL,
);

CREATE TABLE Jizdy (
    jizdaId INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    zacatekAdresaId INT NOT NULL FOREIGN KEY REFERENCES Adresy(adresaId),
    konecAdresaId INT NOT NULL FOREIGN KEY REFERENCES Adresy(adresaId),
    ridicZamestnanecId INT NOT NULL FOREIGN KEY REFERENCES Zamestnanci(zamestnanecId),
    vozidloId INT NOT NULL FOREIGN KEY REFERENCES Vozidla(vozidloId),
    zakazkaId INT NOT NULL FOREIGN KEY REFERENCES Zakazky(zakazkaId),
    datum DATE NOT NULL,
    casZacatku DATETIME NOT NULL,
    csaKonce DATETIME NOT NULL,
    vzdalenostKm INT NOT NULL,
    ukoncena BOOLEAN NOT NULL,
    cena INT NOT NULL,
    zaplaceno INT NOT NULL,
);
