
open System
open System.Text.RegularExpressions
open System.Numerics

let reverseString (s: string) =
    s.ToCharArray() |> Array.rev |> fun chars -> String(chars)

let isPalindrome (s: string) =
    let cleaned =
        s.ToLowerInvariant()
        |> Seq.filter (fun c -> not (Char.IsWhiteSpace c))
        |> Array.ofSeq
        |> fun chars -> String(chars)
    cleaned = reverseString cleaned

let transform (s: string) =
    if s <> "" && (s |> Seq.forall Char.IsLetter) then
        s.ToUpperInvariant()
    elif s <> "" && (s |> Seq.forall Char.IsDigit) then
        string (BigInteger.Parse(s) * 2I)
    else
        s

let isValidEmail (email: string) =
    Regex.IsMatch(email, @"^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$")

printfn "1. Reverse and Palindrome"
for s in ["madam"; "hello"; "level"] do
    printfn "%s | Reverse: %s | Palindrome: %b" s (reverseString s) (isPalindrome s)

printfn "\n2. String Transformation"
for s in ["hello"; "123"; "abc123"] do
    printfn "%s -> %s" s (transform s)

printfn "\n3. Email Validation"
for email in ["student@example.com"; "abc@company.co.in"; "wrong-email"] do
    printfn "%s -> %b" email (isValidEmail email)
