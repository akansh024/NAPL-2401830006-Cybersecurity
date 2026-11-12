open System

let task1 = async {
    printfn "Task 1 started"
    do! Async.Sleep(3000)
    printfn "Task 1 completed"
    return "Task 1 Result: Data Downloaded"
}

let task2 = async {
    printfn "Task 2 started"
    do! Async.Sleep(2000)
    printfn "Task 2 completed"
    return "Task 2 Result: File Processed"
}

let task3 = async {
    printfn "Task 3 started"
    do! Async.Sleep(1000)
    printfn "Task 3 completed"
    return "Task 3 Result: Report Generated"
}

let main = async {
    printfn "Starting all tasks concurrently..."

    let! results = Async.Parallel [task1; task2; task3]

    printfn "\nAll tasks completed!"
    printfn "\nResults:"

    results |> Array.iter (printfn "%s")
}

Async.RunSynchronously main