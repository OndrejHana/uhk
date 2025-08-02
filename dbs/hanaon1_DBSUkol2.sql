CREATE TABLE Adresy 
    (
     adresaId NUMERIC (28) NOT NULL , 
     ulice VARCHAR (64) NOT NULL , 
     cp VARCHAR (9) NOT NULL , 
     mesto VARCHAR (64) NOT NULL , 
     psc VARCHAR (5) NOT NULL 
    )
GO

ALTER TABLE Adresy ADD CONSTRAINT Adresy_PK PRIMARY KEY CLUSTERED (adresaId)
     WITH (
     ALLOW_PAGE_LOCKS = ON , 
     ALLOW_ROW_LOCKS = ON )
GO

CREATE TABLE Firmy 
    (
     firmaId NUMERIC (28) NOT NULL , 
     nazev VARCHAR (64) NOT NULL , 
     adresaId NUMERIC (28) 
    )
GO

ALTER TABLE Firmy ADD CONSTRAINT Firmy_PK PRIMARY KEY CLUSTERED (firmaId)
     WITH (
     ALLOW_PAGE_LOCKS = ON , 
     ALLOW_ROW_LOCKS = ON )
GO

CREATE TABLE Jizdy 
    (
     jizdaId NUMERIC (28) NOT NULL , 
     casZacatku DATETIME NOT NULL , 
     casKonce DATETIME , 
     vzdalenostKm NUMERIC (28) , 
     zamestnanecId NUMERIC (28) , 
     vozidloId NUMERIC (28) , 
     zacatekAdresaId NUMERIC (28) , 
     konecAdresaId NUMERIC (28) , 
     ukoncena BIT NOT NULL , 
     cena INTEGER NOT NULL , 
     zaplaceno NUMERIC (28) , 
     telefonickeObjednavkyId NUMERIC (28) 
    )
GO

ALTER TABLE Jizdy ADD CONSTRAINT Jizdy_PK PRIMARY KEY CLUSTERED (jizdaId)
     WITH (
     ALLOW_PAGE_LOCKS = ON , 
     ALLOW_ROW_LOCKS = ON )
GO

CREATE TABLE Kontrakty 
    (
     kontraktId NUMERIC (28) NOT NULL , 
     pocetJizd NUMERIC (28) NOT NULL , 
     cenaZaKm NUMERIC (28) NOT NULL , 
     datumUzavreni DATE , 
     datumDo DATE , 
     firmaId NUMERIC (28) 
    )
GO

ALTER TABLE Kontrakty ADD CONSTRAINT Kontrakty_PK PRIMARY KEY CLUSTERED (kontraktId)
     WITH (
     ALLOW_PAGE_LOCKS = ON , 
     ALLOW_ROW_LOCKS = ON )
GO

CREATE TABLE Pobocky 
    (
     pobockaId NUMERIC (28) NOT NULL , 
     adresaId NUMERIC (28) , 
     nazev VARCHAR (64) NOT NULL , 
     zamestnanecId NUMERIC (28) 
    )
GO

ALTER TABLE Pobocky ADD CONSTRAINT Pobocky_PK PRIMARY KEY CLUSTERED (pobockaId)
     WITH (
     ALLOW_PAGE_LOCKS = ON , 
     ALLOW_ROW_LOCKS = ON )
GO
ALTER TABLE Pobocky ADD CONSTRAINT Pobocky_nazev_UN UNIQUE NONCLUSTERED (nazev)
GO

CREATE TABLE Pozice 
    (
     poziceId NUMERIC (28) NOT NULL , 
     nazev VARCHAR (64) NOT NULL 
    )
GO

ALTER TABLE Pozice ADD CONSTRAINT Pozice_PK PRIMARY KEY CLUSTERED (poziceId)
     WITH (
     ALLOW_PAGE_LOCKS = ON , 
     ALLOW_ROW_LOCKS = ON )
GO
ALTER TABLE Pozice ADD CONSTRAINT Pozice_nazev_UN UNIQUE NONCLUSTERED (nazev)
GO

