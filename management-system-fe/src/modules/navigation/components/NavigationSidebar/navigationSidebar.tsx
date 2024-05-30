import { Navigation } from "@/app/api/navigation"
import { Box } from "@radix-ui/themes"
import {
  NavigationMenu,
  NavigationMenuItem,
  NavigationMenuLink,
  NavigationMenuList
} from "@ui/atoms/Navigation"

const getData = async (): Promise<Navigation[]> => {
  const res = await fetch("http://localhost:3000/api/navigation", {
    method: "GET",
    headers: {
      "Content-Type": "application/json"
    }
  })

  return res.json()
}

const NavigationSidebar = async () => {
  const navigation = await getData()

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
