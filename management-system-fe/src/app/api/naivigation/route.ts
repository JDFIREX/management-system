import { Navigation } from "@domain/types/navigation"

export async function GET(): Promise<Response> {
  console.log("elooo")
  const data: Navigation[] = [
    {
      id: "1",
      name: "Home",
      url: "/",
      icon: null
    },
    {
      id: "2",
      name: "About",
      url: "/about",
      icon: null
    },
    {
      id: "3",
      name: "Contact",
      url: "/contact",
      icon: null
    }
  ]

  return Response.json({
    data
  })
}
