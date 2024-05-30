import { getOrganizations } from "@/app/api/organizations/route"

const OrganizationsPage = async () => {
  const organizations = await getOrganizations()
  return <div>Organizations Page</div>
}

export default OrganizationsPage