CREATE TABLE sms 
    (
     smsId NUMERIC (28) NOT NULL , 
     obsah VARCHAR (255) , 
     jizdaId NUMERIC (28) 
    )
GO

ALTER TABLE sms ADD CONSTRAINT sms_PK PRIMARY KEY CLUSTERED (smsId)
     WITH (
     ALLOW_PAGE_LOCKS = ON , 
     ALLOW_ROW_LOCKS = ON )
GO

CREATE TABLE TelefonickeObjednavky 
    (
     telefonickeObjednavkyId NUMERIC (28) NOT NULL , 
     tel VARCHAR (9) NOT NULL , 
     predpokladanyZacatek DATETIME , 
     zakaznikId INTEGER , 
     kontraktId NUMERIC (28) , 
     datum DATE NOT NULL 
    )
GO

ALTER TABLE TelefonickeObjednavky ADD CONSTRAINT TelefonickeObjednavky_PK PRIMARY KEY CLUSTERED (telefonickeObjednavkyId)
     WITH (
     ALLOW_PAGE_LOCKS = ON , 
     ALLOW_ROW_LOCKS = ON )
GO

CREATE TABLE Vozidla 
    (
     vozidloId NUMERIC (28) NOT NULL , 
     znacka VARCHAR (64) , 
     model VARCHAR (64) , 
     rokVyroby NUMERIC (28) , 
     najetoKm NUMERIC (28) , 
     spz VARCHAR (7) 
    )
GO

ALTER TABLE Vozidla ADD CONSTRAINT Vozidla_PK PRIMARY KEY CLUSTERED (vozidloId)
     WITH (
     ALLOW_PAGE_LOCKS = ON , 
     ALLOW_ROW_LOCKS = ON )
GO

CREATE TABLE Zakaznici 
    (
     zakaznikId INTEGER NOT NULL , 
     datumRegistrace DATE , 
     jmeno VARCHAR (50) , 
     prijmeni VARCHAR (50) 
    )
GO

ALTER TABLE Zakaznici ADD CONSTRAINT Zakaznici_PK PRIMARY KEY CLUSTERED (zakaznikId)
     WITH (
     ALLOW_PAGE_LOCKS = ON , 
     ALLOW_ROW_LOCKS = ON )
GO

CREATE TABLE Zamestnanci 
    (
     zamestnanecId NUMERIC (28) NOT NULL , 
     plat NUMERIC (28) , 
     pobockaId NUMERIC (28) , 
     poziceId NUMERIC (28) , 
     fotografieCesta VARCHAR (255) 
    )
GO

ALTER TABLE Zamestnanci ADD CONSTRAINT Zamestnanci_PK PRIMARY KEY CLUSTERED (zamestnanecId)
     WITH (
     ALLOW_PAGE_LOCKS = ON , 
     ALLOW_ROW_LOCKS = ON )
GO

ALTER TABLE Firmy 
    ADD CONSTRAINT Firmy_Adresy_FK FOREIGN KEY 
    ( 
     adresaId
    ) 
    REFERENCES Adresy 
    ( 
     adresaId 
    ) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION 
GO

ALTER TABLE Jizdy 
    ADD CONSTRAINT Jizdy_Adresy_FK FOREIGN KEY 
    ( 
     zacatekAdresaId
    ) 
    REFERENCES Adresy 
    ( 
     adresaId 
    ) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION 
GO

ALTER TABLE Jizdy 
    ADD CONSTRAINT Jizdy_Adresy_FKv2 FOREIGN KEY 
    ( 
     konecAdresaId
    ) 
    REFERENCES Adresy 
    ( 
     adresaId 
    ) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION 
GO

ALTER TABLE Jizdy 
    ADD CONSTRAINT Jizdy_TelefonickeObjednavky_FK FOREIGN KEY 
    ( 
     telefonickeObjednavkyId
    ) 
    REFERENCES TelefonickeObjednavky 
    ( 
     telefonickeObjednavkyId 
    ) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION 
GO

