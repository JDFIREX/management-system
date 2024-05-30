import { getServerSession } from "next-auth"

import { authOptions } from "@/app/api/auth"
import { User } from "@/app/api/user"
import { Avatar, Box, Card, Flex, Text } from "@radix-ui/themes"

const getData = async (): Promise<User> => {
  const session = await getServerSession(authOptions)
  //console.log("getData", session)
  if (!session?.user) {
    throw new Error("Failed to fetch data")
  }

  return session.user as User
}

const UserProfileSidebar = async () => {
  const user = await getData()
  //console.log(user)
  return (
    <Box>
      <Card>
        <Flex gap="3" align="center">
          <Avatar size="3" src={user.image} radius="full" fallback={user.name} />
          <Box>
            <Text size="2" weight="bold">
              {user.name}
            </Text>
          </Box>
        </Flex>
      </Card>
    </Box>
  )
}

export default UserProfileSidebar
