open System

let isPrime n =
    let rec check d =
        if d * d > n then true
        elif n % d = 0 then false
        else check (d + 1)

    if n < 2 then false
    else check 2

printf "Enter an integer: "
let n = int (Console.ReadLine())

if isPrime n then
    printfn "%d is Prime" n
else
    printfn "%d is Not Prime" n