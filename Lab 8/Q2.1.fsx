
#r "nuget: MongoDB.Driver"

open MongoDB.Driver
open MongoDB.Bson

let client = MongoClient("mongodb://localhost:27017")

let database = client.GetDatabase("FSharpCRUD")

let collection =
    database.GetCollection<BsonDocument>("Students")

let filter =
    Builders<BsonDocument>.Filter.Eq("_id", BsonInt32(1))

let readStudents () =
    let students = collection.Find(FilterDefinition<BsonDocument>.Empty).ToList()

    printfn "\nStudent Records:"

    for student in students do
        printfn "%s" (student.ToJson())

collection.DeleteOne(filter) |> ignore

let student = BsonDocument()
student.Add("_id", BsonInt32(1))
student.Add("name", BsonString("Akansh"))
student.Add("age", BsonInt32(20))

collection.InsertOne(student)

printfn "After CREATE:"
readStudents()

printfn "\nAfter READ:"
readStudents()

let update =
    Builders<BsonDocument>.Update
        .Set("name", BsonString("Rahul"))
        .Set("age", BsonInt32(21))

collection.UpdateOne(filter, update) |> ignore

printfn "\nAfter UPDATE:"
readStudents()

collection.DeleteOne(filter) |> ignore

printfn "\nAfter DELETE:"
readStudents()
