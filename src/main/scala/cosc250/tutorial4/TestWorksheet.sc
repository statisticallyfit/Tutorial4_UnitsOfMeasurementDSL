val a:Option[Int] = Some(1)
println(a.map({ case x if x % 2 == 0 => x / 2 }))