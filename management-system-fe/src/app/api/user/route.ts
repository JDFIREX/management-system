import { User } from "@/app/api/user/index"

export async function GET() {
  const user: User = {
    fullName: "John Doe",
    name: "John",
    surname: "Doe",
    email: "",
    role: "Engineering",
    avatar:
      "https://images.unsplash.com/photo-1607346256330-dee7af15f7c5?&w=64&h=64&dpr=2&q=70&crop=focalpoint&fp-x=0.67&fp-y=0.5&fp-z=1.4&fit=crop"
  }

  return Response.json(user)
}
