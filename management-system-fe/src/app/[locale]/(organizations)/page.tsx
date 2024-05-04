

const getOrganizations = async () => {
  const response = await fetch('http://localhost:8080/organizations')
  return response.json()
}

const OrganizationsPage = () => <div>Organizations Page</div>

export default OrganizationsPage