ALTER TABLE Jizdy 
    ADD CONSTRAINT Jizdy_Vozidla_FK FOREIGN KEY 
    ( 
     vozidloId
    ) 
    REFERENCES Vozidla 
    ( 
     vozidloId 
    ) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION 
GO

ALTER TABLE Jizdy 
    ADD CONSTRAINT Jizdy_Zamestnanci_FK FOREIGN KEY 
    ( 
     zamestnanecId
    ) 
    REFERENCES Zamestnanci 
    ( 
     zamestnanecId 
    ) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION 
GO

ALTER TABLE Kontrakty 
    ADD CONSTRAINT Kontrakty_Firmy_FK FOREIGN KEY 
    ( 
     firmaId
    ) 
    REFERENCES Firmy 
    ( 
     firmaId 
    ) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION 
GO

ALTER TABLE Pobocky 
    ADD CONSTRAINT Pobocky_Adresy_FK FOREIGN KEY 
    ( 
     adresaId
    ) 
    REFERENCES Adresy 
    ( 
     adresaId 
    ) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION 
GO

ALTER TABLE Pobocky 
    ADD CONSTRAINT Pobocky_Zamestnanci_FK FOREIGN KEY 
    ( 
     zamestnanecId
    ) 
    REFERENCES Zamestnanci 
    ( 
     zamestnanecId 
    ) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION 
GO

ALTER TABLE sms 
    ADD CONSTRAINT sms_Jizdy_FK FOREIGN KEY 
    ( 
     jizdaId
    ) 
    REFERENCES Jizdy 
    ( 
     jizdaId 
    ) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION 
GO

ALTER TABLE TelefonickeObjednavky 
    ADD CONSTRAINT TelefonickeObjednavky_Kontrakty_FK FOREIGN KEY 
    ( 
     kontraktId
    ) 
    REFERENCES Kontrakty 
    ( 
     kontraktId 
    ) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION 
GO

ALTER TABLE TelefonickeObjednavky 
    ADD CONSTRAINT TelefonickeObjednavky_Zakaznici_FK FOREIGN KEY 
    ( 
     zakaznikId
    ) 
    REFERENCES Zakaznici 
    ( 
     zakaznikId 
    ) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION 
GO

ALTER TABLE Zamestnanci 
    ADD CONSTRAINT Zamestnanci_Pobocky_FK FOREIGN KEY 
    ( 
     pobockaId
    ) 
    REFERENCES Pobocky 
    ( 
     pobockaId 
    ) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION 
GO

ALTER TABLE Zamestnanci 
    ADD CONSTRAINT Zamestnanci_Pozice_FK FOREIGN KEY 
    ( 
     poziceId
    ) 
    REFERENCES Pozice 
    ( 
     poziceId 
    ) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION 
GO




CREATE PROCEDURE REGISTRACE
    @firmaNazev VARCHAR(64),
    @ulice VARCHAR(64),
    @cp VARCHAR(9),
    @mesto VARCHAR(64),
    @psc VARCHAR(5),
    @kontraktPocetJizd NUMERIC(28),
    @kontraktCenaZaKm NUMERIC(28),
    @kontraktDatumUzavreni DATE,
    @kontraktDatumDo DATE
AS
BEGIN
    BEGIN TRANSACTION;

    BEGIN TRY
        -- Vlozeni adresy
        DECLARE @adresaId NUMERIC(28);
        INSERT INTO Adresy (ulice, cp, mesto, psc)
        VALUES (@ulice, @cp, @mesto, @psc);
        SET @adresaId = SCOPE_IDENTITY();

        -- Vlozeni firmy
        DECLARE @firmaId NUMERIC(28);
        INSERT INTO Firmy (nazev, adresaId)
        VALUES (@firmaNazev, @adresaId);
        SET @firmaId = SCOPE_IDENTITY();

        -- Vlozeni kontraktu
        DECLARE @kontraktId NUMERIC(28);
        INSERT INTO Kontrakty (pocetJizd, cenaZaKm, datumUzavreni, datumDo, firmaId)
        VALUES (@kontraktPocetJizd, @kontraktCenaZaKm, @kontraktDatumUzavreni, @kontraktDatumDo, @firmaId);

        COMMIT TRANSACTION;
    END TRY

    BEGIN CATCH
        ROLLBACK TRANSACTION;
        THROW;
    END CATCH
