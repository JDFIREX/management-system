import { Navigation } from "@/app/api/navigation/index"

export async function GET() {
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
  return Response.json(data)
}
