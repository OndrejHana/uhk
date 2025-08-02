findFirst [] _ = []
findFirst (h:b) x
    | h == x =  b
    | otherwise = h:findFirst b x

find[] _ = []
find(h:b) x
    | h == x = find b x
    | otherwise = h:find b x

otoc' [] buffer = buffer
otoc' (h:b) buffer = otoc' b (h:buffer)


otoc'' b buffer = foldl (flip (:)) buffer b

otoc a = otoc' a []

zvys2 = (2+)
umocni = (6^)

boobies = (.).(.)

zvys [] = []
zvys (h:b) = h+1:zvys b

zvys' = map (1+)

dvojnasob = map (2*)

