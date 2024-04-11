import { User } from "@domain/types/user"
import { Avatar, Box, Card, Flex, Text } from "@radix-ui/themes"

const getData = async (): Promise<User> => {
  const res = await fetch("http://localhost:3000/api/user", {
    method: "GET",
    headers: {
      "Content-Type": "application/json"
    }
  })

  if (!res.ok) {
    throw new Error("Failed to fetch data")
  }

  return res.json()
}

const UserProfileSidebar = async () => {
  const user = await getData()

  return (
    <Box>
      <Card>
        <Flex gap="3" align="center">
          <Avatar size="3" src={user.avatar} radius="full" fallback={user.name[0]} />
          <Box>
            <Text size="2" weight="bold">
              {user.name}
            </Text>
            <Text size="2" color="gray">
              {user.role}
            </Text>
          </Box>
        </Flex>
      </Card>
    </Box>
  )
}

export default UserProfileSidebar