END


GO

CREATE VIEW JIZDY_RIDICU AS
SELECT 
    j.jizdaId,
    j.zamestnanecId AS ridicId,
    j.vozidloId,
    a1.ulice AS zacatekUlice,
    a1.mesto AS zacatekMesto,
    a2.ulice AS konecUlice,
    a2.mesto AS konecMesto,
    j.casZacatku,
    j.casKonce,
    j.vzdalenostKm,
    j.cena
FROM 
    Jizdy j
JOIN 
    Adresy a1 ON j.zacatekAdresaId = a1.adresaId
JOIN 
    Adresy a2 ON j.konecAdresaId = a2.adresaId
WHERE 
    CAST(j.casZacatku AS DATE) = '2016-11-17';


GO

CREATE VIEW NASMLOUVANE_KONTRAKTY AS
SELECT 
    k.kontraktId,
    k.pocetJizd,
    k.cenaZaKm,
    k.datumUzavreni,
    k.datumDo,
    z.zakaznikId,
    z.jmeno,
    z.prijmeni,
    (
        SELECT COUNT(*)
        FROM Jizdy j
        WHERE j.telefonickeObjednavkyId IN (
            SELECT t.telefonickeObjednavkyId
            FROM TelefonickeObjednavky t
            WHERE t.zakaznikId = z.zakaznikId
              AND MONTH(t.datum) = MONTH(GETDATE()) - 1
              AND YEAR(t.datum) = YEAR(GETDATE())
        )
    ) AS pocetJizdMinulyMesic
FROM 
    Kontrakty k
JOIN 
    TelefonickeObjednavky t ON k.kontraktId = t.kontraktId
JOIN 
    Zakaznici z ON t.zakaznikId = z.zakaznikId;

GO


CREATE VIEW VLASTNI_POHLED AS
SELECT TOP 10
    v.vozidloId,
    v.znacka,
    v.model,
    COUNT(j.jizdaId) AS pocetJizd,
    SUM(j.cena) AS celkoveVydelky
FROM 
    Vozidla v
LEFT JOIN 
    Jizdy j ON v.vozidloId = j.vozidloId
GROUP BY 
    v.vozidloId, v.znacka, v.model
ORDER BY 
    pocetJizd DESC;

GO


-- Vložení testovacích dat pro tabulky ProfiTaxi

-- Adresy
INSERT INTO Adresy (adresaId, ulice, cisloPopisne, mesto, psc) VALUES
(1, 'Hlavní', '12', 'Praha', '11000'),
(2, 'Masarykova', '58', 'Brno', '60200'),
(3, 'Smetanova', '8', 'Ostrava', '70200'),
(4, 'Komenského', '15', 'Plzeň', '30100'),
(5, 'Nádražní', '10', 'Liberec', '46001'),
(6, 'Jiráskova', '45', 'Olomouc', '77900'),
(7, 'Václavské náměstí', '1', 'Praha', '11000'),
(8, 'Dlouhá', '14', 'Brno', '60200'),
(9, 'Mlýnská', '22', 'Ostrava', '70200'),
(10, 'Karla IV.', '7', 'Plzeň', '30100');

-- Firmy
INSERT INTO Firmy (firmaId, nazev, adresaId) VALUES
(1, 'AutoTrans s.r.o.', 1),
(2, 'Cestovka Plus', 2),
(3, 'TechCorp', 3),
(4, 'Global Logistics', 4),
(5, 'FastDelivery', 5);

-- Kontrakty
INSERT INTO Kontrakty (kontraktId, firmaId, platnostOd, platnostDo) VALUES
(1, 1, '2016-01-01', '2016-12-31'),
(2, 2, '2016-11-01', '2016-12-01'),
(3, 3, '2017-03-01', '2020-09-30'),
(4, 4, '2023-01-15', '2024-11-15'),
(5, 5, '2024-02-01', '2025-10-31');

