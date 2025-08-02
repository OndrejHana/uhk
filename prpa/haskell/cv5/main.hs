prvni [] = error "rip"
prvni (hlava:_) = hlava

foo (hlava:_) = hlava
prvni2 arr  | null arr = error "rip"
            | otherwise = foo arr

druhy (a:b:lol) = b
telo (_:telo) = telo

posledni (hlava:telo)   
    | null telo = hlava
    | otherwise = posledni telo




posledni2 [a] = a
posledni2 (a:b) = posledni2 b

-- predposledni arr 
--     | arr == [a,_] = a
--     | otherwise 
--

kek (a:b) x
    | a == x = True
    | null b = False
    | otherwise = kek b x

nty (a:b) n
    | n == 1 = a
    | otherwise = nty b (n-1)

