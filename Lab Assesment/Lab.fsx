type Student = {
    Id: int
    Name: string
    Gpa: float
}

let mutable db = []

let addAsync s = async {
    db <- s :: db
}

let updateAsync id newGpa = async {
    db <- db |> List.map (fun s -> if s.Id = id then { s with Gpa = newGpa } else s)
}

let deleteAsync id = async {
    db <- db |> List.filter (fun s -> s.Id <> id)
}

let getGrade gpa =
    match gpa with
    | g when g >= 3.5 -> "Honors"
    | _ -> "Regular"

async {
    do! addAsync { Id = 1; Name = "Alice"; Gpa = 3.8 }
    do! addAsync { Id = 2; Name = "Bob"; Gpa = 3.0 }

    do! updateAsync 2 3.6
    do! deleteAsync 1

    let topNames =
        db
        |> List.filter (fun s -> s.Gpa >= 3.5)
        |> List.map (fun s -> s.Name)

    for s in db do
        printfn "%s: %s (GPA: %.1f)" s.Name (getGrade s.Gpa) s.Gpa

    printfn "Top students: %A" topNames
}
|> Async.RunSynchronously