
#r "nuget: Microsoft.Data.Sqlite"

open Microsoft.Data.Sqlite

let connection =
    new SqliteConnection("Data Source=students.db")

connection.Open()

let execute sql =
    use cmd = new SqliteCommand(sql, connection)
    cmd.ExecuteNonQuery() |> ignore

let readStudents () =
    use cmd = new SqliteCommand("SELECT * FROM Students", connection)
    use reader = cmd.ExecuteReader()

    printfn "\nStudent Records:"

    while reader.Read() do
        printfn "ID: %d, Name: %s, Age: %d"
            (reader.GetInt32(0))
            (reader.GetString(1))
            (reader.GetInt32(2))

execute """
CREATE TABLE IF NOT EXISTS Students (
    Id INTEGER PRIMARY KEY,
    Name TEXT,
    Age INTEGER
)
"""

execute "DELETE FROM Students"

execute """
INSERT INTO Students (Id, Name, Age)
VALUES (1, 'Akansh', 20)
"""

printfn "After CREATE:"
readStudents()

printfn "\nAfter READ:"
readStudents()

execute """
UPDATE Students
SET Name = 'Rahul', Age = 21
WHERE Id = 1
"""

printfn "\nAfter UPDATE:"
readStudents()

execute "DELETE FROM Students WHERE Id = 1"

printfn "\nAfter DELETE:"
readStudents()

connection.Close()