-- TelefonickeObjednavky
INSERT INTO TelefonickeObjednavky (telefonickeObjednavkyId, zakaznikId, kontraktId, datum, cas) VALUES
(1, 1, 1, '2016-05-10', '08:30:00'),
(2, 4, null, '2024-10-02', '10:15:00'),
(3, 5, null, '2024-12-03', '14:00:00'),
(4, 2, 4, '2024-10-04', '18:45:00'),
(5, 3, 4, '2024-10-04', '18:45:00'),
(6, 4, 3, '2016-11-17', '18:45:00'),
(7, 5, 3, '2016-11-17', '07:20:00');

-- Pobocky
INSERT INTO Pobocky (pobockaId, nazev, adresaId, zamestnanecId) VALUES
(1, 'Pražská pobočka', 7, 1),
(2, 'Brněnská pobočka', 8, 2),
(3, 'Ostravská pobočka', 9, 3),
(4, 'Plzeňská pobočka', 10, 4);

-- Zamestnanci
INSERT INTO Zamestnanci (zamestnanecId, jmeno, prijmeni, pobockaId, poziceId) VALUES
(1, 'Jan', 'Novák', 1, 1),
(2, 'Petr', 'Svoboda', 2, 2),
(3, 'Anna', 'Dvořáková', 3, 3),
(4, 'Karel', 'Veselý', 4, 4);

-- Pozice
INSERT INTO Pozice (poziceId, nazev) VALUES
(1, 'Řidič'),
(2, 'Dispečer'),
(3, 'Administrátor'),
(4, 'Manažer');

-- Zakaznici
INSERT INTO Zakaznici (zakaznikId, jmeno, prijmeni, telefon) VALUES
(1, 'Eva', 'Novotná', '123456789'),
(2, 'Tomáš', 'Černý', '987654321'),
(3, 'Jana', 'Malá', '456123789'),
(4, 'Marek', 'Velký', '789456123'),
(5, 'Lucie', 'Bílá', '159753456');

-- Vozidla
INSERT INTO Vozidla (vozidloId, znacka, model, rokVyroby, spz) VALUES
(1, 'Škoda', 'Octavia', 2020, '1A2 3456'),
(2, 'Volkswagen', 'Passat', 2019, '3B4 5678'),
(3, 'Toyota', 'Corolla', 2021, '5C6 7890'),
(4, 'Hyundai', 'Tucson', 2020, '7D8 9012'),
(5, 'Ford', 'Focus', 2018, '9E0 1234');

-- Jizdy
INSERT INTO Jizdy (jizdaId, zacatekAdresaId, konecAdresaId, telefonickeObjednavkyId, vozidloId, zamestnanecId, casZacatku, casKoncu) VALUES
(1, 1, 2, 6, 1, 1, '2016-11-17 08:30:00', '2016-11-17 09:00:00'),
(2, 3, 4, 6, 2, 2, '2016-11-17 10:15:00', '2016-11-17 10:45:00'),
(3, 5, 6, 7, 3, 3, '2016-11-03 14:00:00', '2016-11-03 14:40:00'),
(4, 7, 8, 4, 4, 4, '2024-12-04 18:45:00', '2024-12-04 19:30:00'),
(5, 9, 10, 5, 5, 1, '2024-12-05 07:20:00', '2024-12-05 08:00:00');

INSERT INTO sms (smsId, obsah,jizdaId) VALUES
(1, 'Vaše jízda byla potvrzena na 8:30.', 1),
(2, 'Řidič je na cestě k Vám.', 1),
(3, 'Děkujeme, že jste využili našich služeb.', 1),
(4, 'Vaše jízda byla potvrzena na 10:15.', 2),
(5, 'Řidič je na cestě k Vám.', 2),
(6, 'Děkujeme, že jste využili našich služeb.', 2),
(7, 'Vaše jízda byla potvrzena na 14:00.', 3),
(8, 'Řidič je na cestě k Vám.', 3),
(9, 'Děkujeme, že jste využili našich služeb.', 3);
