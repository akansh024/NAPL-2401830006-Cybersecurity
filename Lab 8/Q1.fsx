type Shape() =
    abstract member Area : unit -> float
    default this.Area() = 0.0

type Circle(radius: float) =
    inherit Shape()

    override this.Area() =
        3.14 * radius * radius

type Rectangle(length: float, width: float) =
    inherit Shape()

    override this.Area() =
        length * width

let circle = Circle(5.0)
let rectangle = Rectangle(10.0, 4.0)

printfn "Area of Circle: %.2f" (circle.Area())
printfn "Area of Rectangle: %.2f" (rectangle.Area())

let shapes: Shape list =
    [ circle :> Shape
      rectangle :> Shape ]

printfn "\nDemonstrating Polymorphism:"

for shape in shapes do
    printfn "Area: %.2f" (shape.Area())