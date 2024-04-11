import { Navigation } from "@domain/types/navigation"
import { Box } from "@radix-ui/themes"
import {
  NavigationMenu,
  NavigationMenuItem,
  NavigationMenuLink,
  NavigationMenuList
} from "@ui/atoms/Navigation"

const getData = async (): Promise<Navigation[]> => {
  const res = await fetch("http://localhost:3000/pl/api/navigation", {
    method: "GET",
    headers: {
      "Content-Type": "application/json"
    }
  })
  console.log(res)
  const x = await res.json()
  console.log(x)
  if (!res.ok) {
    throw new Error("Failed to fetch data")
  }

  return x
}

const NavigationSidebar = async () => {
  const navigation = getData()

  return (
    <Box>
      <NavigationMenu>
        <NavigationMenuList>
          {navigation.map((item) => (
            <NavigationMenuItem key={item.id}>
              <NavigationMenuLink>{item.name}</NavigationMenuLink>
            </NavigationMenuItem>
          ))}
        </NavigationMenuList>
      </NavigationMenu>
    </Box>
  )
}

export default NavigationSidebar
