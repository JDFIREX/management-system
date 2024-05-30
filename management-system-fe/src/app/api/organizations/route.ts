import { getServerSession } from "next-auth"

import { authOptions } from "@/app/api/auth"
import { Organization } from "@/app/api/organizations/types"
import { Page } from "@/app/api/types"

export async function GET() {
  const response = await fetch("http://localhost:8080/organizations", { cache: "no-store" })
  return Response.json(await response.json())
}

export const getOrganizations = async () => {
  const session = await getServerSession(authOptions)
  const response = await fetch("http://localhost:8080/organizations", {
    cache: "no-store",
    headers: {
      Authorization: `Bearer ${session.token}`
    }
  }).then((res) => {
    console.log("response", res.headers)
    return res
  })
  return {} as Page<Organization>
}
